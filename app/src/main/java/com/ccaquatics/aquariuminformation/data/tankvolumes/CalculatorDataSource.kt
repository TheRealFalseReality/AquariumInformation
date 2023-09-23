package com.ccaquatics.aquariuminformation.data.tankvolumes

import com.ccaquatics.aquariuminformation.R

val cylinderDataSource =
	CalculatorData(
		inputText = R.string.text_amount_DH,
		formulaText = R.string.text_formula_vol_cylinder,
		image = R.drawable.cylinder_calc,
//		color = MaterialTheme.colorScheme.secondary
	)

val bowFrontDataSource =
	CalculatorData(
		inputText = R.string.text_amount_LWHFW,
		formulaText = R.string.text_formula_soon,
		image = R.drawable.bowfront_calc,
	)

val hexagonalDataSource =
	CalculatorData(
		inputText = R.string.text_amount_EH,
		formulaText = R.string.text_formula_soon,
		image = R.drawable.hexagonal_prism,
	)

val rectangleDataSource =
	CalculatorData(
		inputText = R.string.text_amount_LWH,
		formulaText = R.string.text_formula_vol_rec,
		image = R.drawable.rectangle_calc,
	)

val cubeDataSource =
	CalculatorData(
		inputText = R.string.text_amount_length_side,
		formulaText = R.string.text_formula_vol_cube,
		image = R.drawable.cube_calc,
	)