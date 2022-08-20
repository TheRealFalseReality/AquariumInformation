package cca.capitalcityaquatics.aquariuminfo

import android.app.Activity
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import cca.capitalcityaquatics.aquariuminfo.navigation.*
import cca.capitalcityaquatics.aquariuminfo.ui.advert.TopBannerAd
import cca.capitalcityaquatics.aquariuminfo.ui.navigation.BottomNavBar
import cca.capitalcityaquatics.aquariuminfo.ui.navigation.NavDrawer
import cca.capitalcityaquatics.aquariuminfo.ui.navigation.TopNavBarMenu
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AppTheme
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration


class MainActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

		super.onCreate(savedInstanceState)
		setContent {
			AppTheme {

				NavDrawer(mainNavDrawer)

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
				changeStatusBarColor(
					ContextCompat.getColor(
						this,
						R.color.blue_dk
					), false
				)
			}
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AquariumApp(
	onClick: () -> Unit
) {
	val navController = rememberNavController()
	val currentBackStack by navController.currentBackStackEntryAsState()
	val currentDestination = currentBackStack?.destination
	val currentScreen = bottomNavRow.find {
		it.route == currentDestination?.route
	} ?: Home

	Scaffold(
		topBar = {
			Column {
				TopBannerAd()
				TopNavBarMenu(navController, onClick)
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

fun Activity.changeStatusBarColor(color: Int, isLight: Boolean) {
	window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
	window.statusBarColor = color

	WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = isLight
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	AppTheme {
		NavDrawer(mainNavDrawer)
	}
}