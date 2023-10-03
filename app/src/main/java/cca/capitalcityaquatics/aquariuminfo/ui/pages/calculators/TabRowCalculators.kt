package cca.capitalcityaquatics.aquariuminfo.ui.pages.calculators

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
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
import cca.capitalcityaquatics.aquariuminfo.navigation.calculatorsTabRow
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FancyIndicator

@Composable
fun CalculatorsTabRow(
	windowSize: WindowSizeClass,
	selectedState: Int = 0,
	selectedColor: Color = MaterialTheme.colorScheme.primary,
	unselectedColor: Color = MaterialTheme.colorScheme.outline,
) {
	var state by remember { mutableIntStateOf(selectedState) }
	val tabs = calculatorsTabRow
	val indicator = @Composable { tabPositions: List<TabPosition> ->
		FancyIndicator(
			selectedColor,
			Modifier.tabIndicatorOffset(tabPositions[state])
		)
	}

	Column(
		modifier = Modifier.fillMaxSize()
	) {
		when (windowSize.widthSizeClass) {
			WindowWidthSizeClass.Compact -> {
				ScrollableTabRow(
					selectedTabIndex = state,
					indicator = indicator,
				) {
					tabs.forEachIndexed { index, tab ->
						Tab(
							selected = state == index,
							onClick = { state = index },
							selectedContentColor = selectedColor,
							unselectedContentColor = unselectedColor,
							text = {
								Text(
									text = stringResource(id = tab.title),
									maxLines = 1,
									overflow = TextOverflow.Ellipsis
								)
							},
							icon = {
								Icon(
									painter =
									if (state == index) painterResource(id = tab.iconFilled)
									else painterResource(id = tab.icon),
									contentDescription = stringResource(id = tab.title)
								)
							}
						)
					}
				}
			}

			WindowWidthSizeClass.Expanded, WindowWidthSizeClass.Medium -> {
				TabRow(
					selectedTabIndex = state,
					indicator = indicator,
				) {
					tabs.forEachIndexed { index, tab ->
						LeadingIconTab(
							selected = state == index,
							onClick = { state = index },
							selectedContentColor = selectedColor,
							unselectedContentColor = unselectedColor,
							text = {
								Text(
									text = stringResource(id = tab.title),
									maxLines = 1,
									overflow = TextOverflow.Ellipsis
								)
							},
							icon = {
								Icon(
									painter =
									if (state == index) painterResource(id = tab.iconFilled)
									else painterResource(id = tab.icon),
									contentDescription = stringResource(id = tab.title)
								)
							}
						)
					}
				}
			}
		}
		when (state) {
			0 -> {
				SalinityPage(windowSize = windowSize)
			}

			1 -> {
				AlkalinityPage(windowSize = windowSize)
			}

			2 -> {
				TemperaturePage(windowSize = windowSize)
			}

			3 -> CarbonDioxidePage(windowSize = windowSize)
		}
	}
}

//@Preview(showBackground = true)
//@Composable
//fun CalculatorsTabRowPreview() {
//	AquariumInformationTheme {
//		CalculatorsTabRow()
//	}
//}
//
//@Preview(showBackground = true)
//@Composable
//fun CalculatorsTabRowPreviewDark(
//) {
//	AquariumInformationTheme(useDarkTheme = true) {
//		CalculatorsTabRow()
//	}
//}