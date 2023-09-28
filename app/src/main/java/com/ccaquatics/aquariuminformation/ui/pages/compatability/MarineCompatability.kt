package com.ccaquatics.aquariuminformation.ui.pages.compatability

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ccaquatics.aquariuminformation.R
import com.ccaquatics.aquariuminformation.data.compatability.CompatabilityData
import com.ccaquatics.aquariuminformation.data.compatability.MarineDataSource
import com.ccaquatics.aquariuminformation.ui.commonui.CompatabilityDataList
import com.ccaquatics.aquariuminformation.ui.commonui.FishCardsCompatabilityData
import com.ccaquatics.aquariuminformation.ui.commonui.PageViewLazy

@Composable
fun MarineCompatabilityScreen() {
	PageViewLazy {
		CompatabilityDataList(MarineDataSource().loadFishCardsMarineDataSource())
	}
}

@Preview(showBackground = true)
@Composable
fun FishCardCompatabilityDataPreview() {
	FishCardsCompatabilityData(
		compatabilityData = CompatabilityData(
			R.drawable.dwarf_angel,
			R.string.text_dwarf_angels,
			R.string.text_latin_dwarf_angels,
			R.string.list_compatible_dwarf_angels,
			R.string.list_caution_dwarf_angels,
			R.string.list_incompatible_dwarf_angels,
			R.string.plecos_description
		)
	)
}

@Preview(showBackground = true)
@Composable
fun ListCompatabilityDataPreview() {
	MarineCompatabilityScreen()
}