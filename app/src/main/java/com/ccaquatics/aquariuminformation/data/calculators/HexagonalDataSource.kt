package com.ccaquatics.aquariuminformation.data.calculators

import com.ccaquatics.aquariuminformation.R

data class HexagonalData(
	val radioTextFeet: Int,
	val radioTextInches: Int,
	val labelEdge: Int,
	val labelHeight: Int,
	val placeholderEdge: Int,
	val placeholderHeight: Int,
	val inputText: Int,
	val equalsText: Int,
	val calculatedTextGallons: Int,
	val calculatedTextLiters: Int,
	val calculatedTextWaterWeight: Int,
	val formulaText: Int,
	val image: Int,
)

val hexagonalDataSource =
	HexagonalData(
		radioTextFeet = R.string.button_label_feet,
		radioTextInches = R.string.button_label_inches,
		labelEdge = R.string.edge,
		labelHeight = R.string.height,
		placeholderEdge = R.string.field_label_edge,
		placeholderHeight = R.string.Field_label_height,
		inputText = R.string.text_amount_EH,
		equalsText = R.string.text_equal_to,
		calculatedTextGallons = R.string.text_amount_gallon,
		calculatedTextLiters = R.string.text_amount_liters,
		calculatedTextWaterWeight = R.string.text_amount_water_weight_lbs,
		formulaText = R.string.text_formula_soon,
		image = R.drawable.hexagonal_prism,
	)