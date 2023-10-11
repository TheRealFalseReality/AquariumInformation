package cca.capitalcityaquatics.aquariuminfo.model.calculators

import androidx.annotation.VisibleForTesting
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow
import kotlin.math.sqrt

class SalinityMethods(
	private val tds: Double = 0.0,
	private val testWaterTemperature: Double = 25.0,
	pureWaterTemperature: Double = 25.0,
) {
	private val a =
		8.24493e-1 - 4.0899e-3 * testWaterTemperature + 7.6438e-5 * testWaterTemperature * testWaterTemperature -
				8.2467e-7 * testWaterTemperature * testWaterTemperature * testWaterTemperature + 5.3875e-9 * testWaterTemperature *
				testWaterTemperature * testWaterTemperature * testWaterTemperature
	private val b =
		-5.72466e-3 + 1.0227e-4 * testWaterTemperature - 1.6546e-6 * testWaterTemperature * testWaterTemperature
	private val c = 4.8314e-4
	private val rROo =
		999.842594 + 6.793952e-2 * testWaterTemperature - 9.095290e-3 * testWaterTemperature *
				testWaterTemperature + 1.001685e-4 * testWaterTemperature * testWaterTemperature * testWaterTemperature -
				1.120083e-6 * testWaterTemperature * testWaterTemperature * testWaterTemperature * testWaterTemperature +
				6.536332e-9 * testWaterTemperature * testWaterTemperature * testWaterTemperature * testWaterTemperature *
				testWaterTemperature
	private val rROoTD =
		999.842594 + 6.793952e-2 * pureWaterTemperature - 9.095290e-3 * pureWaterTemperature *
				pureWaterTemperature + 1.001685e-4 * pureWaterTemperature * pureWaterTemperature * pureWaterTemperature -
				1.120083e-6 * pureWaterTemperature * pureWaterTemperature * pureWaterTemperature * pureWaterTemperature +
				6.536332e-9 * pureWaterTemperature * pureWaterTemperature * pureWaterTemperature * pureWaterTemperature *
				pureWaterTemperature
	private var ro = rROo + a * tds + b * sqrt(tds.pow(3.0)) + c * tds * tds
	private var i = 0
	private var p = 0
	private var c0 = 0.6766097
	private var c1 = 0.0200564
	private var c2 = 0.0001104259
	private var c3 = -0.00000069698
	private var c4 = 0.0000000010031
	private var gt =
		c0 +
				c1 * testWaterTemperature +
				c2 * testWaterTemperature.pow(2.0) +
				c3 * testWaterTemperature.pow(3.0) +
				c4 * testWaterTemperature.pow(4.0)

	// Convert to Specific Gravity from Salinity
	@VisibleForTesting
	fun calculateSpecificGravityPPT(): String {
		val salDensityPPT = rROo + a * tds + b * sqrt(tds.pow(3)) + c * tds * tds
		val specificGravity = salDensityPPT / rROoTD
		val df = DecimalFormat("#.###")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(specificGravity)
	}

	// Convert to Salinity from Specific Gravity
	@VisibleForTesting
	fun calculateSalinitySG(): String {
		val sg = ro / rROoTD

		val ppt =
			tds * 1240.63326 + testWaterTemperature * -3.26377 + tds * testWaterTemperature * 3.20800 + tds *
					tds * 4.58072 + testWaterTemperature * testWaterTemperature * 0.00719 + -1246.10737

		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(ppt)
//		return df.format(sg)

	}

	// Convert to Density from Salinity
	@VisibleForTesting
	fun calculateDensityPPT(): String {
		val rOO =
			999.842594 + 6.793952e-2 * testWaterTemperature - 9.095290e-3 * testWaterTemperature * testWaterTemperature
		+1.001685e-4 * testWaterTemperature * testWaterTemperature * testWaterTemperature - 1.120083e-6 *
				testWaterTemperature * testWaterTemperature * testWaterTemperature * testWaterTemperature + 6.536332e-9 *
				testWaterTemperature * testWaterTemperature * testWaterTemperature * testWaterTemperature * testWaterTemperature
		val rO = rOO + a * tds + b * sqrt(tds.pow(3)) + c * tds * tds

		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(rO)
	}

	// Convert to Density from Specific Gravity
	@VisibleForTesting
	fun calculateDensitySG(): String {
		val rO1 = tds * rROoTD

		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(rO1)
	}

	// Convert to Conductivity from Salinity
	@VisibleForTesting
	fun calculateConductivityPPT(): String {
		var cond: Int
		var r: Double
		var rp: Double
		var rt: Double
		var sal: Double

		do {
			cond = i / 1000
			r = cond / 42.914
			rp =
				1 +
						(2.07e-5 * p - 6.37e-10 * p + 3.989e-15 * p) /
						(1 +
								(3.426e-2 * testWaterTemperature +
										4.464e-4 * testWaterTemperature * testWaterTemperature +
										4.215e-1 * r -
										3.107e-3 * testWaterTemperature * r))
			rt = r / (gt * rp)
			sal =
				0.008 -
						0.1692 * sqrt(rt) +
						25.3851 * rt +
						14.0941 * sqrt(rt.pow(3.0)) -
						7.0261 * rt * rt +
						2.7081 * sqrt(rt.pow(5.0)) +
						((testWaterTemperature - 15) / (1 + 0.0162 * (testWaterTemperature - 15))) *
						(0.0005 -
								0.0056 * sqrt(rt) -
								0.0066 * rt -
								0.0375 * sqrt(rt.pow(3.0)) +
								0.0636 * rt * rt -
								0.0144 * sqrt(rt.pow(5.0)))
			i++
		} while (sal <= tds)
		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(cond)
	}
}


