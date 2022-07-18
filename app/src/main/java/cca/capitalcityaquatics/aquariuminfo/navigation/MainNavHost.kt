package cca.capitalcityaquatics.aquariuminfo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cca.capitalcityaquatics.aquariuminfo.ui.appscreens.InfoScreen
import cca.capitalcityaquatics.aquariuminfo.ui.converters.AlkalinityScreen
import cca.capitalcityaquatics.aquariuminfo.ui.converters.SalScreen
import cca.capitalcityaquatics.aquariuminfo.ui.navigation.CompatibilityNavScreen
import cca.capitalcityaquatics.aquariuminfo.ui.navigation.ConvertNavScreen
import cca.capitalcityaquatics.aquariuminfo.ui.navigation.TankVolumeNavScreen

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
			CompatibilityNavScreen()
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
		composable(FishCompat.route) {
			CompatibilityNavScreen()
		}
	}
}

fun NavHostController.navigateSingleTopTo(route: String) =
	this.navigate(route) { launchSingleTop = true }