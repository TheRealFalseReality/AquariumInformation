package cca.capitalcityaquatics.aquariuminfo.model.tankvolumes

import androidx.annotation.VisibleForTesting
import cca.capitalcityaquatics.aquariuminfo.data.tankvolumes.calculatorDataSource
import java.math.RoundingMode
import java.text.DecimalFormat

class CalculateVolumeRectangle(
	private val selected: Int,
	length: Double,
	width: Double,
	height: Double,
) {
	private var volume = length * width * height

	@VisibleForTesting
	fun calculateVolumeRectangleGallons(): String {
		val conversionFactor =
			when (selected) {
				calculatorDataSource.radioTextInches -> {
					calculatorDataSource.conversionGallonsInches
				}

				else -> {
					calculatorDataSource.conversionGallonsFeet
				}
			}
		val volGallons = volume / conversionFactor
		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(volGallons)
	}

	@VisibleForTesting
	fun calculateVolumeRectangleLiters(): String {
		val conversionFactor =
			when (selected) {
				calculatorDataSource.radioTextInches -> {
					calculatorDataSource.conversionLitersInches
				}

				else -> {
					calculatorDataSource.conversionLitersFeet
				}
			}
		val volLiters = volume / conversionFactor
		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(volLiters)
	}

	@VisibleForTesting
	fun calculateWaterWeight(): String {
		val conversionFactor = calculatorDataSource.conversionPoundsGallons
		val conversionFactorVolume =
			when (selected) {
				calculatorDataSource.radioTextInches -> {
					calculatorDataSource.conversionGallonsInches
				}

				else -> {
					calculatorDataSource.conversionGallonsFeet
				}
			}
		val waterWeight = (volume / conversionFactorVolume)* conversionFactor
		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(waterWeight)
	}
}