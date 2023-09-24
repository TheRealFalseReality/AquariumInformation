package com.ccaquatics.aquariuminformation.ui.pages.tankvolumes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
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
import com.ccaquatics.aquariuminformation.navigation.tankVolumeTabRow
import com.ccaquatics.aquariuminformation.ui.commonui.FancyIndicator

@Composable
fun TankVolumeTabRow(
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