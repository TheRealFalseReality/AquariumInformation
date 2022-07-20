package cca.capitalcityaquatics.aquariuminfo.data.compatibility

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Marine(
	@DrawableRes val image: Int?,
	@StringRes val title: Int,
	@StringRes val latin: Int,
	@StringRes val compatible: Int,
	@StringRes val caution: Int,
	@StringRes val incompatible: Int
)
