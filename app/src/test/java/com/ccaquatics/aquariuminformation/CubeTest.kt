package com.ccaquatics.aquariuminformation

import com.ccaquatics.aquariuminformation.ui.pages.calculators.calculateVolGallonCube
import com.ccaquatics.aquariuminformation.ui.pages.calculators.calculateVolGallonFTCube
import com.ccaquatics.aquariuminformation.ui.pages.calculators.calculateVolLiterCube
import com.ccaquatics.aquariuminformation.ui.pages.calculators.calculateVolLiterFTCube
import com.ccaquatics.aquariuminformation.ui.pages.calculators.calculateWaterWeightCube
import com.ccaquatics.aquariuminformation.ui.pages.calculators.calculateWaterWeightFTCube
import junit.framework.TestCase.assertEquals
import org.junit.Test

class TankVolCubeCalculatorTest {
	@Test
	fun calculate_48_in() {
		val l = 48.0

		val expectedGAL = "478.75"
		val expectedLIT = "1812.28"
		val expectedWW = "3988.01"
		val actualGAL = calculateVolGallonCube(l)
		val actualLIT = calculateVolLiterCube(l)
		val actualWW = calculateWaterWeightCube(l)

		assertEquals(expectedGAL, actualGAL)
		assertEquals(expectedLIT, actualLIT)
		assertEquals(expectedWW, actualWW)
	}

	@Test
	fun calculate_36_in() {
		val l = 36.0

		val expectedGAL = "201.97"
		val expectedLIT = "764.56"
		val expectedWW = "1682.44"
		val actualGAL = calculateVolGallonCube(l)
		val actualLIT = calculateVolLiterCube(l)
		val actualWW = calculateWaterWeightCube(l)

		assertEquals(expectedGAL, actualGAL)
		assertEquals(expectedLIT, actualLIT)
		assertEquals(expectedWW, actualWW)
	}

	@Test
	fun calculate_72_in() {
		val l = 72.0

		val expectedGAL = "1615.79"
		val expectedLIT = "6116.44"
		val expectedWW = "13459.55"
		val actualGAL = calculateVolGallonCube(l)
		val actualLIT = calculateVolLiterCube(l)
		val actualWW = calculateWaterWeightCube(l)

		assertEquals(expectedGAL, actualGAL)
		assertEquals(expectedLIT, actualLIT)
		assertEquals(expectedWW, actualWW)
	}

	@Test
	fun calculate_4_ft() {
		val l = 4.0

		val expectedGAL = "478.75"
		val expectedLIT = "1812.28"
		val expectedWW = "3988"
		val actualGAL = calculateVolGallonFTCube(l)
		val actualLIT = calculateVolLiterFTCube(l)
		val actualWW = calculateWaterWeightFTCube(l)

		assertEquals(expectedGAL, actualGAL)
		assertEquals(expectedLIT, actualLIT)
		assertEquals(expectedWW, actualWW)
	}

	@Test
	fun calculate_3_ft() {
		val l = 3.0

		val expectedGAL = "201.97"
		val expectedLIT = "764.55"
		val expectedWW = "1682.44"
		val actualGAL = calculateVolGallonFTCube(l)
		val actualLIT = calculateVolLiterFTCube(l)
		val actualWW = calculateWaterWeightFTCube(l)

		assertEquals(expectedGAL, actualGAL)
		assertEquals(expectedLIT, actualLIT)
		assertEquals(expectedWW, actualWW)
	}

	@Test
	fun calculate_9_in() {
		val l = 9.0

		val expectedGAL = "5453.28"
		val expectedLIT = "20642.96"
		val expectedWW = "45425.83"
		val actualGAL = calculateVolGallonFTCube(l)
		val actualLIT = calculateVolLiterFTCube(l)
		val actualWW = calculateWaterWeightFTCube(l)

		assertEquals(expectedGAL, actualGAL)
		assertEquals(expectedLIT, actualLIT)
		assertEquals(expectedWW, actualWW)
	}
}