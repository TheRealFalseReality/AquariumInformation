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
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.navigation.calculatorsTabRow
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FancyIndicator
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.pagerTabIndicatorOffset
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CalculatorsTabRow(
	windowSize: WindowSizeClass,
	selectedState: Int = 0,
	selectedColor: Color = MaterialTheme.colorScheme.primary,
	unselectedColor: Color = MaterialTheme.colorScheme.outline,
) {
	val pagerState = rememberPagerState(
		initialPage = selectedState
	)
	val coroutineScope = rememberCoroutineScope()
	val tabs = calculatorsTabRow
//	val indicatorAnimated = @Composable { tabPositions: List<TabPosition> ->
//		FancyAnimatedIndicator(
//			Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
//			tabPositions = tabPositions,
//			selectedTabIndex = state,
//			indicatorColor = selectedColor
//		)
//	}
	val indicator = @Composable { tabPositions: List<TabPosition> ->
		FancyIndicator(
			selectedColor,
			Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
		)
	}

	Column(
		modifier = Modifier.fillMaxSize()
	) {
		when (windowSize.widthSizeClass) {
			WindowWidthSizeClass.Compact -> {
				ScrollableTabRow(
					indicator = indicator,
					selectedTabIndex = pagerState.currentPage,
				) {
					tabs.forEachIndexed { index, tab ->
						Tab(
							selected = pagerState.currentPage == index,
							onClick = {
								coroutineScope.launch {
									pagerState.animateScrollToPage(index)
								}
							},
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
									if (pagerState.currentPage == index) painterResource(id = tab.iconFilled)
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
					selectedTabIndex = pagerState.currentPage,
					indicator = indicator,
				) {
					tabs.forEachIndexed { index, tab ->
						LeadingIconTab(
							selected = pagerState.currentPage == index,
							onClick = {
								coroutineScope.launch {
									pagerState.animateScrollToPage(index)
								}
							},
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
									if (pagerState.currentPage == index) painterResource(id = tab.iconFilled)
									else painterResource(id = tab.icon),
									contentDescription = stringResource(id = tab.title)
								)
							}
						)
					}
				}
			}
		}
		HorizontalPager(
			count = tabs.size,
			state = pagerState,
		) { page ->
			when (page) {
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

//		when (state) {
//			0 -> {
//				SalinityPage(windowSize = windowSize)
//			}
//
//			1 -> {
//				AlkalinityPage(windowSize = windowSize)
//			}
//
//			2 -> {
//				TemperaturePage(windowSize = windowSize)
//			}
//
//			3 -> CarbonDioxidePage(windowSize = windowSize)
//		}
	}
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun CalculatorsTabRowPreview() {
	AquariumInformationTheme {
		CalculatorsTabRow(windowSize = WindowSizeClass.calculateFromSize(DpSize(300.dp, 400.dp)))
	}
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun CalculatorsTabRowPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		CalculatorsTabRow(windowSize = WindowSizeClass.calculateFromSize(DpSize(300.dp, 400.dp)))
	}
}