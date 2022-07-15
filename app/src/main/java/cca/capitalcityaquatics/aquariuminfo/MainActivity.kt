package cca.capitalcityaquatics.aquariuminfo

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import cca.capitalcityaquatics.aquariuminfo.navigation.Home
import cca.capitalcityaquatics.aquariuminfo.navigation.MainNavHost
import cca.capitalcityaquatics.aquariuminfo.navigation.bottomNavRow
import cca.capitalcityaquatics.aquariuminfo.navigation.navigateSingleTopTo
import cca.capitalcityaquatics.aquariuminfo.ui.advert.TopBannerAd
import cca.capitalcityaquatics.aquariuminfo.ui.navigation.BottomNavBar
import cca.capitalcityaquatics.aquariuminfo.ui.navigation.TopNavBar
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AppTheme
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration


class MainActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

		super.onCreate(savedInstanceState)
		setContent {
			AppTheme {

				AquariumApp()

				MobileAds.initialize(this) {}

				// Set your test devices. Check your logcat output for the hashed device ID to
				// get test ads on a physical device. e.g.
				// "Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList("6BCF308C3CD7950CD7409B0F17F762F2"))
				// to get test ads on this device."
				MobileAds.setRequestConfiguration(
					RequestConfiguration.Builder()
						.setTestDeviceIds(listOf("6BCF308C3CD7950CD7409B0F17F762F2"))
						.build()
				)
			}
		}
	}
}


@Composable
fun AquariumApp() {
	val navController = rememberNavController()
	val currentBackStack by navController.currentBackStackEntryAsState()
	val currentDestination = currentBackStack?.destination
	val currentScreen = bottomNavRow.find {
		it.route == currentDestination?.route
	} ?: Home

	//TODO Material3
	Scaffold(
		topBar = {
			Column {
				TopBannerAd()
				TopNavBar(navController)
			}
		},
		bottomBar = {
			BottomNavBar(
				allScreens = bottomNavRow,
				onTabSelected = { newScreen ->
					navController.navigateSingleTopTo(newScreen.route)
				},
				currentScreen = currentScreen
			)
		},
	) { innerPadding ->
		MainNavHost(
			navController = navController,
			modifier = Modifier
				.padding(innerPadding)
		)
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	AppTheme {
		AquariumApp()
	}
}