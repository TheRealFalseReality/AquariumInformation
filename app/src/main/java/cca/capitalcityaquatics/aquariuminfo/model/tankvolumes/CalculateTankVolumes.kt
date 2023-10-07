package cca.capitalcityaquatics.aquariuminfo.model.tankvolumes

import androidx.annotation.VisibleForTesting
import cca.capitalcityaquatics.aquariuminfo.data.tankvolumes.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.navigation.Cube
import java.math.RoundingMode
import java.text.DecimalFormat

class CalculateTankVolumes(
	private val selected: Int,
	shape: Int,
	length: Double,
	width: Double,
	height: Double,
) {
	private var volume =
		when (shape) {
			// Cube
			Cube.title -> {
				length * length * length
			}

			// Rectangle
			else -> {
				length * width * height
			}
		}

	@VisibleForTesting
	fun calculateVolumeGallons(): String {
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
	fun calculateVolumeLiters(): String {
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
	fun calculateWaterWeightPounds(): String {
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
		val waterWeight = (volume / conversionFactorVolume) * conversionFactor
		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(waterWeight)
	}
}