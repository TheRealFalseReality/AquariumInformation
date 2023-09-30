package cca.capitalcityaquatics.aquariuminfo.data.calculators

import androidx.annotation.StringRes

data class TemperatureData(
	@StringRes val subtitle: Int,
	@StringRes val radioTextCelsius: Int,
	@StringRes val radioTextFahrenheit: Int,
	@StringRes val labelCelsius: Int,
	@StringRes val labelFahrenheit: Int,
	@StringRes val placeholderCelsius: Int,
	@StringRes val placeholderFahrenheit: Int,
	@StringRes val inputTextCelsius: Int,
	@StringRes val inputTextFahrenheit: Int,
	@StringRes val equalsText: Int,
	@StringRes val calculatedTextFahrenheit: Int,
	@StringRes val calculatedTextCelsius: Int,
	@StringRes val calculatedTextKelvin: Int,
	@StringRes val formulaText1: Int,
	@StringRes val formulaText2: Int,
	@StringRes val formulaText3: Int,
)
