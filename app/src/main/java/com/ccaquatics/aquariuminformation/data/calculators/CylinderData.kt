package com.ccaquatics.aquariuminformation.data.calculators

import com.ccaquatics.aquariuminformation.R

data class CylinderData(
	val inputText: Int,
	val formulaText: Int,
	val image: Int,
)

val cylinderDataSource =
	CylinderData(
		inputText = R.string.text_amount_DH,
		formulaText = R.string.text_formula_vol_cylinder,
		image = R.drawable.cylinder_calc,
	)