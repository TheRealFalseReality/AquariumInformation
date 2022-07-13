package cca.capitalcityaquatics.aquariuminfo.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun TankVolumeNavScreen() {
	val navController = rememberNavController()
	val currentBackStack by navController.currentBackStackEntryAsState()
	val currentDestination = currentBackStack?.destination
	val currentScreen = tankVolumeNavRow.find {
		it.route == currentDestination?.route
	} ?: Rectangle

	Scaffold(
		bottomBar = {
			TankVolumeBottomNavBar(
				allScreens = tankVolumeNavRow,
				currentScreen = currentScreen,
				onTabSelected = { newScreen ->
					navController.navigateSingleTopTo(newScreen.route)
				},
			)
		},
	) { innerPadding ->
		TankVolumeNavHost(
			navController = navController,
			modifier = Modifier
				.padding(innerPadding)
		)
	}
}

@Composable
fun TankVolumeBottomNavBar(
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
					color = MaterialTheme.colors.onPrimary,
					colorSelected = MaterialTheme.colors.primaryVariant
				)
			}
		},
		color = MaterialTheme.colors.secondary
	)
}

@Preview(showBackground = true)
@Composable
fun TankVolPreview() {
	TankVolumeNavScreen()
}