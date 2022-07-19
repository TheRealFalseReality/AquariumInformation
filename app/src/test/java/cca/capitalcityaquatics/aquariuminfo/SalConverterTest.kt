package cca.capitalcityaquatics.aquariuminfo

import cca.capitalcityaquatics.aquariuminfo.ui.converters.calculateDensityPPT
import cca.capitalcityaquatics.aquariuminfo.ui.converters.calculateDensitySG
import cca.capitalcityaquatics.aquariuminfo.ui.converters.calculateSalinity
import cca.capitalcityaquatics.aquariuminfo.ui.converters.calculateSpecificGravity
import junit.framework.Assert.assertEquals
import org.junit.Test

class SalConverterTest {
	@Test
	fun calculate_36_ppt() {
		val ppt = 36.0
		val tempTestWater = 25.0
		val tempPureWater = 25.0
		val expectedSG = "1.027"
		val expectedDensity = "1022.908"
		val actualSG = calculateSpecificGravity(ppt, tempPureWater, tempTestWater)
		val actualDensity = calculateDensityPPT(ppt, tempPureWater)

		assertEquals(expectedSG, actualSG)
		assertEquals(expectedDensity, actualDensity)
	}

	@Test
	fun calculate_40_ppt() {
		val ppt = 40.0
		val tempTestWater = 25.0
		val tempPureWater = 25.0
		val expectedSG = "1.03"
		val expectedDensity = "1025.936"
		val actualDensity = calculateDensityPPT(ppt, tempPureWater)
		val actualSG = calculateSpecificGravity(ppt, tempPureWater, tempTestWater)

		assertEquals(expectedSG, actualSG)
		assertEquals(expectedDensity, actualDensity)
	}

	@Test
	fun calculate_15_ppt() {
		val ppt = 15.0
		val tempTestWater = 25.0
		val tempPureWater = 25.0
		val expectedSG = "1.011"
		val expectedDensity = "1007.11"
		val actualDensity = calculateDensityPPT(ppt, tempPureWater)
		val actualSG = calculateSpecificGravity(ppt, tempPureWater, tempTestWater)

		assertEquals(expectedSG, actualSG)
		assertEquals(expectedDensity, actualDensity)
	}

	@Test
	fun calculate_10111_SG() {
		val sG = 1.0111
		val tempTestWater = 25.0
		val tempPureWater = 25.0
		val expectedPPT = "16.97"
		val expectedDensity = "1008.115"
		val actualPPT = calculateSalinity(sG, tempPureWater)
		val actualDensity = calculateDensitySG(sG, tempPureWater)

		assertEquals(expectedPPT, actualPPT)
		assertEquals(expectedDensity, actualDensity)
	}

	@Test
	fun calculate_1023_SG() {
		val sG = 1.023
		val tempTestWater = 25.0
		val tempPureWater = 25.0
		val expectedPPT = "32.798"
		val expectedDensity = "1019.98"
		val actualPPT = calculateSalinity(sG, tempPureWater)
		val actualDensity = calculateDensitySG(sG, tempPureWater)

		assertEquals(expectedPPT, actualPPT)
		assertEquals(expectedDensity, actualDensity)
	}

	@Test
	fun calculate_103_SG() {
		val sG = 1.03
		val tempTestWater = 25.0
		val tempPureWater = 25.0
		val expectedPPT = "42.11"
		val expectedDensity = "1026.959"
		val actualPPT = calculateSalinity(sG, tempPureWater)
		val actualDensity = calculateDensitySG(sG, tempPureWater)

		assertEquals(expectedPPT, actualPPT)
		assertEquals(expectedDensity, actualDensity)
	}
}