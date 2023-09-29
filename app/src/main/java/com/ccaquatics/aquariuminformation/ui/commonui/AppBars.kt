package com.ccaquatics.aquariuminformation.ui.commonui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ccaquatics.aquariuminformation.R
import com.ccaquatics.aquariuminformation.navigation.Destinations
import com.ccaquatics.aquariuminformation.navigation.Home
import com.ccaquatics.aquariuminformation.navigation.Information
import com.ccaquatics.aquariuminformation.navigation.Overview
import com.ccaquatics.aquariuminformation.navigation.bottomNavRow
import com.ccaquatics.aquariuminformation.navigation.navigateSingleTopTo
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme

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
					text = R.string.app_name,
					color = MaterialTheme.colorScheme.onSurfaceVariant,
				)

			}
		},
		colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
			containerColor = MaterialTheme.colorScheme.surface,
			navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
			actionIconContentColor = MaterialTheme.colorScheme.onSurface
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
					painter = painterResource(id = R.drawable.ic_info_2),
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
) {
	NavigationBar {
		allScreens.forEach { screen ->
			NavigationBarItem(
				selected = currentScreen == screen,
				onClick = { onTabSelected(screen) },
				icon = {
					Icon(
						painter =
						if (currentScreen != screen) painterResource(id = screen.icon)
						else painterResource(id = screen.iconFilled),
						stringResource(id = screen.title),
						modifier = Modifier
							.size(dimensionResource(id = R.dimen.icon_size_verySmall)),
					)
				},
				label = { Text(stringResource(id = screen.title)) },
				alwaysShowLabel = false,
				colors = NavigationBarItemDefaults.colors(
					selectedTextColor = MaterialTheme.colorScheme.secondary,
					selectedIconColor = MaterialTheme.colorScheme.secondary,
					unselectedIconColor = MaterialTheme.colorScheme.primary,
					unselectedTextColor = MaterialTheme.colorScheme.primary,
				)
			)
		}
	}
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
	AquariumInformationTheme {
		AquariumAppBar(navController = rememberNavController())
	}
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun TopAppBarPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		AquariumAppBar(navController = rememberNavController())
	}
}

@Preview(showBackground = true)
@Composable
fun BottomNavBarPreview() {
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

@Preview(showBackground = true)
@Composable
fun BottomNavBarPreviewDark(
) {
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