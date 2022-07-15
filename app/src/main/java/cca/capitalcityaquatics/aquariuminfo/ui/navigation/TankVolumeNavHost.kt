package cca.capitalcityaquatics.aquariuminfo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cca.capitalcityaquatics.aquariuminfo.navigation.*
import cca.capitalcityaquatics.aquariuminfo.ui.tankVolume.*

@Composable
fun TankVolumeNavHost(
	navController: NavHostController,
	modifier: Modifier = Modifier
) {
	NavHost(
		navController = navController,
		startDestination = Rectangle.route,
		modifier = modifier
	) {
		composable(Rectangle.route) {
			TankVolRecScreen()
		}
		composable(Cube.route) {
			TankVolCubeScreen()
		}
		composable(Cylinder.route) {
			TankVolCylScreen()
		}
		composable(Hexagonal.route) {
			TankVolHexScreen()
		}
		composable(BowFront.route) {
			TankVolBFScreen()
		}
	}
}
