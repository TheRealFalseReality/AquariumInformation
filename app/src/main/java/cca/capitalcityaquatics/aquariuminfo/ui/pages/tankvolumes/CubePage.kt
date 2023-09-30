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
import cca.capitalcityaquatics.aquariuminfo.data.tankvolumes.cubeDataSource
import cca.capitalcityaquatics.aquariuminfo.navigation.Cube
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateField
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateImage
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FormulaString
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.GenericCalculatePage
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.InputNumberField
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageView
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.RadioButtonTwoUnits
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.SingleWideCardExpandableRadio
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.TankVolumeResults
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme
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
		subtitle = calculatorDataSource.subtitle,
		color = color,
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