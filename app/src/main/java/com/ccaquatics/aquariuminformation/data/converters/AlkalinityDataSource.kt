package com.ccaquatics.aquariuminformation.data.converters

import com.ccaquatics.aquariuminformation.R

data class AlkalinityData(
	val subtitle: Int,
	val radioTextDkh: Int,
	val radioTextPpm: Int,
	val radioTextMeq: Int,
	val labelDkh: Int,
	val labelPpm: Int,
	val labelMeq: Int,
	val placeholderDkh: Int,
	val placeholderPpm: Int,
	val placeholderMeq: Int,
	val inputTextDkh: Int,
	val inputTextPpm: Int,
	val inputTextMeq: Int,
	val equalsText: Int,
	val calculatedTextPpm: Int,
	val calculatedTextDkh: Int,
	val calculatedTextMeq: Int,
	val formulaText: Int
)

val alkalinityDataSource =
	AlkalinityData(
		subtitle = R.string.text_subtitle_alk,
		radioTextDkh = R.string.button_label_dkh,
		radioTextPpm = R.string.button_label_ppm,
		radioTextMeq = R.string.button_label_meq,
		labelDkh = R.string.button_label_dkh,
		labelPpm = R.string.button_label_ppm,
		labelMeq = R.string.button_label_meq,
		placeholderDkh = R.string.field_label_dkh,
		placeholderPpm = R.string.field_label_ppm,
		placeholderMeq = R.string.field_label_meq,
		inputTextDkh = R.string.text_amount_dkh,
		inputTextPpm = R.string.text_amount_ppm,
		inputTextMeq = R.string.text_amount_meq,
		equalsText = R.string.text_equal_to,
		calculatedTextPpm = R.string.text_amount_ppm,
		calculatedTextDkh = R.string.text_amount_dkh,
		calculatedTextMeq = R.string.text_amount_meq,
		formulaText =  R.string.text_formula_alk,
)