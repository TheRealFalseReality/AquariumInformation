package cca.capitalcityaquatics.aquariuminfo.ui.pages.calculators

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.data.calculators.temperatureDataSource
import cca.capitalcityaquatics.aquariuminfo.data.tankvolumes.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.BodyText
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateField
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatedText
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatorSubtitleThree
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FormulaStringContent
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.GenericCalculatePage
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.InputNumberField
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageView
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.RadioButtonTwoUnits
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.SingleWideCardExpandableRadio
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun TemperaturePage(windowSize: WindowSizeClass) {
	PageView {
		TemperatureLayout(windowSize = windowSize)
	}
}

@Composable
fun TemperatureLayout(
	windowSize: WindowSizeClass,
	color: Color = MaterialTheme.colorScheme.primary,
	containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
	contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
) {
	val dataSource = temperatureDataSource
	var inputTemperature by rememberSaveable {
		mutableStateOf("0")
	}
	var selected by rememberSaveable {
		mutableIntStateOf(dataSource.radioTextCelsius)
	}
	val temp = inputTemperature.toDoubleOrNull() ?: 0.0
	val celsius = calculateCelsius(temp).toDoubleOrNull() ?: 0.0
	val kelvinCelsius = calculateKelvinCel(temp).toDoubleOrNull() ?: 0.0
	val kelvinFahrenheit = calculateKelvinFah(temp).toDoubleOrNull() ?: 0.0
	val fahrenheit = calculateFahrenheit(temp).toDoubleOrNull() ?: 0.0

	GenericCalculatePage(
		windowSize = windowSize,
		subtitleContent = {
			CalculatorSubtitleThree(
				contentColor = color,
				text1 = dataSource.subtitle1,
				text2 = dataSource.subtitle2,
				text3 = dataSource.subtitle3,
			)
		},
		selectContent = {
			SingleWideCardExpandableRadio(
				modifier = Modifier.fillMaxWidth(fraction = 0.75f),
				expandedState = true,
				header = R.string.select_input_units,
				contentColor = color,
				content = {
					RadioButtonTwoUnits(
						onClick1 = { selected = dataSource.radioTextCelsius },
						onClick2 = { selected = dataSource.radioTextFahrenheit },
						label1 = dataSource.radioTextCelsius,
						label2 = dataSource.radioTextFahrenheit,
						selected = selected,
						selectedColor = color,
						textColor = color
					)
				}
			)
		},
		inputFieldContent = {
			InputNumberField(
				label =
				when (selected) {
					dataSource.radioTextFahrenheit -> {
						dataSource.labelFahrenheit
					}

					else -> {
						dataSource.labelCelsius
					}
				},
				value = inputTemperature,
				onValueChange = { inputTemperature = it },
				focusedContainerColor = containerColor,
				focusedColor = contentColor,
				unfocusedColor = color,
				leadingIcon = calculatorDataSource.leadingIconTemperature,
			)
		},
		calculateFieldContent = {
			when (selected) {
				dataSource.radioTextFahrenheit -> {
					CalculateField(
						inputText = dataSource.inputTextFahrenheit,
						inputValue = inputTemperature,
						equalsText = dataSource.equalsText,
						contentColor = color,
						containerColor = containerColor,
						calculateContent = {
							CalculatedText(
								text = dataSource.calculatedTextCelsius,
								calculatedValue = celsius,
								textColor = contentColor,
							)
							CalculatedText(
								text = dataSource.calculatedTextKelvin,
								calculatedValue = kelvinFahrenheit,
								textColor = contentColor,
							)
						}
					)
				}

				else -> {
					CalculateField(
						inputText = dataSource.inputTextCelsius,
						inputValue = inputTemperature,
						equalsText = dataSource.equalsText,
						contentColor = color,
						containerColor = containerColor,
						calculateContent = {
							CalculatedText(
								text = dataSource.calculatedTextFahrenheit,
								calculatedValue = fahrenheit,
								textColor = contentColor,
							)
							CalculatedText(
								text = dataSource.calculatedTextKelvin,
								calculatedValue = kelvinCelsius,
								textColor = contentColor,
							)
						}
					)
				}
			}
		}
	) {
		FormulaStringContent(
			contentColor = color,
			content = {
				BodyText(
					text = dataSource.formulaText1,
					textAlign = TextAlign.Start,
					color = color
				)
				BodyText(
					text = dataSource.formulaText2,
					textAlign = TextAlign.Start,
					color = color
				)
				BodyText(
					text = dataSource.formulaText3,
					textAlign = TextAlign.Start,
					color = color
				)
			}
		)
	}
}

@VisibleForTesting
fun calculateCelsius(
	temp: Double,
): String {
	val celsius = (temp - 32) * (5.0 / 9.0)
	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(celsius)
}

@VisibleForTesting
fun calculateFahrenheit(
	temp: Double
): String {
	val fahrenheit = (temp * (9.0 / 5.0) + 32)
	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(fahrenheit)
}

@VisibleForTesting
fun calculateKelvinFah(
	temp: Double,
): String {
	val kelvin = ((temp - 32) * (5.0 / 9.0)) + 273.15
	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(kelvin)
}

@VisibleForTesting
fun calculateKelvinCel(
	temp: Double,
): String {
	val kelvin = (temp + 273.15)
	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(kelvin)
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun TemperaturePreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.surface)
		) {
			TemperaturePage(windowSize = WindowSizeClass.calculateFromSize(DpSize(300.dp, 400.dp)))
		}
	}
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun TemperaturePreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.surface)
		) {
			TemperaturePage(windowSize = WindowSizeClass.calculateFromSize(DpSize(300.dp, 400.dp)))
		}
	}
}