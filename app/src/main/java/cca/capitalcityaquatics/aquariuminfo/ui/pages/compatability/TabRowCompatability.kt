package cca.capitalcityaquatics.aquariuminfo.ui.pages.compatability

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import cca.capitalcityaquatics.aquariuminfo.data.compatability.FreshwaterDataSource
import cca.capitalcityaquatics.aquariuminfo.data.compatability.MarineDataSource
import cca.capitalcityaquatics.aquariuminfo.navigation.compatibilityTabRow
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CompatibilityDataList
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FancyIndicator
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme

@Composable
fun CompatibilityTabRow(
	selectedState: Int = 0,
	selectedColor: Color = MaterialTheme.colorScheme.tertiary,
	unselectedColor: Color = MaterialTheme.colorScheme.outline,
) {
	var state by remember { mutableIntStateOf(selectedState) }
	val tabs = compatibilityTabRow
	val indicator = @Composable { tabPositions: List<TabPosition> ->
		FancyIndicator(
			selectedColor,
			Modifier.tabIndicatorOffset(tabPositions[state])
		)
	}

	Column(
		modifier = Modifier.fillMaxSize()
	) {
		TabRow(
			selectedTabIndex = state,
			indicator = indicator
		) {
			tabs.forEachIndexed { index, tab ->
				Tab(
					selected = state == index,
					selectedContentColor = selectedColor,
					unselectedContentColor = unselectedColor,
					onClick = { state = index },
					text = {
						Text(
							text = stringResource(id = tab.title),
							maxLines = 2,
							overflow = TextOverflow.Ellipsis
						)
					},
//					icon = { // TODO Use Row for Landscape
//						Icon(
//							painter = painterResource(id = tab.icon),
//							contentDescription = stringResource(id = tab.title)
//						)
//					}
				)
			}
		}
		when (state) {
			0 -> {
				CompatibilityDataList(FreshwaterDataSource().loadFishCardsFreshwaterDataSource())
			}

			1 -> {
				CompatibilityDataList(MarineDataSource().loadFishCardsMarineDataSource())
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
	AquariumInformationTheme {
		CompatibilityTabRow()
	}
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		CompatibilityTabRow()
	}
}