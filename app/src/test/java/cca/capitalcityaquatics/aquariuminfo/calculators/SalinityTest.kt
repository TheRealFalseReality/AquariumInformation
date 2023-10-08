package cca.capitalcityaquatics.aquariuminfo.calculators

import cca.capitalcityaquatics.aquariuminfo.data.calculators.salinityDataSource
import cca.capitalcityaquatics.aquariuminfo.model.calculators.SalinityMethods
import junit.framework.TestCase.assertEquals
import org.junit.Test

class SalConverterTest {
	private val selectedSalinity = salinityDataSource.radioTextPpt
	private val selectedSpecificGravity = salinityDataSource.radioTextSg
	@Test
	fun calculate_36_ppt() {
		val selected = selectedSalinity
		val tds = 36.0

		val expectedSG = "1.027"
		val expectedDensity = "1022.908"
		val parameters = SalinityMethods(selected = selected, tds = tds)
		val actualSG = parameters.calculateSpecificGravity()
		val actualDensity = parameters.calculateDensityPPT()

		assertEquals(expectedSG, actualSG)
		assertEquals(expectedDensity, actualDensity)
	}

	@Test
	fun calculate_40_ppt() {
		val selected = selectedSalinity
		val tds = 40.0

		val expectedSG = "1.03"
		val expectedDensity = "1025.936"
		val parameters = SalinityMethods(selected = selected, tds = tds)
		val actualSG = parameters.calculateSpecificGravity()
		val actualDensity = parameters.calculateDensityPPT()

		assertEquals(expectedSG, actualSG)
		assertEquals(expectedDensity, actualDensity)
	}

	@Test
	fun calculate_15_ppt() {
		val selected = selectedSalinity
		val tds = 15.0
		
		val expectedSG = "1.011"
		val expectedDensity = "1007.11"
		val parameters = SalinityMethods(selected = selected, tds = tds)
		val actualSG = parameters.calculateSpecificGravity()
		val actualDensity = parameters.calculateDensityPPT()

		assertEquals(expectedSG, actualSG)
		assertEquals(expectedDensity, actualDensity)
	}

	@Test
	fun calculate_10111_SG() {
		val selected = selectedSpecificGravity
		val tds = 1.0111

		val expectedPPT = "16.97"
		val expectedDensity = "1008.115"
		val parameters = SalinityMethods(selected = selected, tds = tds)
		val actualPPT = parameters.calculateSalinity()
		val actualDensity = parameters.calculateDensitySG()

		assertEquals(expectedPPT, actualPPT)
		assertEquals(expectedDensity, actualDensity)
	}

	@Test
	fun calculate_1023_SG() {
		val selected = selectedSpecificGravity
		val tds = 1.023

		val expectedPPT = "32.798"
		val expectedDensity = "1019.98"
		val parameters = SalinityMethods(selected = selected, tds = tds)
		val actualPPT = parameters.calculateSalinity()
		val actualDensity = parameters.calculateDensitySG()

		assertEquals(expectedPPT, actualPPT)
		assertEquals(expectedDensity, actualDensity)
	}

	@Test
	fun calculate_103_SG() {
		val selected = selectedSpecificGravity
		val tds = 1.03

		val expectedPPT = "42.11"
		val expectedDensity = "1026.959"
		val parameters = SalinityMethods(selected = selected, tds = tds)
		val actualPPT = parameters.calculateSalinity()
		val actualDensity = parameters.calculateDensitySG()

		assertEquals(expectedPPT, actualPPT)
		assertEquals(expectedDensity, actualDensity)
	}
}