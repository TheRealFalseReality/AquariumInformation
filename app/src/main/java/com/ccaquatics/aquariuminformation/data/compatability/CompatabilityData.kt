package com.ccaquatics.aquariuminformation.data.compatability

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CompatabilityData(
	@DrawableRes val image: Int,
	@StringRes val title: Int,
	@StringRes val latin: Int,
	@StringRes val compatible: Int,
	@StringRes val caution: Int,
	@StringRes val incompatible: Int
)
