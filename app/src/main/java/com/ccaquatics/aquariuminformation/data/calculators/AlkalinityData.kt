package com.ccaquatics.aquariuminformation.data.calculators

import androidx.annotation.StringRes

data class AlkalinityData(
	@StringRes val subtitle: Int,
	@StringRes val radioTextDkh: Int,
	@StringRes val radioTextPpm: Int,
	@StringRes val radioTextMeq: Int,
	@StringRes val labelDkh: Int,
	@StringRes val labelPpm: Int,
	@StringRes val labelMeq: Int,
	@StringRes val placeholderDkh: Int,
	@StringRes val placeholderPpm: Int,
	@StringRes val placeholderMeq: Int,
	@StringRes val inputTextDkh: Int,
	@StringRes val inputTextPpm: Int,
	@StringRes val inputTextMeq: Int,
	@StringRes val equalsText: Int,
	@StringRes val calculatedTextPpm: Int,
	@StringRes val calculatedTextDkh: Int,
	@StringRes val calculatedTextMeq: Int,
	@StringRes val formulaText: Int
)