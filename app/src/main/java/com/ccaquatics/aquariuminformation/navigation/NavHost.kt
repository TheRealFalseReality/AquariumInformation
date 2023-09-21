package com.ccaquatics.aquariuminformation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ccaquatics.aquariuminformation.ui.pages.CalculatorsOverviewPage
import com.ccaquatics.aquariuminformation.ui.pages.ConvertersOverviewPage
import com.ccaquatics.aquariuminformation.ui.pages.HomePage
import com.ccaquatics.aquariuminformation.ui.pages.InfoPage
import com.ccaquatics.aquariuminformation.ui.pages.OverviewPage
import com.ccaquatics.aquariuminformation.ui.pages.TankVolumeOverviewPage
import com.ccaquatics.aquariuminformation.ui.pages.calculators.BowFrontPage
import com.ccaquatics.aquariuminformation.ui.pages.calculators.CarbonDioxidePage
import com.ccaquatics.aquariuminformation.ui.pages.calculators.CubePage
import com.ccaquatics.aquariuminformation.ui.pages.calculators.CylinderPage
import com.ccaquatics.aquariuminformation.ui.pages.calculators.HexagonalPage
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
		/* TODO Alter Routes */
		composable(route = Home.route) {
			HomePage()
		}
		composable(route = Information.route) {
			InfoPage()
		}
		composable(route = Overview.route) {
			OverviewPage(
				onClickTemperature = {
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
					/* TODO */
				}
			)
		}
		composable(route = Converters.route) {

			ConvertersNavHostScreen()
//			ConvertersOverviewPage(
//				onClickTemperature = {
//					navController.navigateSingleTopTo(Temperature.route)
//				},
//				onClickSalinity = {
//					navController.navigateSingleTopTo(Salinity.route)
//				},
//				onClickAlkalinity = {
//					navController.navigateSingleTopTo(Alkalinity.route)
//				},
//			)
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
					navController.navigateSingleTopTo(Cylinder.route)
				},
				onClickHexagonal = {
					navController.navigateSingleTopTo(Hexagonal.route)
				},
				onClickBowFront = {
					navController.navigateSingleTopTo(BowFront.route)
				},
			)
		}
		composable(route = FishCompatability.route) {
			/* TODO */
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
		composable(route = Hexagonal.route) {
			HexagonalPage()
		}
		composable(route = Cylinder.route) {
			CylinderPage()
		}
		composable(route = BowFront.route) {
			BowFrontPage()
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
		composable(route = Hexagonal.route) {
			HexagonalPage()
		}
		composable(route = Cylinder.route) {
			CylinderPage()
		}
		composable(route = BowFront.route) {
			BowFrontPage()
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
					navController.navigateSingleTopTo(Cylinder.route)
				},
				onClickHexagonal = {
					navController.navigateSingleTopTo(Hexagonal.route)
				},
				onClickBowFront = {
					navController.navigateSingleTopTo(BowFront.route)
				},
			)
		}
	}
}

@Composable
fun ConvertersNavHostScreen(

) {
	val navController = rememberNavController()
	ConvertersNavHost(navController = navController)
}

@Composable
		/* TODO Add Tank Volumes ALL */
fun CalculatorsNavHostScreen() {
	val navController = rememberNavController()
	CalculatorsNavHost(navController = navController)
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