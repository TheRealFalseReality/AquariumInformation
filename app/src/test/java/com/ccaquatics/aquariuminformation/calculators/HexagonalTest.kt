package com.ccaquatics.aquariuminformation.calculators

import com.ccaquatics.aquariuminformation.ui.pages.calculators.calculateVolGallonFTHex
import com.ccaquatics.aquariuminformation.ui.pages.calculators.calculateVolGallonHex
import com.ccaquatics.aquariuminformation.ui.pages.calculators.calculateVolLiterFTHex
import com.ccaquatics.aquariuminformation.ui.pages.calculators.calculateVolLiterHex
import com.ccaquatics.aquariuminformation.ui.pages.calculators.calculateWaterWeightFTHex
import com.ccaquatics.aquariuminformation.ui.pages.calculators.calculateWaterWeightHex
import junit.framework.TestCase.assertEquals
import org.junit.Test

class TankVolHexCalculatorTest {
	@Test
	fun calculate_12_24_in() {
		val l = 12.0
		val h = 24.0
		val expectedGAL = "38.87"
		val expectedLIT = "147.14"
		val expectedWW = "323.79"
		val actualGAL = calculateVolGallonHex(l, h)
		val actualLIT = calculateVolLiterHex(l, h)
		val actualWW = calculateWaterWeightHex(l, h)

		assertEquals(expectedGAL, actualGAL)
		assertEquals(expectedLIT, actualLIT)
		assertEquals(expectedWW, actualWW)
	}

	@Test
	fun calculate_36_12_in() {
		val l = 36.0
		val h = 12.0
		val expectedGAL = "174.91"
		val expectedLIT = "662.12"
		val expectedWW = "1457.04"
		val actualGAL = calculateVolGallonHex(l, h)
		val actualLIT = calculateVolLiterHex(l, h)
		val actualWW = calculateWaterWeightHex(l, h)

		assertEquals(expectedGAL, actualGAL)
		assertEquals(expectedLIT, actualLIT)
		assertEquals(expectedWW, actualWW)
	}

	@Test
	fun calculate_72_21_in() {
		val l = 72.0
		val h = 12.0
		val expectedGAL = "699.66"
		val expectedLIT = "2648.5"
		val expectedWW = "5828.16"
		val actualGAL = calculateVolGallonHex(l, h)
		val actualLIT = calculateVolLiterHex(l, h)
		val actualWW = calculateWaterWeightHex(l, h)

		assertEquals(expectedGAL, actualGAL)
		assertEquals(expectedLIT, actualLIT)
		assertEquals(expectedWW, actualWW)
	}

	@Test
	fun calculate_1_2_ft() {
		val l = 1.0
		val h = 2.0
		val expectedGAL = "38.87"
		val expectedLIT = "147.14"
		val expectedWW = "323.79"
		val actualGAL = calculateVolGallonFTHex(l, h)
		val actualLIT = calculateVolLiterFTHex(l, h)
		val actualWW = calculateWaterWeightFTHex(l, h)

		assertEquals(expectedGAL, actualGAL)
		assertEquals(expectedLIT, actualLIT)
		assertEquals(expectedWW, actualWW)
	}

	@Test
	fun calculate_3_1_ft() {
		val l = 3.0
		val h = 1.0
		val expectedGAL = "174.91"
		val expectedLIT = "662.12"
		val expectedWW = "1457.03"
		val actualGAL = calculateVolGallonFTHex(l, h)
		val actualLIT = calculateVolLiterFTHex(l, h)
		val actualWW = calculateWaterWeightFTHex(l, h)

		assertEquals(expectedGAL, actualGAL)
		assertEquals(expectedLIT, actualLIT)
		assertEquals(expectedWW, actualWW)
	}

	@Test
	fun calculate_5_2_ft() {
		val l = 5.0
		val h = 2.0
		val expectedGAL = "971.74"
		val expectedLIT = "3678.46"
		val expectedWW = "8094.63"
		val actualGAL = calculateVolGallonFTHex(l, h)
		val actualLIT = calculateVolLiterFTHex(l, h)
		val actualWW = calculateWaterWeightFTHex(l, h)

		assertEquals(expectedGAL, actualGAL)
		assertEquals(expectedLIT, actualLIT)
		assertEquals(expectedWW, actualWW)
	}
}