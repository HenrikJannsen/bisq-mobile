package network.bisq.mobile.presentation.ui.components.molecules

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import network.bisq.mobile.presentation.ui.theme.BisqTheme
import network.bisq.mobile.presentation.ui.theme.BisqUIConstants

@Composable
fun BisqDialog(
    onDismissRequest: () -> Unit = {},
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    content: @Composable ColumnScope.() -> Unit = {}
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(dismissOnClickOutside = true)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = BisqUIConstants.ScreenPadding5X)
        ) {
            Card(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .fillMaxWidth(),
                colors = CardColors(
                    containerColor = BisqTheme.colors.dark3,
                    contentColor = Color.Unspecified,
                    disabledContainerColor = Color.Unspecified,
                    disabledContentColor = Color.Unspecified,
                ),
                shape = RoundedCornerShape(16.dp),
            ) {
                // TODO: When content is too long, footer buttons will be hidden at bottom now.
                // Dialog should have Header, Footer with scrollable only for content
                Column(
                    modifier = Modifier.padding(BisqUIConstants.ScreenPadding2X).verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(BisqUIConstants.ScreenPadding),
                    horizontalAlignment = horizontalAlignment,
                ) {
                    content()
                }
            }
        }
    }
}