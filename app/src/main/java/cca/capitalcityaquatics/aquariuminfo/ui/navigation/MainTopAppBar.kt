package cca.capitalcityaquatics.aquariuminfo.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.navigation.Home
import cca.capitalcityaquatics.aquariuminfo.navigation.Information
import cca.capitalcityaquatics.aquariuminfo.navigation.navigateSingleTopTo
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AppTheme

@Composable
fun TopNavBar(
	navController: NavHostController,
) {
	CenterAlignedTopAppBar(
		modifier = Modifier
			.fillMaxWidth(),
		title = {
			Text(
				text = stringResource(R.string.app_name),
				modifier = Modifier
					.clickable {
						navController.navigateSingleTopTo(Home.route)
					},
				fontSize = 18.sp
			)
		},
		colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
			containerColor = MaterialTheme.colorScheme.surfaceTint,
			navigationIconContentColor = MaterialTheme.colorScheme.primaryContainer,
			actionIconContentColor = MaterialTheme.colorScheme.primaryContainer,
			titleContentColor = MaterialTheme.colorScheme.primaryContainer,
		),
		navigationIcon = {
			IconButton(
				onClick = {
					navController.navigateSingleTopTo(Home.route)
				}
			) {
				Icon(
					painter = painterResource(id = R.drawable.myicon48),
					contentDescription = stringResource(R.string.text_home),
					modifier = Modifier
						.padding(4.dp)
				)
			}
		},
		actions = {
			IconButton(
				onClick = {
					navController.navigateSingleTopTo(Information.route)
				}
			) {
				Icon(
					painter = painterResource(id = R.drawable.information),
					contentDescription = null,
					modifier = Modifier
						.padding(4.dp)
				)
			}
		}
	)
}

@Composable
fun TopNavBarMenu(
	navController: NavHostController,
	onClick: () -> Unit
) {
	CenterAlignedTopAppBar(
		modifier = Modifier
			.fillMaxWidth(),
		title = {
			Row(
				modifier = Modifier
					.clickable {
						navController.navigateSingleTopTo(Home.route)
					},
			) {
				Text(
					text = stringResource(R.string.app_name),
					fontSize = 18.sp
				)
			}

		},
		colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
			containerColor = MaterialTheme.colorScheme.surfaceTint,
			navigationIconContentColor = MaterialTheme.colorScheme.primaryContainer,
			actionIconContentColor = MaterialTheme.colorScheme.primaryContainer,
			titleContentColor = MaterialTheme.colorScheme.primaryContainer,
		),
		navigationIcon = {
			IconButton(
				onClick = onClick,
			) {
				Icon(
					painter = painterResource(id = R.drawable.ic_baseline_menu_48),
					contentDescription = stringResource(R.string.text_home),
					modifier = Modifier
						.padding(4.dp)
				)
			}
		},
		actions = {
			IconButton(
				onClick = {
					navController.navigateSingleTopTo(Information.route)
				}
			) {
				Icon(
					painter = painterResource(id = R.drawable.myicon48),
					contentDescription = stringResource(id = R.string.text_title_info),
					modifier = Modifier
						.padding(4.dp)
				)
			}
		}
	)
}

@Preview(showBackground = true)
@Composable
fun TopAppBar1() {
	AppTheme {
		TopNavBar(rememberNavController())
	}
}

@Preview(showBackground = true)
@Composable
fun TopAppBarMenu() {
	AppTheme {
		TopNavBarMenu(rememberNavController()) {}
	}
}