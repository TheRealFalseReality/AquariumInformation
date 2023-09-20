package com.ccaquatics.aquariuminformation.converters

import com.ccaquatics.aquariuminformation.ui.pages.converters.calculateCelsius
import com.ccaquatics.aquariuminformation.ui.pages.converters.calculateFahrenheit
import com.ccaquatics.aquariuminformation.ui.pages.converters.calculateKelvinCel
import com.ccaquatics.aquariuminformation.ui.pages.converters.calculateKelvinFah
import junit.framework.TestCase.assertEquals
import org.junit.Test

class TempConverterTest {
	@Test
	fun calculate_32_F() {
		val temp = 32.0
		val expectedCelsius = "0"
		val expectedKelvin = "273.15"
		val actualCelsius = calculateCelsius(temp = temp)
		val actualKelvin = calculateKelvinFah(temp = temp)

		assertEquals(expectedCelsius, actualCelsius)
		assertEquals(expectedKelvin, actualKelvin)
	}

	@Test
	fun calculate_0_F() {
		val temp = 0.0
		val expectedCelsius = "-17.78"
		val expectedKelvin = "255.37"
		val actualCelsius = calculateCelsius(temp = temp)
		val actualKelvin = calculateKelvinFah(temp = temp)

		assertEquals(expectedCelsius, actualCelsius)
		assertEquals(expectedKelvin, actualKelvin)
	}

	@Test
	fun calculate_100_F() {
		val temp = 100.0
		val expectedCelsius = "37.78"
		val expectedKelvin = "310.93"
		val actualCelsius = calculateCelsius(temp = temp)
		val actualKelvin = calculateKelvinFah(temp = temp)

		assertEquals(expectedCelsius, actualCelsius)
		assertEquals(expectedKelvin, actualKelvin)
	}

	@Test
	fun calculate_32_C() {
		val temp = 32.0
		val expectedFah = "89.6"
		val expectedKelvin = "305.15"
		val actualFah = calculateFahrenheit(temp = temp)
		val actualKelvin = calculateKelvinCel(temp = temp)

		assertEquals(expectedFah, actualFah)
		assertEquals(expectedKelvin, actualKelvin)
	}

	@Test
	fun calculate_0_C() {
		val temp = 0.0
		val expectedFah = "32"
		val expectedKelvin = "273.15"
		val actualFah = calculateFahrenheit(temp = temp)
		val actualKelvin = calculateKelvinCel(temp = temp)

		assertEquals(expectedFah, actualFah)
		assertEquals(expectedKelvin, actualKelvin)
	}

	@Test
	fun calculate_100_C() {
		val temp = 100.0
		val expectedFah = "212"
		val expectedKelvin = "373.15"
		val actualFah = calculateFahrenheit(temp = temp)
		val actualKelvin = calculateKelvinCel(temp = temp)

		assertEquals(expectedFah, actualFah)
		assertEquals(expectedKelvin, actualKelvin)
	}
}