package network.bisq.mobile.presentation.ui.uicases.offer.create_offer

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import network.bisq.mobile.domain.formatters.PercentageFormatter
import network.bisq.mobile.domain.formatters.PriceQuoteFormatter
import network.bisq.mobile.domain.parser.PercentageParser
import network.bisq.mobile.domain.parser.PriceParser
import network.bisq.mobile.domain.replicated.common.currency.marketCodes
import network.bisq.mobile.domain.replicated.common.monetary.PriceQuoteVO
import network.bisq.mobile.domain.replicated.common.monetary.fromPrice
import network.bisq.mobile.domain.utils.PriceUtil
import network.bisq.mobile.i18n.AppStrings
import network.bisq.mobile.presentation.BasePresenter
import network.bisq.mobile.presentation.MainPresenter
import network.bisq.mobile.presentation.ui.navigation.Routes
import network.bisq.mobile.presentation.ui.uicases.offer.create_offer.CreateOfferPresenter.PriceType

class CreateOfferPricePresenter(
    mainPresenter: MainPresenter,
    private val createOfferPresenter: CreateOfferPresenter
) : BasePresenter(mainPresenter) {

    lateinit var priceTypeTitle: String
    lateinit var fixPriceDescription: String
    var priceTypes: List<PriceType> = PriceType.entries.toList()
    lateinit var priceQuote: PriceQuoteVO
    var percentagePriceValue: Double = 0.0
    private val _formattedPercentagePrice = MutableStateFlow("")
    val formattedPercentagePrice: StateFlow<String> = _formattedPercentagePrice
    private val _formattedPrice = MutableStateFlow("")
    val formattedPrice: StateFlow<String> = _formattedPrice
    private val _priceType = MutableStateFlow(PriceType.PERCENTAGE)
    val priceType: StateFlow<PriceType> = _priceType

    private lateinit var createOfferModel: CreateOfferPresenter.CreateOfferModel
    lateinit var appStrings: AppStrings

    override fun onViewAttached() {
        createOfferModel = createOfferPresenter.createOfferModel

        _priceType.value = createOfferModel.priceType
        priceQuote = createOfferModel.priceQuote
        percentagePriceValue = createOfferModel.percentagePriceValue
        _formattedPercentagePrice.value = PercentageFormatter.format(percentagePriceValue, false)
        _formattedPrice.value = PriceQuoteFormatter.format(priceQuote)
        val bisqEasyTradeWizardStrings = appStrings.bisqEasyTradeWizard
        priceTypeTitle = if (priceType.value == PriceType.PERCENTAGE)
            bisqEasyTradeWizardStrings.bisqEasy_tradeWizard_trade_price_percentage
        else
            bisqEasyTradeWizardStrings.bisqEasy_tradeWizard_trade_price_fixed

        fixPriceDescription = bisqEasyTradeWizardStrings.bisqEasy_price_tradePrice_inputBoxText(createOfferModel.market!!.marketCodes)

        //onPercentagePriceChanged("10")
    }

    fun getPriceTypeDisplayString(priceType: PriceType): String {
        if (priceType == PriceType.PERCENTAGE)
            return appStrings.bisqEasyTradeWizard.bisqEasy_tradeWizard_trade_price_percentage
        else
            return appStrings.bisqEasyTradeWizard.bisqEasy_tradeWizard_trade_price_fixed
    }

    fun onSelectPriceType(value: PriceType) {
        _priceType.value = value
    }

    fun onPercentagePriceChanged(value: String) {
        percentagePriceValue = PercentageParser.parse(value)
        _formattedPercentagePrice.value = PercentageFormatter.format(this.percentagePriceValue, false)
        val marketPriceQuote = createOfferPresenter.getMostRecentPriceQuote(createOfferModel.market!!)
        priceQuote = PriceUtil.fromMarketPriceMarkup(marketPriceQuote, this.percentagePriceValue)
        _formattedPrice.value = PriceQuoteFormatter.format(priceQuote)
    }

    fun onFixPriceChanged(value: String) {
        val valueAsDouble = PriceParser.parse(value)
        priceQuote = PriceQuoteVO.fromPrice(valueAsDouble, createOfferModel.market!!)
        _formattedPrice.value = PriceQuoteFormatter.format(priceQuote)
        val marketPriceQuote = createOfferPresenter.getMostRecentPriceQuote(createOfferModel.market!!)
        percentagePriceValue = PriceUtil.getPercentageToMarketPrice(marketPriceQuote, priceQuote)
        _formattedPercentagePrice.value = PercentageFormatter.format(percentagePriceValue, false)
    }

    fun onBack() {
        if (isValid(percentagePriceValue)) {
            commitToModel()
        }
        rootNavigator.popBackStack()
    }

    fun onNext() {
        if (isValid(percentagePriceValue)) {
            commitToModel()
            rootNavigator.navigate(Routes.CreateOfferPaymentMethod.name)
        }
    }

    private fun commitToModel() {
        createOfferPresenter.commitPrice(
            priceType.value, percentagePriceValue, priceQuote
        )
    }

    private fun isValid(percentagePriceValue: Double): Boolean {
        return percentagePriceValue >= -0.1 && percentagePriceValue <= 0.5
    }

}
