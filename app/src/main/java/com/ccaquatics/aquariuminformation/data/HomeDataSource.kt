package com.ccaquatics.aquariuminformation.data

import com.ccaquatics.aquariuminformation.R

val homeHeaderDataSource =
	TextData(text = R.string.text_welcome)

val homeCompatibilityDataSource =
	HeaderData(
		icon = R.drawable.ic_new_releases,
		title = R.string.text_welcome_compatibility_title,
		text = R.string.text_welcome_compatibility_2,
	)

val homeNavigateDataSource =
	TextData(
		text = R.string.tap_below_to_navigate,
	)