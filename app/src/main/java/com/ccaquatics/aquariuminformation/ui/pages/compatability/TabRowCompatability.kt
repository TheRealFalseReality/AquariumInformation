package com.ccaquatics.aquariuminformation.ui.pages.compatability

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.ccaquatics.aquariuminformation.data.compatability.FreshwaterDataSource
import com.ccaquatics.aquariuminformation.data.compatability.MarineDataSource
import com.ccaquatics.aquariuminformation.navigation.compatibilityTabRow
import com.ccaquatics.aquariuminformation.ui.commonui.FancyIndicator
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme

@Composable
fun CompatabilityTabRow(
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
							maxLines = 1,
							overflow = TextOverflow.Ellipsis
						)
					},
					icon = {
						Icon(
							painter = painterResource(id = tab.icon),
							contentDescription = stringResource(id = tab.title)
						)
					}
				)
			}
		}
		when (state) {
			0 -> {
				FreshwaterList(FreshwaterDataSource().loadFishCardsFresh())
			}
			1 -> {
				CompatabilityDataList(MarineDataSource().loadFishCardsMarineData())
			}
		}
	}
}

@Composable
fun TabComposableTest() {
	var state by remember { mutableIntStateOf(0) }
	val titles = listOf("Tab 1", "Tab 2", "Tab 3 with lots of text")
	Column(
		modifier = Modifier.fillMaxSize()
	) {
		TabRow(
			selectedTabIndex = state,
		) {
			titles.forEachIndexed { index, title ->
				Tab(
					selected = state == index,
					onClick = { state = index },
					text = { Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis) }
				)
			}
		}
		Column(
			modifier = Modifier.fillMaxSize(),
			verticalArrangement = Arrangement.Center
		) {
			Text(
				modifier = Modifier.align(Alignment.CenterHorizontally),
				text = "Text tab ${state + 1} selected",
				style = MaterialTheme.typography.bodyLarge
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
	AquariumInformationTheme {
		CompatabilityTabRow()
	}
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		CompatabilityTabRow()
	}
}