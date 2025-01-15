package network.bisq.mobile.presentation.ui.uicases.open_trades.selected.states

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import bisqapps.shared.presentation.generated.resources.Res
import bisqapps.shared.presentation.generated.resources.trade_bitcoin_confirmation
import network.bisq.mobile.i18n.i18n
import network.bisq.mobile.presentation.ui.components.atoms.BisqButton
import network.bisq.mobile.presentation.ui.components.atoms.BisqText
import network.bisq.mobile.presentation.ui.components.atoms.BisqTextField
import network.bisq.mobile.presentation.ui.components.atoms.CircularLoadingImage
import network.bisq.mobile.presentation.ui.components.atoms.layout.BisqGap
import network.bisq.mobile.presentation.ui.helpers.RememberPresenterLifecycle
import network.bisq.mobile.presentation.ui.theme.BisqTheme
import network.bisq.mobile.presentation.ui.uicases.open_trades.selected.states.TxConfirmationState.CONFIRMED
import network.bisq.mobile.presentation.ui.uicases.open_trades.selected.states.TxConfirmationState.FAILED
import network.bisq.mobile.presentation.ui.uicases.open_trades.selected.states.TxConfirmationState.IDLE
import network.bisq.mobile.presentation.ui.uicases.open_trades.selected.states.TxConfirmationState.IN_MEMPOOL
import network.bisq.mobile.presentation.ui.uicases.open_trades.selected.states.TxConfirmationState.REQUEST_STARTED

@Composable
fun BuyerStateMainChain3b(
    presenter: BuyerStateMainChain3bPresenter,
) {
    RememberPresenterLifecycle(presenter)

    val confirmationState by presenter.txConfirmationState.collectAsState()
    val btcBalance by presenter.balanceFromTx.collectAsState()
    val buttonText by presenter.buttonText.collectAsState()
    val explorerRequestError by presenter.errorMessage.collectAsState()
    val blockExplorer by presenter.blockExplorer.collectAsState()
    val tradeItemModel = presenter.selectedTrade.value!!
    val txId = tradeItemModel.bisqEasyTradeModel.paymentProof.value ?: "data.na".i18n()

    val role = if (tradeItemModel.bisqEasyTradeModel.isBuyer) "buyer" else "seller"
    val waitingText = "bisqEasy.tradeState.info.$role.phase3b.balance.prompt".i18n(txId)  // Waiting for blockchain data...
    val balanceLabel = "bisqEasy.tradeState.info.$role.phase3b.balance".i18n() // Bitcoin payment
    Column {
        BisqGap.V1()
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CircularLoadingImage(
                image = Res.drawable.trade_bitcoin_confirmation,
                isLoading = true
            )
            // Waiting for blockchain confirmation
            BisqText.h5Light(text = "bisqEasy.tradeState.info.$role.phase3b.headline.MAIN_CHAIN".i18n())
        }

        Column {
            BisqGap.V1()
            BisqText.baseLight(
                // The Bitcoin payment require at least 1 blockchain confirmation to be considered complete.
                text = "bisqEasy.tradeState.info.$role.phase3b.info.MAIN_CHAIN".i18n(),
                color = BisqTheme.colors.grey2
            )

            BisqGap.V1()
            // todo add copy icon
            BisqTextField(
                // Transaction ID
                label = "bisqEasy.tradeState.info.phase3b.txId".i18n(),
                value = txId,
                disabled = true
            )

            BisqGap.VQuarter()


            when (confirmationState) {
                IDLE,
                REQUEST_STARTED -> {
                    BisqTextField(
                        label = balanceLabel,
                        placeholder = waitingText,
                        helperText = "bisqEasy.tradeState.info.phase3b.balance.help.explorerLookup".i18n(blockExplorer), // Looking up transaction at block explorer ''{0}''
                        errorText = explorerRequestError ?: "",
                        disabled = true,
                        modifier = Modifier.alpha(0.5f)
                    )
                }

                IN_MEMPOOL -> {
                    //todo
                    BisqTextField(
                        label = balanceLabel,
                        value = btcBalance,
                        helperText = "bisqEasy.tradeState.info.phase3b.balance.help.notConfirmed".i18n(), // Transaction seen in mempool but not confirmed yet
                        errorText = explorerRequestError ?: "",
                        color = BisqTheme.colors.warning,
                        disabled = true,
                    )
                }

                CONFIRMED -> {
                    //todo
                    BisqTextField(
                        label = balanceLabel,
                        value = btcBalance,
                        helperText = "bisqEasy.tradeState.info.phase3b.balance.help.confirmed".i18n(), // Transaction is confirmed
                        errorText = explorerRequestError ?: "",
                        //color = BisqTheme.colors.primary,
                        disabled = true,
                    )
                }

                FAILED -> {
                    //todo
                    BisqTextField(
                        label = balanceLabel,
                        value = waitingText,
                        errorText = explorerRequestError ?: "",
                        disabled = true,
                    )
                }
            }

            BisqGap.V1()
            //todo if skip is set we use grey button style
            BisqButton(
                text = buttonText,
                onClick = { presenter.onCompleteTrade() },
                padding = PaddingValues(
                    horizontal = 18.dp,
                    vertical = 6.dp
                )
            )
        }
    }
}
