package cca.capitalcityaquatics.aquariuminfo.ui.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cca.capitalcityaquatics.aquariuminfo.navigation.Destinations

@Composable
fun BottomNavBar(
	allScreens: List<Destinations>,
	onTabSelected: (Destinations) -> Unit,
	currentScreen: Destinations
) {
	NavBar(
		content = {
			allScreens.forEach { screen ->
				NavTab(
					text = screen.title,
					icon = screen.icon,
					onSelected = { onTabSelected(screen) },
					selected = currentScreen == screen,
					color = MaterialTheme.colorScheme.onPrimary,
					colorSelected = MaterialTheme.colorScheme.tertiaryContainer
				)
			}
		},
		color = MaterialTheme.colorScheme.surfaceTint
	)
}