package cca.capitalcityaquatics.aquariuminfo.model.calculators

import androidx.annotation.VisibleForTesting
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow

class CalculateCarbonDioxide(
	private val ph: Double,
	private val dKH: Double
) {
	@VisibleForTesting
	fun calculateCarbonDioxide(): String {

		val phSolution = 10.0.pow(6.37 - ph)
		val carbonDioxide = (12.839 * dKH) * phSolution

		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(carbonDioxide)
	}
}