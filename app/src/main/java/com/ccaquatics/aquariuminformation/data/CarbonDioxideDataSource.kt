package com.ccaquatics.aquariuminformation.data

import com.ccaquatics.aquariuminformation.R

data class CalculatePageTwoNumberData(
	val unitsLabel: Int,
	val label1: Int,
	val placeholder1: Int,
	val label2: Int,
	val placeholder2: Int,
	val inputText: Int,
	val equalsText: Int,
	val calculatedText: Int,
	val formulaText: Int
)

val carbonDioxideData =
	CalculatePageTwoNumberData(
		unitsLabel = R.string.text_co2_units,
		label1 = R.string.ph,
		placeholder1 = R.string.field_label_ph,
		label2 = R.string.button_label_dkh,
		placeholder2 = R.string.field_label_dkh,
		inputText = R.string.text_amount_ph_dkh,
		equalsText = R.string.text_equal_to,
		calculatedText = R.string.text_amount_co2,
		formulaText = R.string.text_formula_soon
	)
