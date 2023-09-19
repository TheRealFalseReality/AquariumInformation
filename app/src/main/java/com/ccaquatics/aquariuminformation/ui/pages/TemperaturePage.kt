package com.ccaquatics.aquariuminformation.ui.pages

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
import com.ccaquatics.aquariuminformation.R
import com.ccaquatics.aquariuminformation.data.TemperatureDataSource
import com.ccaquatics.aquariuminformation.navigation.Temperature
import com.ccaquatics.aquariuminformation.ui.commonui.BodyTextCard
import com.ccaquatics.aquariuminformation.ui.commonui.CalculateField
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
fun TemperaturePage() {
	PageView {
		TemperatureLayout()
	}
}

@Composable
fun TemperatureLayout(modifier: Modifier = Modifier) {
	val color = MaterialTheme.colorScheme.primary
	var inputTemperature by rememberSaveable {
		mutableStateOf("0")
	}
	var selected by rememberSaveable {
		mutableIntStateOf(R.string.button_label_cel)
	}
	val temp = inputTemperature.toDoubleOrNull() ?: 0.0
	val celsius = calculateCelsius(temp).toDoubleOrNull() ?: 0.0
	val kelvinCelsius = calculateKelvinCel(temp).toDoubleOrNull() ?: 0.0
	val kelvinFahrenheit = calculateKelvinFah(temp).toDoubleOrNull() ?: 0.0
	val fahrenheit = calculateFahrenheit(temp).toDoubleOrNull() ?: 0.0

	Column(modifier = modifier) {
		GenericPage(
			title = Temperature.title,
			subtitle = Temperature.subtitle,
			icon = Temperature.icon,
			color = color,
			selectContent = {
				UnitButtonCard(
					contentColor = color,
					content = {
						RadioButtonComp(
							modifier = Modifier
								.weight(1f),
							text = TemperatureDataSource.radioTextCelsius,
							onClick = { selected = TemperatureDataSource.radioTextCelsius },
							selected = selected,
							selectedColor = color,
						)
						RadioButtonComp(
							modifier = Modifier
								.weight(1f),
							text = TemperatureDataSource.radioTextFahrenheit,
							onClick = { selected = TemperatureDataSource.radioTextFahrenheit },
							selected = selected,
							selectedColor = color,
						)
					}
				)
			},
			calculateFieldContent = {
				when (selected) {
					TemperatureDataSource.radioTextCelsius -> {
						CalculateField(
							inputContent = {
								InputNumberField(
									modifier = Modifier.fillMaxWidth(),
									placeholder = TemperatureDataSource.placeholderCelsius,
									label = TemperatureDataSource.labelCelsius,
									value = inputTemperature,
									onValueChange = { inputTemperature = it },
									color = color
								)
							},
							inputText = TemperatureDataSource.inputTextCelsius,
							inputValue = inputTemperature,
							equalsText = TemperatureDataSource.equalsText,
							calculateContent = {
								CalculatedText(
									modifier = Modifier.fillMaxWidth(),
									text = TemperatureDataSource.calculatedTextFahrenheit,
									calculatedValue = fahrenheit,
									color = color
								)
								CalculatedText(
									modifier = Modifier.fillMaxWidth(),
									text = TemperatureDataSource.calculatedTextKelvin,
									calculatedValue = kelvinCelsius,
									color = color
								)
							}
						)
					}

					TemperatureDataSource.radioTextFahrenheit -> {
						CalculateField(
							inputContent = {
								InputNumberField(
									modifier = Modifier.fillMaxWidth(),
									placeholder = TemperatureDataSource.placeholderFahrenheit,
									label =TemperatureDataSource.labelFahrenheit,
									value = inputTemperature,
									onValueChange = { inputTemperature = it },
									color = color
								)
							},
							inputText = TemperatureDataSource.inputTextFahrenheit,
							inputValue = inputTemperature,
							equalsText = TemperatureDataSource.equalsText,
							calculateContent = {
								CalculatedText(
									modifier = Modifier.fillMaxWidth(),
									text = TemperatureDataSource.calculatedTextCelsius,
									calculatedValue = celsius,
									color = color
								)
								CalculatedText(
									modifier = Modifier.fillMaxWidth(),
									text = TemperatureDataSource.calculatedTextKelvin,
									calculatedValue = kelvinFahrenheit,
									color = color
								)
							}
						)
					}
				}
			},
			formulaContent = {
				FormulaString(
					color= color,
					content = {
						BodyTextCard(
							text = TemperatureDataSource.formulaText1,
							textAlign = TextAlign.Justify,
							color = color
						)
						BodyTextCard(
							text = TemperatureDataSource.formulaText2,
							textAlign = TextAlign.Justify,
							color = color
						)
						BodyTextCard(
							text = TemperatureDataSource.formulaText3,
							textAlign = TextAlign.Justify,
							color = color
						)
					}
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