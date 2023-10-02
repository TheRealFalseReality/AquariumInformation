package cca.capitalcityaquatics.aquariuminfo.ui.pages.tankvolumes

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
import cca.capitalcityaquatics.aquariuminfo.navigation.tankVolumeTabRow
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FancyIndicator

@Composable
fun TankVolumeTabRowScrollable(
	windowSize: WindowSizeClass,
	selectedState: Int = 0,
	selectedColor: Color = MaterialTheme.colorScheme.secondary,
	unselectedColor: Color = MaterialTheme.colorScheme.outline,
) {
	var state by remember { mutableIntStateOf(selectedState) }
	val tabs = tankVolumeTabRow
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
									painter = painterResource(id = tab.icon),
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
									painter = painterResource(id = tab.icon),
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
				RectanglePage()
			}

			1 -> {
				CubePage()
			}

			2 -> {
				CylinderPage()
			}

			3 -> {
				HexagonalPage()
			}

			4 -> {
				BowFrontPage()
			}
		}
	}
}