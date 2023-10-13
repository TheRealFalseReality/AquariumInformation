package cca.capitalcityaquatics.aquariuminfo.calculators

import cca.capitalcityaquatics.aquariuminfo.data.calculators.salinityDataSource
import cca.capitalcityaquatics.aquariuminfo.model.calculators.SalinityMethods
import junit.framework.TestCase.assertEquals
import org.junit.Test

class SalConverterTest {
	private val selectedSalinity = salinityDataSource.radioTextSalinity
	private val selectedSpecificGravity = salinityDataSource.radioTextSpecificGravity
	private val selectedDensity = salinityDataSource.radioTextDensity
	private val selectedConductivity = salinityDataSource.radioTextConductivity

	@Test
	fun calculate_0_ppt() {
		val selected = selectedSalinity
		val tds = 0.0

		val expectedSG = "1"
		val expectedDensity = "997.05"
		val expectedConductivity = "0.0"
		val parameters = SalinityMethods(selected = selected, tds = tds)
		val actualSG = parameters.calculateSpecificGravity()
		val actualDensity = parameters.calculateDensity()
		val actualConductivity = parameters.calculateConductivity()

		assertEquals(expectedSG, actualSG)
		assertEquals(expectedDensity, actualDensity)
		assertEquals(expectedConductivity, actualConductivity)
	}

	@Test
	fun calculate_36_ppt() {
		val selected = selectedSalinity
		val tds = 36.0

		val expectedSG = "1.027"
		val expectedDensity = "1024.1"
		val expectedConductivity = "54.41"
		val parameters = SalinityMethods(selected = selected, tds = tds)
		val actualSG = parameters.calculateSpecificGravity()
		val actualDensity = parameters.calculateDensity()
		val actualConductivity = parameters.calculateConductivity()

		assertEquals(expectedSG, actualSG)
		assertEquals(expectedDensity, actualDensity)
		assertEquals(expectedConductivity, actualConductivity)
	}

	@Test
	fun calculate_40_ppt() {
		val selected = selectedSalinity
		val tds = 40.0

		val expectedSG = "1.03"
		val expectedDensity = "1027.13"
		val expectedConductivity = "59.727"
		val parameters = SalinityMethods(selected = selected, tds = tds)
		val actualSG = parameters.calculateSpecificGravity()
		val actualDensity = parameters.calculateDensity()
		val actualConductivity = parameters.calculateConductivity()

		assertEquals(expectedSG, actualSG)
		assertEquals(expectedDensity, actualDensity)
		assertEquals(expectedConductivity, actualConductivity)
	}

	@Test
	fun calculate_15_ppt() {
		val selected = selectedSalinity
		val tds = 15.0
		
		val expectedSG = "1.011"
		val expectedDensity = "1008.3"
		val expectedConductivity = "24.693"
		val parameters = SalinityMethods(selected = selected, tds = tds)
		val actualSG = parameters.calculateSpecificGravity()
		val actualDensity = parameters.calculateDensity()
		val actualConductivity = parameters.calculateConductivity()

		assertEquals(expectedSG, actualSG)
		assertEquals(expectedDensity, actualDensity)
		assertEquals(expectedConductivity, actualConductivity)
	}

	@Test
	fun calculate_1011_SG() {
		val selected = selectedSpecificGravity
		val tds = 1.011

		val expectedPPT = "14.619"
		val expectedDensity = "1008.02"
		val expectedConductivity = "24.1"
		val parameters = SalinityMethods(selected = selected, tds = tds)
		val actualPPT = parameters.calculateSalinity()
		val actualDensity = parameters.calculateDensity()
		val actualConductivity = parameters.calculateConductivity()

		assertEquals(expectedPPT, actualPPT)
		assertEquals(expectedDensity, actualDensity)
		assertEquals(expectedConductivity, actualConductivity)
	}

	@Test
	fun calculate_1023_SG() {
		val selected = selectedSpecificGravity
		val tds = 1.023

		val expectedPPT = "30.545"
		val expectedDensity = "1019.98"
		val expectedConductivity = "47"
		val parameters = SalinityMethods(selected = selected, tds = tds)
		val actualPPT = parameters.calculateSalinity()
		val actualDensity = parameters.calculateDensity()
		val actualConductivity = parameters.calculateConductivity()

		assertEquals(expectedPPT, actualPPT)
		assertEquals(expectedDensity, actualDensity)
		assertEquals(expectedConductivity, actualConductivity)
	}

	@Test
	fun calculate_103_SG() {
		val selected = selectedSpecificGravity
		val tds = 1.03

		val expectedPPT = "39.779"
		val expectedDensity = "1026.96"
		val expectedConductivity = "59.4"
		val parameters = SalinityMethods(selected = selected, tds = tds)
		val actualPPT = parameters.calculateSalinity()
		val actualDensity = parameters.calculateDensity()
		val actualConductivity = parameters.calculateConductivity()

		assertEquals(expectedPPT, actualPPT)
		assertEquals(expectedDensity, actualDensity)
		assertEquals(expectedConductivity, actualConductivity)
	}
}