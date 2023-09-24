package com.ccaquatics.aquariuminformation.data.calculators

import androidx.annotation.StringRes

data class CarbonDioxideData(
	@StringRes val subtitle: Int,
	@StringRes val unitsLabel: Int,
	@StringRes val labelPh: Int,
	@StringRes val placeholderPh: Int,
	@StringRes val labelDkh: Int,
	@StringRes val placeholderDkh: Int,
	@StringRes val inputText: Int,
	@StringRes val equalsText: Int,
	@StringRes val calculatedText: Int,
	@StringRes val formulaText: Int
)