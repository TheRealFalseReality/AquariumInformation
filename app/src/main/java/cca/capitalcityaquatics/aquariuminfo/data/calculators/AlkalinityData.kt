package cca.capitalcityaquatics.aquariuminfo.data.calculators

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class AlkalinityData(
	@StringRes val subtitle: Int,
	@StringRes val subtitle1: Int,
	@StringRes val subtitle2: Int,
	@StringRes val subtitle3: Int,
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
	@DrawableRes val leadingIconTDS: Int,
	@StringRes val formulaText: Int,
	val conversionPPMDKH: Double,
	val conversionPPMMEQ: Double,
	val conversionDKHPPM: Double,
	val conversionDKHMEQ: Double,
	val conversionMEQPPM: Double,
	val conversionMEQDKH: Double,
)