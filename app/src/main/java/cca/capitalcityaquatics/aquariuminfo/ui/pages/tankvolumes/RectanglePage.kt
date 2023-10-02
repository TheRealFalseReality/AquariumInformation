package cca.capitalcityaquatics.aquariuminfo.ui.pages.tankvolumes

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.data.tankvolumes.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.data.tankvolumes.rectangleDataSource
import cca.capitalcityaquatics.aquariuminfo.navigation.Rectangle
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateFieldThreeInputs
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateImage
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatorSubtitleTwo
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FormulaString
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.GenericCalculatePage
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.InputNumberFieldThreeStackedInputs
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageView
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.RadioButtonTwoUnits
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.SingleWideCardExpandableRadio
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.TankVolumeResults
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun RectanglePage() {
	PageView {
		RectangleLayout()
	}
}

@Composable
fun RectangleLayout(
	color: Color = MaterialTheme.colorScheme.secondary,
	containerColor: Color = MaterialTheme.colorScheme.secondaryContainer,
	contentColor: Color = MaterialTheme.colorScheme.onSecondaryContainer,
) {
	var inputLength by rememberSaveable {
		mutableStateOf("")
	}
	var inputWidth by rememberSaveable {
		mutableStateOf("")
	}
	var inputHeight by rememberSaveable {
		mutableStateOf("")
	}
	var selected by rememberSaveable {
		mutableIntStateOf(calculatorDataSource.radioTextFeet)
	}
	val length = inputLength.toDoubleOrNull() ?: 0.0
	val width = inputWidth.toDoubleOrNull() ?: 0.0
	val height = inputHeight.toDoubleOrNull() ?: 0.0
	val volGallon = calculateVolGallon(length, width, height).toDoubleOrNull() ?: 0.0
	val volLiter = calculateVolLiter(length, width, height).toDoubleOrNull() ?: 0.0
	val waterWeight = calculateWaterWeight(length, width, height).toDoubleOrNull() ?: 0.0
	val volGallonFT = calculateVolGallonFT(length, width, height).toDoubleOrNull() ?: 0.0
	val volLiterFT = calculateVolLiterFT(length, width, height).toDoubleOrNull() ?: 0.0
	val waterWeightFT = calculateWaterWeightFT(length, width, height).toDoubleOrNull() ?: 0.0

	GenericCalculatePage(
		subtitleContent = {
			CalculatorSubtitleTwo(
				contentColor = contentColor,
				text1 = calculatorDataSource.subtitle1,
				text2 = calculatorDataSource.subtitle2,
			)
		},
		selectContent = {
			SingleWideCardExpandableRadio(
				modifier = Modifier.fillMaxWidth(fraction = 0.75f),
				header = R.string.select_input_units,
				content = {
					RadioButtonTwoUnits(
						onClick1 = { selected = calculatorDataSource.radioTextFeet },
						onClick2 = { selected = calculatorDataSource.radioTextInches },
						selected = selected,
						selectedColor = color,
						textColor = color
					)
				},
				contentColor = color,
			)
		},
		inputFieldContent = {
			InputNumberFieldThreeStackedInputs(
				label1 = calculatorDataSource.labelLength,
				label2 = calculatorDataSource.labelWidth,
				label3 = calculatorDataSource.labelHeight,
				value1 = inputLength,
				onValueChange1 = { inputLength = it },
				value2 = inputWidth,
				onValueChange2 = { inputWidth = it },
				value3 = inputHeight,
				onValueChange3 = { inputHeight = it },
				focusedContainerColor = containerColor,
				focusedColor = contentColor,
				unfocusedColor = color,
				leadingIcon1 = calculatorDataSource.leadingIconLength,
				leadingIcon2 = calculatorDataSource.leadingIconWidth,
				leadingIcon3 = calculatorDataSource.leadingIconHeight,
			)
		},
		calculateFieldContent = {
			CalculateFieldThreeInputs(
//				inputContent = {
//					InputNumberFieldThreeStackedInputs(
//						label1 = calculatorDataSource.labelLength,
//						label2 = calculatorDataSource.labelWidth,
//						label3 = calculatorDataSource.labelHeight,
//						value1 = inputLength,
//						onValueChange1 = { inputLength = it },
//						value2 = inputWidth,
//						onValueChange2 = { inputWidth = it },
//						value3 = inputHeight,
//						onValueChange3 = { inputHeight = it },
//						focusedContainerColor = containerColor,
//						focusedColor = contentColor,
//						unfocusedColor = color,
//						leadingIcon1 = calculatorDataSource.leadingIconLength,
//						leadingIcon2 = calculatorDataSource.leadingIconWidth,
//						leadingIcon3 = calculatorDataSource.leadingIconHeight,
//					)
//				},
				inputText =
				if (selected == calculatorDataSource.radioTextFeet) rectangleDataSource.inputTextFeet
				else rectangleDataSource.inputTextInches,
				inputValue1 = inputLength,
				inputValue2 = inputWidth,
				inputValue3 = inputHeight,
				equalsText = calculatorDataSource.equalsText,
				contentColor = color,
				containerColor = containerColor,
				calculateContent = {
					when (selected) {
						calculatorDataSource.radioTextFeet -> {
							TankVolumeResults(
								contentColor = contentColor,
								calculatedValue1 = volGallonFT,
								calculatedValue2 = volLiterFT,
								calculatedValue3 = waterWeightFT
							)
						}

						calculatorDataSource.radioTextInches -> {
							TankVolumeResults(
								contentColor = contentColor,
								calculatedValue1 = volGallon,
								calculatedValue2 = volLiter,
								calculatedValue3 = waterWeight
							)
						}
					}
				}
			)
		},
		imageContent = {
			CalculateImage(
				painter = rectangleDataSource.image,
				contentDescription = Rectangle.title,
				colorFilter = color
			)
		},
		formulaContent = {
			FormulaString(
				text = rectangleDataSource.formulaText,
				contentColor = color
			)
		},
	)
}

@VisibleForTesting
fun calculateVolGallon(
	length: Double,
	width: Double,
	height: Double
): String {
	val volGallons = (length * width * height) / 231.0

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volGallons)
}

@VisibleForTesting
fun calculateVolLiter(
	length: Double,
	width: Double,
	height: Double,
): String {
	val volLiters = (length * width * height) / 61.0237

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volLiters)
}

@VisibleForTesting
fun calculateWaterWeight(
	length: Double,
	width: Double,
	height: Double,
): String {
	val waterWeight = ((length * width * height) / 231.0) * 8.33

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(waterWeight)
}

@VisibleForTesting
fun calculateVolGallonFT(
	length: Double,
	width: Double,
	height: Double
): String {
	val volGallons = (length * width * height) / 0.133681

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volGallons)
}

@VisibleForTesting
fun calculateVolLiterFT(
	length: Double,
	width: Double,
	height: Double,
): String {
	val volLiters = (length * width * height) / 0.0353147

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volLiters)
}

@VisibleForTesting
fun calculateWaterWeightFT(
	length: Double,
	width: Double,
	height: Double,
): String {
	val waterWeight = ((length * width * height) / 0.133681) * 8.33

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(waterWeight)
}

@Preview(showBackground = true)
@Composable
fun RectanglePreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			RectanglePage()
		}
	}
}

@Preview(showBackground = true)
@Composable
fun RectanglePreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			RectanglePage()
		}
	}
}