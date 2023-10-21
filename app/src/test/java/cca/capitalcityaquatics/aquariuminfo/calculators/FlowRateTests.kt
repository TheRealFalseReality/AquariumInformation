package cca.capitalcityaquatics.aquariuminfo.calculators

import cca.capitalcityaquatics.aquariuminfo.model.calculators.CalculatorMethods
import junit.framework.TestCase.assertEquals
import org.junit.Test

class FlowRateTests {
	@Test
	fun calculate_rate_500() {
		val tankVolume = 500.0

		val expectedLowRate = "2500"
		val expectedHighRate = "5000"
		val parameters = CalculatorMethods(tankVolume = tankVolume)
		val actualLowRate = parameters.pumpFlowLow()
		val actualHighRate = parameters.pumpFlowHigh()

		assertEquals(expectedLowRate, actualLowRate)
		assertEquals(expectedHighRate, actualHighRate)
	}
}