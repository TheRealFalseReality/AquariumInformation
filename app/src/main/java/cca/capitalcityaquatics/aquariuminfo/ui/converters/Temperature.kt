package cca.capitalcityaquatics.aquariuminfo.ui.converters

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.ui.commonComposables.*
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AppTheme
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun TempScreen(
	modifier: Modifier = Modifier,
) {
	var inputTemp by rememberSaveable {
		mutableStateOf("0")
	}
	var selected by rememberSaveable {
		mutableStateOf(R.string.text_celsius)
	}

	val temp = inputTemp.toDoubleOrNull() ?: 0.0
	val celsius = calculateCelsius(temp).toDoubleOrNull() ?: 0.0
	val kelvinCel = calculateKelvinCel(temp).toDoubleOrNull() ?: 0.0
	val kelvinFah = calculateKelvinFah(temp).toDoubleOrNull() ?: 0.0
	val fahrenheit = calculateFahrenheit(temp).toDoubleOrNull() ?: 0.0

	GeneralCard(verticalArrangement = Arrangement.Top) {

		GeneralComposeHeader(text = R.string.text_title_temp)

		GeneralComposeSubHeader(text = R.string.text_subtitle_temp)

		RadioButtonCard {
			RadioButtonComp(
				text = R.string.text_celsius,
				onClick1 = { selected = R.string.text_celsius },
				selected = selected
			)
			RadioButtonComp(
				text = R.string.text_fah,
				onClick1 = { selected = R.string.text_fah },
				selected = selected
			)
		}

		Spacer(modifier = Modifier.height(12.dp))

		when (selected) {
			R.string.text_celsius -> {
				DataOutputLines4(
					inputValue = inputTemp,
					label = R.string.field_label_cel,
					onValueChange = { inputTemp = it },
					inputText = R.string.text_amount_celsius,
					equalsText = R.string.text_equal_to,
					outputTextA = R.string.text_amount_fah,
					valueA = fahrenheit,
					outputTextB = R.string.text_amount_kelvin,
					valueB = kelvinCel
				)
			}
			R.string.text_fah -> {
				DataOutputLines4(
					inputValue = inputTemp,
					label = R.string.field_label_fah,
					onValueChange = { inputTemp = it },
					inputText = R.string.text_amount_fah,
					equalsText = R.string.text_equal_to,
					outputTextA = R.string.text_amount_celsius,
					valueA = celsius,
					outputTextB = R.string.text_amount_kelvin,
					valueB = kelvinFah
				)
			}
		}
		FormulaStringTemp()
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
fun TempPreview() {
	AppTheme {
		TempScreen()
	}
}