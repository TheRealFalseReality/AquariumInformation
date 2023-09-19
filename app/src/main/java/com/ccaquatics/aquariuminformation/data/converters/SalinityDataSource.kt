package com.ccaquatics.aquariuminformation.data.converters

import com.ccaquatics.aquariuminformation.R

data class SalinityData (
	val radioTextPpt: Int,
	val radioTextSg: Int,
	val labelPpt: Int,
	val labelSg: Int,
	val placeholderPpt: Int,
	val placeholderSg: Int,
	val inputTextPpt: Int,
	val inputTextSg: Int,
	val equalsText: Int,
	val calculatedTextSg: Int,
	val calculatedTextPpt: Int,
	val calculatedTextDensity: Int,
	val formulaText: Int,
)

val salinityDataSource = 
	SalinityData(
		radioTextPpt = R.string.salinity_ppt,
		radioTextSg = R.string.button_label_sg,
		labelPpt = R.string.button_label_ppt,
		labelSg = R.string.button_label_sg,
		placeholderPpt = R.string.field_label_ppt,
		placeholderSg = R.string.field_label_sg,
		inputTextPpt = R.string.text_amount_ppt,
		inputTextSg = R.string.text_amount_sg,
		equalsText = R.string.text_equiv,
		calculatedTextSg = R.string.text_amount_sg,
		calculatedTextPpt = R.string.text_amount_ppt,
		calculatedTextDensity = R.string.text_amount_density,
		formulaText = R.string.text_formula_soon,
	)