package cca.capitalcityaquatics.aquariuminfo.model.calculators

import androidx.annotation.VisibleForTesting
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow

class SalinityMethods(
	private val selected: Int? = null,
	private val tds: Double = 0.0,
	private val testWaterTemperature: Double = 25.0,
	private val pureWaterTemperature: Double = 25.0,
) {
	// Convert to Specific Gravity
	@VisibleForTesting
	fun calculateSpecificGravity(): String {
		val aA =
			8.24493e-1 - 4.0899e-3 * testWaterTemperature + 7.6438e-5 * testWaterTemperature * testWaterTemperature -
					8.2467e-7 * testWaterTemperature * testWaterTemperature * testWaterTemperature + 5.3875e-9 * testWaterTemperature *
					testWaterTemperature * testWaterTemperature * testWaterTemperature
		val bB =
			-5.72466e-3 + 1.0227e-4 * testWaterTemperature - 1.6546e-6 * testWaterTemperature * testWaterTemperature
		val cC = 4.8314e-4
		val rROo =
			999.842594 + 6.793952e-2 * testWaterTemperature - 9.095290e-3 * testWaterTemperature *
					testWaterTemperature + 1.001685e-4 * testWaterTemperature * testWaterTemperature * testWaterTemperature -
					1.120083e-6 * testWaterTemperature * testWaterTemperature * testWaterTemperature * testWaterTemperature +
					6.536332e-9 * testWaterTemperature * testWaterTemperature * testWaterTemperature * testWaterTemperature *
					testWaterTemperature
		val rROoTD =
			999.842594 + 6.793952e-2 * pureWaterTemperature - 9.095290e-3 * pureWaterTemperature *
					pureWaterTemperature + 1.001685e-4 * pureWaterTemperature * pureWaterTemperature * pureWaterTemperature -
					1.120083e-6 * pureWaterTemperature * pureWaterTemperature * pureWaterTemperature * pureWaterTemperature +
					6.536332e-9 * pureWaterTemperature * pureWaterTemperature * pureWaterTemperature * pureWaterTemperature *
					pureWaterTemperature
		val salDensityPPT = rROo + aA * tds + bB * kotlin.math.sqrt(tds.pow(3)) + cC * tds * tds

		val specificGravity = salDensityPPT / rROoTD

		val df = DecimalFormat("#.###")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(specificGravity)
	}

	// Convert to Salinity
	@VisibleForTesting
	fun calculateSalinity(): String {
		val ppt =
			tds * 1240.63326 + testWaterTemperature * -3.26377 + tds * testWaterTemperature * 3.20800 + tds *
					tds * 4.58072 + testWaterTemperature * testWaterTemperature * 0.00719 + -1246.10737

		val df = DecimalFormat("#.###")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(ppt)
	}

	// Convert to Density from Salinity
	@VisibleForTesting
	fun calculateDensityPPT(): String {
		val aB =
			8.24493e-1 - 4.0899e-3 * testWaterTemperature + 7.6438e-5 * testWaterTemperature * testWaterTemperature -
					8.2467e-7 * testWaterTemperature * testWaterTemperature * testWaterTemperature + 5.3875e-9 * testWaterTemperature *
					testWaterTemperature * testWaterTemperature * testWaterTemperature
		val bC =
			-5.72466e-3 + 1.0227e-4 * testWaterTemperature - 1.6546e-6 * testWaterTemperature * testWaterTemperature
		val cD = 4.8314e-4
		val rOO =
			999.842594 + 6.793952e-2 * testWaterTemperature - 9.095290e-3 * testWaterTemperature * testWaterTemperature
		+1.001685e-4 * testWaterTemperature * testWaterTemperature * testWaterTemperature - 1.120083e-6 *
				testWaterTemperature * testWaterTemperature * testWaterTemperature * testWaterTemperature + 6.536332e-9 *
				testWaterTemperature * testWaterTemperature * testWaterTemperature * testWaterTemperature * testWaterTemperature
		val rO = rOO + aB * tds + bC * kotlin.math.sqrt(tds.pow(3)) + cD * tds * tds

		val df = DecimalFormat("#.###")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(rO)
	}

	// Convert to Density from Specific Gravity
	@VisibleForTesting
	fun calculateDensitySG(): String {
		val rOoTDc =
			999.842594 + 6.793952e-2 * pureWaterTemperature - 9.095290e-3 * pureWaterTemperature *
					pureWaterTemperature + 1.001685e-4 * pureWaterTemperature * pureWaterTemperature * pureWaterTemperature -
					1.120083e-6 * pureWaterTemperature * pureWaterTemperature * pureWaterTemperature * pureWaterTemperature +
					6.536332e-9 * pureWaterTemperature * pureWaterTemperature * pureWaterTemperature * pureWaterTemperature *
					pureWaterTemperature
		val rO1 = tds * rOoTDc

		val df = DecimalFormat("#.###")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(rO1)
	}
}


