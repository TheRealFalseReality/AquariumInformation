package com.ccaquatics.aquariuminformation.data.calculators

import com.ccaquatics.aquariuminformation.R

data class RectangleData(
	val radioTextFeet: Int,
	val radioTextInches: Int,
	val labelLength: Int,
	val labelWidth: Int,
	val labelHeight: Int,
	val placeholderLength: Int,
	val placeholderWidth: Int,
	val placeholderHeight: Int,
	val inputText: Int,
//	val inputTextLength: Int,
//	val inputTextWidth: Int,
//	val inputTextHeight: Int,
	val equalsText: Int,
	val calculatedTextGallons: Int,
	val calculatedTextLiters: Int,
	val calculatedTextWaterWeight: Int,
	val waterWeightText: Int,
	val formulaText: Int,
	val image: Int,
)

val rectangleDataSource = 
	RectangleData(
		radioTextFeet = R.string.button_label_feet,
		radioTextInches = R.string.button_label_inches,
		labelLength = R.string.length,
		labelWidth = R.string.width,
		labelHeight = R.string.height,
		placeholderLength = R.string.field_label_length,
		placeholderWidth = R.string.Field_label_width,
		placeholderHeight = R.string.Field_label_height,
		inputText = R.string.text_amount_LWH,
//		inputTextLength = R.string.text_amount_length,
//		inputTextWidth = R.string.text_amount_width,
//		inputTextHeight = R.string.text_amount_height,
		equalsText = R.string.text_equal_to,
		calculatedTextGallons = R.string.text_amount_gallon,
		calculatedTextLiters = R.string.text_amount_liters,
		calculatedTextWaterWeight = R.string.text_amount_water_weight_lbs,
		waterWeightText = R.string.text_water_weight,
		formulaText = R.string.text_formula_vol_rec,
		image = R.drawable.rectangle_calc,
	)