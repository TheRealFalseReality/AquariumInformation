package com.ccaquatics.aquariuminformation.data.tankvolumes

import androidx.annotation.StringRes

data class CommonData(
	@StringRes val subtitle: Int,
	@StringRes val radioTextFeet: Int,
	@StringRes val radioTextInches: Int,
	@StringRes val labelLength: Int,
	@StringRes val labelWidth: Int,
	@StringRes val labelHeight: Int,
	@StringRes val labelEdge: Int,
	@StringRes val labelSide: Int,
	@StringRes val labelDiameter: Int,
	@StringRes val labelFullWidth: Int,
	@StringRes val placeholderLength: Int,
	@StringRes val placeholderWidth: Int,
	@StringRes val placeholderHeight: Int,
	@StringRes val placeholderEdge: Int,
	@StringRes val placeholderSide: Int,
	@StringRes val placeholderDiameter: Int,
	@StringRes val placeholderFullWidth: Int,
	@StringRes val equalsText: Int,
	@StringRes val calculatedTextGallons: Int,
	@StringRes val calculatedTextLiters: Int,
	@StringRes val calculatedTextWaterWeight: Int,
	@StringRes val labelWaterWeight: Int,
	@StringRes val radioHalfCylinder: Int,
	@StringRes val radioCornerCylinder: Int,
	@StringRes val radioFullCylinder: Int,
	@StringRes val labelCylinderType: Int,
)