package cca.capitalcityaquatics.aquariuminfo.ui.pages.tankvolumes

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.data.tankvolumes.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.data.tankvolumes.hexagonalDataSource
import cca.capitalcityaquatics.aquariuminfo.navigation.Hexagonal
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateFieldTwoInputs
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateImageTitle
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatorSubtitleTwo
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FormulaString
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.GenericCalculatePage
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.InputRowNumberFieldTwoInputs
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageView
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.RadioButtonTwoUnits
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.SingleWideCardExpandableRadio
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.TankVolumeResults
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun HexagonalPage(windowSize: WindowSizeClass) {
	PageView {
		HexagonalLayout(windowSize = windowSize)
	}
}

@Composable
fun HexagonalLayout(
	windowSize: WindowSizeClass,
	color: Color = MaterialTheme.colorScheme.secondary,
	containerColor: Color = MaterialTheme.colorScheme.secondaryContainer,
	contentColor: Color = MaterialTheme.colorScheme.onSecondaryContainer,
) {
	var inputEdge by rememberSaveable {
		mutableStateOf("")
	}
	var inputHeight by rememberSaveable {
		mutableStateOf("")
	}
	var selected by rememberSaveable {
		mutableIntStateOf(calculatorDataSource.radioTextFeet)
	}
	val edge = inputEdge.toDoubleOrNull() ?: 0.0
	val height = inputHeight.toDoubleOrNull() ?: 0.0
	val volGallon = calculateVolGallonHex(edge, height).toDoubleOrNull() ?: 0.0
	val volLiter = calculateVolLiterHex(edge, height).toDoubleOrNull() ?: 0.0
	val waterWeight = calculateWaterWeightHex(edge, height).toDoubleOrNull() ?: 0.0
	val volGallonFT = calculateVolGallonFTHex(edge, height).toDoubleOrNull() ?: 0.0
	val volLiterFT = calculateVolLiterFTHex(edge, height).toDoubleOrNull() ?: 0.0
	val waterWeightFT = calculateWaterWeightFTHex(edge, height).toDoubleOrNull() ?: 0.0

	GenericCalculatePage(
		windowSize = windowSize,
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
				contentColor = color
			)
		},
		inputFieldContent = {
			InputRowNumberFieldTwoInputs(
				label1 = calculatorDataSource.labelEdge,
				label2 = calculatorDataSource.labelHeight,
				value1 = inputEdge,
				onValueChange1 = { inputEdge = it },
				value2 = inputHeight,
				onValueChange2 = { inputHeight = it },
				focusedContainerColor = containerColor,
				focusedColor = contentColor,
				unfocusedColor = color,
				leadingIcon1 = calculatorDataSource.leadingIconFullWidth,
				leadingIcon2 = calculatorDataSource.leadingIconHeight,
			)
		},
		calculateFieldContent = {
			CalculateFieldTwoInputs(
//				inputContent = {
//					InputRowNumberFieldTwoInputs(
//						label1 = calculatorDataSource.labelEdge,
//						label2 = calculatorDataSource.labelHeight,
//						value1 = inputEdge,
//						onValueChange1 = { inputEdge = it },
//						value2 = inputHeight,
//						onValueChange2 = { inputHeight = it },
//						focusedContainerColor = containerColor,
//						focusedColor = contentColor,
//						unfocusedColor = color,
//						leadingIcon1 = calculatorDataSource.leadingIconFullWidth,
//						leadingIcon2 = calculatorDataSource.leadingIconHeight,
//					)
//				},
				inputText =
				if (selected == calculatorDataSource.radioTextFeet) hexagonalDataSource.inputTextFeet
				else hexagonalDataSource.inputTextInches,
				inputValue1 = inputEdge,
				inputValue2 = inputHeight,
				equalsText = calculatorDataSource.equalsText,
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
				},
				containerColor = containerColor,
				contentColor = color
			)
		},
		imageContent = {
			CalculateImageTitle(
				image = hexagonalDataSource.image,
				contentDescription = Hexagonal.title,
				color = color
			)
		}
	) {
		FormulaString(
			text = hexagonalDataSource.formulaText,
			contentColor = color
		)
	}
}

@VisibleForTesting
fun calculateVolGallonHex(
	edge: Double,
	height: Double
): String {
	val volGallons = (((3 * kotlin.math.sqrt(3.0)) / 2) * edge * edge * height) / 231.0

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volGallons)
}

@VisibleForTesting
fun calculateVolLiterHex(
	edge: Double,
	height: Double
): String {
	val volLiters = (((3 * kotlin.math.sqrt(3.0)) / 2) * edge * edge * height) / 61.0237

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volLiters)
}

@VisibleForTesting
fun calculateWaterWeightHex(
	edge: Double,
	height: Double
): String {
	val waterWeight = ((((3 * kotlin.math.sqrt(3.0)) / 2) * edge * edge * height) / 231.0) * 8.33

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(waterWeight)
}

@VisibleForTesting
fun calculateVolGallonFTHex(
	edge: Double,
	height: Double
): String {
	val volGallons = (((3 * kotlin.math.sqrt(3.0)) / 2) * edge * edge * height) / 0.133681

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volGallons)
}

@VisibleForTesting
fun calculateVolLiterFTHex(
	edge: Double,
	height: Double
): String {
	val volLiters = (((3 * kotlin.math.sqrt(3.0)) / 2) * edge * edge * height) / 0.0353147

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volLiters)
}

@VisibleForTesting
fun calculateWaterWeightFTHex(
	edge: Double,
	height: Double
): String {
	val waterWeight = ((((3 * kotlin.math.sqrt(3.0)) / 2) * edge * edge * height) / 0.133681) * 8.33

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(waterWeight)
}

//@Preview(showBackground = true)
//@Composable
//fun HexagonalPreview() {
//	AquariumInformationTheme {
//		Column(
//			modifier = Modifier
//				.background(color = MaterialTheme.colorScheme.background)
//		) {
//			HexagonalPage()
//		}
//	}
//}
//
//@Preview(showBackground = true)
//@Composable
//fun HexagonalPreviewDark(
//) {
//	AquariumInformationTheme(useDarkTheme = true) {
//		Column(
//			modifier = Modifier
//				.background(color = MaterialTheme.colorScheme.background)
//		) {
//			HexagonalPage()
//		}
//	}
//}