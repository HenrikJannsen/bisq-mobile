package network.bisq.mobile.presentation.ui.uicases.open_trades.selected.states

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import network.bisq.mobile.i18n.i18n
import network.bisq.mobile.presentation.ui.components.atoms.BisqButton
import network.bisq.mobile.presentation.ui.components.atoms.BisqText
import network.bisq.mobile.presentation.ui.components.atoms.BisqTextField
import network.bisq.mobile.presentation.ui.components.atoms.layout.BisqGap
import network.bisq.mobile.presentation.ui.helpers.RememberPresenterLifecycle
import network.bisq.mobile.presentation.ui.theme.BisqTheme

@Composable
fun SellerState1(
    presenter: SellerState1Presenter
) {
    RememberPresenterLifecycle(presenter)

    val paymentAccountData by presenter.paymentAccountData.collectAsState()

    Column {
        BisqGap.V1()
        BisqText.h5Light(text = "bisqEasy.tradeState.info.seller.phase1.headline".i18n()) // Send your payment account data to the buyer

        BisqGap.V1()
        BisqText.baseLight(
            text = "bisqEasy.tradeState.info.seller.phase1.accountData.prompt".i18n(), // Fill in your payment account data. E.g. IBAN, BIC and account owner name
            color = BisqTheme.colors.grey2
        )

        BisqGap.V1()
        BisqTextField(
            label = "bisqEasy.tradeState.info.seller.phase1.accountData".i18n(), // My payment account data
            value = paymentAccountData,
            onValueChanged = { presenter.onPaymentDataInput(it) },
        )

        BisqGap.V1()
        BisqButton(
            text = "bisqEasy.tradeState.info.seller.phase1.buttonText".i18n(), // Send account data
            onClick = { presenter.onSendPaymentData() },
            disabled = paymentAccountData.isEmpty(),
            padding = PaddingValues(
                horizontal = 18.dp,
                vertical = 6.dp
            )
        )
    }
}