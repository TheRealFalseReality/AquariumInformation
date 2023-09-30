package cca.capitalcityaquatics.aquariuminfo.ui.pages.calculators

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.data.calculators.temperatureDataSource
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.BodyText
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateField
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatedText
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
fun TemperaturePage() {
	PageView {
		TemperatureLayout()
	}
}

@Composable
fun TemperatureLayout(
	color: Color = MaterialTheme.colorScheme.primary,
	containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
	contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
) {
	var inputTemperature by rememberSaveable {
		mutableStateOf("0")
	}
	var selected by rememberSaveable {
		mutableIntStateOf(temperatureDataSource.radioTextCelsius)
	}
	val temp = inputTemperature.toDoubleOrNull() ?: 0.0
	val celsius = calculateCelsius(temp).toDoubleOrNull() ?: 0.0
	val kelvinCelsius = calculateKelvinCel(temp).toDoubleOrNull() ?: 0.0
	val kelvinFahrenheit = calculateKelvinFah(temp).toDoubleOrNull() ?: 0.0
	val fahrenheit = calculateFahrenheit(temp).toDoubleOrNull() ?: 0.0

	GenericCalculatePage(
		subtitle = temperatureDataSource.subtitle,
		color = color,
		selectContent = {
			SingleWideCardExpandableRadio(
				modifier = Modifier.fillMaxWidth(fraction = 0.75f),
				expandedState = true,
				header = R.string.select_input_units,
				contentColor = color,
				content = {
					RadioButtonTwoUnits(
						onClick1 = { selected = temperatureDataSource.radioTextCelsius },
						onClick2 = { selected = temperatureDataSource.radioTextFahrenheit },
						label1 = temperatureDataSource.radioTextCelsius,
						label2 = temperatureDataSource.radioTextFahrenheit,
						selected = selected,
						selectedColor = color,
						textColor = color
					)
				}
			)
		},
		calculateFieldContent = {
			when (selected) {
				temperatureDataSource.radioTextCelsius -> {
					CalculateField(
						inputContent = {
							InputNumberField(
								placeholder = temperatureDataSource.placeholderCelsius,
								label = temperatureDataSource.labelCelsius,
								value = inputTemperature,
								onValueChange = { inputTemperature = it },
								focusedContainerColor = containerColor,
								focusedColor = contentColor,
								unfocusedColor = color,
							)
						},
						inputText = temperatureDataSource.inputTextCelsius,
						inputValue = inputTemperature,
						equalsText = temperatureDataSource.equalsText,
						contentColor = color,
						containerColor = containerColor,
						calculateContent = {
							CalculatedText(
								text = temperatureDataSource.calculatedTextFahrenheit,
								calculatedValue = fahrenheit,
								textColor = contentColor,
							)
							CalculatedText(
								text = temperatureDataSource.calculatedTextKelvin,
								calculatedValue = kelvinCelsius,
								textColor = contentColor,
							)
						}
					)
				}

				temperatureDataSource.radioTextFahrenheit -> {
					CalculateField(
						inputContent = {
							InputNumberField(
								placeholder = temperatureDataSource.placeholderFahrenheit,
								label = temperatureDataSource.labelFahrenheit,
								value = inputTemperature,
								onValueChange = { inputTemperature = it },
								focusedContainerColor = containerColor,
								focusedColor = contentColor,
								unfocusedColor = color,
							)
						},
						inputText = temperatureDataSource.inputTextFahrenheit,
						inputValue = inputTemperature,
						equalsText = temperatureDataSource.equalsText,
						contentColor = color,
						containerColor = containerColor,
						calculateContent = {
							CalculatedText(
								text = temperatureDataSource.calculatedTextCelsius,
								calculatedValue = celsius,
								textColor = contentColor,
							)
							CalculatedText(
								text = temperatureDataSource.calculatedTextKelvin,
								calculatedValue = kelvinFahrenheit,
								textColor = contentColor,
							)
						}
					)
				}
			}
		},
		formulaContent = {
			FormulaStringContent(
				contentColor = color,
				content = {
					BodyText(
						text = temperatureDataSource.formulaText1,
						textAlign = TextAlign.Start,
						color = color
					)
					BodyText(
						text = temperatureDataSource.formulaText2,
						textAlign = TextAlign.Start,
						color = color
					)
					BodyText(
						text = temperatureDataSource.formulaText3,
						textAlign = TextAlign.Start,
						color = color
					)
				}
			)
		}
	)
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

@Preview(showBackground = true)
@Composable
fun TemperaturePreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.surface)
		) {
			TemperaturePage()
		}
	}
}

@Preview(showBackground = true)
@Composable
fun TemperaturePreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.surface)
		) {
			TemperaturePage()
		}
	}
}