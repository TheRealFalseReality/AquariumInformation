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
import com.ccaquatics.aquariuminformation.data.tankvolumes.cubeDataSource
import com.ccaquatics.aquariuminformation.navigation.Cube
import com.ccaquatics.aquariuminformation.ui.commonui.CalculateField
import com.ccaquatics.aquariuminformation.ui.commonui.CalculateImage
import com.ccaquatics.aquariuminformation.ui.commonui.FormulaString
import com.ccaquatics.aquariuminformation.ui.commonui.GenericCalculatePage
import com.ccaquatics.aquariuminformation.ui.commonui.InputNumberField
import com.ccaquatics.aquariuminformation.ui.commonui.PageView
import com.ccaquatics.aquariuminformation.ui.commonui.RadioButtonTwoUnits
import com.ccaquatics.aquariuminformation.ui.commonui.TankVolumeResults
import com.ccaquatics.aquariuminformation.ui.commonui.UnitButtonCard
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun CubePage() {
	PageView {
		CubeLayout()
	}
}

@Composable
fun CubeLayout(
	color: Color = MaterialTheme.colorScheme.secondary,
	containerColor: Color = MaterialTheme.colorScheme.secondaryContainer,
	contentColor: Color = MaterialTheme.colorScheme.onSecondaryContainer,
) {
	var inputSide by rememberSaveable {
		mutableStateOf("")
	}
	var selected by rememberSaveable {
		mutableIntStateOf(calculatorDataSource.radioTextFeet)
	}
	val side = inputSide.toDoubleOrNull() ?: 0.0
	val volGallon = calculateVolGallonCube(side).toDoubleOrNull() ?: 0.0
	val volLiter = calculateVolLiterCube(side).toDoubleOrNull() ?: 0.0
	val waterWeight = calculateWaterWeightCube(side).toDoubleOrNull() ?: 0.0
	val volGallonFT = calculateVolGallonFTCube(side).toDoubleOrNull() ?: 0.0
	val volLiterFT = calculateVolLiterFTCube(side).toDoubleOrNull() ?: 0.0
	val waterWeightFT = calculateWaterWeightFTCube(side).toDoubleOrNull() ?: 0.0

	GenericCalculatePage(
		title = Cube.title,
		subtitle = calculatorDataSource.subtitle,
		icon = Cube.icon,
		color = color,
		selectContent = {
			UnitButtonCard(
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
//						if (selected == calculatorDataSource.radioTextInches) color
//						else MaterialTheme.colorScheme.onBackground
//					)
				},
				contentColor = color,
			)
		},
		calculateFieldContent = {
			CalculateField(
				inputContent = {
					InputNumberField(
						label = calculatorDataSource.labelSide,
						placeholder = calculatorDataSource.placeholderSide,
						value = inputSide,
						onValueChange = { inputSide = it },
						focusedContainerColor = containerColor,
						focusedColor = contentColor,
						unfocusedColor = color,
					)
				},
				inputText =
				if (selected == calculatorDataSource.radioTextFeet) cubeDataSource.inputTextFeet
				else cubeDataSource.inputTextInches,
				inputValue = inputSide,
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
//								text = calculatorDataSource.calculatedTextGallons,
//								calculatedValue = volGallonFT,
//								textColor = contentColor,
//							)
//							CalculatedText(
//								text = calculatorDataSource.calculatedTextLiters,
//								calculatedValue = volLiterFT,
//								textColor = contentColor,
//							)
//							VerySmallSpacer()
//							LabelWaterWeight()
//							CalculatedText(
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
//								text = calculatorDataSource.calculatedTextGallons,
//								calculatedValue = volGallon,
//								textColor = contentColor,
//							)
//							CalculatedText(
//								text = calculatorDataSource.calculatedTextLiters,
//								calculatedValue = volLiter,
//								textColor = contentColor,
//							)
//							VerySmallSpacer()
//							LabelWaterWeight()
//							CalculatedText(
//								text = calculatorDataSource.calculatedTextWaterWeight,
//								calculatedValue = waterWeight,
//								textColor = contentColor,
//							)
						}
					}
				},
				contentColor = color,
				containerColor = containerColor
			)
		},
		imageContent = {
			CalculateImage(
				painter = cubeDataSource.image,
				contentDescription = Cube.title,
				colorFilter = color
			)
		},
		formulaContent = {
			FormulaString(
				text = cubeDataSource.formulaText,
				color = color,
			)
		}
	)
}

@VisibleForTesting
fun calculateVolGallonCube(
	side: Double
): String {
	val volGallons = (side * side * side) / 231.0

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volGallons)
}

@VisibleForTesting
fun calculateVolLiterCube(
	side: Double
): String {
	val volLiters = (side * side * side) / 61.0237

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volLiters)
}

@VisibleForTesting
fun calculateWaterWeightCube(
	side: Double
): String {
	val waterWeight = ((side * side * side) / 231.0) * 8.33

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(waterWeight)
}

@VisibleForTesting
fun calculateVolGallonFTCube(
	side: Double
): String {
	val volGallons = (side * side * side) / 0.133681

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volGallons)
}

@VisibleForTesting
fun calculateVolLiterFTCube(
	side: Double
): String {
	val volLiters = (side * side * side) / 0.0353147

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volLiters)
}

@VisibleForTesting
fun calculateWaterWeightFTCube(
	side: Double
): String {
	val waterWeight = ((side * side * side) / 0.133681) * 8.33

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(waterWeight)
}

@Preview(showBackground = true)
@Composable
fun CubePreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			CubePage()
		}
	}
}

@Preview(showBackground = true)
@Composable
fun CubePreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			CubePage()
		}
	}
}