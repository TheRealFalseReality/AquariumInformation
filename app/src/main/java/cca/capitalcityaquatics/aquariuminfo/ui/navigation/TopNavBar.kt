package cca.capitalcityaquatics.aquariuminfo.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.navigation.Home
import cca.capitalcityaquatics.aquariuminfo.navigation.Information
import cca.capitalcityaquatics.aquariuminfo.navigation.navigateSingleTopTo

@Composable
fun TopNavBar(
	navController: NavHostController,
) {
	TopAppBar(
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
		backgroundColor = MaterialTheme.colorScheme.inverseSurface,
		contentColor = MaterialTheme.colorScheme.primaryContainer,
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