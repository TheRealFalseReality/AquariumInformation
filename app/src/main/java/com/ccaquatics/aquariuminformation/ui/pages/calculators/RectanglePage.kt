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
import com.ccaquatics.aquariuminformation.data.calculators.rectangleDataSource
import com.ccaquatics.aquariuminformation.navigation.Rectangle
import com.ccaquatics.aquariuminformation.ui.commonui.BodyTextCard
import com.ccaquatics.aquariuminformation.ui.commonui.CalculateFieldThreeInputs
import com.ccaquatics.aquariuminformation.ui.commonui.CalculateImage
import com.ccaquatics.aquariuminformation.ui.commonui.CalculatedText
import com.ccaquatics.aquariuminformation.ui.commonui.FormulaString
import com.ccaquatics.aquariuminformation.ui.commonui.GenericPage
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
	modifier: Modifier = Modifier,
	color: Color = MaterialTheme.colorScheme.secondary
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
		mutableIntStateOf(rectangleDataSource.radioTextFeet)
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

	Column(modifier = modifier) {
		GenericPage(
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
							text = rectangleDataSource.radioTextFeet,
							onClick = { selected = rectangleDataSource.radioTextFeet },
							selected = selected,
							selectedColor = color
						)
						RadioButtonComp(
							modifier = Modifier
								.weight(1f),
							text = rectangleDataSource.radioTextInches,
							onClick = { selected = rectangleDataSource.radioTextInches },
							selected = selected,
							selectedColor = color
						)
					},
					contentColor = color,
				)
			},
			calculateFieldContent = {
				CalculateFieldThreeInputs(
					inputContent = {
						InputNumberFieldThreeInputs(
							label1 = rectangleDataSource.labelLength,
							placeholder1 = rectangleDataSource.placeholderLength,
							label2 = rectangleDataSource.labelWidth,
							placeholder2 = rectangleDataSource.placeholderWidth,
							label3 = rectangleDataSource.labelHeight,
							placeholder3 = rectangleDataSource.placeholderHeight,
							value1 = inputLength,
							onValueChange1 = { inputLength = it },
							value2 = inputWidth,
							onValueChange2 = { inputWidth = it },
							value3 = inputHeight,
							onValueChange3 = { inputHeight = it },
							color = color
						)
					},
					inputText = rectangleDataSource.inputText,
					inputValue1 = inputLength,
					inputValue2 = inputWidth,
					inputValue3 = inputHeight,
					equalsText = rectangleDataSource.equalsText,
					color = color,
					calculateContent = {
						when (selected) {
							rectangleDataSource.radioTextFeet -> {
								CalculatedText(
									modifier = Modifier.fillMaxWidth(),
									text = rectangleDataSource.calculatedTextGallons,
									calculatedValue = volGallonFT,
									color = color
								)
								CalculatedText(
									modifier = Modifier.fillMaxWidth(),
									text = rectangleDataSource.calculatedTextLiters,
									calculatedValue = volLiterFT,
									color = color
								)
								CalculatedText(
									modifier = Modifier.fillMaxWidth(),
									text = rectangleDataSource.calculatedTextWaterWeight,
									calculatedValue = waterWeightFT,
									color = color
								)
							}

							rectangleDataSource.radioTextInches -> {
								CalculatedText(
									modifier = Modifier.fillMaxWidth(),
									text = rectangleDataSource.calculatedTextGallons,
									calculatedValue = volGallon,
									color = color
								)
								CalculatedText(
									modifier = Modifier.fillMaxWidth(),
									text = rectangleDataSource.calculatedTextLiters,
									calculatedValue = volLiter,
									color = color
								)
								CalculatedText(
									modifier = Modifier.fillMaxWidth(),
									text = rectangleDataSource.calculatedTextWaterWeight,
									calculatedValue = waterWeight,
									color = color
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
					content = {
						BodyTextCard(text = rectangleDataSource.formulaText)
					},
					color = color
				)
			},
		)
	}
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