package com.ccaquatics.aquariuminformation.data.tankvolumes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CalculatorData(
	@StringRes val inputTextFeet: Int,
	@StringRes val inputTextInches: Int,
	@StringRes val formulaText: Int,
	@DrawableRes val image: Int,
)
