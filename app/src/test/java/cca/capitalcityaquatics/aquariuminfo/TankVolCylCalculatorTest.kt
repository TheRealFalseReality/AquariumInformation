package cca.capitalcityaquatics.aquariuminfo

import cca.capitalcityaquatics.aquariuminfo.tankVolume.*
import junit.framework.Assert.assertEquals
import org.junit.Test

class TankVolCylCalculatorTest{
    @Test
    fun calculate_24_24_in (){
        val l = 24.0
        val h = 24.0
        val half = false
        val quart = false
        val expectedGAL = "47"
        val expectedLIT = "177.92"
        val expectedWW = "391.52"
        val actualGAL = calculateVolGallonCyl(l,h, half, quart)
        val actualLIT = calculateVolLiterCyl(l,h, half, quart)
        val actualWW = calculateWaterWeightCyl(l,h, half, quart)

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }
    @Test
    fun calculate_36_12_in (){
        val l = 36.0
        val h = 12.0
        val half = false
        val quart = false
        val expectedGAL = "52.88"
        val expectedLIT = "200.16"
        val expectedWW = "440.46"
        val actualGAL = calculateVolGallonCyl(l,h, half, quart)
        val actualLIT = calculateVolLiterCyl(l,h, half, quart)
        val actualWW = calculateWaterWeightCyl(l,h, half, quart)

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }
    @Test
    fun calculate_72_21_in (){
        val l = 72.0
        val h = 12.0
        val half = false
        val quart = false
        val expectedGAL = "211.51"
        val expectedLIT = "800.64"
        val expectedWW = "1761.85"
        val actualGAL = calculateVolGallonCyl(l,h, half, quart)
        val actualLIT = calculateVolLiterCyl(l,h, half, quart)
        val actualWW = calculateWaterWeightCyl(l,h, half, quart)

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }
    @Test
    fun calculate_2_2_ft (){
        val l = 2.0
        val h = 2.0
        val half = false
        val quart = false
        val expectedGAL = "47"
        val expectedLIT = "177.92"
        val expectedWW = "391.52"
        val actualGAL = calculateVolGallonFTCyl(l,h, half, quart)
        val actualLIT = calculateVolLiterFTCyl(l,h, half, quart)
        val actualWW = calculateWaterWeightFTCyl(l,h, half, quart)

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }
    @Test
    fun calculate_3_1_in (){
        val l = 3.0
        val h = 1.0
        val half = false
        val quart = false
        val expectedGAL = "52.88"
        val expectedLIT = "200.16"
        val expectedWW = "440.46"
        val actualGAL = calculateVolGallonFTCyl(l,h, half, quart)
        val actualLIT = calculateVolLiterFTCyl(l,h, half, quart)
        val actualWW = calculateWaterWeightFTCyl(l,h, half, quart)

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }
    @Test
    fun calculate_5_2_in (){
        val l = 5.0
        val h = 2.0
        val half = false
        val quart = false
        val expectedGAL = "293.76"
        val expectedLIT = "1112"
        val expectedWW = "2447.01"
        val actualGAL = calculateVolGallonFTCyl(l,h, half, quart)
        val actualLIT = calculateVolLiterFTCyl(l,h, half, quart)
        val actualWW = calculateWaterWeightFTCyl(l,h, half, quart)

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }
}