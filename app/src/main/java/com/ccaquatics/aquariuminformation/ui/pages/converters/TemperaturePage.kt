package com.ccaquatics.aquariuminformation.ui.pages.converters

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.ccaquatics.aquariuminformation.data.converters.temperatureDataSource
import com.ccaquatics.aquariuminformation.navigation.Temperature
import com.ccaquatics.aquariuminformation.ui.commonui.BodyText
import com.ccaquatics.aquariuminformation.ui.commonui.CalculateField
import com.ccaquatics.aquariuminformation.ui.commonui.CalculatedText
import com.ccaquatics.aquariuminformation.ui.commonui.FormulaStringContent
import com.ccaquatics.aquariuminformation.ui.commonui.GenericCalculatePage
import com.ccaquatics.aquariuminformation.ui.commonui.InputNumberField
import com.ccaquatics.aquariuminformation.ui.commonui.PageView
import com.ccaquatics.aquariuminformation.ui.commonui.RadioButtonComp
import com.ccaquatics.aquariuminformation.ui.commonui.UnitButtonCard
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun TemperaturePage() {
	PageView {
		TemperatureLayout()
	}
}

@Composable
fun TemperatureLayout() {
	val color = MaterialTheme.colorScheme.primary
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
		title = Temperature.title,
		subtitle = temperatureDataSource.subtitle,
		icon = Temperature.icon,
		color = color,
		selectContent = {
			UnitButtonCard(
				contentColor = color,
				content = {
					RadioButtonComp(
						modifier = Modifier
							.weight(1f),
						text = temperatureDataSource.radioTextCelsius,
						onClick = { selected = temperatureDataSource.radioTextCelsius },
						selected = selected,
						selectedColor = color,
					)
					RadioButtonComp(
						modifier = Modifier
							.weight(1f),
						text = temperatureDataSource.radioTextFahrenheit,
						onClick = { selected = temperatureDataSource.radioTextFahrenheit },
						selected = selected,
						selectedColor = color,
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
								modifier = Modifier.fillMaxWidth(),
								placeholder = temperatureDataSource.placeholderCelsius,
								label = temperatureDataSource.labelCelsius,
								value = inputTemperature,
								onValueChange = { inputTemperature = it },
								color = color
							)
						},
						inputText = temperatureDataSource.inputTextCelsius,
						inputValue = inputTemperature,
						equalsText = temperatureDataSource.equalsText,
						color = color,
						calculateContent = {
							CalculatedText(
								modifier = Modifier.fillMaxWidth(),
								text = temperatureDataSource.calculatedTextFahrenheit,
								calculatedValue = fahrenheit,
								color = color
							)
							CalculatedText(
								modifier = Modifier.fillMaxWidth(),
								text = temperatureDataSource.calculatedTextKelvin,
								calculatedValue = kelvinCelsius,
								color = color
							)
						}
					)
				}

				temperatureDataSource.radioTextFahrenheit -> {
					CalculateField(
						inputContent = {
							InputNumberField(
								modifier = Modifier.fillMaxWidth(),
								placeholder = temperatureDataSource.placeholderFahrenheit,
								label = temperatureDataSource.labelFahrenheit,
								value = inputTemperature,
								onValueChange = { inputTemperature = it },
								color = color
							)
						},
						inputText = temperatureDataSource.inputTextFahrenheit,
						inputValue = inputTemperature,
						equalsText = temperatureDataSource.equalsText,
						color = color,
						calculateContent = {
							CalculatedText(
								modifier = Modifier.fillMaxWidth(),
								text = temperatureDataSource.calculatedTextCelsius,
								calculatedValue = celsius,
								color = color
							)
							CalculatedText(
								modifier = Modifier.fillMaxWidth(),
								text = temperatureDataSource.calculatedTextKelvin,
								calculatedValue = kelvinFahrenheit,
								color = color
							)
						}
					)
				}
			}
		},
		formulaContent = {
			FormulaStringContent(
				color = color,
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