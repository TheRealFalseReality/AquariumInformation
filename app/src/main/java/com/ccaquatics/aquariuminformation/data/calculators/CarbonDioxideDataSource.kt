package com.ccaquatics.aquariuminformation.data.calculators

import com.ccaquatics.aquariuminformation.R

data class CarbonDioxideData(
	val unitsLabel: Int,
	val labelPh: Int,
	val placeholderPh: Int,
	val labelDkh: Int,
	val placeholderDkh: Int,
	val inputText: Int,
	val equalsText: Int,
	val calculatedText: Int,
	val formulaText: Int
)

val carbonDioxideDataSource =
	CarbonDioxideData(
		unitsLabel = R.string.text_co2_units,
		labelPh = R.string.ph,
		placeholderPh = R.string.field_label_ph,
		labelDkh = R.string.button_label_dkh,
		placeholderDkh = R.string.field_label_dkh,
		inputText = R.string.text_amount_ph_dkh,
		equalsText = R.string.text_equal_to,
		calculatedText = R.string.text_amount_co2,
		formulaText = R.string.text_formula_soon
	)
