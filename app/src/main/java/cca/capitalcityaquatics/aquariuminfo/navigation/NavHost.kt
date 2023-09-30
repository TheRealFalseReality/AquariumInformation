package cca.capitalcityaquatics.aquariuminfo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cca.capitalcityaquatics.aquariuminfo.ui.pages.HomePage
import cca.capitalcityaquatics.aquariuminfo.ui.pages.InfoPage
import cca.capitalcityaquatics.aquariuminfo.ui.pages.OverviewPage
import cca.capitalcityaquatics.aquariuminfo.ui.pages.calculators.CalculatorsTabRow
import cca.capitalcityaquatics.aquariuminfo.ui.pages.compatability.CompatibilityTabRow
import cca.capitalcityaquatics.aquariuminfo.ui.pages.tankvolumes.TankVolumeTabRow

@Composable
fun AquariumNavHost(
	navController: NavHostController,
	modifier: Modifier = Modifier
) {
	NavHost(
		navController = navController,
		startDestination = Overview.route,
		modifier = modifier,
	) {
		composable(route = Home.route) {
			HomePage()
		}
		composable(route = Information.route) {
			InfoPage()
		}
		composable(route = Overview.route) {
			OverviewPage(
				onClickTemperature = {
					navController.navigateSingleTopTo(Temperature.route)
				},
				onClickCo2 = {
					navController.navigateSingleTopTo(CarbonDioxide.route)
				},
				onClickSalinity = {
					navController.navigateSingleTopTo(Calculators.route)
				},
				onClickAlkalinity = {
					navController.navigateSingleTopTo(Alkalinity.route)
				},
				onClickFreshwater = {
					navController.navigateSingleTopTo(FishCompatibility.route)
				},
				onClickMarine = {
					navController.navigateSingleTopTo(FishCompatibilityMarine.route)
				},
				onClickRectangle = {
					navController.navigateSingleTopTo((TankVolume.route))
				},
				onClickCube = {
					navController.navigateSingleTopTo(Cube.route)
				},
				onClickCylinder = {
					navController.navigateSingleTopTo(Cylinder.route)
				},
				onClickHexagonal = {
					navController.navigateSingleTopTo(Hexagonal.route)
				},
				onClickBowFront = {
					navController.navigateSingleTopTo(BowFront.route)
				}
			)
		}
		composable(route = Converters.route) {
			CalculatorsTabRow()
		}
		composable(route = Calculators.route) {
			CalculatorsTabRow()
		}
		composable(route = TankVolume.route) {
			TankVolumeTabRow()
		}
		composable(route = FishCompatibility.route) {
			CompatibilityTabRow()
		}
		composable(route = FishCompatibilityMarine.route) {
			CompatibilityTabRow(selectedState = 1)
		}
		composable(route = FishCompatibilityFreshwater.route) {
			CompatibilityTabRow()
		}
		composable(route = Temperature.route) {
			CalculatorsTabRow(selectedState = 2)
		}
		composable(route = CarbonDioxide.route) {
			CalculatorsTabRow(selectedState = 3)
		}
		composable(route = Alkalinity.route) {
			CalculatorsTabRow(selectedState = 1)
		}
		composable(route = Salinity.route) {
			CalculatorsTabRow()
		}
		composable(route = Rectangle.route) {
			TankVolumeTabRow()
		}
		composable(route = Cube.route) {
			TankVolumeTabRow(selectedState = 1)
		}
		composable(route = Hexagonal.route) {
			TankVolumeTabRow(selectedState = 3)
		}
		composable(route = Cylinder.route) {
			TankVolumeTabRow(selectedState = 2)
		}
		composable(route = BowFront.route) {
			TankVolumeTabRow(selectedState = 4)
		}
	}
}

fun NavHostController.navigateSingleTopTo(route: String) =
	this.navigate(route) {
		popUpTo(
			this@navigateSingleTopTo.graph.findStartDestination().id
		) {
			saveState = true
		}
		launchSingleTop = true
		restoreState = true
	}