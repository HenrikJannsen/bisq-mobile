package network.bisq.mobile.presentation.ui.uicases.open_trades.selected.states

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import network.bisq.mobile.domain.data.BackgroundDispatcher
import network.bisq.mobile.domain.data.replicated.common.monetary.CoinVOFactory
import network.bisq.mobile.domain.data.replicated.common.monetary.CoinVOFactory.from
import network.bisq.mobile.domain.data.replicated.presentation.open_trades.TradeItemPresentationModel
import network.bisq.mobile.domain.formatters.AmountFormatter
import network.bisq.mobile.domain.service.explorer.ExplorerServiceFacade
import network.bisq.mobile.domain.service.trades.TradesServiceFacade
import network.bisq.mobile.i18n.i18n
import network.bisq.mobile.presentation.BasePresenter
import network.bisq.mobile.presentation.MainPresenter
import network.bisq.mobile.presentation.ui.uicases.open_trades.selected.states.TxConfirmationState.CONFIRMED
import network.bisq.mobile.presentation.ui.uicases.open_trades.selected.states.TxConfirmationState.IDLE
import network.bisq.mobile.presentation.ui.uicases.open_trades.selected.states.TxConfirmationState.IN_MEMPOOL
import network.bisq.mobile.presentation.ui.uicases.open_trades.selected.states.TxConfirmationState.REQUEST_STARTED

class BuyerStateMainChain3bPresenter(
    mainPresenter: MainPresenter,
    private val tradesServiceFacade: TradesServiceFacade,
    private val explorerServiceFacade: ExplorerServiceFacade
) : BasePresenter(mainPresenter) {

    val selectedTrade: StateFlow<TradeItemPresentationModel?> = tradesServiceFacade.selectedTrade

    private val _buttonText: MutableStateFlow<String> = MutableStateFlow("")
    val buttonText: StateFlow<String> = _buttonText

    private val _txConfirmationState: MutableStateFlow<TxConfirmationState> = MutableStateFlow(IDLE)
    val txConfirmationState: StateFlow<TxConfirmationState> = _txConfirmationState

    private val _blockExplorer: MutableStateFlow<String> = MutableStateFlow("")
    val blockExplorer: StateFlow<String> = _blockExplorer

    private val _balanceFromTx: MutableStateFlow<String> = MutableStateFlow("")
    val balanceFromTx: StateFlow<String> = _balanceFromTx

    private val _errorMessage: MutableStateFlow<String?> = MutableStateFlow(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    private var jobs: MutableSet<Job> = mutableSetOf()

    override fun onViewAttached() {
        _buttonText.value = if (txConfirmationState.value == CONFIRMED) {
            "bisqEasy.tradeState.info.phase3b.button.next".i18n()
        } else {
            "bisqEasy.tradeState.info.phase3b.button.skip".i18n()
        }

        if (txConfirmationState.value == IDLE) {
            requestTx();
        }
    }

    override fun onViewUnattaching() {
        jobs.forEach { it.cancel() }
        jobs.clear()

        _buttonText.value = ""
        _txConfirmationState.value = IDLE
        _blockExplorer.value = ""
        _balanceFromTx.value = ""
        _errorMessage.value = null
    }

    fun onCompleteTrade() {
        jobs.add(CoroutineScope(BackgroundDispatcher).launch {
            tradesServiceFacade.btcConfirmed()
        })
    }

    private fun requestTx() {
        if (txConfirmationState.value == REQUEST_STARTED || tradesServiceFacade.selectedTrade.value == null) {
            return
        }
        val openTradeItemModel = tradesServiceFacade.selectedTrade.value!!
        val bisqEasyTradeModel = openTradeItemModel.bisqEasyTradeModel
        val txId: String? = bisqEasyTradeModel.paymentProof.value
        val address: String? = bisqEasyTradeModel.bitcoinPaymentData.value
        if (txId == null || address == null) {
            return
        }
        jobs.add(CoroutineScope(BackgroundDispatcher).launch {
            _blockExplorer.value = ""
            val result = explorerServiceFacade.getSelectedBlockExplorer()
            if (result.isSuccess) {
                _blockExplorer.value = result.getOrThrow()
            } else {
                _blockExplorer.value = "data.na".i18n()
            }
        })

        doRequestTx(txId, address, openTradeItemModel)
    }

    private fun doRequestTx(
        txId: String,
        address: String,
        openTradeItemModel: TradeItemPresentationModel
    ) {
        jobs.add(CoroutineScope(BackgroundDispatcher).launch {
            _txConfirmationState.value = REQUEST_STARTED
            _errorMessage.value = null
            _balanceFromTx.value = ""
            val explorerResult = explorerServiceFacade.requestTx(txId, address)
            if (explorerResult.isSuccess) {
                if (explorerResult.isConfirmed) {
                    _txConfirmationState.value = CONFIRMED
                    _buttonText.value = "bisqEasy.tradeState.info.phase3b.button.next".i18n()
                } else {
                    _txConfirmationState.value = IN_MEMPOOL

                    // We request again after 20 seconds.
                    // As its presenterScope it will get canceled when presenter is deactivated.
                    presenterScope.launch {
                        delay(20_000)
                        requestTx()
                    }
                }

                val outputValues = explorerResult.outputValues
                if (outputValues.size == 1) {
                    val outputValue = outputValues[0]
                    val formattedAmount = AmountFormatter.formatAmount(
                        CoinVOFactory.from(outputValue, openTradeItemModel.baseCurrencyCode),
                        useLowPrecision = false,
                        withCode = true
                    )
                    _balanceFromTx.value = formattedAmount

                    val tradeAmount: Long = openTradeItemModel.bisqEasyTradeModel.contract.baseSideAmount
                    if (outputValue != tradeAmount) {
                        _errorMessage.value = "bisqEasy.tradeState.info.phase3b.balance.invalid.amountNotMatching".i18n()
                    }
                } else if (outputValues.isEmpty()) {
                    _errorMessage.value = "bisqEasy.tradeState.info.phase3b.balance.invalid.noOutputsForAddress".i18n()
                } else {
                    // Not expected use case and not further handled. User should look up in explorer to validate tx
                    _errorMessage.value = "bisqEasy.tradeState.info.phase3b.balance.invalid.multipleOutputsForAddress".i18n()
                }

            } else {
                _txConfirmationState.value = TxConfirmationState.FAILED
                _errorMessage.value = "bisqEasy.tradeState.info.phase3b.txId.failed".i18n(
                    blockExplorer.value,
                    explorerResult.exceptionName!!,
                    explorerResult.errorMessage!!
                )
            }
        })
    }
}