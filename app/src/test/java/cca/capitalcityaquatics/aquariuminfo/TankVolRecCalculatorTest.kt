package cca.capitalcityaquatics.aquariuminfo

import cca.capitalcityaquatics.aquariuminfo.tankVolume.*
import junit.framework.Assert.assertEquals
import org.junit.Test

class TankVolRecCalculatorTest{
    @Test
    fun calculate_48_24_24_in (){
        val l = 48.0
        val w = 24.0
        val h = 24.0
        val expectedGAL = "119.69"
        val expectedLIT = "453.07"
        val expectedWW = "997"
        val actualGAL = calculateVolGallon(l,w,h)
        val actualLIT = calculateVolLiter(l,w,h)
        val actualWW = calculateWaterWeight(l,w,h)

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }
    @Test
    fun calculate_36_12_12_in (){
        val l = 36.0
        val w = 12.0
        val h = 12.0
        val expectedGAL = "22.44"
        val expectedLIT = "84.95"
        val expectedWW = "186.94"
        val actualGAL = calculateVolGallon(l,w,h)
        val actualLIT = calculateVolLiter(l,w,h)
        val actualWW = calculateWaterWeight(l,w,h)

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }
    @Test
    fun calculate_72_2_21_in (){
        val l = 72.0
        val w = 24.0
        val h = 21.0
        val expectedGAL = "157.09"
        val expectedLIT = "594.65"
        val expectedWW = "1308.57"
        val actualGAL = calculateVolGallon(l,w,h)
        val actualLIT = calculateVolLiter(l,w,h)
        val actualWW = calculateWaterWeight(l,w,h)

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }
    @Test
    fun calculate_4_2_2_ft (){
        val l = 4.0
        val w = 2.0
        val h = 2.0
        val expectedGAL = "119.69"
        val expectedLIT = "453.07"
        val expectedWW = "997"
        val actualGAL = calculateVolGallonFT(l,w,h)
        val actualLIT = calculateVolLiterFT(l,w,h)
        val actualWW = calculateWaterWeightFT(l,w,h)

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }
    @Test
    fun calculate_3_1_1_in (){
        val l = 3.0
        val w = 1.0
        val h = 1.0
        val expectedGAL = "22.44"
        val expectedLIT = "84.95"
        val expectedWW = "186.94"
        val actualGAL = calculateVolGallonFT(l,w,h)
        val actualLIT = calculateVolLiterFT(l,w,h)
        val actualWW = calculateWaterWeightFT(l,w,h)

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }
    @Test
    fun calculate_3_2_2_in (){
        val l = 3.0
        val w = 2.0
        val h = 2.0
        val expectedGAL = "89.77"
        val expectedLIT = "339.8"
        val expectedWW = "747.75"
        val actualGAL = calculateVolGallonFT(l,w,h)
        val actualLIT = calculateVolLiterFT(l,w,h)
        val actualWW = calculateWaterWeightFT(l,w,h)

        assertEquals(expectedGAL, actualGAL)
        assertEquals(expectedLIT, actualLIT)
        assertEquals(expectedWW, actualWW)
    }
}