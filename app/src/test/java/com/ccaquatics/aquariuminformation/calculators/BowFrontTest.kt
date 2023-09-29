package com.ccaquatics.aquariuminformation.calculators

import com.ccaquatics.aquariuminformation.ui.pages.tankvolumes.calculateVolGallonBF
import com.ccaquatics.aquariuminformation.ui.pages.tankvolumes.calculateVolGallonFTBF
import com.ccaquatics.aquariuminformation.ui.pages.tankvolumes.calculateVolLiterBF
import com.ccaquatics.aquariuminformation.ui.pages.tankvolumes.calculateVolLiterFTBF
import com.ccaquatics.aquariuminformation.ui.pages.tankvolumes.calculateWaterWeightBF
import com.ccaquatics.aquariuminformation.ui.pages.tankvolumes.calculateWaterWeightFTBF
import junit.framework.TestCase.assertEquals
import org.junit.Test

class TankVolBFrontCalculatorTest {
	@Test
	fun calculate_36_12_21_17_in() {
		val l = 36.0
		val w = 12.0
		val h = 21.0
		val fw = 17.0
		val expectedGAL = "52.12"
		val expectedLIT = "197.31"
		val expectedWW = "434.2"
		val actualGAL = calculateVolGallonBF(l, w, h, fw)
		val actualLIT = calculateVolLiterBF(l, w, h, fw)
		val actualWW = calculateWaterWeightBF(l, w, h, fw)

		assertEquals(expectedGAL, actualGAL)
		assertEquals(expectedLIT, actualLIT)
		assertEquals(expectedWW, actualWW)
	}

	@Test
	fun calculate_36_12_12_in() {
		val l = 36.0
		val w = 12.0
		val h = 12.0
		val fw = 17.0
		val expectedGAL = "29.79"
		val expectedLIT = "112.75"
		val expectedWW = "248.11"
		val actualGAL = calculateVolGallonBF(l, w, h, fw)
		val actualLIT = calculateVolLiterBF(l, w, h, fw)
		val actualWW = calculateWaterWeightBF(l, w, h, fw)

		assertEquals(expectedGAL, actualGAL)
		assertEquals(expectedLIT, actualLIT)
		assertEquals(expectedWW, actualWW)
	}

	@Test
	fun calculate_72_2_21_32_in() {
		val l = 72.0
		val w = 24.0
		val h = 21.0
		val fw = 32.0
		val expectedGAL = "198.22"
		val expectedLIT = "750.33"
		val expectedWW = "1651.15"
		val actualGAL = calculateVolGallonBF(l, w, h, fw)
		val actualLIT = calculateVolLiterBF(l, w, h, fw)
		val actualWW = calculateWaterWeightBF(l, w, h, fw)

		assertEquals(expectedGAL, actualGAL)
		assertEquals(expectedLIT, actualLIT)
		assertEquals(expectedWW, actualWW)
	}

	@Test
	fun calculate_4_2_2_45_ft() {
		val l = 4.0
		val w = 2.0
		val h = 2.0
		val fw = 4.5
		val expectedGAL = "237.19"
		val expectedLIT = "897.87"
		val expectedWW = "1975.8"
		val actualGAL = calculateVolGallonFTBF(l, w, h, fw)
		val actualLIT = calculateVolLiterFTBF(l, w, h, fw)
		val actualWW = calculateWaterWeightFTBF(l, w, h, fw)

		assertEquals(expectedGAL, actualGAL)
		assertEquals(expectedLIT, actualLIT)
		assertEquals(expectedWW, actualWW)
	}

	@Test
	fun calculate_3_1_1_ft() {
		val l = 3.0
		val w = 1.0
		val h = 1.0
		val fw = 1.5
		val expectedGAL = "31.25"
		val expectedLIT = "118.31"
		val expectedWW = "260.35"
		val actualGAL = calculateVolGallonFTBF(l, w, h, fw)
		val actualLIT = calculateVolLiterFTBF(l, w, h, fw)
		val actualWW = calculateWaterWeightFTBF(l, w, h, fw)

		assertEquals(expectedGAL, actualGAL)
		assertEquals(expectedLIT, actualLIT)
		assertEquals(expectedWW, actualWW)
	}

	@Test
	fun calculate_3_2_2_ft() {
		val l = 1.0
		val w = 2.0
		val h = 3.0
		val fw = 2.5
		val expectedGAL = "53.7"
		val expectedLIT = "203.26"
		val expectedWW = "447.29"
		val actualGAL = calculateVolGallonFTBF(l, w, h, fw)
		val actualLIT = calculateVolLiterFTBF(l, w, h, fw)
		val actualWW = calculateWaterWeightFTBF(l, w, h, fw)

		assertEquals(expectedGAL, actualGAL)
		assertEquals(expectedLIT, actualLIT)
		assertEquals(expectedWW, actualWW)
	}
}