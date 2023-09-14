package com.example.aquariuminformation.ui.commonui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.aquariuminformation.R
import com.example.aquariuminformation.navigation.Destinations
import com.example.aquariuminformation.navigation.Home
import com.example.aquariuminformation.navigation.Information
import com.example.aquariuminformation.navigation.Overview
import com.example.aquariuminformation.navigation.bottomNavRow
import com.example.aquariuminformation.navigation.navigateSingleTopTo
import com.example.aquariuminformation.ui.theme.AquariumInformationTheme

@ExperimentalMaterial3Api
@Composable
fun AquariumAppBar(
	modifier: Modifier = Modifier,
	navController: NavHostController,
) {
	CenterAlignedTopAppBar(
		modifier = modifier,
		title = {
			Row(
				modifier = Modifier
					.clickable {
						navController.navigateSingleTopTo(Overview.route)
					},
			) {
				HeaderTextLarge(
					text = stringResource(id = R.string.app_name),
					color = MaterialTheme.colorScheme.onSurfaceVariant,
				)

			}
		},
		colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
			containerColor = MaterialTheme.colorScheme.background,
			navigationIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
			actionIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant
		),
		navigationIcon = {
			IconButton(
				onClick = {
					navController.navigateSingleTopTo(Home.route)
				},
			) {
				Icon(
					painter = painterResource(id = R.drawable.ic_launcher_foreground),
					contentDescription = stringResource(R.string.home),
				)
			}
		},
		actions = {
			IconButton(
				onClick = {
					navController.navigateSingleTopTo(Information.route)
				},
			) {
				Icon(
					painter = painterResource(id = R.drawable.baseline_info_24),
					contentDescription = stringResource(R.string.text_title_info),
					tint = MaterialTheme.colorScheme.onSurfaceVariant
				)
			}
		}
	)
}

@Composable
fun BottomNavBar(
	allScreens: List<Destinations>,
	onTabSelected: (Destinations) -> Unit,
	currentScreen: Destinations,
){
	NavigationBar {
		allScreens.forEach { screen ->
			NavigationBarItem(
				selected = currentScreen == screen,
				onClick = { onTabSelected(screen) },
				icon = { Icon(painter = painterResource(id = screen.icon), stringResource(id = screen.title)) },
				label = { Text(stringResource(id = screen.title)) },
				colors = NavigationBarItemDefaults.colors(
					selectedTextColor = MaterialTheme.colorScheme.secondary,
					selectedIconColor = MaterialTheme.colorScheme.secondary,
					unselectedIconColor = MaterialTheme.colorScheme.onSurface,
					unselectedTextColor = MaterialTheme.colorScheme.onSurface,
				)
			)
		}
	}
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun TopAppBarPreview(){
	AquariumInformationTheme {
		AquariumAppBar(navController = rememberNavController())
	}
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun TopAppBarPreviewDark(
){
	AquariumInformationTheme(useDarkTheme = true) {
		AquariumAppBar(navController = rememberNavController())
	}
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun BottomNavBarPreview(){
	AquariumInformationTheme {
		val navController = rememberNavController()
		val currentBackStack by navController.currentBackStackEntryAsState()
		val currentDestination = currentBackStack?.destination
		BottomNavBar(
			allScreens = bottomNavRow,
			onTabSelected = { newScreen ->
				navController.navigateSingleTopTo(newScreen.route)
			},
			currentScreen = bottomNavRow.find {
				it.route == currentDestination?.route
			} ?: Home
		)
	}
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun BottomNavBarPreviewDark(
){
	AquariumInformationTheme(useDarkTheme = true) {
		val navController = rememberNavController()
		val currentBackStack by navController.currentBackStackEntryAsState()
		val currentDestination = currentBackStack?.destination
		BottomNavBar(
			allScreens = bottomNavRow,
			onTabSelected = { newScreen ->
				navController.navigateSingleTopTo(newScreen.route)
			},
			currentScreen = bottomNavRow.find {
				it.route == currentDestination?.route
			} ?: Home
		)
	}
}