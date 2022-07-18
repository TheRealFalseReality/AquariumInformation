package cca.capitalcityaquatics.aquariuminfo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cca.capitalcityaquatics.aquariuminfo.ui.calculators.CarbonDioxideScreen
import cca.capitalcityaquatics.aquariuminfo.ui.converters.TempScreen

@Composable
fun ConvertNavHost(
	navController: NavHostController,
	modifier: Modifier = Modifier
) {
	NavHost(
		navController = navController,
		startDestination = Temperature.route,
		modifier = modifier
	) {
		composable(Temperature.route) {
			TempScreen()
		}
		composable(CarbonDioxide.route) {
			CarbonDioxideScreen()
		}
	}
}