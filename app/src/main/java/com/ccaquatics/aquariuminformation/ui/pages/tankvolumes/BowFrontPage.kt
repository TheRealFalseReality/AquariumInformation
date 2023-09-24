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
import com.ccaquatics.aquariuminformation.data.tankvolumes.bowFrontDataSource
import com.ccaquatics.aquariuminformation.data.tankvolumes.calculatorDataSource
import com.ccaquatics.aquariuminformation.navigation.BowFront
import com.ccaquatics.aquariuminformation.ui.commonui.CalculateFieldFourInputs
import com.ccaquatics.aquariuminformation.ui.commonui.CalculateImage
import com.ccaquatics.aquariuminformation.ui.commonui.CalculatedText
import com.ccaquatics.aquariuminformation.ui.commonui.FormulaString
import com.ccaquatics.aquariuminformation.ui.commonui.GenericCalculatePage
import com.ccaquatics.aquariuminformation.ui.commonui.InputQuadNumberFieldFourInputs
import com.ccaquatics.aquariuminformation.ui.commonui.PageView
import com.ccaquatics.aquariuminformation.ui.commonui.RadioButtonComposable
import com.ccaquatics.aquariuminformation.ui.commonui.UnitButtonCard
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.PI

@Composable
fun BowFrontPage() {
	PageView {
		BowFrontLayout()
	}
}

@Composable
fun BowFrontLayout(
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
	var inputFullWidth by rememberSaveable {
		mutableStateOf("")
	}
	var selected by rememberSaveable {
		mutableIntStateOf(calculatorDataSource.radioTextFeet)
	}
	val length = inputLength.toDoubleOrNull() ?: 0.0
	val width = inputWidth.toDoubleOrNull() ?: 0.0
	val height = inputHeight.toDoubleOrNull() ?: 0.0
	val fullWidth = inputFullWidth.toDoubleOrNull() ?: 0.0

	val volGallon = calculateVolGallonBF(length, width, height, fullWidth).toDoubleOrNull() ?: 0.0
	val volLiter = calculateVolLiterBF(length, width, height, fullWidth).toDoubleOrNull() ?: 0.0
	val waterWeight =
		calculateWaterWeightBF(length, width, height, fullWidth).toDoubleOrNull() ?: 0.0
	val volGallonFT =
		calculateVolGallonFTBF(length, width, height, fullWidth).toDoubleOrNull() ?: 0.0
	val volLiterFT = calculateVolLiterFTBF(length, width, height, fullWidth).toDoubleOrNull() ?: 0.0
	val waterWeightFT =
		calculateWaterWeightFTBF(length, width, height, fullWidth).toDoubleOrNull() ?: 0.0

	GenericCalculatePage(
		title = BowFront.title,
		subtitle = calculatorDataSource.subtitle,
		icon = BowFront.icon,
		color = color,
		selectContent = {
			UnitButtonCard(
				content = {
//					RadioButtonFeetInches()
					RadioButtonComposable(
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
					RadioButtonComposable(
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
				contentColor = color
			)
		},
		calculateFieldContent = {
			CalculateFieldFourInputs(
				inputContent = {
					InputQuadNumberFieldFourInputs(
						label1 = calculatorDataSource.labelLength,
						placeholder1 = calculatorDataSource.placeholderLength,
						label2 = calculatorDataSource.labelWidth,
						placeholder2 = calculatorDataSource.placeholderWidth,
						value1 = inputLength,
						onValueChange1 = { inputLength = it },
						value2 = inputWidth,
						onValueChange2 = { inputWidth = it },
						focusedContainerColor = containerColor,
						focusedColor = contentColor,
						unfocusedColor = color,
						label3 = calculatorDataSource.labelHeight,
						placeholder3 = calculatorDataSource.placeholderHeight,
						label4 = calculatorDataSource.labelFullWidth,
						placeholder4 = calculatorDataSource.placeholderFullWidth,
						value3 = inputHeight,
						onValueChange3 = { inputHeight = it },
						value4 = inputFullWidth,
						onValueChange4 = { inputFullWidth = it },
					)
				},
				inputText =
				if (selected == calculatorDataSource.radioTextFeet) bowFrontDataSource.inputTextFeet
				else bowFrontDataSource.inputTextInches,
				inputValue1 = inputLength,
				inputValue2 = inputWidth,
				inputValue3 = inputHeight,
				inputValue4 = inputFullWidth,
				equalsText = calculatorDataSource.equalsText,
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
				},
				containerColor = containerColor,
				contentColor = color
			)
		},
		imageContent = {
			CalculateImage(
				painter = bowFrontDataSource.image,
				contentDescription = BowFront.title,
				colorFilter = color,
			)
		},
		formulaContent = {
			FormulaString(
				text = bowFrontDataSource.formulaText,
				color = color
			)
		}
	)
}

@VisibleForTesting
fun calculateVolGallonBF(
	length: Double,
	width: Double,
	height: Double,
	fullWidth: Double
): String {
	val volGallons =
		((length * width + (PI * (length / 2) * (fullWidth - width)) / 2) * height) / 231.0

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volGallons)
}

@VisibleForTesting
fun calculateVolLiterBF(
	length: Double,
	width: Double,
	height: Double,
	fullWidth: Double
): String {
	val volLiters =
		((length * width + (PI * (length / 2) * (fullWidth - width)) / 2) * height) / 61.0237

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volLiters)
}

@VisibleForTesting
fun calculateWaterWeightBF(
	length: Double,
	width: Double,
	height: Double,
	fullWidth: Double
): String {
	val waterWeight =
		(((length * width + (PI * (length / 2) * (fullWidth - width)) / 2) * height) / 231.0) * 8.33

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(waterWeight)
}

@VisibleForTesting
fun calculateVolGallonFTBF(
	length: Double,
	width: Double,
	height: Double,
	fullWidth: Double
): String {
	val volGallons =
		((length * width + (PI * (length / 2) * (fullWidth - width)) / 2) * height) / 0.133681

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volGallons)
}

@VisibleForTesting
fun calculateVolLiterFTBF(
	length: Double,
	width: Double,
	height: Double,
	fullWidth: Double
): String {
	val volLiters =
		((length * width + (PI * (length / 2) * (fullWidth - width)) / 2) * height) / 0.0353147

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volLiters)
}

@VisibleForTesting
fun calculateWaterWeightFTBF(
	length: Double,
	width: Double,
	height: Double,
	fullWidth: Double
): String {
	val waterWeight =
		(((length * width + (PI * (length / 2) * (fullWidth - width)) / 2) * height) / 0.133681) * 8.33

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(waterWeight)
}

@Preview(showBackground = true)
@Composable
fun BowFrontPreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			BowFrontPage()
		}
	}
}

@Preview(showBackground = true)
@Composable
fun BowFrontPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			BowFrontPage()
		}
	}
}