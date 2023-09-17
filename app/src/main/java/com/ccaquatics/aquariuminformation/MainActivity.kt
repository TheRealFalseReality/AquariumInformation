package com.ccaquatics.aquariuminformation

import android.app.Activity
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ccaquatics.aquariuminformation.navigation.AquariumNavHost
import com.ccaquatics.aquariuminformation.navigation.Home
import com.ccaquatics.aquariuminformation.navigation.bottomNavRow
import com.ccaquatics.aquariuminformation.navigation.navigateSingleTopTo
import com.ccaquatics.aquariuminformation.ui.commonui.AquariumAppBar
import com.ccaquatics.aquariuminformation.ui.commonui.BottomNavBar
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme
import com.example.aquariuminformation.R

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
		super.onCreate(savedInstanceState)
		setContent {
			AquariumInformationTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.surface
				) {
					AquariumInfoApp()

					changeStatusBarColor(
						ContextCompat.getColor(
							this,
							R.color.status_bar
						), false
					)
				}
			}
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AquariumInfoApp() {
	val navController = rememberNavController()
	val currentBackStack by navController.currentBackStackEntryAsState()
	val currentDestination = currentBackStack?.destination
	val currentScreen = bottomNavRow.find {
		it.route == currentDestination?.route
	} ?: Home

	Scaffold(
		topBar = {
			AquariumAppBar(navController = navController)
		},
		bottomBar = {
			BottomNavBar(
				allScreens = bottomNavRow,
				onTabSelected = { newScreen ->
					navController.navigateSingleTopTo(newScreen.route)
				},
				currentScreen = currentScreen,
			)
		}
	) { innerPadding ->
		AquariumNavHost(
			navController = navController,
			modifier = Modifier.padding(innerPadding)
		)
	}
}

fun Activity.changeStatusBarColor(color: Int, isLight: Boolean) {
	window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
	window.statusBarColor = color

	WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = isLight
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.fillMaxSize()
				.background(color = MaterialTheme.colorScheme.surface)
		) {
			AquariumInfoApp()
		}
	}
}

@Preview(showBackground = true)
@Composable
fun AppDarkPreview() {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.fillMaxSize()
				.background(color = MaterialTheme.colorScheme.surface)
		) {
			AquariumInfoApp()
		}
	}
}