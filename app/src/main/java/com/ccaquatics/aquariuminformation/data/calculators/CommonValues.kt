package com.ccaquatics.aquariuminformation.data.calculators

import com.ccaquatics.aquariuminformation.R

data class CommonTankVolumeData(
	val radioTextFeet: Int,
	val radioTextInches: Int,
	val labelLength: Int,
	val labelWidth: Int,
	val labelHeight: Int,
	val labelEdge: Int,
	val labelSide: Int,
	val placeholderLength: Int,
	val placeholderWidth: Int,
	val placeholderHeight: Int,
	val placeholderEdge: Int,
	val placeholderSide: Int,
	val equalsText: Int,
	val calculatedTextGallons: Int,
	val calculatedTextLiters: Int,
	val calculatedTextWaterWeight: Int,
)

val commonTankVolumeDataSource =
	CommonTankVolumeData(
		radioTextFeet = R.string.button_label_feet,
		radioTextInches = R.string.button_label_inches,
		labelLength = R.string.length,
		labelWidth = R.string.width,
		labelHeight = R.string.height,
		labelEdge = R.string.edge,
		labelSide = R.string.length,
		placeholderLength = R.string.field_label_length,
		placeholderWidth = R.string.Field_label_width,
		placeholderHeight = R.string.Field_label_height,
		placeholderEdge = R.string.field_label_edge,
		placeholderSide = R.string.field_label_length,
		equalsText = R.string.text_equal_to,
		calculatedTextGallons = R.string.text_amount_gallon,
		calculatedTextLiters = R.string.text_amount_liters,
		calculatedTextWaterWeight = R.string.text_amount_water_weight_lbs,
	)
