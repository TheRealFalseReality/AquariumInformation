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
import androidx.compose.ui.tooling.preview.Preview
import com.ccaquatics.aquariuminformation.data.calculators.cubeDataSource
import com.ccaquatics.aquariuminformation.data.calculators.rectangleDataSource
import com.ccaquatics.aquariuminformation.navigation.Cube
import com.ccaquatics.aquariuminformation.ui.commonui.BodyTextCard
import com.ccaquatics.aquariuminformation.ui.commonui.CalculateField
import com.ccaquatics.aquariuminformation.ui.commonui.CalculateImage
import com.ccaquatics.aquariuminformation.ui.commonui.CalculatedText
import com.ccaquatics.aquariuminformation.ui.commonui.FormulaString
import com.ccaquatics.aquariuminformation.ui.commonui.GenericPage
import com.ccaquatics.aquariuminformation.ui.commonui.InputNumberField
import com.ccaquatics.aquariuminformation.ui.commonui.PageView
import com.ccaquatics.aquariuminformation.ui.commonui.RadioButtonComp
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
fun CubeLayout(modifier: Modifier = Modifier) {
	val color = MaterialTheme.colorScheme.secondary

	var inputSide by rememberSaveable {
		mutableStateOf("")
	}
	var selected by rememberSaveable {
		mutableIntStateOf(cubeDataSource.radioTextFeet)
	}
	val side = inputSide.toDoubleOrNull() ?: 0.0
	val volGallon = calculateVolGallonCube(side).toDoubleOrNull() ?: 0.0
	val volLiter = calculateVolLiterCube(side).toDoubleOrNull() ?: 0.0
	val waterWeight = calculateWaterWeightCube(side).toDoubleOrNull() ?: 0.0
	val volGallonFT = calculateVolGallonFTCube(side).toDoubleOrNull() ?: 0.0
	val volLiterFT = calculateVolLiterFTCube(side).toDoubleOrNull() ?: 0.0
	val waterWeightFT = calculateWaterWeightFTCube(side).toDoubleOrNull() ?: 0.0

	Column(modifier = modifier) {
		GenericPage(
			title = Cube.title,
			subtitle = Cube.subtitle,
			icon = Cube.icon,
			color = color,
			selectContent = {
				UnitButtonCard(
					content = {
						RadioButtonComp(
							modifier = Modifier
								.weight(1f),
							text = cubeDataSource.radioTextFeet,
							onClick = { selected = cubeDataSource.radioTextFeet },
							selected = selected,
							selectedColor = color
						)
						RadioButtonComp(
							modifier = Modifier
								.weight(1f),
							text = cubeDataSource.radioTextInches,
							onClick = { selected = cubeDataSource.radioTextInches },
							selected = selected,
							selectedColor = color
						)
					},
					contentColor = color,
				)
			},
			calculateFieldContent = {
				CalculateField(
					inputContent = {
						InputNumberField(
							label = cubeDataSource.labelSide,
							placeholder = cubeDataSource.placeholderSide,
							value = inputSide,
							onValueChange = { inputSide = it },
							color = color,
						)
					},
					inputText = cubeDataSource.inputText,
					inputValue = inputSide,
					equalsText = cubeDataSource.equalsText,
					calculateContent = {
						when (selected) {
							cubeDataSource.radioTextFeet -> {
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

							cubeDataSource.radioTextInches -> {
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
					},
					color = color,
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
					content = {
						BodyTextCard(text = cubeDataSource.formulaText)
					},
					color = color,
				)
			}
		)
	}
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