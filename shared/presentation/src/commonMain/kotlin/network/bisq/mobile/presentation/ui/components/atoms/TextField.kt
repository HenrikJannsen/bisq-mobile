package network.bisq.mobile.presentation.ui.components.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import network.bisq.mobile.presentation.ui.components.atoms.button.CopyIconButton
import network.bisq.mobile.presentation.ui.theme.BisqTheme

@Composable
fun BisqTextField(
    label: String = "",
    value: String = "",
    onValueChange: (String, Boolean) -> Unit = { it, isValid -> }, // Param1: newValue, Param2: validatity of newValue, based on validation()
    placeholder: String = "",
    labelRightSuffix: (@Composable () -> Unit)? = null,
    leftSuffix: (@Composable () -> Unit)? = null,
    rightSuffix: (@Composable () -> Unit)? = null,
    rightSuffixModifier: Modifier = Modifier.width(50.dp),
    isSearch: Boolean = false,
    helperText: String = "",
    indicatorColor: Color = BisqTheme.colors.primary,
    isTextArea: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Unspecified,
    paddingValues: PaddingValues = PaddingValues(all = 12.dp),
    disabled: Boolean = false,
    color: Color = BisqTheme.colors.light2,
    showCopy: Boolean = false,
    valuePrefix: String? = null,
    valueSuffix: String? = null,
    validation: ((String) -> String?)? = null,
    modifier: Modifier = Modifier,
) {
    var isFocused by remember { mutableStateOf(false) }
    var validationError by remember { mutableStateOf<String?>(null) }

    val focusManager = LocalFocusManager.current

    val imeAction = when {
        isSearch -> ImeAction.Search
        isTextArea -> ImeAction.Next
        else -> ImeAction.Done
    }

    var finalValue = ""
    finalValue = if (valuePrefix != null) valuePrefix + value else value
    finalValue = if (valueSuffix != null) value + valueSuffix else value

    val dangerColor = BisqTheme.colors.danger
    val finalIndicatorColor by remember(validationError) {
        mutableStateOf(
            if (validationError == null || validationError?.isEmpty() == true)
                indicatorColor
            else
                dangerColor
        )
    }

    val secondaryColor = BisqTheme.colors.secondary
    val secondaryDisabledColor = BisqTheme.colors.secondaryDisabled
    val finalBackgroundColor by remember(disabled) {
        mutableStateOf(
            if (disabled) {
                secondaryDisabledColor
            } else {
                secondaryColor
            }
        )
    }

    val light2Color = BisqTheme.colors.light2
    val light5Color = BisqTheme.colors.grey1
    val finalLabelColor by remember(disabled) {
        mutableStateOf(
            if (disabled) {
                light5Color
            } else {
                light2Color
            }
        )
    }

    var hasInitialized by remember { mutableStateOf(false) }
    LaunchedEffect(value) {
        if (hasInitialized) {
            validationError = validation?.invoke(value)
            onValueChange(value, validationError == null)
        }
        hasInitialized = true
    }

    Column(modifier = modifier) {
        if (label.isNotEmpty()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BisqText.baseLight(
                    text = label,
                    color = finalLabelColor,
                    modifier = Modifier.padding(start = 4.dp, top = 4.dp, bottom = 2.dp)
                )
                if (labelRightSuffix != null) {
                    labelRightSuffix()
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(6.dp))
                .background(color = finalBackgroundColor)
                .drawBehind {
                    if (!isSearch && isFocused) {
                        drawLine(
                            color = finalIndicatorColor,
                            start = Offset(0f, size.height),
                            end = Offset(size.width, size.height),
                            strokeWidth = 4.dp.toPx()
                        )
                    }
                }
        ) {
            BasicTextField(
                value = finalValue,
                onValueChange = {
                    var cleanValue = it
                    if (valuePrefix != null && cleanValue.startsWith(valuePrefix)) {
                        cleanValue = cleanValue.removePrefix(valuePrefix)
                    }
                    if (valueSuffix != null && cleanValue.endsWith(valueSuffix)) {
                        cleanValue = cleanValue.removeSuffix(valueSuffix)
                    }
                    validationError = validation?.invoke(cleanValue)
                    onValueChange(cleanValue, validationError == null || validationError?.isEmpty() == true)
                },
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth()
                    .onFocusChanged { focusState ->
                        isFocused = focusState.isFocused
                        if (!focusState.isFocused) {
                            validationError = validation?.invoke(value)
                        }
                    },
                singleLine = !isTextArea,
                maxLines = if (isTextArea) 4 else 1,
                textStyle = TextStyle(
                    color = color,
                    fontSize = 18.sp,
                    textDecoration = TextDecoration.None
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType,
                    imeAction = imeAction
                ),
                cursorBrush = SolidColor(BisqTheme.colors.primary),
                enabled = !disabled,
                decorationBox = { innerTextField ->

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        if (leftSuffix != null) {
                            leftSuffix()
                            Spacer(modifier = Modifier.width(10.dp))
                        }

                        Box(modifier = Modifier.weight(1f)) {
                            if (value.isEmpty()) {
                                BisqText.largeLight(
                                    text = placeholder,
                                    color = BisqTheme.colors.grey2
                                )
                            }
                            innerTextField()
                        }


                        if (showCopy) {
                            CopyIconButton(value)
                        }

                        if (rightSuffix != null) {
                            Box(modifier = rightSuffixModifier) {
                                rightSuffix()
                            }
                        }
                    }
                }
            )
        }
        // Error text has priority over help field
        if (validationError?.isNotEmpty() == true) {
            BisqText.smallRegular(
                text = validationError!!,
                modifier = Modifier.padding(start = 4.dp, top = 1.dp, bottom = 4.dp),
                color = BisqTheme.colors.danger
            )
        } else if (helperText.isNotEmpty()) {
            BisqText.smallRegular(
                text = helperText,
                modifier = Modifier.padding(start = 4.dp, top = 1.dp, bottom = 4.dp),
                color = BisqTheme.colors.grey1
            )
        }
    }
}