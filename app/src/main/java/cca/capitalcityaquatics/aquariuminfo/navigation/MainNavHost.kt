package cca.capitalcityaquatics.aquariuminfo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cca.capitalcityaquatics.aquariuminfo.ui.appscreens.HomeScreen
import cca.capitalcityaquatics.aquariuminfo.ui.appscreens.InfoScreen
import cca.capitalcityaquatics.aquariuminfo.ui.converters.AlkalinityScreen
import cca.capitalcityaquatics.aquariuminfo.ui.converters.SalScreen

@Composable
fun MainNavHost(
	navController: NavHostController,
	modifier: Modifier = Modifier,

	) {
	NavHost(
		navController = navController,
		startDestination = Home.route,
		modifier = modifier
	) {
		composable(Home.route) {
			HomeScreen()
		}
		composable(Information.route) {
			InfoScreen()
		}
		composable(Alkalinity.route) {
			AlkalinityScreen()
		}
		composable(Salinity.route) {
			SalScreen()
		}
		composable(Converters.route) {
			ConvertNavScreen()
		}
		composable(TankVolume.route) {
			TankVolumeNavScreen()
		}
	}
}

fun NavHostController.navigateSingleTopTo(route: String) =
	this.navigate(route) { launchSingleTop = true }