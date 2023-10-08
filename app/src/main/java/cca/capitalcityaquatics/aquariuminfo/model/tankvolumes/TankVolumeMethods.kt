package cca.capitalcityaquatics.aquariuminfo.model.tankvolumes

import androidx.annotation.VisibleForTesting
import cca.capitalcityaquatics.aquariuminfo.data.tankvolumes.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.navigation.BowFront
import cca.capitalcityaquatics.aquariuminfo.navigation.Cube
import cca.capitalcityaquatics.aquariuminfo.navigation.Cylinder
import cca.capitalcityaquatics.aquariuminfo.navigation.Hexagonal
import com.google.android.gms.common.util.Hex
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.PI
import kotlin.math.pow

class TankVolumeMethods(
	private val selected: Int,
	selectedCylinder: Int? = null,
	view: Int,
	length: Double = 0.0,
	width: Double = 0.0,
	height: Double = 0.0,
	diameter: Double = 0.0,
	edge: Double = 0.0,
	fullWidth: Double = 0.0,
) {
	private val radius = diameter / 2.0

	private var volume =
		when (view) {
			// Cube
			Cube.title -> {
				length.pow(3)
			}

			// Cylinder
			Cylinder.title -> {
				when (selectedCylinder) {
					// Half
					calculatorDataSource.radioHalfCylinder -> {
						(PI * radius.pow(2) * height) / 2
					}

					// Corner
					calculatorDataSource.radioCornerCylinder -> {
						(PI * radius.pow(2) * height) / 4
					}

					// Full
					else -> {
						PI * radius.pow(2) * height
					}
				}
			}

			// Hexagonal
			Hexagonal.title -> {
				(((3 * kotlin.math.sqrt(3.0)) / 2) * edge * edge * height)
			}

			// Bow-Front
			BowFront.title -> {
				((length * width + (PI * (length / 2) * (fullWidth - width)) / 2) * height)
			}

			// Rectangle
			else -> {
				length * width * height
			}
		}

	//Gallons
	@VisibleForTesting
	fun calculateVolumeGallons(): String {
		val conversionFactor =
			when (selected) {
				// Inches
				calculatorDataSource.radioTextInches -> {
					calculatorDataSource.conversionGallonsInches
				}

				// Feet
				else -> {
					calculatorDataSource.conversionGallonsFeet
				}
			}
		val volGallons = volume * conversionFactor
		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(volGallons)
	}

	//Liters
	@VisibleForTesting
	fun calculateVolumeLiters(): String {
		val conversionFactor =
			when (selected) {
				// Inches
				calculatorDataSource.radioTextInches -> {
					calculatorDataSource.conversionLitersInches
				}

				// Feet
				else -> {
					calculatorDataSource.conversionLitersFeet
				}
			}
		val volLiters = volume * conversionFactor
		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(volLiters)
	}

	// Water Weight
	@VisibleForTesting
	fun calculateWaterWeightPounds(): String {
		val conversionFactor = calculatorDataSource.conversionPoundsGallons
		val conversionFactorVolume =
			when (selected) {
				// Inches
				calculatorDataSource.radioTextInches -> {
					calculatorDataSource.conversionGallonsInches
				}

				// Feet
				else -> {
					calculatorDataSource.conversionGallonsFeet
				}
			}
		val waterWeight = (volume * conversionFactorVolume) * conversionFactor
		val df = DecimalFormat("#.##")
		df.roundingMode = RoundingMode.HALF_UP

		return df.format(waterWeight)
	}
}