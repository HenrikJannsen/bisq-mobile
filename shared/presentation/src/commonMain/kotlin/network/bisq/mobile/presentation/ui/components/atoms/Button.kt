package network.bisq.mobile.presentation.ui.components.atoms

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import network.bisq.mobile.presentation.ui.components.atoms.layout.BisqGap
import network.bisq.mobile.presentation.ui.theme.BisqTheme
import network.bisq.mobile.presentation.ui.theme.BisqUIConstants

enum class BisqButtonType {
    Default,
    Outline,
    Clear
}

/**
 * Either pass
 *  - iconOnly for Icon only button (or)
 *  - textComponent for button with custom styled text (or)
 *  - text for regular button
 */
@Composable
fun BisqButton(
    text: String? = "Button",
    textAlign: TextAlign = TextAlign.Center,
    onClick: (() -> Unit)? = null,
    color: Color = BisqTheme.colors.light1,
    textColor: Color = BisqTheme.colors.light1,
    backgroundColor: Color = BisqTheme.colors.primary,
    fullWidth: Boolean = false,
    padding: PaddingValues = PaddingValues(
        horizontal = BisqUIConstants.ScreenPadding4X,
        vertical = BisqUIConstants.ScreenPaddingHalf
    ),
    iconOnly: (@Composable () -> Unit)? = null,
    leftIcon: (@Composable () -> Unit)? = null,
    rightIcon: (@Composable () -> Unit)? = null,
    textComponent: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 8.dp,
    disabled: Boolean = false,
    isLoading: Boolean = false,
    border: BorderStroke? = null,
    type: BisqButtonType = BisqButtonType.Default,
    borderColor: Color = BisqTheme.colors.primary,
) {

    val enabled = !disabled && !isLoading

    val finalBackgroundColor = when (type) {
        BisqButtonType.Default -> if(disabled) backgroundColor.copy(alpha = 0.75F) else backgroundColor
        BisqButtonType.Outline -> Color.Transparent
        BisqButtonType.Clear -> Color.Transparent
    }

    val finalBorder = when (type) {
        BisqButtonType.Default -> border
        BisqButtonType.Outline -> BorderStroke(1.dp, borderColor)
        BisqButtonType.Clear -> null
    }

    val finalContentColor = if (disabled)
        BisqTheme.colors.grey1
    else
        color

    Button(
        onClick = { onClick?.invoke() },
        contentPadding = if (iconOnly != null) PaddingValues(horizontal = 0.dp, vertical = 0.dp) else padding,
        colors = ButtonColors(
            containerColor = finalBackgroundColor,
            disabledContainerColor = finalBackgroundColor.copy(alpha = 0.5f),
            contentColor = finalContentColor,
            disabledContentColor = finalContentColor.copy(alpha = 0.5f),
        ),
        shape = RoundedCornerShape(cornerRadius),
        enabled = enabled,
        border = finalBorder,
        modifier = if (fullWidth) modifier.fillMaxWidth() else modifier
    ) {
        if (iconOnly == null && text == null && textComponent == null) {
            BisqText.baseMedium("Error: Pass either text or customText or icon")
        }

        if (iconOnly != null) {
            iconOnly()
        } else if (text != null) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(16.dp),
                        color = BisqTheme.colors.light1,
                        strokeWidth = 2.dp
                    )
                    BisqGap.HHalf()
                }
                if (leftIcon != null) leftIcon()
                if (leftIcon != null) Spacer(modifier = Modifier.width(10.dp))
                if (textComponent != null) {
                    textComponent()
                } else {
                    BisqText.baseMedium(
                        text = text,
                        color = finalContentColor,
                        textAlign = textAlign,
                        modifier = if (fullWidth) Modifier.weight(1f) else Modifier,
                    )
                }
                if (rightIcon != null) Spacer(modifier = Modifier.width(10.dp))
                if (rightIcon != null) rightIcon()
            }
        }
    }
}
