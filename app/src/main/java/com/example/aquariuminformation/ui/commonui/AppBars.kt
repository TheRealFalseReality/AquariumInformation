package com.example.aquariuminformation.ui.commonui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.aquariuminformation.R
import com.example.aquariuminformation.navigation.Home
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
						navController.navigateSingleTopTo(Home.route)
					},
			) {
				HeaderText(
					text = stringResource(id = R.string.app_name),
					color = MaterialTheme.colorScheme.onSurfaceVariant,
					style = MaterialTheme.typography.titleLarge
				)

			}
		},
		colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
			containerColor = MaterialTheme.colorScheme.surfaceVariant,
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
					contentDescription = stringResource(R.string.text_home),
				)
			}
		},
	)
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