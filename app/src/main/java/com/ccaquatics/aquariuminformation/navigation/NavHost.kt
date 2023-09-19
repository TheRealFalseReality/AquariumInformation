package com.ccaquatics.aquariuminformation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ccaquatics.aquariuminformation.ui.pages.CalculatorsNavHostScreen
import com.ccaquatics.aquariuminformation.ui.pages.CalculatorsOverviewPage
import com.ccaquatics.aquariuminformation.ui.pages.ConvertersNavHostScreen
import com.ccaquatics.aquariuminformation.ui.pages.ConvertersOverviewPage
import com.ccaquatics.aquariuminformation.ui.pages.HomePage
import com.ccaquatics.aquariuminformation.ui.pages.InfoPage
import com.ccaquatics.aquariuminformation.ui.pages.OverviewPage
import com.ccaquatics.aquariuminformation.ui.pages.TankVolumeOverviewPage
import com.ccaquatics.aquariuminformation.ui.pages.calculators.CarbonDioxidePage
import com.ccaquatics.aquariuminformation.ui.pages.calculators.CubePage
import com.ccaquatics.aquariuminformation.ui.pages.calculators.RectanglePage
import com.ccaquatics.aquariuminformation.ui.pages.converters.AlkalinityPage
import com.ccaquatics.aquariuminformation.ui.pages.converters.SalinityPage
import com.ccaquatics.aquariuminformation.ui.pages.converters.TemperaturePage

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
					/* TODO Alter Routes */
//					navController.navigateSingleTopTo(Converters.route)
					navController.navigateSingleTopTo(Temperature.route)
				},
				onClickCo2 = {
					navController.navigateSingleTopTo(CarbonDioxide.route)
				},
				onClickSalinity =  {
					navController.navigateSingleTopTo(Salinity.route)
				},
				onClickAlkalinity = {
					navController.navigateSingleTopTo(Alkalinity.route)
				},
				onClickVolume = {
					navController.navigateSingleTopTo(TankVolume.route)
				},
				onClickFish = {

				}
			)
		}
		composable(route = Converters.route) {
			ConvertersNavHostScreen()
		}
		composable(route = Calculators.route) {
			CalculatorsNavHostScreen()
		}
		composable(route = TankVolume.route) {
			TankVolumeOverviewPage(
				onClickRectangle = {
					navController.navigateSingleTopTo(Rectangle.route)
				},
				onClickCube = {
					navController.navigateSingleTopTo(Cube.route)
				},
				onClickCylinder = {

				},
				onClickHexagonal = {

				},
				onClickBowFront = {

				},
			)
		}
		composable(route = FishCompatability.route) {

		}
		composable(route = Temperature.route) {
			TemperaturePage()
		}
		composable(route = CarbonDioxide.route) {
			CarbonDioxidePage()
		}
		composable(route = Alkalinity.route) {
			AlkalinityPage()
		}
		composable(route = Salinity.route) {
			SalinityPage()
		}
		composable(route = Rectangle.route) {
			RectanglePage()
		}
		composable(route = Cube.route) {
			CubePage()
		}
	}
}

@Composable
fun ConvertersNavHost(
	navController: NavHostController,
	modifier: Modifier = Modifier
) {
	NavHost(
		navController = navController,
		startDestination = Converters.route,
		modifier = modifier,
	) {
		composable(route = Converters.route) {
			ConvertersOverviewPage(
				onClickTemperature = {
					navController.navigateSingleTopTo(Temperature.route)
				},
				onClickSalinity = {
					navController.navigateSingleTopTo(Salinity.route)
				},
				onClickAlkalinity = {
					navController.navigateSingleTopTo(Alkalinity.route)
				},
			)
		}
		composable(route = Temperature.route) {
			TemperaturePage()
		}
		composable(route = Alkalinity.route) {
			AlkalinityPage()
		}
		composable(route = Salinity.route) {
			SalinityPage()
		}
	}
}

@Composable
fun CalculatorsNavHost(
	navController: NavHostController,
	modifier: Modifier = Modifier
) {
	NavHost(
		navController = navController,
		startDestination = Calculators.route,
		modifier = modifier,
	) {
		composable(route = Calculators.route) {
			CalculatorsOverviewPage(
				onClickCo2 = {
					navController.navigateSingleTopTo(CarbonDioxide.route)
				},
				onClickVolume = {
					navController.navigateSingleTopTo(TankVolume.route)
				},
			)
		}
		composable(route = CarbonDioxide.route) {
			CarbonDioxidePage()
		}
		composable(route = Rectangle.route) {
			RectanglePage()
		}
		composable(route = Cube.route) {
			CubePage()
		}
		composable(route = TankVolume.route) {
			TankVolumeOverviewPage(
				onClickRectangle = {
					navController.navigateSingleTopTo(Rectangle.route)
				},
				onClickCube = {
					navController.navigateSingleTopTo(Cube.route)
				},
				onClickCylinder = {

				},
				onClickHexagonal = {

				},
				onClickBowFront = {

				},
			)
		}
	}
}

//@Composable
//fun TankVolumeNavHost(
//	navController: NavHostController,
//	modifier: Modifier = Modifier
//) {
//	NavHost(
//		navController = navController,
//		startDestination = Calculators.route,
//		modifier = modifier,
//	) {
//		composable(route = Rectangle.route) {
//			RectanglePage()
//		}
//	}
//}

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

//private fun NavHostController.navigateToSingleAccount(accountType: String) {
//	this.navigateSingleTopTo("${SingleAccount.route}/$accountType")
//}