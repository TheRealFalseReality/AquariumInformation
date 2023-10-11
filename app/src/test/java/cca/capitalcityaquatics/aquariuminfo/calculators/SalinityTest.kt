package cca.capitalcityaquatics.aquariuminfo.calculators

import cca.capitalcityaquatics.aquariuminfo.model.calculators.SalinityMethods
import junit.framework.TestCase.assertEquals
import org.junit.Test

class SalConverterTest {
	@Test
	fun calculate_36_ppt() {
		val tds = 36.0

		val expectedSG = "1.027"
		val expectedDensity = "1022.91"
		val expectedConductivity = "55"
		val parameters = SalinityMethods(tds = tds)
		val actualSG = parameters.calculateSpecificGravityPPT()
		val actualDensity = parameters.calculateDensityPPT()
		val actualConductivity = parameters.calculateConductivityPPT()

		assertEquals(expectedSG, actualSG)
		assertEquals(expectedDensity, actualDensity)
		assertEquals(expectedConductivity, actualConductivity)
	}

	@Test
	fun calculate_40_ppt() {
		val tds = 40.0

		val expectedSG = "1.03"
		val expectedDensity = "1025.94"
		val expectedConductivity = "60"
		val parameters = SalinityMethods(tds = tds)
		val actualSG = parameters.calculateSpecificGravityPPT()
		val actualDensity = parameters.calculateDensityPPT()
		val actualConductivity = parameters.calculateConductivityPPT()

		assertEquals(expectedSG, actualSG)
		assertEquals(expectedDensity, actualDensity)
		assertEquals(expectedConductivity, actualConductivity)
	}

	@Test
	fun calculate_15_ppt() {
		val tds = 15.0
		
		val expectedSG = "1.011"
		val expectedDensity = "1007.11"
		val expectedConductivity = "25"
		val parameters = SalinityMethods(tds = tds)
		val actualSG = parameters.calculateSpecificGravityPPT()
		val actualDensity = parameters.calculateDensityPPT()
		val actualConductivity = parameters.calculateConductivityPPT()

		assertEquals(expectedSG, actualSG)
		assertEquals(expectedDensity, actualDensity)
		assertEquals(expectedConductivity, actualConductivity)
	}

	@Test
	fun calculate_10111_SG() {
		val tds = 1.0111

		val expectedPPT = "16.97"
		val expectedDensity = "1008.12"
		val parameters = SalinityMethods(tds = tds)
		val actualPPT = parameters.calculateSalinitySG()
		val actualDensity = parameters.calculateDensitySG()

		assertEquals(expectedPPT, actualPPT)
		assertEquals(expectedDensity, actualDensity)
	}

	@Test
	fun calculate_1023_SG() {
		val tds = 1.023

		val expectedPPT = "32.8"
		val expectedDensity = "1019.98"
		val parameters = SalinityMethods(tds = tds)
		val actualPPT = parameters.calculateSalinitySG()
		val actualDensity = parameters.calculateDensitySG()

		assertEquals(expectedPPT, actualPPT)
		assertEquals(expectedDensity, actualDensity)
	}

	@Test
	fun calculate_103_SG() {
		val tds = 1.03

		val expectedPPT = "42.11"
		val expectedDensity = "1026.96"
		val parameters = SalinityMethods(tds = tds)
		val actualPPT = parameters.calculateSalinitySG()
		val actualDensity = parameters.calculateDensitySG()

		assertEquals(expectedPPT, actualPPT)
		assertEquals(expectedDensity, actualDensity)
	}
}