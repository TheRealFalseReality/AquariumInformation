package cca.capitalcityaquatics.aquariuminfo.calculators

import cca.capitalcityaquatics.aquariuminfo.data.tankvolumes.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.model.tankvolumes.CalculateVolumeRectangle
import junit.framework.TestCase.assertEquals
import org.junit.Test

class TankVolRecCalculatorTest {
	@Test
	fun calculate_48_24_24_in() {
		val length = 48.0
		val width = 24.0
		val height = 24.0
		val selected = calculatorDataSource.radioTextInches
		val dimensions = CalculateVolumeRectangle(selected, length, width, height)
		val expectedGAL = "119.69"
		val expectedLIT = "453.07"
		val expectedWW = "997"
		val actualGAL = dimensions.calculateVolumeRectangleGallons()
		val actualLIT = dimensions.calculateVolumeRectangleLiters()
		val actualWW = dimensions.calculateWaterWeight()

		assertEquals(expectedGAL, actualGAL)
		assertEquals(expectedLIT, actualLIT)
		assertEquals(expectedWW, actualWW)
	}

	@Test
	fun calculate_36_12_12_in() {
		val length = 36.0
		val width = 12.0
		val height = 12.0
		val selected = calculatorDataSource.radioTextInches
		val dimensions = CalculateVolumeRectangle(selected, length, width, height)
		val expectedGAL = "22.44"
		val expectedLIT = "84.95"
		val expectedWW = "186.94"
		val actualGAL = dimensions.calculateVolumeRectangleGallons()
		val actualLIT = dimensions.calculateVolumeRectangleLiters()
		val actualWW = dimensions.calculateWaterWeight()

		assertEquals(expectedGAL, actualGAL)
		assertEquals(expectedLIT, actualLIT)
		assertEquals(expectedWW, actualWW)
	}

	@Test
	fun calculate_72_2_21_in() {
		val length = 72.0
		val width = 24.0
		val height = 21.0
		val selected = calculatorDataSource.radioTextInches
		val dimensions = CalculateVolumeRectangle(selected, length, width, height)
		val expectedGAL = "157.09"
		val expectedLIT = "594.65"
		val expectedWW = "1308.57"
		val actualGAL = dimensions.calculateVolumeRectangleGallons()
		val actualLIT = dimensions.calculateVolumeRectangleLiters()
		val actualWW = dimensions.calculateWaterWeight()

		assertEquals(expectedGAL, actualGAL)
		assertEquals(expectedLIT, actualLIT)
		assertEquals(expectedWW, actualWW)
	}

	@Test
	fun calculate_4_2_2_ft() {
		val length = 4.0
		val width = 2.0
		val height = 2.0
		val selected = calculatorDataSource.radioTextFeet
		val dimensions = CalculateVolumeRectangle(selected, length, width, height)
		val expectedGAL = "119.69"
		val expectedLIT = "453.07"
		val expectedWW = "997"
		val actualGAL = dimensions.calculateVolumeRectangleGallons()
		val actualLIT = dimensions.calculateVolumeRectangleLiters()
		val actualWW = dimensions.calculateWaterWeight()

		assertEquals(expectedGAL, actualGAL)
		assertEquals(expectedLIT, actualLIT)
		assertEquals(expectedWW, actualWW)
	}

	@Test
	fun calculate_3_1_1_ft() {
		val length = 3.0
		val width = 1.0
		val height = 1.0
		val selected = calculatorDataSource.radioTextFeet
		val dimensions = CalculateVolumeRectangle(selected, length, width, height)
		val expectedGAL = "22.44"
		val expectedLIT = "84.95"
		val expectedWW = "186.94"
		val actualGAL = dimensions.calculateVolumeRectangleGallons()
		val actualLIT = dimensions.calculateVolumeRectangleLiters()
		val actualWW = dimensions.calculateWaterWeight()

		assertEquals(expectedGAL, actualGAL)
		assertEquals(expectedLIT, actualLIT)
		assertEquals(expectedWW, actualWW)
	}

	@Test
	fun calculate_3_2_2_ft() {
		val length = 3.0
		val width = 2.0
		val height = 2.0
		val selected = calculatorDataSource.radioTextFeet
		val dimensions = CalculateVolumeRectangle(selected, length, width, height)
		val expectedGAL = "89.77"
		val expectedLIT = "339.8"
		val expectedWW = "747.75"
		val actualGAL = dimensions.calculateVolumeRectangleGallons()
		val actualLIT = dimensions.calculateVolumeRectangleLiters()
		val actualWW = dimensions.calculateWaterWeight()

		assertEquals(expectedGAL, actualGAL)
		assertEquals(expectedLIT, actualLIT)
		assertEquals(expectedWW, actualWW)
	}
}