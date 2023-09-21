package com.ccaquatics.aquariuminformation.ui.pages.calculators

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
import com.ccaquatics.aquariuminformation.data.calculators.calculatorDataSource
import com.ccaquatics.aquariuminformation.data.calculators.hexagonalDataSource
import com.ccaquatics.aquariuminformation.navigation.Hexagonal
import com.ccaquatics.aquariuminformation.ui.commonui.CalculateFieldTwoInputs
import com.ccaquatics.aquariuminformation.ui.commonui.CalculateImage
import com.ccaquatics.aquariuminformation.ui.commonui.CalculatedText
import com.ccaquatics.aquariuminformation.ui.commonui.FormulaString
import com.ccaquatics.aquariuminformation.ui.commonui.GenericCalculatePage
import com.ccaquatics.aquariuminformation.ui.commonui.InputRowNumberFieldTwoInputs
import com.ccaquatics.aquariuminformation.ui.commonui.PageView
import com.ccaquatics.aquariuminformation.ui.commonui.RadioButtonComp
import com.ccaquatics.aquariuminformation.ui.commonui.UnitButtonCard
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
	color: Color = MaterialTheme.colorScheme.secondary
) {
	var inputEdge by rememberSaveable {
		mutableStateOf("")
	}
	var inputHeight by rememberSaveable {
		mutableStateOf("")
	}
	var selected by rememberSaveable {
		mutableIntStateOf(hexagonalDataSource.radioTextFeet)
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
		title = Hexagonal.title,
		subtitle = calculatorDataSource.subtitle,
		icon = Hexagonal.icon,
		color = color,
		selectContent = {
			UnitButtonCard(
				content = {
					RadioButtonComp(
						modifier = Modifier
							.weight(1f),
						text = hexagonalDataSource.radioTextFeet,
						onClick = { selected = hexagonalDataSource.radioTextFeet },
						selected = selected,
						selectedColor = color
					)
					RadioButtonComp(
						modifier = Modifier
							.weight(1f),
						text = hexagonalDataSource.radioTextInches,
						onClick = { selected = hexagonalDataSource.radioTextInches },
						selected = selected,
						selectedColor = color
					)
				},
				contentColor = color
			)
		},
		calculateFieldContent = {
			CalculateFieldTwoInputs(
				inputContent = {
					InputRowNumberFieldTwoInputs(
						label1 = hexagonalDataSource.labelEdge,
						placeholder1 = hexagonalDataSource.placeholderEdge,
						label2 = hexagonalDataSource.labelHeight,
						placeholder2 = hexagonalDataSource.placeholderHeight,
						value1 = inputEdge,
						onValueChange1 = { inputEdge = it },
						value2 = inputHeight,
						onValueChange2 = { inputHeight = it },
						color = color,
					)
				},
				inputText = hexagonalDataSource.inputText,
				inputValue1 = inputEdge,
				inputValue2 = inputHeight,
				equalsText = hexagonalDataSource.equalsText,
				calculateContent = {
					when (selected) {
						hexagonalDataSource.radioTextFeet -> {
							CalculatedText(
								modifier = Modifier.fillMaxWidth(),
								text = hexagonalDataSource.calculatedTextGallons,
								calculatedValue = volGallonFT,
								color = color
							)
							CalculatedText(
								modifier = Modifier.fillMaxWidth(),
								text = hexagonalDataSource.calculatedTextLiters,
								calculatedValue = volLiterFT,
								color = color
							)
							CalculatedText(
								modifier = Modifier.fillMaxWidth(),
								text = hexagonalDataSource.calculatedTextWaterWeight,
								calculatedValue = waterWeightFT,
								color = color
							)
						}

						hexagonalDataSource.radioTextInches -> {
							CalculatedText(
								modifier = Modifier.fillMaxWidth(),
								text = hexagonalDataSource.calculatedTextGallons,
								calculatedValue = volGallon,
								color = color
							)
							CalculatedText(
								modifier = Modifier.fillMaxWidth(),
								text = hexagonalDataSource.calculatedTextLiters,
								calculatedValue = volLiter,
								color = color
							)
							CalculatedText(
								modifier = Modifier.fillMaxWidth(),
								text = hexagonalDataSource.calculatedTextWaterWeight,
								calculatedValue = waterWeight,
								color = color
							)
						}
					}
				},
				color = color
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