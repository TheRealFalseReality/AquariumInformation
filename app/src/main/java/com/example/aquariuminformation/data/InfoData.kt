package com.example.aquariuminformation.data

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.aquariuminformation.R

data class Info(
	@StringRes val title: Int,
	@StringRes val body: Int,
	val icon: ImageVector?
)

val infoData = listOf(
	// Information
	Info(R.string.text_title_info, R.string.text_info_1, Icons.Filled.Info),
)
