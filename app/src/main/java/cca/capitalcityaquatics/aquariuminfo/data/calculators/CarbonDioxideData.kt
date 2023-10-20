package cca.capitalcityaquatics.aquariuminfo.data.calculators

import androidx.annotation.DrawableRes
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
	@DrawableRes val leadingIconPH: Int,
	@DrawableRes val leadingIconDKH: Int,
	@StringRes val formulaText: Int
)
