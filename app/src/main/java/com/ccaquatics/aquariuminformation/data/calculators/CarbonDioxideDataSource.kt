package com.ccaquatics.aquariuminformation.data.calculators

import androidx.annotation.StringRes
import com.ccaquatics.aquariuminformation.R

data class CarbonDioxideData(
	@StringRes val subtitle: Int,
	@StringRes val unitsLabel: Int,
	@StringRes val labelPh: Int,
	@StringRes val placeholderPh: Int,
	@StringRes val labelDkh: Int,
	@StringRes val placeholderDkh: Int,
	@StringRes val inputText: Int,
	@StringRes val equalsText: Int,
	@StringRes val calculatedText: Int,
	@StringRes val formulaText: Int
)

val carbonDioxideDataSource =
	CarbonDioxideData(
		subtitle = R.string.text_subtitle_co2,
		unitsLabel = R.string.text_co2_units,
		labelPh = R.string.ph,
		placeholderPh = R.string.field_label_ph,
		labelDkh = R.string.button_label_dkh,
		placeholderDkh = R.string.field_label_dkh,
		inputText = R.string.text_amount_ph_dkh,
		equalsText = R.string.text_equal_to,
		calculatedText = R.string.text_amount_co2,
		formulaText = R.string.text_formula_soon
	)
