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

//class HomeDataSource{
//	fun loadHomeData(): List<HomeData> {
//		return listOf(
//			HomeData(R.string.about, R.string.text_welcome),
//			HomeData(R.string.text_title_info, R.string.text_info_1)
//		)
//	}
//}

val homeData = listOf(
	Home(R.string.about, R.string.text_welcome, Icons.Filled.Home),
	Home(R.string.text_title_info, R.string.text_info_1, Icons.Filled.Info)
)