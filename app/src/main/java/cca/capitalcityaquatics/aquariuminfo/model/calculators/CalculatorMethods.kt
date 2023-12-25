package cca.capitalcityaquatics.aquariuminfo.model.calculators

import androidx.annotation.VisibleForTesting
import cca.capitalcityaquatics.aquariuminfo.data.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.data.calculators.alkalinityDataSource
import cca.capitalcityaquatics.aquariuminfo.data.calculators.flowRateDataSourceFreshwater
import cca.capitalcityaquatics.aquariuminfo.data.calculators.flowRateDataSourceMarine
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow

class CalculatorMethods(
	private val selected: Int? = null,
	private val pH: Double = 0.0,
	private val dKH: Double = 0.0,
	private val alkalinity: Double = 0.0,
	private val temperature: Double = 0.0,
	private val tankVolume: Double = 0.0,
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
				calculatorDataSource.radioTextPpm -> {
					alkalinityDataSource.conversionDKHPPM
				}

				// meq/L
				calculatorDataSource.radioTextMeq -> {
					alkalinityDataSource.conversionDKHMEQ
				}

				// error
				else -> {
					0.0
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
				calculatorDataSource.radioTextDkh -> {
					alkalinityDataSource.conversionPPMDKH
				}

				// meq/L
				calculatorDataSource.radioTextMeq -> {
					alkalinityDataSource.conversionPPMMEQ
				}
				// error
				else -> {
					0.0
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
				calculatorDataSource.radioTextDkh -> {
					alkalinityDataSource.conversionMEQDKH
				}

				// ppm
				calculatorDataSource.radioTextPpm -> {
					alkalinityDataSource.conversionMEQPPM
				}
				// error
				else -> {
					0.0
				}
			}
		val ppmDKH = alkalinity * conversionFactor
		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(ppmDKH)
	}

	// Temperature
	@VisibleForTesting
	fun convertTemperature(): String {
		val calculatedTemperature =
			when (selected) {
				// Fahrenheit
				calculatorDataSource.radioTextFahrenheit -> {
					(temperature - 32) * (5.0 / 9.0)
				}

				//Celsius
				calculatorDataSource.radioTextCelsius -> {
					(temperature * (9.0 / 5.0) + 32)
				}
				// error
				else -> {
					0.0
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
				calculatorDataSource.radioTextFahrenheit -> {
					(temperature - 32) * (5.0 / 9.0)
				}

				//Celsius
				calculatorDataSource.radioTextCelsius -> {
					temperature
				}
				// error
				else -> {
					0.0
				}
			}
		val calculatedTemperatureKelvin = calculatedTemperature + 273.15
		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(calculatedTemperatureKelvin)
	}

	@VisibleForTesting
	fun calculatePumpFlowLowMarine(): String {
		val flow = flowRateDataSourceMarine.conversionLow

		val flowRate = tankVolume * flow
		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(flowRate)
	}

	@VisibleForTesting
	fun calculatePumpFlowHighMarine(): String {
		val flow = flowRateDataSourceMarine.conversionHigh

		val flowRate = tankVolume * flow
		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(flowRate)
	}

	@VisibleForTesting
	fun calculatePumpFlowIdealMarine(): String {
		val flow =
			(flowRateDataSourceMarine.conversionLow + flowRateDataSourceMarine.conversionHigh) / 2.0

		val flowRate = tankVolume * flow
		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(flowRate)
	}

	@VisibleForTesting
	fun calculatePumpFlowLowFreshwater(): String {
		val flow = flowRateDataSourceFreshwater.conversionLow

		val flowRate = tankVolume * flow
		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(flowRate)
	}

	@VisibleForTesting
	fun calculatePumpFlowHighFreshwater(): String {
		val flow = flowRateDataSourceFreshwater.conversionHigh

		val flowRate = tankVolume * flow
		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(flowRate)
	}

	@VisibleForTesting
	fun calculatePumpFlowIdealFreshwater(): String {
		val flow =
			(flowRateDataSourceFreshwater.conversionLow + flowRateDataSourceFreshwater.conversionHigh) / 2.0

		val flowRate = tankVolume * flow
		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(flowRate)
	}
}