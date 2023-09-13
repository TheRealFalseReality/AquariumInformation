package com.example.aquariuminformation.data

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.aquariuminformation.R

data class Home(
	@StringRes val title: Int,
	@StringRes val body: Int,
	val icon: ImageVector?
)

val homeData = listOf(
	// About the App
	Home(R.string.about, R.string.text_welcome, Icons.Filled.Home),
)