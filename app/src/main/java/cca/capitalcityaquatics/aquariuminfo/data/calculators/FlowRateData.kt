package cca.capitalcityaquatics.aquariuminfo.data.calculators

import androidx.annotation.StringRes

data class FlowRateData (
	@StringRes val subtitle: Int,
	@StringRes val subtitle2: Int,
	@StringRes val formulaText: Int,
	val conversionLowFreshwater: Double,
	val conversionHighFreshwater: Double,
	val conversionLowReef: Double,
	val conversionHighReef: Double,
)