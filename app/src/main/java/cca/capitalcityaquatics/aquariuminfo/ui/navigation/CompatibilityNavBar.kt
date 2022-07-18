package cca.capitalcityaquatics.aquariuminfo.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import cca.capitalcityaquatics.aquariuminfo.navigation.*
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompatibilityNavScreen() {
	val navController = rememberNavController()
	val currentBackStack by navController.currentBackStackEntryAsState()
	val currentDestination = currentBackStack?.destination
	val currentScreen = compatibilityNavRow.find {
		it.route == currentDestination?.route
	} ?: FishCompat

	Scaffold(
		bottomBar = {
			CompatibilityBottomNavBar(
				allScreens = compatibilityNavRow,
				currentScreen = currentScreen,
				onTabSelected = { newScreen ->
					navController.navigateSingleTopTo(newScreen.route)
				},
			)
		},
	) { innerPadding ->
		CompatibilityNavHost(
			navController = navController,
			modifier = Modifier
				.padding(innerPadding)
		)
	}
}

@Composable
fun CompatibilityBottomNavBar(
	allScreens: List<Destinations>,
	onTabSelected: (Destinations) -> Unit,
	currentScreen: Destinations
) {
	NavBarCenter(
		content = {
			allScreens.forEach { screen ->
				NavTab(
					text = screen.title,
					icon = screen.icon,
					selected = currentScreen == screen,
					onSelected = { onTabSelected(screen) },
					color = MaterialTheme.colorScheme.onSecondary,
					colorSelected = MaterialTheme.colorScheme.tertiaryContainer
				)
			}
		},
		color = MaterialTheme.colorScheme.secondary
	)
}

@Preview(showBackground = true)
@Composable
fun CompatibilityPreview() {
	AppTheme {
		CompatibilityNavScreen()
	}
}