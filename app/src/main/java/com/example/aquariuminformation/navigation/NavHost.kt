package com.example.aquariuminformation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aquariuminformation.ui.pages.HomePage
import com.example.aquariuminformation.ui.pages.InfoPage
import com.example.aquariuminformation.ui.pages.OverviewPage

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
			OverviewPage()
		}
		composable(route = Temperature.route) {

		}
		composable(route = CarbonDioxide.route) {

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