package com.ccaquatics.aquariuminformation.ui.pages.compatability

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.ccaquatics.aquariuminformation.R
import com.ccaquatics.aquariuminformation.data.compatability.CompatabilityData
import com.ccaquatics.aquariuminformation.data.compatability.MarineDataSource
import com.ccaquatics.aquariuminformation.ui.commonui.FishCardsCompatabilityData
import com.ccaquatics.aquariuminformation.ui.commonui.PageViewLazy

@Composable
fun MarineCompatabilityScreen() {
	PageViewLazy {
		CompatabilityDataList(MarineDataSource().loadFishCardsMarineData())
	}
}

@Composable
fun CompatabilityDataList(
	marineList: List<CompatabilityData>,
	modifier: Modifier = Modifier
) {
	Surface(
		modifier = modifier
			.fillMaxSize(),
		color = MaterialTheme.colorScheme.background
	) {
		Column(
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			LazyVerticalGrid(
				columns = GridCells.Adaptive(minSize = dimensionResource(id = R.dimen.grid_colum_medium)),
				userScrollEnabled = true,
				state = LazyGridState(),
				content = {
					items(marineList) { compatabilityData ->
						FishCardsCompatabilityData(compatabilityData = compatabilityData)
					}
				}
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun FishCardCompatabilityDataPreview() {
	FishCardsCompatabilityData(
		compatabilityData = CompatabilityData(
			R.drawable.pleco,
			R.string.text_pleco,
			R.string.text_latin_pleco,
			R.string.text_app_errors,
			R.string.text_amount_fah,
			R.string.text_pleco
		)
	)
}

@Preview(showBackground = true)
@Composable
fun ListCompatabilityDataPreview() {
	MarineCompatabilityScreen()
}