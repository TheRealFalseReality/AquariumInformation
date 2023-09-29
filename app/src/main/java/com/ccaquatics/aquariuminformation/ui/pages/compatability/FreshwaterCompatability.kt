package com.ccaquatics.aquariuminformation.ui.pages.compatability

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ccaquatics.aquariuminformation.R
import com.ccaquatics.aquariuminformation.data.compatability.CompatabilityData
import com.ccaquatics.aquariuminformation.data.compatability.FreshwaterDataSource
import com.ccaquatics.aquariuminformation.ui.commonui.CompatabilityDataList
import com.ccaquatics.aquariuminformation.ui.commonui.FishCardsCompatabilityData
import com.ccaquatics.aquariuminformation.ui.commonui.PageViewLazy

@Composable
fun FreshwaterCompatabilityScreen() {
	PageViewLazy {
		CompatabilityDataList(FreshwaterDataSource().loadFishCardsFreshwaterDataSource())
	}
}

@Preview(showBackground = true)
@Composable
fun FishCardPreview() {
	FishCardsCompatabilityData(
		compatabilityData = CompatabilityData(
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
	FreshwaterCompatabilityScreen()
}