package com.ccaquatics.aquariuminformation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ccaquatics.aquariuminformation.ui.pages.HomePage
import com.ccaquatics.aquariuminformation.ui.pages.InfoPage
import com.ccaquatics.aquariuminformation.ui.pages.OverviewPage
import com.ccaquatics.aquariuminformation.ui.pages.calculators.CalculatorsTabRow
import com.ccaquatics.aquariuminformation.ui.pages.compatability.CompatabilityTabRow
import com.ccaquatics.aquariuminformation.ui.pages.tankvolumes.TankVolumeTabRow

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
					navController.navigateSingleTopTo(FishCompatability.route)
				},
				onClickMarine = {
					navController.navigateSingleTopTo(FishCompatabilityMarine.route)
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
		composable(route = FishCompatability.route) {
			CompatabilityTabRow()
		}
		composable(route = FishCompatabilityMarine.route) {
			CompatabilityTabRow(selectedState = 1)
		}
		composable(route = FishCompatabilityFreshwater.route) {
			CompatabilityTabRow()
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