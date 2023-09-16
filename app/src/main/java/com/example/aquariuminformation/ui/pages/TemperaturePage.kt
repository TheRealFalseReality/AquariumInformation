package com.example.aquariuminformation.ui.pages

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aquariuminformation.R
import com.example.aquariuminformation.ui.commonui.PageView
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
	modifier: Modifier = Modifier
) {
	Column(
		modifier = modifier
	) {
		val inputTemperature by rememberSaveable {
			mutableStateOf("0")
		}
		var selected by rememberSaveable {
			mutableIntStateOf(R.string.text_celsius)
		}

		val temp = inputTemperature.toDoubleOrNull() ?: 0.0
		val celsius = calculateCelsius(temp).toDoubleOrNull() ?: 0.0
		val kelvinCel = calculateKelvinCel(temp).toDoubleOrNull() ?: 0.0
		val kelvinFah = calculateKelvinFah(temp).toDoubleOrNull() ?: 0.0
		val fahrenheit = calculateFahrenheit(temp).toDoubleOrNull() ?: 0.0
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