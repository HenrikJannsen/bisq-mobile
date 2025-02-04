package network.bisq.mobile.presentation.ui.components.organisms.offer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import bisqapps.shared.presentation.generated.resources.Res
import bisqapps.shared.presentation.generated.resources.bisq_easy
import bisqapps.shared.presentation.generated.resources.bisq_easy_circle
import network.bisq.mobile.i18n.i18n
import network.bisq.mobile.presentation.ui.components.atoms.BisqButton
import network.bisq.mobile.presentation.ui.components.atoms.BisqText
import network.bisq.mobile.presentation.ui.components.atoms.DynamicImage
import network.bisq.mobile.presentation.ui.components.atoms.image.RotatingImage
import network.bisq.mobile.presentation.ui.components.atoms.layout.BisqGap
import network.bisq.mobile.presentation.ui.components.molecules.BisqDialog
import network.bisq.mobile.presentation.ui.theme.BisqTheme
import network.bisq.mobile.presentation.ui.theme.BisqUIConstants
import org.jetbrains.compose.resources.painterResource

@Composable
fun TakeOfferSuccessDialog(
    onShowTrades: () -> Unit
) {

    BisqDialog {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            BisqText.h4Regular(text = "bisqEasy.takeOffer.review.takeOfferSuccess.headline".i18n(), textAlign = TextAlign.Center)

            BisqGap.V2()

            BisqText.baseRegular(text = "bisqEasy.tradeWizard.review.takeOfferSuccess.subTitle".i18n(), textAlign = TextAlign.Center)

            BisqGap.V2()

            BisqButton(
                "bisqEasy.takeOffer.review.takeOfferSuccessButton".i18n(),
                padding = PaddingValues(all= BisqUIConstants.ScreenPadding),
                onClick = onShowTrades,
            )

        }
    }
}