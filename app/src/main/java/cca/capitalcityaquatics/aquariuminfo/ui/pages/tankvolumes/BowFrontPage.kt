package cca.capitalcityaquatics.aquariuminfo.ui.pages.tankvolumes

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.data.tankvolumes.bowFrontDataSource
import cca.capitalcityaquatics.aquariuminfo.data.tankvolumes.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.navigation.BowFront
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateFieldFourInputs
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateImage
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FormulaString
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.GenericCalculatePage
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.InputQuadNumberFieldFourInputs
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageView
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.RadioButtonTwoUnits
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.SingleWideCardExpandableRadio
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.TankVolumeResults
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme
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
		subtitle = calculatorDataSource.subtitle,
		subtitleContent = {
			Row(
				verticalAlignment = Alignment.CenterVertically
			) {
				Text(
					text = stringResource(id = R.string.text_subtitle_tank_vol_distance),
					color = contentColor
				)
				Icon(
					modifier = Modifier
						.padding(dimensionResource(id = R.dimen.padding_verySmall)),
					painter = painterResource(id = R.drawable.ic_sync_alt),
					contentDescription = null,
					tint = contentColor
				)
				Text(
					text = stringResource(id = R.string.text_subtitle_tank_vol_volume),
					color = contentColor
				)
			}
		},
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
				contentColor = color
			)
		},
		calculateFieldContent = {
			CalculateFieldFourInputs(
				inputContent = {
					InputQuadNumberFieldFourInputs(
						label1 = calculatorDataSource.labelLength,
//						placeholder1 = calculatorDataSource.placeholderLength,
						label2 = calculatorDataSource.labelWidth,
//						placeholder2 = calculatorDataSource.placeholderWidth,
						value1 = inputLength,
						onValueChange1 = { inputLength = it },
						value2 = inputWidth,
						onValueChange2 = { inputWidth = it },
						focusedContainerColor = containerColor,
						focusedColor = contentColor,
						unfocusedColor = color,
						label3 = calculatorDataSource.labelHeight,
//						placeholder3 = calculatorDataSource.placeholderHeight,
						label4 = calculatorDataSource.labelFullWidth,
//						placeholder4 = calculatorDataSource.placeholderFullWidth,
						value3 = inputHeight,
						onValueChange3 = { inputHeight = it },
						value4 = inputFullWidth,
						onValueChange4 = { inputFullWidth = it },
						leadingIcon1 = calculatorDataSource.leadingIconLength,
						leadingIcon2 = calculatorDataSource.leadingIconWidth,
						leadingIcon3 = calculatorDataSource.leadingIconHeight,
						leadingIcon4 = calculatorDataSource.leadingIconFullWidth,
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
			CalculateImage(
				painter = bowFrontDataSource.image,
				contentDescription = BowFront.title,
				colorFilter = color,
			)
		},
		formulaContent = {
			FormulaString(
				text = bowFrontDataSource.formulaText,
				contentColor = color
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