package cca.capitalcityaquatics.aquariuminfo

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import cca.capitalcityaquatics.aquariuminfo.navigation.*
import cca.capitalcityaquatics.aquariuminfo.ui.advert.BannerAd
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInfoTheme
import com.google.android.gms.ads.MobileAds


class MainActivity : ComponentActivity() {

//	private lateinit var reviewManager: ReviewManager

	override fun onCreate(savedInstanceState: Bundle?) {
		window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

		super.onCreate(savedInstanceState)
		setContent {
			AquariumInfoTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
					MobileAds.initialize(this) {}

					AquariumApp()

//					init()
				}
			}
		}
	}

//	private fun init() {
//		reviewManager = ReviewManagerFactory.create(this@MainActivity)
//	}
//
//	private fun showRateDialog() {
//		val request = reviewManager.requestReviewFlow()
//		request.addOnCompleteListener { request ->
//			if (request.isSuccessful) {
//				val reviewInfo = request.result
//				val flow = reviewManager.launchReviewFlow(this@MainActivity, reviewInfo)
//				flow.addOnCompleteListener { _ ->
//					// The flow has finished. The API does not indicate whether the user
//					// reviewed or not, or even whether the review dialog was shown. Thus, no
//					// matter the result, we continue our app flow.
//				}
//			} else {
//				// There was some problem, continue regardless of the result.
//				// you can show your own rate dialog alert and redirect user to your app page
//				// on play store.
//			}
//		}
//	}
}

@Composable
fun AquariumApp() {
	val navController = rememberNavController()
	val currentBackStack by navController.currentBackStackEntryAsState()
	val currentDestination = currentBackStack?.destination
	val currentScreen = bottomNavRow.find {
		it.route == currentDestination?.route
	} ?: Home

	Scaffold(
		topBar = {
			Column {
				BannerAd()
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
	AquariumInfoTheme {
		AquariumApp()
	}
}