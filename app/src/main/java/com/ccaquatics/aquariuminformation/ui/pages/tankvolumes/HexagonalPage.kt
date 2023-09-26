package com.ccaquatics.aquariuminformation.ui.pages.tankvolumes

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
import com.ccaquatics.aquariuminformation.R
import com.ccaquatics.aquariuminformation.data.tankvolumes.calculatorDataSource
import com.ccaquatics.aquariuminformation.data.tankvolumes.hexagonalDataSource
import com.ccaquatics.aquariuminformation.navigation.Hexagonal
import com.ccaquatics.aquariuminformation.ui.commonui.CalculateFieldTwoInputs
import com.ccaquatics.aquariuminformation.ui.commonui.CalculateImage
import com.ccaquatics.aquariuminformation.ui.commonui.FormulaString
import com.ccaquatics.aquariuminformation.ui.commonui.GenericCalculatePage
import com.ccaquatics.aquariuminformation.ui.commonui.InputRowNumberFieldTwoInputs
import com.ccaquatics.aquariuminformation.ui.commonui.PageView
import com.ccaquatics.aquariuminformation.ui.commonui.RadioButtonTwoUnits
import com.ccaquatics.aquariuminformation.ui.commonui.SingleWideCardExpandable
import com.ccaquatics.aquariuminformation.ui.commonui.TankVolumeResults
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun HexagonalPage() {
	PageView {
		HexagonalLayout()
	}
}

@Composable
fun HexagonalLayout(
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
		subtitle = calculatorDataSource.subtitle,
		color = color,
		selectContent = {
			SingleWideCardExpandable(
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
//					RadioButtonComposable(
//						modifier = Modifier
//							.weight(1f),
//						text = calculatorDataSource.radioTextFeet,
//						onClick = { selected = calculatorDataSource.radioTextFeet },
//						selected = selected,
//						selectedColor = color,
//						textColor =
//						if (selected == calculatorDataSource.radioTextFeet) color
//						else MaterialTheme.colorScheme.onBackground
//					)
//					RadioButtonComposable(
//						modifier = Modifier
//							.weight(1f),
//						text = calculatorDataSource.radioTextInches,
//						onClick = { selected = calculatorDataSource.radioTextInches },
//						selected = selected,
//						selectedColor = color,
//						textColor =
//							if (selected == calculatorDataSource.radioTextInches) color
//							else MaterialTheme.colorScheme.onBackground
//					)
				},
				contentColor = color
			)
		},
		calculateFieldContent = {
			CalculateFieldTwoInputs(
				inputContent = {
					InputRowNumberFieldTwoInputs(
						label1 = calculatorDataSource.labelEdge,
						placeholder1 = calculatorDataSource.placeholderEdge,
						label2 = calculatorDataSource.labelHeight,
						placeholder2 = calculatorDataSource.placeholderHeight,
						value1 = inputEdge,
						onValueChange1 = { inputEdge = it },
						value2 = inputHeight,
						onValueChange2 = { inputHeight = it },
						focusedContainerColor = containerColor,
						focusedColor = contentColor,
						unfocusedColor = color,
					)
				},
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
//							CalculatedText(
//								modifier = Modifier.fillMaxWidth(),
//								text = calculatorDataSource.calculatedTextGallons,
//								calculatedValue = volGallonFT,
//								textColor = contentColor,
//							)
//							CalculatedText(
//								modifier = Modifier.fillMaxWidth(),
//								text = calculatorDataSource.calculatedTextLiters,
//								calculatedValue = volLiterFT,
//								textColor = contentColor,
//							)
//							VerySmallSpacer()
//							LabelWaterWeight()
//							CalculatedText(
//								modifier = Modifier.fillMaxWidth(),
//								text = calculatorDataSource.calculatedTextWaterWeight,
//								calculatedValue = waterWeightFT,
//								textColor = contentColor,
//							)
						}

						calculatorDataSource.radioTextInches -> {
							TankVolumeResults(
								contentColor = contentColor,
								calculatedValue1 = volGallon,
								calculatedValue2 = volLiter,
								calculatedValue3 = waterWeight
							)
//							CalculatedText(
//								modifier = Modifier.fillMaxWidth(),
//								text = calculatorDataSource.calculatedTextGallons,
//								calculatedValue = volGallon,
//								textColor = contentColor,
//							)
//							CalculatedText(
//								modifier = Modifier.fillMaxWidth(),
//								text = calculatorDataSource.calculatedTextLiters,
//								calculatedValue = volLiter,
//								textColor = contentColor,
//							)
//							VerySmallSpacer()
//							LabelWaterWeight()
//							CalculatedText(
//								modifier = Modifier.fillMaxWidth(),
//								text = calculatorDataSource.calculatedTextWaterWeight,
//								calculatedValue = waterWeight,
//								textColor = contentColor,
//							)
						}
					}
				},
				containerColor = containerColor,
				contentColor = color
			)
		},
		imageContent = {
			CalculateImage(
				painter = hexagonalDataSource.image,
				contentDescription = Hexagonal.title,
				colorFilter = color,
			)
		},
		formulaContent = {
			FormulaString(
				text = hexagonalDataSource.formulaText,
				color = color
			)
		}
	)
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

@Preview(showBackground = true)
@Composable
fun HexagonalPreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			HexagonalPage()
		}
	}
}

@Preview(showBackground = true)
@Composable
fun HexagonalPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			HexagonalPage()
		}
	}
}