package com.ccaquatics.aquariuminformation.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
//	small = RoundedCornerShape(4.dp),
	medium = RoundedCornerShape(
		bottomStart = 0.dp,
		bottomEnd = 0.dp,
		topStart = 6.dp,
		topEnd = 6.dp,
	),
	large = RoundedCornerShape(
		bottomStart = 12.dp,
		bottomEnd = 0.dp,
		topStart = 0.dp,
		topEnd = 12.dp,
	),
)