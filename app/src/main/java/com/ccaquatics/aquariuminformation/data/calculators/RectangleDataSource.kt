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
	val equalsText: Int,
	val calculatedTextGallons: Int,
	val calculatedTextLiters: Int,
	val calculatedTextWaterWeight: Int,
	val formulaText: Int,
	val image: Int,
)

val rectangleDataSource = 
	RectangleData(
		/* TODO Remove val that are constant, including Radio Button strings below */
		radioTextFeet = R.string.button_label_feet,
		radioTextInches = R.string.button_label_inches,
		labelLength = R.string.length,
		labelWidth = R.string.width,
		labelHeight = R.string.height,
		placeholderLength = R.string.field_label_length,
		placeholderWidth = R.string.Field_label_width,
		placeholderHeight = R.string.Field_label_height,
		inputText = R.string.text_amount_LWH,
		/* TODO Remove val that are constant, including calculated strings below */
		equalsText = R.string.text_equal_to,
		calculatedTextGallons = R.string.text_amount_gallon,
		calculatedTextLiters = R.string.text_amount_liters,
		calculatedTextWaterWeight = R.string.text_amount_water_weight_lbs,
		formulaText = R.string.text_formula_vol_rec,
		image = R.drawable.rectangle_calc,
	)