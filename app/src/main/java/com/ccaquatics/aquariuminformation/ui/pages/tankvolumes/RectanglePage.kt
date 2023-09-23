package com.ccaquatics.aquariuminformation.ui.pages.tankvolumes

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import com.ccaquatics.aquariuminformation.data.tankvolumes.calculatorDataSource
import com.ccaquatics.aquariuminformation.data.tankvolumes.rectangleDataSource
import com.ccaquatics.aquariuminformation.navigation.Rectangle
import com.ccaquatics.aquariuminformation.ui.commonui.CalculateFieldThreeInputs
import com.ccaquatics.aquariuminformation.ui.commonui.CalculateImage
import com.ccaquatics.aquariuminformation.ui.commonui.CalculatedText
import com.ccaquatics.aquariuminformation.ui.commonui.FormulaString
import com.ccaquatics.aquariuminformation.ui.commonui.GenericCalculatePage
import com.ccaquatics.aquariuminformation.ui.commonui.InputNumberFieldThreeInputs
import com.ccaquatics.aquariuminformation.ui.commonui.PageView
import com.ccaquatics.aquariuminformation.ui.commonui.RadioButtonComp
import com.ccaquatics.aquariuminformation.ui.commonui.UnitButtonCard
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme
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
		title = Rectangle.title,
		subtitle = calculatorDataSource.subtitle,
		icon = Rectangle.icon,
		color = color,
		selectContent = {
			UnitButtonCard(
				content = {
					RadioButtonComp(
						modifier = Modifier
							.weight(1f),
						text = calculatorDataSource.radioTextFeet,
						onClick = { selected = calculatorDataSource.radioTextFeet },
						selected = selected,
						selectedColor = color,
						textColor =
						if (selected == calculatorDataSource.radioTextFeet) color
						else MaterialTheme.colorScheme.onBackground
					)
					RadioButtonComp(
						modifier = Modifier
							.weight(1f),
						text = calculatorDataSource.radioTextInches,
						onClick = { selected = calculatorDataSource.radioTextInches },
						selected = selected,
						selectedColor = color,
						textColor =
						if (selected == calculatorDataSource.radioTextInches) color
						else MaterialTheme.colorScheme.onBackground
					)
				},
				contentColor = color,
			)
		},
		calculateFieldContent = {
			CalculateFieldThreeInputs(
				inputContent = {
					InputNumberFieldThreeInputs(
						label1 = calculatorDataSource.labelLength,
						placeholder1 = calculatorDataSource.placeholderLength,
						label2 = calculatorDataSource.labelWidth,
						placeholder2 = calculatorDataSource.placeholderWidth,
						label3 = calculatorDataSource.labelHeight,
						placeholder3 = calculatorDataSource.placeholderHeight,
						value1 = inputLength,
						onValueChange1 = { inputLength = it },
						value2 = inputWidth,
						onValueChange2 = { inputWidth = it },
						value3 = inputHeight,
						onValueChange3 = { inputHeight = it },
						focusedContainerColor = containerColor,
						focusedColor = contentColor,
						unfocusedColor = color,
					)
				},
				inputText = rectangleDataSource.inputText,
				inputValue1 = inputLength,
				inputValue2 = inputWidth,
				inputValue3 = inputHeight,
				equalsText = calculatorDataSource.equalsText,
				contentColor = color,
				containerColor = containerColor,
				calculateContent = {
					when (selected) {
						calculatorDataSource.radioTextFeet -> {
							CalculatedText(
								text = calculatorDataSource.calculatedTextGallons,
								calculatedValue = volGallonFT,
								textColor = contentColor,
							)
							CalculatedText(
								text = calculatorDataSource.calculatedTextLiters,
								calculatedValue = volLiterFT,
								textColor = contentColor,
							)
							CalculatedText(
								text = calculatorDataSource.calculatedTextWaterWeight,
								calculatedValue = waterWeightFT,
								textColor = contentColor,
							)
						}

						calculatorDataSource.radioTextInches -> {
							CalculatedText(
								text = calculatorDataSource.calculatedTextGallons,
								calculatedValue = volGallon,
								textColor = contentColor,
							)
							CalculatedText(
								text = calculatorDataSource.calculatedTextLiters,
								calculatedValue = volLiter,
								textColor = contentColor,
							)
							CalculatedText(
								text = calculatorDataSource.calculatedTextWaterWeight,
								calculatedValue = waterWeight,
								textColor = contentColor,
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
				color = color
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