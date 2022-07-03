package cca.capitalcityaquatics.aquariuminfo

import cca.capitalcityaquatics.aquariuminfo.ui.converters.*
import junit.framework.Assert.assertEquals
import org.junit.Test

class AlkCalculatorTest{
    @Test
    fun calculate_14_dkh (){
        val alk = 14.0
        val expectedPPM = "250"
        val expectedMEQ = "5"
        val actualPPM = calculatePpmDkh(alk = alk)
        val actualMEQ = calculateMeqDkh(alk = alk)

        assertEquals(expectedPPM, actualPPM)
        assertEquals(expectedMEQ, actualMEQ)
    }
    @Test
    fun calculate_5_dkh (){
        val alk = 5.0
        val expectedPPM = "89"
        val expectedMEQ = "1.8"
        val actualPPM = calculatePpmDkh(alk = alk)
        val actualMEQ = calculateMeqDkh(alk = alk)

        assertEquals(expectedPPM, actualPPM)
        assertEquals(expectedMEQ, actualMEQ)
    }
    @Test
    fun calculate_20_dkh (){
        val alk = 20.0
        val expectedPPM = "357"
        val expectedMEQ = "7.1"
        val actualPPM = calculatePpmDkh(alk = alk)
        val actualMEQ = calculateMeqDkh(alk = alk)

        assertEquals(expectedPPM, actualPPM)
        assertEquals(expectedMEQ, actualMEQ)
    }
    @Test
    fun calculate_250_ppm (){
        val alk = 250.0
        val expectedDKH = "14"
        val expectedMEQ = "5"
        val actualDKH = calculateDkhPpm(alk = alk)
        val actualMEQ = calculateMeqPpm(alk = alk)

        assertEquals(expectedDKH, actualDKH)
        assertEquals(expectedMEQ, actualMEQ)
    }
    @Test
    fun calculate_100_ppm (){
        val alk = 100.0
        val expectedDKH = "5.6"
        val expectedMEQ = "2"
        val actualDKH = calculateDkhPpm(alk = alk)
        val actualMEQ = calculateMeqPpm(alk = alk)

        assertEquals(expectedDKH, actualDKH)
        assertEquals(expectedMEQ, actualMEQ)
    }
    @Test
    fun calculate_500_ppm (){
        val alk = 500.0
        val expectedDKH = "28"
        val expectedMEQ = "10"
        val actualDKH = calculateDkhPpm(alk = alk)
        val actualMEQ = calculateMeqPpm(alk = alk)

        assertEquals(expectedDKH, actualDKH)
        assertEquals(expectedMEQ, actualMEQ)
    }
    @Test
    fun calculate_60_meq (){
        val alk = 6.0
        val expectedDKH = "16.8"
        val expectedPPM = "300"
        val actualDKH = calculateDkhMeq(alk = alk)
        val actualPPM = calculatePpmMeq(alk = alk)

        assertEquals(expectedDKH, actualDKH)
        assertEquals(expectedPPM, actualPPM)
    }
    @Test
    fun calculate_2_meq (){
        val alk = 2.0
        val expectedDKH = "5.6"
        val expectedPPM = "100"
        val actualDKH = calculateDkhMeq(alk = alk)
        val actualPPM = calculatePpmMeq(alk = alk)

        assertEquals(expectedDKH, actualDKH)
        assertEquals(expectedPPM, actualPPM)
    }
    @Test
    fun calculate_8_meq (){
        val alk = 8.0
        val expectedDKH = "22.4"
        val expectedPPM = "400"
        val actualDKH = calculateDkhMeq(alk = alk)
        val actualPPM = calculatePpmMeq(alk = alk)

        assertEquals(expectedDKH, actualDKH)
        assertEquals(expectedPPM, actualPPM)
    }
}