package cca.capitalcityaquatics.aquariuminfo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cca.capitalcityaquatics.aquariuminfo.ui.calculators.CarbonDioxideScreen
import cca.capitalcityaquatics.aquariuminfo.ui.compatibility.FreshwaterScreen

@Composable
fun CompatibilityNavHost(
	navController: NavHostController,
	modifier: Modifier = Modifier
) {
	NavHost(
		navController = navController,
		startDestination = FishCompatFresh.route,
		modifier = modifier
	) {
		composable(FishCompatFresh.route) {
			FreshwaterScreen()
		}
		composable(FishCompatMarine.route) {
			CarbonDioxideScreen()
		}
	}
}