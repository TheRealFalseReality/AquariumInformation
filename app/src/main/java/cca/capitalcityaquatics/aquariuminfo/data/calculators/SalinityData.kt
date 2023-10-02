package cca.capitalcityaquatics.aquariuminfo.data.calculators

import androidx.annotation.StringRes

data class SalinityData(
	@StringRes val subtitle: Int,
	@StringRes val subtitle1: Int,
	@StringRes val subtitle2: Int,
	@StringRes val subtitle3: Int,
	@StringRes val radioTextPpt: Int,
	@StringRes val radioTextSg: Int,
	@StringRes val labelPpt: Int,
	@StringRes val labelSg: Int,
	@StringRes val placeholderPpt: Int,
	@StringRes val placeholderSg: Int,
	@StringRes val inputTextPpt: Int,
	@StringRes val inputTextSg: Int,
	@StringRes val equalsText: Int,
	@StringRes val calculatedTextSg: Int,
	@StringRes val calculatedTextPpt: Int,
	@StringRes val calculatedTextDensity: Int,
	@StringRes val formulaText: Int,
	@StringRes val labelSalinity: Int,
	@StringRes val labelSpecificGravity: Int,
	@StringRes val labelConductivity: Int,
	@StringRes val labelDensity: Int,
)