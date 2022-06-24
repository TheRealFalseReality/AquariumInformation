package cca.capitalcityaquatics.aquariuminfo

import cca.capitalcityaquatics.aquariuminfo.calculators.calculateCarbonDioxide
import junit.framework.Assert.assertEquals
import org.junit.Test

class CO2ConverterTest{
    @Test
    fun calculate_9_dkh_83_ph () {
        val pH = 8.3
        val dKH = 9.0
        val expectedCO2 = 1.36
        val actualCO2 = calculateCarbonDioxide(dKH = dKH, pH = pH)

        assertEquals(expectedCO2,actualCO2)
    }
    @Test
    fun calculate_12_dkh_83_ph () {
        val pH = 8.3
        val dKH = 12.0
        val expectedCO2 = 1.81
        val actualCO2 = calculateCarbonDioxide(dKH = dKH, pH = pH)

        assertEquals(expectedCO2,actualCO2)
    }
    @Test
    fun calculate_9_dkh_7_ph () {
        val pH = 7.0
        val dKH = 9.0
        val expectedCO2 = 27.09
        val actualCO2 = calculateCarbonDioxide(dKH = dKH, pH = pH)

        assertEquals(expectedCO2,actualCO2)
    }
    @Test
    fun calculate_12_dkh_7_ph () {
        val pH = 7.0
        val dKH = 12.0
        val expectedCO2 = 36.12
        val actualCO2 = calculateCarbonDioxide(dKH = dKH, pH = pH)

        assertEquals(expectedCO2,actualCO2)
    }
    @Test
    fun calculate_8_dkh_9_ph () {
        val pH = 9.0
        val dKH = 8.0
        val expectedCO2 = 0.24
        val actualCO2 = calculateCarbonDioxide(dKH = dKH, pH = pH)

        assertEquals(expectedCO2,actualCO2)
    }
}