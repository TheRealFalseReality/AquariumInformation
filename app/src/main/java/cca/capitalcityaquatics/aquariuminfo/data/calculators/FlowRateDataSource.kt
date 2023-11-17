package cca.capitalcityaquatics.aquariuminfo.data.calculators

import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.navigation.FishCompatibilityFreshwater
import cca.capitalcityaquatics.aquariuminfo.navigation.FishCompatibilityMarine

val flowRateDataSourceFreshwater =
	FlowRateData(
		image = R.drawable.freshwater_shark,
		subtitle = R.string.flow_rate_subtitle,
		formulaText = FishCompatibilityFreshwater.title,
		icon = FishCompatibilityFreshwater.icon,
		header = R.string.flow_rate_freshwater,
		conversionLow = 3.0,
		conversionHigh = 5.0,
	)

val flowRateDataSourceMarine =
	FlowRateData(
		image = R.drawable.clownfish,
		subtitle = R.string.flow_rate_subtitle,
		formulaText = FishCompatibilityMarine.title,
		icon = FishCompatibilityMarine.icon,
		header = R.string.flow_rate_marine,
		conversionLow = 5.0,
		conversionHigh = 10.00,
	)