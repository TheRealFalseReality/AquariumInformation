package com.ccaquatics.aquariuminformation.ui.pages.compatability

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ccaquatics.aquariuminformation.R
import com.ccaquatics.aquariuminformation.data.compatability.CompatibilityData
import com.ccaquatics.aquariuminformation.data.compatability.FreshwaterDataSource
import com.ccaquatics.aquariuminformation.ui.commonui.CompatibilityDataList
import com.ccaquatics.aquariuminformation.ui.commonui.FishCardsCompatibilityData
import com.ccaquatics.aquariuminformation.ui.commonui.PageViewLazy

@Composable
fun FreshwaterCompatibilityScreen() {
	PageViewLazy {
		CompatibilityDataList(FreshwaterDataSource().loadFishCardsFreshwaterDataSource())
	}
}

@Preview(showBackground = true)
@Composable
fun FishCardPreview() {
	FishCardsCompatibilityData(
		compatibilityData = CompatibilityData(
			R.drawable.pleco,
			R.string.text_pleco,
			R.string.text_latin_pleco,
			R.string.text_app_errors,
			R.string.text_amount_fah,
			R.string.text_pleco,
			R.string.plecos_description
		)
	)
}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
	FreshwaterCompatibilityScreen()
}