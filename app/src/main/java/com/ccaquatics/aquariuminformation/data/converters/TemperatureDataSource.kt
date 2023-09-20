package com.ccaquatics.aquariuminformation.data.converters

import com.ccaquatics.aquariuminformation.R

data class TemperatureData(
	val subtitle: Int,
	val radioTextCelsius: Int,
	val radioTextFahrenheit: Int,
	val labelCelsius: Int,
	val labelFahrenheit: Int,
	val placeholderCelsius: Int,
	val placeholderFahrenheit: Int,
	val inputTextCelsius: Int,
	val inputTextFahrenheit: Int,
	val equalsText: Int,
	val calculatedTextFahrenheit: Int,
	val calculatedTextCelsius: Int,
	val calculatedTextKelvin: Int,
	val formulaText1: Int,
	val formulaText2: Int,
	val formulaText3: Int,
)

val temperatureDataSource =
	TemperatureData(
		subtitle = R.string.text_subtitle_temp,
		radioTextCelsius = R.string.button_label_cel,
		radioTextFahrenheit = R.string.button_label_fah,
		labelCelsius = R.string.button_label_cel,
		labelFahrenheit = R.string.button_label_fah,
		placeholderCelsius = R.string.field_label_cel,
		placeholderFahrenheit = R.string.field_label_fah,
		inputTextCelsius = R.string.text_amount_celsius,
		inputTextFahrenheit =  R.string.text_amount_fah,
		equalsText = R.string.text_equal_to,
		calculatedTextFahrenheit = R.string.text_amount_fah,
		calculatedTextCelsius = R.string.text_amount_celsius,
		calculatedTextKelvin = R.string.text_amount_kelvin,
		formulaText1 = R.string.text_formula_celsius,
		formulaText2 = R.string.text_formula_fahrenheit,
		formulaText3 = R.string.formula_kelvin,
	)