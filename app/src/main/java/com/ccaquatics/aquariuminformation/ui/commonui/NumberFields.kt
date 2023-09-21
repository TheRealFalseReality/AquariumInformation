package com.ccaquatics.aquariuminformation.ui.commonui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ccaquatics.aquariuminformation.R

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
	color: Color
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
				focusedIndicatorColor = color,
				focusedLabelColor = color,
				focusedPlaceholderColor = color,
				focusedTextColor = color,
				focusedSupportingTextColor = color,
				cursorColor = color,
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
				imeAction = ImeAction.Done
			),
			keyboardActions = KeyboardActions(
				onDone = { focusManager.clearFocus() }
			),
			shape = shape
		)
	}
}

@Composable
fun InputNumberFieldNext(
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
	color: Color
) {
	val focusManager = LocalFocusManager.current

	Column(
		modifier = modifier,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		TextField(
			modifier = Modifier
				.padding(
					top = dimensionResource(id = R.dimen.padding_small),
					bottom = dimensionResource(id = R.dimen.padding_small)
				)
				.align(Alignment.CenterHorizontally),
			value = value,
			onValueChange = onValueChange,
			colors = TextFieldDefaults.colors(
				focusedIndicatorColor = color,
				focusedLabelColor = color,
				focusedPlaceholderColor = color,
				focusedTextColor = color,
				focusedSupportingTextColor = color,
				cursorColor = color,
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
				imeAction = ImeAction.Next
			),
			keyboardActions = KeyboardActions(
				onDone = { focusManager.clearFocus() }
			),
			shape = shape
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
	color: Color
) {
	Column(modifier = modifier) {
		InputNumberFieldNext(
			label = label1,
			placeholder = placeholder1,
			value = value1,
			onValueChange = onValueChange1,
			color = color
		)
		MediumSpacer()
		InputNumberField(
			label = label2,
			placeholder = placeholder2,
			value = value2,
			onValueChange = onValueChange2,
			color = color
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
	color: Color
) {
	Column(modifier = modifier) {
		Row(
			modifier = Modifier
				.fillMaxWidth(),
			horizontalArrangement = Arrangement.Center,
			verticalAlignment = Alignment.CenterVertically
		) {
			InputNumberFieldNext(
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.padding_verySmall))
					.weight(1f),
				label = label1,
				placeholder = placeholder1,
				value = value1,
				onValueChange = onValueChange1,
				color = color
			)
			InputNumberField(
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.padding_verySmall))
					.weight(1f),
				label = label2,
				placeholder = placeholder2,
				value = value2,
				onValueChange = onValueChange2,
				color = color
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
	color: Color
) {
	Column(modifier = modifier) {
		Row(
			modifier = Modifier.fillMaxWidth(),
			verticalAlignment = Alignment.CenterVertically
		) {
			InputNumberFieldNext(
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.padding_verySmall))
					.weight(1f),
				label = label1,
				placeholder = placeholder1,
				value = value1,
				onValueChange = onValueChange1,
				color = color
			)
			InputNumberFieldNext(
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.padding_verySmall))
					.weight(1f),
				label = label2,
				placeholder = placeholder2,
				value = value2,
				onValueChange = onValueChange2,
				color = color
			)
			InputNumberField(
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.padding_verySmall))
					.weight(1f),
				label = label3,
				placeholder = placeholder3,
				value = value3,
				onValueChange = onValueChange3,
				color = color
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
	@StringRes equalsText: Int,
	calculateContent: @Composable () -> Unit,
	color: Color
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
				.align(Alignment.CenterHorizontally),
			color = color
		)
		MediumSpacer()
		Text(
			text = stringResource(id = equalsText),
			modifier = Modifier
				.align(Alignment.CenterHorizontally),
			color = color,
		)
		SmallSpacer()
		Column(
			modifier = Modifier.fillMaxWidth(),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			SingleWideCard {
				calculateContent()
			}
		}
	}
}

@Composable
fun CalculateFieldTwoInputs(
	modifier: Modifier = Modifier,
	inputContent: @Composable () -> Unit,
	@StringRes inputText: Int,
	inputValue1: String,
	inputValue2: String,
	@StringRes equalsText: Int,
	calculateContent: @Composable () -> Unit,
	color: Color
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
				.align(Alignment.CenterHorizontally)
				.padding(dimensionResource(id = R.dimen.padding_verySmall)),
			color = color
		)
		MediumSpacer()

		Text(
			text = stringResource(id = equalsText),
			modifier = Modifier
				.align(Alignment.CenterHorizontally)
				.padding(dimensionResource(id = R.dimen.padding_verySmall)),
			color = color,
		)
		SmallSpacer()
		Column(
			modifier = Modifier.fillMaxWidth(),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			SingleWideCard {
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
	@StringRes equalsText: Int,
	calculateContent: @Composable () -> Unit,
	color: Color
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
				.align(Alignment.CenterHorizontally)
				.padding(dimensionResource(id = R.dimen.padding_verySmall)),
			color = color
		)
		MediumSpacer()

		Text(
			text = stringResource(id = equalsText),
			modifier = Modifier
				.align(Alignment.CenterHorizontally)
				.padding(dimensionResource(id = R.dimen.padding_verySmall)),
			color = color,
		)
		SmallSpacer()
		Column(
			modifier = Modifier.fillMaxWidth(),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			SingleWideCard {
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
	@StringRes equalsText: Int,
	calculateContent: @Composable () -> Unit,
	color: Color
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
				.align(Alignment.CenterHorizontally)
				.padding(dimensionResource(id = R.dimen.padding_verySmall)),
			color = color
		)
		MediumSpacer()
		Text(
			text = stringResource(id = equalsText),
			modifier = Modifier
				.align(Alignment.CenterHorizontally)
				.padding(dimensionResource(id = R.dimen.padding_verySmall)),
			color = color,
		)
		SmallSpacer()
		Column(
			modifier = Modifier.fillMaxWidth(),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			SingleWideCard {
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
	color: Color
) {
	Column(modifier = modifier) {
		Text(
			modifier = Modifier
				.align(Alignment.CenterHorizontally),
			text = stringResource(id = text, calculatedValue),
			fontSize = 20.sp,
			fontWeight = FontWeight.Bold,
			color = color
		)
	}
}
