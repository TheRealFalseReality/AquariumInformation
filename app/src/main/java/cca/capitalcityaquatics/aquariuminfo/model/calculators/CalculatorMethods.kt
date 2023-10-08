package cca.capitalcityaquatics.aquariuminfo.model.calculators

import androidx.annotation.VisibleForTesting
import cca.capitalcityaquatics.aquariuminfo.data.calculators.alkalinityDataSource
import cca.capitalcityaquatics.aquariuminfo.data.calculators.temperatureDataSource
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow

class CalculatorMethods(
	private val selected: Int? = null,
	private val pH: Double = 0.0,
	private val dKH: Double = 0.0,
	private val alkalinity: Double = 0.0,
	private val temperature: Double = 0.0,
) {
	// Carbon Dioxide
	@VisibleForTesting
	fun calculateCarbonDioxide(): String {
		val phSolution = 10.0.pow(6.37 - pH)
		val carbonDioxide = (12.839 * dKH) * phSolution
		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(carbonDioxide)
	}

	// Alkalinity
	// Convert to dKH
	@VisibleForTesting
	fun calculateAlkalinityDKH(): String {
		val conversionFactor =
			when (selected) {
				// ppm
				alkalinityDataSource.radioTextPpm -> {
					alkalinityDataSource.conversionDKHPPM
				}

				// meq/L
				else -> {
					alkalinityDataSource.conversionDKHMEQ
				}
			}
		val ppmDKH = alkalinity * conversionFactor
		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(ppmDKH)
	}

	// Convert to ppm
	@VisibleForTesting
	fun calculateAlkalinityPPM(): String {
		val conversionFactor =
			when (selected) {
				// dKH
				alkalinityDataSource.radioTextDkh -> {
					alkalinityDataSource.conversionPPMDKH
				}

				// meq/L
				else -> {
					alkalinityDataSource.conversionPPMMEQ
				}
			}
		val ppmDKH = alkalinity * conversionFactor
		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(ppmDKH)
	}

	// Convert to meq/L
	@VisibleForTesting
	fun calculateAlkalinityMEQ(): String {
		val conversionFactor =
			when (selected) {
				// dKH
				alkalinityDataSource.radioTextDkh -> {
					alkalinityDataSource.conversionMEQDKH
				}

				// ppm
				else -> {
					alkalinityDataSource.conversionMEQPPM
				}
			}
		val ppmDKH = alkalinity * conversionFactor
		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(ppmDKH)
	}

	// Temperature
	@VisibleForTesting
	fun calculateTemperature(): String {
		val calculatedTemperature =
			when (selected) {
				// Fahrenheit
				temperatureDataSource.radioTextFahrenheit -> {
					(temperature - 32) * (5.0 / 9.0)
				}

				//Celsius
				else -> {
					(temperature * (9.0 / 5.0) + 32)
				}
			}
		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(calculatedTemperature)
	}

	// Convert to Kelvin
	@VisibleForTesting
	fun calculateTemperatureKelvin(): String {
		val calculatedTemperature =
			when (selected) {
				// Fahrenheit
				temperatureDataSource.radioTextFahrenheit -> {
					(temperature - 32) * (5.0 / 9.0)
				}

				//Celsius
				else -> {
					temperature
				}
			}
		val calculatedTemperatureKelvin = calculatedTemperature + 273.15
		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(calculatedTemperatureKelvin)
	}
}