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
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ccaquatics.aquariuminformation.R
import com.ccaquatics.aquariuminformation.data.tankvolumes.calculatorDataSource
import com.ccaquatics.aquariuminformation.data.tankvolumes.cylinderDataSource
import com.ccaquatics.aquariuminformation.navigation.Cylinder
import com.ccaquatics.aquariuminformation.ui.commonui.CalculateFieldTwoInputs
import com.ccaquatics.aquariuminformation.ui.commonui.CalculateImage
import com.ccaquatics.aquariuminformation.ui.commonui.FormulaString
import com.ccaquatics.aquariuminformation.ui.commonui.GenericCalculatePage
import com.ccaquatics.aquariuminformation.ui.commonui.InputRowNumberFieldTwoInputs
import com.ccaquatics.aquariuminformation.ui.commonui.PageView
import com.ccaquatics.aquariuminformation.ui.commonui.RadioButtonThreeUnits
import com.ccaquatics.aquariuminformation.ui.commonui.RadioButtonTwoUnits
import com.ccaquatics.aquariuminformation.ui.commonui.SingleWideCardExpandable
import com.ccaquatics.aquariuminformation.ui.commonui.TankVolumeResults
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.PI
import kotlin.math.pow

@Composable
fun CylinderPage() {
	PageView {
		CylinderLayout()
	}
}

@Composable
fun CylinderLayout(
	color: Color = MaterialTheme.colorScheme.secondary,
	containerColor: Color = MaterialTheme.colorScheme.secondaryContainer,
	contentColor: Color = MaterialTheme.colorScheme.onSecondaryContainer,
) {
	var inputDiameter by rememberSaveable {
		mutableStateOf("")
	}
	var inputHeight by rememberSaveable {
		mutableStateOf("")
	}
	var selected by rememberSaveable {
		mutableIntStateOf(calculatorDataSource.radioTextFeet)
	}
	var selectedCylinder by rememberSaveable {
		mutableIntStateOf(calculatorDataSource.radioFullCylinder)
	}
	var halfCyl by remember {
		mutableStateOf(false)
	}
	var quartCyl by remember {
		mutableStateOf(false)
	}
	val diameter = inputDiameter.toDoubleOrNull() ?: 0.0
	val height = inputHeight.toDoubleOrNull() ?: 0.0
	val volGallon =
		calculateVolGallonCyl(diameter, height, halfCyl, quartCyl).toDoubleOrNull() ?: 0.0
	val volLiter = calculateVolLiterCyl(diameter, height, halfCyl, quartCyl).toDoubleOrNull() ?: 0.0
	val waterWeight =
		calculateWaterWeightCyl(diameter, height, halfCyl, quartCyl).toDoubleOrNull() ?: 0.0
	val volGallonFT =
		calculateVolGallonFTCyl(diameter, height, halfCyl, quartCyl).toDoubleOrNull() ?: 0.0
	val volLiterFT =
		calculateVolLiterFTCyl(diameter, height, halfCyl, quartCyl).toDoubleOrNull() ?: 0.0
	val waterWeightFT =
		calculateWaterWeightFTCyl(diameter, height, halfCyl, quartCyl).toDoubleOrNull() ?: 0.0

	// TODO Add half and corner cylinder
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
//						if (selected == calculatorDataSource.radioTextInches) color
//						else MaterialTheme.colorScheme.onBackground
//					)
				},
				contentColor = color
			)
		},
		optionsContent = {
			SingleWideCardExpandable(
				header = calculatorDataSource.labelCylinderType,
				modifier = Modifier.fillMaxWidth(fraction = 0.75f),
				content = {
					RadioButtonThreeUnits(
						onClick1 = {
							selectedCylinder = calculatorDataSource.radioFullCylinder
							halfCyl = false; quartCyl = false
						},
						onClick2 = {
							selectedCylinder = calculatorDataSource.radioHalfCylinder
							halfCyl = true; quartCyl = false
						},
						onClick3 = {
							selectedCylinder = calculatorDataSource.radioCornerCylinder
							halfCyl = false; quartCyl = true
						},
						label1 = calculatorDataSource.radioFullCylinder,
						label2 = calculatorDataSource.radioHalfCylinder,
						label3 = calculatorDataSource.radioCornerCylinder,
						selected = selectedCylinder,
						selectedColor = color,
						textColor = color
					)
				},
				contentColor = color,
			)
		},
		calculateFieldContent = {
			CalculateFieldTwoInputs(
				inputContent = {
					InputRowNumberFieldTwoInputs(
						label1 = calculatorDataSource.labelDiameter,
						placeholder1 = calculatorDataSource.placeholderDiameter,
						label2 = calculatorDataSource.labelHeight,
						placeholder2 = calculatorDataSource.placeholderHeight,
						value1 = inputDiameter,
						onValueChange1 = { inputDiameter = it },
						value2 = inputHeight,
						onValueChange2 = { inputHeight = it },
						focusedContainerColor = containerColor,
						focusedColor = contentColor,
						unfocusedColor = color,
					)
				},
				inputText =
				if (selected == calculatorDataSource.radioTextFeet) cylinderDataSource.inputTextFeet
				else cylinderDataSource.inputTextInches,
				inputValue1 = inputDiameter,
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
				containerColor = containerColor,
				contentColor = color,
			)
		},
		imageContent = {
			CalculateImage(
				painter = cylinderDataSource.image,
				contentDescription = Cylinder.title,
				colorFilter = color
			)
		},
		formulaContent = {
			FormulaString(
				text = cylinderDataSource.formulaText,
				color = color
			)
		}
	)
}

@VisibleForTesting
fun calculateVolGallonCyl(
	diameter: Double,
	height: Double,
	halfCyl: Boolean,
	quartCyl: Boolean,
): String {
	val radius = 0.5 * diameter
	var volGallons = (PI * radius.pow(2) * height) / 231.0
	if (halfCyl)
		volGallons = ((PI * radius.pow(2) * height) / 2) / 231.0
	if (quartCyl)
		volGallons = ((PI * radius.pow(2) * height) / 4) / 231.0

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volGallons)
}

@VisibleForTesting
fun calculateVolLiterCyl(
	diameter: Double,
	height: Double,
	halfCyl: Boolean,
	quartCyl: Boolean,
): String {
	val radius = 0.5 * diameter
	var volLiters = (PI * radius.pow(2) * height) / 61.0237
	if (halfCyl)
		volLiters = ((PI * radius.pow(2) * height) / 2) / 61.0237
	if (quartCyl)
		volLiters = ((PI * radius.pow(2) * height) / 4) / 61.0237

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volLiters)
}

@VisibleForTesting
fun calculateWaterWeightCyl(
	diameter: Double,
	height: Double,
	halfCyl: Boolean,
	quartCyl: Boolean,
): String {
	val radius = 0.5 * diameter
	var waterWeight = ((PI * radius.pow(2) * height) / 231.0) * 8.33
	if (halfCyl)
		waterWeight = (((PI * radius.pow(2) * height) / 2) / 231.0) * 8.33
	if (quartCyl)
		waterWeight = (((PI * radius.pow(2) * height) / 4) / 231.0) * 8.33

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(waterWeight)
}

@VisibleForTesting
fun calculateVolGallonFTCyl(
	diameter: Double,
	height: Double,
	halfCyl: Boolean,
	quartCyl: Boolean,
): String {
	val radius = 0.5 * diameter
	var volGallons = (PI * radius.pow(2) * height) / 0.133681
	if (halfCyl)
		volGallons = ((PI * radius.pow(2) * height) / 2) / 0.133681
	if (quartCyl)
		volGallons = ((PI * radius.pow(2) * height) / 4) / 0.133681

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volGallons)
}

@VisibleForTesting
fun calculateVolLiterFTCyl(
	diameter: Double,
	height: Double,
	halfCyl: Boolean,
	quartCyl: Boolean,
): String {
	val radius = 0.5 * diameter
	var volLiters = (PI * radius.pow(2) * height) / 0.0353147
	if (halfCyl)
		volLiters = ((PI * radius.pow(2) * height) / 2) / 0.0353147
	if (quartCyl)
		volLiters = ((PI * radius.pow(2) * height) / 4) / 0.0353147

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volLiters)
}

@VisibleForTesting
fun calculateWaterWeightFTCyl(
	diameter: Double,
	height: Double,
	halfCyl: Boolean,
	quartCyl: Boolean,
): String {
	val radius = 0.5 * diameter
	var waterWeight = ((PI * radius.pow(2) * height) / 0.133681) * 8.33
	if (halfCyl)
		waterWeight = (((PI * radius.pow(2) * height) / 2) / 0.133681) * 8.33
	if (quartCyl)
		waterWeight = (((PI * radius.pow(2) * height) / 4) / 0.133681) * 8.33

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(waterWeight)
}

@Preview(showBackground = true)
@Composable
fun CylinderPreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			CylinderPage()
		}
	}
}

@Preview(showBackground = true)
@Composable
fun CylinderPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			CylinderPage()
		}
	}
}