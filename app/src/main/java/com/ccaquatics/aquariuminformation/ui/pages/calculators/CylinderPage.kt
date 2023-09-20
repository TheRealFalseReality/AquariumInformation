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
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ccaquatics.aquariuminformation.data.calculators.commonTankVolumeDataSource
import com.ccaquatics.aquariuminformation.data.calculators.cylinderDataSource
import com.ccaquatics.aquariuminformation.navigation.Cylinder
import com.ccaquatics.aquariuminformation.ui.commonui.BodyTextCard
import com.ccaquatics.aquariuminformation.ui.commonui.CalculateFieldTwoInputs
import com.ccaquatics.aquariuminformation.ui.commonui.CalculateImage
import com.ccaquatics.aquariuminformation.ui.commonui.CalculatedText
import com.ccaquatics.aquariuminformation.ui.commonui.FormulaString
import com.ccaquatics.aquariuminformation.ui.commonui.GenericPage
import com.ccaquatics.aquariuminformation.ui.commonui.InputRowNumberFieldTwoInputs
import com.ccaquatics.aquariuminformation.ui.commonui.PageView
import com.ccaquatics.aquariuminformation.ui.commonui.RadioButtonComp
import com.ccaquatics.aquariuminformation.ui.commonui.UnitButtonCard
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
fun CylinderLayout(modifier: Modifier = Modifier) {
	val color = MaterialTheme.colorScheme.secondary

	var inputDiameter by rememberSaveable {
		mutableStateOf("")
	}
	var inputHeight by rememberSaveable {
		mutableStateOf("")
	}
	var selected by rememberSaveable {
		mutableIntStateOf(commonTankVolumeDataSource.radioTextFeet)
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

	Column(modifier = modifier) {
		GenericPage(
			title = Cylinder.title,
			subtitle = Cylinder.subtitle,
			icon = Cylinder.icon,
			color = color,
			selectContent = {
				UnitButtonCard(
					content = {
						RadioButtonComp(
							modifier = Modifier
								.weight(1f),
							text = commonTankVolumeDataSource.radioTextFeet,
							onClick = { selected = commonTankVolumeDataSource.radioTextFeet },
							selected = selected,
							selectedColor = color
						)
						RadioButtonComp(
							modifier = Modifier
								.weight(1f),
							text = commonTankVolumeDataSource.radioTextInches,
							onClick = { selected = commonTankVolumeDataSource.radioTextInches },
							selected = selected,
							selectedColor = color
						)
					},
					contentColor = color
				)
			},
			optionsContent = { /* TODO */ },
			calculateFieldContent = {
				CalculateFieldTwoInputs(
					inputContent = {
						InputRowNumberFieldTwoInputs(
							label1 = commonTankVolumeDataSource.labelDiameter,
							placeholder1 = commonTankVolumeDataSource.placeholderDiameter,
							label2 = commonTankVolumeDataSource.labelHeight,
							placeholder2 = commonTankVolumeDataSource.placeholderHeight,
							value1 = inputDiameter,
							onValueChange1 = { inputDiameter = it },
							value2 = inputHeight,
							onValueChange2 = { inputHeight = it },
							color = color
						)
					},
					inputText = cylinderDataSource.inputText,
					inputValue1 = inputDiameter,
					inputValue2 = inputHeight,
					equalsText = commonTankVolumeDataSource.equalsText,
					calculateContent = {
						when (selected) {
							commonTankVolumeDataSource.radioTextFeet -> {
								CalculatedText(
									modifier = Modifier.fillMaxWidth(),
									text = commonTankVolumeDataSource.calculatedTextGallons,
									calculatedValue = volGallonFT,
									color = color
								)
								CalculatedText(
									modifier = Modifier.fillMaxWidth(),
									text = commonTankVolumeDataSource.calculatedTextLiters,
									calculatedValue = volLiterFT,
									color = color
								)
								CalculatedText(
									modifier = Modifier.fillMaxWidth(),
									text = commonTankVolumeDataSource.calculatedTextWaterWeight,
									calculatedValue = waterWeightFT,
									color = color
								)
							}

							commonTankVolumeDataSource.radioTextInches -> {
								CalculatedText(
									modifier = Modifier.fillMaxWidth(),
									text = commonTankVolumeDataSource.calculatedTextGallons,
									calculatedValue = volGallon,
									color = color
								)
								CalculatedText(
									modifier = Modifier.fillMaxWidth(),
									text = commonTankVolumeDataSource.calculatedTextLiters,
									calculatedValue = volLiter,
									color = color
								)
								CalculatedText(
									modifier = Modifier.fillMaxWidth(),
									text = commonTankVolumeDataSource.calculatedTextWaterWeight,
									calculatedValue = waterWeight,
									color = color
								)
							}
						}
					},
					color = color,
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
					content = {
						BodyTextCard(text = cylinderDataSource.formulaText)
					},
					color = color
				)
			}
		)
	}
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