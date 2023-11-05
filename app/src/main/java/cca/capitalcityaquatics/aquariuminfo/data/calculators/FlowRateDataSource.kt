package cca.capitalcityaquatics.aquariuminfo.data.calculators

import cca.capitalcityaquatics.aquariuminfo.R

val flowRateDataSource =
	FlowRateData(
		subtitle = R.string.text_subtitle_alk,
		subtitle2 = R.string.text_subtitle_alk_1,
		formulaText = R.string.text_formula_alk,
		conversionLowFreshwater = 3.0,
		conversionHighFreshwater = 5.0,
		conversionLowReef = 5.0,
		conversionHighReef = 10.00,
	)