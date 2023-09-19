package com.ccaquatics.aquariuminformation.data.calculators

import com.ccaquatics.aquariuminformation.R

data class CubeData(
	val radioTextFeet: Int,
	val radioTextInches: Int,
	val labelSide: Int,
	val placeholderSide: Int,
	val inputText: Int,
	val equalsText: Int,
	val calculatedTextGallons: Int,
	val calculatedTextLiters: Int,
	val calculatedTextWaterWeight: Int,
	val waterWeightText: Int,
	val formulaText: Int,
	val image: Int,
)

val cubeDataSource =
	CubeData(
		radioTextFeet = R.string.button_label_feet,
		radioTextInches = R.string.button_label_inches,
		labelSide = R.string.length,
		placeholderSide = R.string.field_label_length,
		inputText = R.string.text_amount_length_side,
		equalsText = R.string.text_equal_to,
		calculatedTextGallons = R.string.text_amount_gallon,
		calculatedTextLiters = R.string.text_amount_liters,
		calculatedTextWaterWeight = R.string.text_amount_water_weight_lbs,
		waterWeightText = R.string.text_water_weight,
		formulaText = R.string.text_formula_vol_cube,
		image = R.drawable.cube_calc,
	)