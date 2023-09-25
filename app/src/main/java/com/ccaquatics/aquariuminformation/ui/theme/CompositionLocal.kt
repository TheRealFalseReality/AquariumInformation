package com.ccaquatics.aquariuminformation.ui.theme

import androidx.compose.runtime.compositionLocalOf

data class DarkTheme(val isDark: Boolean = false)

val LocalTheme = compositionLocalOf { DarkTheme() }