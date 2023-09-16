package com.example.aquariuminformation.ui.pages

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.aquariuminformation.R
import com.example.aquariuminformation.ui.commonui.BodyTextCard
import com.example.aquariuminformation.ui.commonui.CalculateField
import com.example.aquariuminformation.ui.commonui.CalculatedText
import com.example.aquariuminformation.ui.commonui.FormulaString
import com.example.aquariuminformation.ui.commonui.GenericPageHeader
import com.example.aquariuminformation.ui.commonui.InputNumberField
import com.example.aquariuminformation.ui.commonui.PageView
import com.example.aquariuminformation.ui.commonui.RadioButtonCard
import com.example.aquariuminformation.ui.commonui.RadioButtonComp
import com.example.aquariuminformation.ui.theme.AquariumInformationTheme
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
	modifier: Modifier = Modifier,
) {
	var inputTemperature by rememberSaveable {
		mutableStateOf("0")
	}
	var selected by rememberSaveable {
		mutableIntStateOf(R.string.text_celsius)
	}

	val temp = inputTemperature.toDoubleOrNull() ?: 0.0
	val celsius = calculateCelsius(temp).toDoubleOrNull() ?: 0.0
	val kelvinCelsius = calculateKelvinCel(temp).toDoubleOrNull() ?: 0.0
	val kelvinFahrenheit = calculateKelvinFah(temp).toDoubleOrNull() ?: 0.0
	val fahrenheit = calculateFahrenheit(temp).toDoubleOrNull() ?: 0.0

	Column(
		modifier = modifier
	) {
		val color = MaterialTheme.colorScheme.primary

		GenericPageHeader(
			title = R.string.text_title_temp,
			subtitle = R.string.text_subtitle_temp,
			icon = R.drawable.ic_thermostat,
			color = color,
			selectContent = {
				RadioButtonCard(
					contentColor = color,
					content = {
						RadioButtonComp(
							modifier = Modifier
								.weight(1f),
							text = R.string.text_celsius,
							onClick = { selected = R.string.text_celsius },
							selected = selected,
							selectedColor = color,
						)
						RadioButtonComp(
							modifier = Modifier
								.weight(1f),
							text = R.string.text_fah,
							onClick = { selected = R.string.text_fah },
							selected = selected,
							selectedColor = color,
						)
					}
				)
			},
			calculateFieldContent = {
				Column(
					modifier = Modifier.fillMaxWidth(),
					horizontalAlignment = Alignment.CenterHorizontally
				) {
					when (selected) {
						R.string.text_celsius -> {
							CalculateField(
								inputContent = {
									InputNumberField(
										modifier = Modifier.fillMaxWidth(),
										placeholder = R.string.field_label_cel,
										label = R.string.button_label_cel,
										value = inputTemperature,
										onValueChange = { inputTemperature = it },
										color = color
									)
								},
								inputText = R.string.text_amount_celsius,
								inputValue = inputTemperature,
								equalsText = R.string.text_equal_to,
								calculateContent = {
									CalculatedText(
										modifier = Modifier.fillMaxWidth(),
										label = R.string.text_amount_fah,
										calculatedValue = fahrenheit,
										color = color
									)
									CalculatedText(
										modifier = Modifier.fillMaxWidth(),
										label = R.string.text_amount_kelvin,
										calculatedValue = kelvinCelsius,
										color = color
									)
								}
							)
						}

						R.string.text_fah -> {
							CalculateField(
								inputContent = {
									InputNumberField(
										modifier = Modifier.fillMaxWidth(),
										placeholder = R.string.field_label_fah,
										label = R.string.button_label_fah,
										value = inputTemperature,
										onValueChange = { inputTemperature = it },
										color = color
									)
								},
								inputText = R.string.text_amount_fah,
								inputValue = inputTemperature,
								equalsText = R.string.text_equal_to,
								calculateContent = {
									CalculatedText(
										modifier = Modifier.fillMaxWidth(),
										label = R.string.text_amount_celsius,
										calculatedValue = celsius,
										color = color
									)
									CalculatedText(
										modifier = Modifier.fillMaxWidth(),
										label = R.string.text_amount_kelvin,
										calculatedValue = kelvinFahrenheit,
										color = color
									)
								}
							)
						}
					}
				}
				FormulaString(
					content = {
						BodyTextCard(
							text = R.string.text_formula_celsius,
							textAlign = TextAlign.Justify,
							color = color
						)
						BodyTextCard(
							text = R.string.text_formula_fahrenheit,
							textAlign = TextAlign.Justify,
							color = color
						)
						BodyTextCard(
							text = R.string.formula_kelvin,
							textAlign = TextAlign.Justify,
							color = color
						)
					}
				)
			},
		)
	}
	Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_verySmall)))
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