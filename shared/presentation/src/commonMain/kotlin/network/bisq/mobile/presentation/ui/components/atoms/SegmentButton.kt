package network.bisq.mobile.presentation.ui.components.atoms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonColors
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import network.bisq.mobile.presentation.ui.theme.BisqTheme

@Composable
fun BisqSegmentButton(
    label: String = "",
    disabled: Boolean = false,
    items: List<String>,
    onValueChange: ((String) -> Unit)? = null,
    modifier: Modifier = Modifier.fillMaxWidth(),
) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    Column(modifier = modifier) {
        if (label.isNotEmpty()) {
            BisqText.baseRegular(
                text = label,
                color = BisqTheme.colors.light2,
            )
        }
        SingleChoiceSegmentedButtonRow(

        ) {
            items.forEachIndexed { index, label ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(
                        index = index,
                        count = items.size
                    ),
                    onClick = {
                        selectedIndex = index
                        if (onValueChange != null) {
                            onValueChange(items[selectedIndex])
                        }
                    },
                    selected = index == selectedIndex,
                    enabled = !disabled,
                    label = {
                        BisqText.baseRegular(
                            label,
                            color = if(disabled)
                                BisqTheme.colors.grey3
                            else
                                BisqTheme.colors.light5
                        )
                    },
                    colors = SegmentedButtonColors(
                        activeContainerColor = BisqTheme.colors.secondary,
                        activeContentColor = BisqTheme.colors.light5,
                        activeBorderColor = BisqTheme.colors.backgroundColor,
                        inactiveContainerColor = BisqTheme.colors.secondaryDisabled,
                        inactiveContentColor = BisqTheme.colors.light5,
                        inactiveBorderColor = BisqTheme.colors.backgroundColor,
                        disabledActiveContainerColor = BisqTheme.colors.secondaryDisabled,
                        disabledActiveContentColor = BisqTheme.colors.grey3,
                        disabledActiveBorderColor = BisqTheme.colors.backgroundColor,
                        disabledInactiveContainerColor = BisqTheme.colors.secondaryDisabled,
                        disabledInactiveContentColor = BisqTheme.colors.grey3,
                        disabledInactiveBorderColor = BisqTheme.colors.backgroundColor,
                    )
                )
            }
        }
    }
}