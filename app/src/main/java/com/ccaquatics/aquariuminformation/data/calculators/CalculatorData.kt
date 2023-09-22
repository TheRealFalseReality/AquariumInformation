package com.ccaquatics.aquariuminformation.data.calculators

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CalculatorData(
	@StringRes val inputText: Int,
	@StringRes val formulaText: Int,
	@DrawableRes val image: Int,
)
