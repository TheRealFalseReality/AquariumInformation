package com.ccaquatics.aquariuminformation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ccaquatics.aquariuminformation.ui.pages.CalculatorsOverviewPage
import com.ccaquatics.aquariuminformation.ui.pages.CarbonDioxidePage
import com.ccaquatics.aquariuminformation.ui.pages.ConvertersOverviewPage
import com.ccaquatics.aquariuminformation.ui.pages.HomePage
import com.ccaquatics.aquariuminformation.ui.pages.InfoPage
import com.ccaquatics.aquariuminformation.ui.pages.OverviewPage
import com.ccaquatics.aquariuminformation.ui.pages.TankOverviewPage
import com.ccaquatics.aquariuminformation.ui.pages.TemperaturePage

@Composable
fun AquariumNavHost(
	navController: NavHostController,
	modifier: Modifier = Modifier
) {
	NavHost(
		navController = navController,
		startDestination = Home.route,
		modifier = modifier,
	){
		composable(route = Home.route) {
			HomePage()
		}
		composable(route = Information.route){
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
//			onClickSalinity: () -> Unit = {},
//			onClickAlkalinity: () -> Unit = {},
			onClickVolume = {
				navController.navigateSingleTopTo(TankVolume.route)
			},
//			onClickFish: () -> Unit = {},
			)
		}
		composable(route = Converters.route) {
			ConvertersOverviewPage(
				onClickTemperature = {
					navController.navigateSingleTopTo(Temperature.route)
				},
				onClickCo2 = {
					navController.navigateSingleTopTo(CarbonDioxide.route)
				},
//				onClickSalinity = onClickSalinity,
//				onClickAlkalinity = onClickAlkalinity
			)
		}
		composable(route = Calculators.route) {
			CalculatorsOverviewPage(
				onClickCo2 = {
					navController.navigateSingleTopTo(CarbonDioxide.route)
				},
			)
		}
		composable(route = TankVolume.route){
			TankOverviewPage()
		}
		composable(route = FishCompatability.route) {

		}
		composable(route = Temperature.route) {
			TemperaturePage()
		}
		composable(route = CarbonDioxide.route) {
			CarbonDioxidePage()
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

//private fun NavHostController.navigateToSingleAccount(accountType: String) {
//	this.navigateSingleTopTo("${SingleAccount.route}/$accountType")
//}