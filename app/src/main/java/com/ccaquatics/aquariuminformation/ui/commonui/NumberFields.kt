package com.ccaquatics.aquariuminformation.ui.commonui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ccaquatics.aquariuminformation.R
import com.ccaquatics.aquariuminformation.data.tankvolumes.calculatorDataSource

@Composable
fun InputNumberField(
	modifier: Modifier = Modifier,
	@StringRes label: Int,
	@StringRes placeholder: Int,
	value: String,
	onValueChange: (String) -> Unit,
	shape: Shape = RoundedCornerShape(
		bottomStart = 0.dp,
		bottomEnd = 0.dp,
		topStart = dimensionResource(id = R.dimen.shape_medium),
		topEnd = dimensionResource(id = R.dimen.shape_medium),
	),
	focusedColor: Color,
	focusedContainerColor: Color,
	unfocusedColor: Color,
	imeAction: ImeAction = ImeAction.Done,
) {
	val focusManager = LocalFocusManager.current

	Column(
		modifier = modifier,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		TextField(
			modifier = Modifier
				.align(Alignment.CenterHorizontally),
			value = value,
			onValueChange = onValueChange,
			colors = TextFieldDefaults.colors(
				focusedIndicatorColor = focusedColor,
				focusedLabelColor = focusedColor,
				focusedPlaceholderColor = focusedColor,
				focusedTextColor = focusedColor,
				focusedSupportingTextColor = focusedColor,
				cursorColor = focusedColor,
				focusedContainerColor = focusedContainerColor,
				unfocusedTextColor = unfocusedColor,
				unfocusedIndicatorColor = unfocusedColor,
				unfocusedLabelColor = unfocusedColor,
			),
			label = {
				Text(
					stringResource(id = label),
				)
			},
			placeholder = {
				Text(
					stringResource(id = placeholder),
				)
			},
			keyboardOptions = KeyboardOptions(
				keyboardType = KeyboardType.Number,
				imeAction = imeAction
			),
			keyboardActions = KeyboardActions(
				onDone = { focusManager.clearFocus() }
			),
			shape = shape,
			trailingIcon = {
				if (value.isNotEmpty()) {
					IconButton(
						onClick = {
							onValueChange("")
						}
					) {
						Icon(
							modifier = Modifier.size(dimensionResource(id = R.dimen.icon_trailing_small)),
							painter = painterResource(id = R.drawable.ic_cancel),
							contentDescription = stringResource(R.string.clear),
							tint = MaterialTheme.colorScheme.outline
						)
					}
				}
			}
		)
	}
}

@Composable
fun InputNumberFieldTwoInputs(
	modifier: Modifier = Modifier,
	@StringRes label1: Int,
	@StringRes placeholder1: Int,
	@StringRes label2: Int,
	@StringRes placeholder2: Int,
	value1: String,
	onValueChange1: (String) -> Unit,
	value2: String,
	onValueChange2: (String) -> Unit,
	focusedColor: Color,
	focusedContainerColor: Color,
	unfocusedColor: Color,
) {
	Column(modifier = modifier) {
		InputNumberField(
			label = label1,
			placeholder = placeholder1,
			value = value1,
			onValueChange = onValueChange1,
			focusedColor = focusedColor,
			focusedContainerColor = focusedContainerColor,
			unfocusedColor = unfocusedColor,
			imeAction = ImeAction.Next
		)
		SmallSpacer()
		InputNumberField(
			label = label2,
			placeholder = placeholder2,
			value = value2,
			onValueChange = onValueChange2,
			focusedColor = focusedColor,
			focusedContainerColor = focusedContainerColor,
			unfocusedColor = unfocusedColor,
		)
	}
}

@Composable
fun InputRowNumberFieldTwoInputs(
	modifier: Modifier = Modifier,
	@StringRes label1: Int,
	@StringRes placeholder1: Int,
	@StringRes label2: Int,
	@StringRes placeholder2: Int,
	value1: String,
	onValueChange1: (String) -> Unit,
	value2: String,
	onValueChange2: (String) -> Unit,
	focusedColor: Color,
	focusedContainerColor: Color,
	unfocusedColor: Color,
) {
	Column(modifier = modifier) {
		Row(
			modifier = Modifier
				.fillMaxWidth(),
			horizontalArrangement = Arrangement.Center,
			verticalAlignment = Alignment.CenterVertically
		) {
			InputNumberField(
				modifier = Modifier
					.padding(
						start = dimensionResource(id = R.dimen.padding_verySmall),
						end = dimensionResource(id = R.dimen.padding_verySmall)
					)
					.weight(1f),
				label = label1,
				placeholder = placeholder1,
				value = value1,
				onValueChange = onValueChange1,
				focusedColor = focusedColor,
				focusedContainerColor = focusedContainerColor,
				unfocusedColor = unfocusedColor,
				imeAction = ImeAction.Next
			)
			InputNumberField(
				modifier = Modifier
					.padding(
						start = dimensionResource(id = R.dimen.padding_verySmall),
						end = dimensionResource(id = R.dimen.padding_verySmall)
					)
					.weight(1f),
				label = label2,
				placeholder = placeholder2,
				value = value2,
				onValueChange = onValueChange2,
				focusedColor = focusedColor,
				focusedContainerColor = focusedContainerColor,
				unfocusedColor = unfocusedColor,
			)
		}
	}
}

@Composable
fun InputQuadNumberFieldFourInputs(
	modifier: Modifier = Modifier,
	@StringRes label1: Int,
	@StringRes placeholder1: Int,
	@StringRes label2: Int,
	@StringRes placeholder2: Int,
	value1: String,
	onValueChange1: (String) -> Unit,
	value2: String,
	onValueChange2: (String) -> Unit,
	@StringRes label3: Int,
	@StringRes placeholder3: Int,
	@StringRes label4: Int,
	@StringRes placeholder4: Int,
	value3: String,
	onValueChange3: (String) -> Unit,
	value4: String,
	onValueChange4: (String) -> Unit,
	focusedColor: Color,
	focusedContainerColor: Color,
	unfocusedColor: Color,
) {
	Column(modifier = modifier) {
		Row(
			modifier = Modifier
				.fillMaxWidth(),
			horizontalArrangement = Arrangement.Center,
			verticalAlignment = Alignment.CenterVertically
		) {
			InputNumberField(
				modifier = Modifier
					.padding(
						start = dimensionResource(id = R.dimen.padding_verySmall),
						end = dimensionResource(id = R.dimen.padding_verySmall)
					)
					.weight(1f),
				label = label1,
				placeholder = placeholder1,
				value = value1,
				onValueChange = onValueChange1,
				focusedColor = focusedColor,
				focusedContainerColor = focusedContainerColor,
				unfocusedColor = unfocusedColor,
				imeAction = ImeAction.Next
			)
			InputNumberField(
				modifier = Modifier
					.padding(
						start = dimensionResource(id = R.dimen.padding_verySmall),
						end = dimensionResource(id = R.dimen.padding_verySmall)
					)
					.weight(1f),
				label = label2,
				placeholder = placeholder2,
				value = value2,
				onValueChange = onValueChange2,
				focusedColor = focusedColor,
				focusedContainerColor = focusedContainerColor,
				unfocusedColor = unfocusedColor,
				imeAction = ImeAction.Next
			)
		}
		SmallSpacer()
		Row(
			modifier = Modifier
				.fillMaxWidth(),
			horizontalArrangement = Arrangement.Center,
			verticalAlignment = Alignment.CenterVertically
		) {
			InputNumberField(
				modifier = Modifier
					.padding(
						start = dimensionResource(id = R.dimen.padding_verySmall),
						end = dimensionResource(id = R.dimen.padding_verySmall)
					)
					.weight(1f),
				label = label3,
				placeholder = placeholder3,
				value = value3,
				onValueChange = onValueChange3,
				focusedColor = focusedColor,
				focusedContainerColor = focusedContainerColor,
				unfocusedColor = unfocusedColor,
				imeAction = ImeAction.Next
			)
			InputNumberField(
				modifier = Modifier
					.padding(
						start = dimensionResource(id = R.dimen.padding_verySmall),
						end = dimensionResource(id = R.dimen.padding_verySmall)
					)
					.weight(1f),
				label = label4,
				placeholder = placeholder4,
				value = value4,
				onValueChange = onValueChange4,
				focusedColor = focusedColor,
				focusedContainerColor = focusedContainerColor,
				unfocusedColor = unfocusedColor,
			)
		}
	}
}

@Composable
fun InputNumberFieldThreeInputs(
	modifier: Modifier = Modifier,
	@StringRes label1: Int,
	@StringRes placeholder1: Int,
	@StringRes label2: Int,
	@StringRes placeholder2: Int,
	@StringRes label3: Int,
	@StringRes placeholder3: Int,
	value1: String,
	onValueChange1: (String) -> Unit,
	value2: String,
	onValueChange2: (String) -> Unit,
	value3: String,
	onValueChange3: (String) -> Unit,
	focusedColor: Color,
	focusedContainerColor: Color,
	unfocusedColor: Color,
) {
	Column(modifier = modifier) {
		Row(
			modifier = Modifier.fillMaxWidth(),
			verticalAlignment = Alignment.CenterVertically
		) {
			InputNumberField(
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.padding_verySmall))
					.weight(1f),
				label = label1,
				placeholder = placeholder1,
				value = value1,
				onValueChange = onValueChange1,
				focusedColor = focusedColor,
				focusedContainerColor = focusedContainerColor,
				unfocusedColor = unfocusedColor,
				imeAction = ImeAction.Next
			)
			InputNumberField(
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.padding_verySmall))
					.weight(1f),
				label = label2,
				placeholder = placeholder2,
				value = value2,
				onValueChange = onValueChange2,
				focusedColor = focusedColor,
				focusedContainerColor = focusedContainerColor,
				unfocusedColor = unfocusedColor,
				imeAction = ImeAction.Next
			)
			InputNumberField(
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.padding_verySmall))
					.weight(1f),
				label = label3,
				placeholder = placeholder3,
				value = value3,
				onValueChange = onValueChange3,
				focusedColor = focusedColor,
				focusedContainerColor = focusedContainerColor,
				unfocusedColor = unfocusedColor,
			)
		}
	}
}

@Composable
fun InputNumberFieldThreeStackedInputs(
	modifier: Modifier = Modifier,
	@StringRes label1: Int,
	@StringRes placeholder1: Int,
	@StringRes label2: Int,
	@StringRes placeholder2: Int,
	@StringRes label3: Int,
	@StringRes placeholder3: Int,
	value1: String,
	onValueChange1: (String) -> Unit,
	value2: String,
	onValueChange2: (String) -> Unit,
	value3: String,
	onValueChange3: (String) -> Unit,
	focusedColor: Color,
	focusedContainerColor: Color,
	unfocusedColor: Color,
) {
	Column(modifier = modifier) {
		Row(
			modifier = Modifier
				.fillMaxWidth(),
			horizontalArrangement = Arrangement.SpaceBetween,
			verticalAlignment = Alignment.CenterVertically
		) {
			InputNumberField(
				modifier = Modifier
					.padding(horizontal = dimensionResource(id = R.dimen.padding_verySmall))
					.weight(1f),
				label = label1,
				placeholder = placeholder1,
				value = value1,
				onValueChange = onValueChange1,
				focusedColor = focusedColor,
				focusedContainerColor = focusedContainerColor,
				unfocusedColor = unfocusedColor,
				imeAction = ImeAction.Next
			)
			InputNumberField(
				modifier = Modifier
					.padding(horizontal = dimensionResource(id = R.dimen.padding_verySmall))
					.weight(1f),
				label = label2,
				placeholder = placeholder2,
				value = value2,
				onValueChange = onValueChange2,
				focusedColor = focusedColor,
				focusedContainerColor = focusedContainerColor,
				unfocusedColor = unfocusedColor,
				imeAction = ImeAction.Next
			)
		}
		SmallSpacer()
		Row(
			modifier = Modifier
				.fillMaxWidth(),
			horizontalArrangement = Arrangement.Center,
			verticalAlignment = Alignment.CenterVertically
		) {
			InputNumberField(
				modifier = Modifier
					.padding(horizontal = dimensionResource(id = R.dimen.padding_verySmall))
					.weight(1f),
				label = label3,
				placeholder = placeholder3,
				value = value3,
				onValueChange = onValueChange3,
				focusedColor = focusedColor,
				focusedContainerColor = focusedContainerColor,
				unfocusedColor = unfocusedColor,
			)
		}
	}
}

@Composable
fun CalculateField(
	modifier: Modifier = Modifier,
	inputContent: @Composable () -> Unit,
	@StringRes inputText: Int,
	inputValue: String,
	@StringRes equalsText: Int = calculatorDataSource.equalsText,
	calculateContent: @Composable () -> Unit,
	contentColor: Color,
	containerColor: Color,
) {
	Column(
		modifier = modifier,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		inputContent()
		MediumSpacer()
		Text(
			text = stringResource(id = inputText, inputValue),
			modifier = Modifier
				.padding(horizontal = dimensionResource(id = R.dimen.padding_verySmall)),
			color = contentColor,
			textAlign = TextAlign.Center
		)
		MediumSpacer()
		EqualsText(
			color = contentColor,
			equalsText = equalsText
		)
		SmallSpacer()
		Column(
			modifier = Modifier.fillMaxWidth(),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			SingleWideCard(
				contentColor = contentColor,
				containerColor = containerColor
			) {
				calculateContent()
			}
		}
	}
}

@Composable
fun EqualsText(
	modifier: Modifier = Modifier,
	@StringRes equalsText: Int = calculatorDataSource.equalsText,
	color: Color,
) {
	Column(modifier = modifier) {
		Text(
			text = stringResource(id = equalsText),
			modifier = Modifier
				.align(Alignment.CenterHorizontally),
			color = color,
		)
	}
}


@Composable
fun CalculateFieldTwoInputs(
	modifier: Modifier = Modifier,
	inputContent: @Composable () -> Unit,
	@StringRes inputText: Int,
	inputValue1: String,
	inputValue2: String,
	@StringRes equalsText: Int = calculatorDataSource.equalsText,
	calculateContent: @Composable () -> Unit,
	contentColor: Color,
	containerColor: Color,
) {
	Column(
		modifier = modifier,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		inputContent()
		MediumSpacer()
		Text(
			text = stringResource(id = inputText, inputValue1, inputValue2),
			modifier = Modifier
				.padding(horizontal = dimensionResource(id = R.dimen.padding_verySmall)),
			color = contentColor,
			textAlign = TextAlign.Center
		)
		MediumSpacer()
		EqualsText(
			color = contentColor,
			equalsText = equalsText
		)
		SmallSpacer()
		Column(
			modifier = Modifier.fillMaxWidth(),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			SingleWideCard(
				contentColor = contentColor,
				containerColor = containerColor
			) {
				calculateContent()
			}
		}
	}
}

@Composable
fun CalculateFieldFourInputs(
	modifier: Modifier = Modifier,
	inputContent: @Composable () -> Unit,
	@StringRes inputText: Int,
	inputValue1: String,
	inputValue2: String,
	inputValue3: String,
	inputValue4: String,
	@StringRes equalsText: Int = calculatorDataSource.equalsText,
	calculateContent: @Composable () -> Unit,
	contentColor: Color,
	containerColor: Color,
) {
	Column(
		modifier = modifier,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		inputContent()
		MediumSpacer()

		Text(
			text = stringResource(
				id = inputText,
				inputValue1,
				inputValue2,
				inputValue3,
				inputValue4
			),
			modifier = Modifier
				.padding(horizontal = dimensionResource(id = R.dimen.padding_verySmall)),
			color = contentColor,
			textAlign = TextAlign.Center
		)
		MediumSpacer()
		EqualsText(
			color = contentColor,
			equalsText = equalsText
		)
		SmallSpacer()
		Column(
			modifier = Modifier.fillMaxWidth(),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			SingleWideCard(
				contentColor = contentColor,
				containerColor = containerColor
			) {
				calculateContent()
			}
		}
	}
}

@Composable
fun CalculateFieldThreeInputs(
	modifier: Modifier = Modifier,
	inputContent: @Composable () -> Unit,
	@StringRes inputText: Int,
	inputValue1: String,
	inputValue2: String,
	inputValue3: String,
	@StringRes equalsText: Int = calculatorDataSource.equalsText,
	calculateContent: @Composable () -> Unit,
	contentColor: Color,
	containerColor: Color,
) {
	Column(
		modifier = modifier,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		inputContent()
		MediumSpacer()
		Text(
			text = stringResource(id = inputText, inputValue1, inputValue2, inputValue3),
			modifier = Modifier
				.padding(horizontal = dimensionResource(id = R.dimen.padding_verySmall)),
			color = contentColor,
			textAlign = TextAlign.Center
		)
		MediumSpacer()
		EqualsText(
			color = contentColor,
			equalsText = equalsText
		)
		SmallSpacer()
		Column(
			modifier = Modifier.fillMaxWidth(),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			SingleWideCard(
				contentColor = contentColor,
				containerColor = containerColor
			) {
				calculateContent()
			}
		}
	}
}

@Composable
fun CalculatedText(
	modifier: Modifier = Modifier,
	@StringRes text: Int,
	calculatedValue: Double,
	textColor: Color
) {
	Column(modifier = modifier) {
		Text(
			modifier = Modifier
				.align(Alignment.CenterHorizontally),
			text = stringResource(id = text, calculatedValue),
			fontSize = 20.sp,
			fontWeight = FontWeight.Bold,
			color = textColor
		)
	}
}
