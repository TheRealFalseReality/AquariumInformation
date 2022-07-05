package cca.capitalcityaquatics.aquariuminfo

import android.os.Bundle
import android.util.Log
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
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

const val AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712"

class MainActivity : ComponentActivity() {

    private var mInterstitialAd: InterstitialAd? = null
    private var TAG = "MainActivity"

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

                    AquariumApp()

                    // Initialize the Mobile Ads SDK.
                    MobileAds.initialize(this) {}

                    // Set your test devices. Check your logcat output for the hashed device ID to
                    // get test ads on a physical device. e.g.
                    // "Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(""))
                    // to get test ads on this device."
                    MobileAds.setRequestConfiguration(
                        RequestConfiguration.Builder()
                            .setTestDeviceIds(listOf("6BCF308C3CD7950CD7409B0F17F762F2"))
                            .build()
                    )

                    var adRequest = AdRequest.Builder().build()

                    InterstitialAd.load(this, AD_UNIT_ID,
                        adRequest, object : InterstitialAdLoadCallback() {
                            override fun onAdFailedToLoad(adError: LoadAdError) {
                                Log.d(TAG, adError?.toString())
                                mInterstitialAd = null
                            }

                            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                                Log.d(TAG, "Ad was loaded.")
                                mInterstitialAd = interstitialAd
                            }
                        }
                    )

                    if (mInterstitialAd != null) {
                        mInterstitialAd?.show(this)
                        mInterstitialAd?.fullScreenContentCallback =
                            object: FullScreenContentCallback() {
                                override fun onAdClicked() {
                                    // Called when a click is recorded for an ad.
                                    Log.d(TAG, "Ad was clicked.")
                                }

                                override fun onAdDismissedFullScreenContent() {
                                    // Called when ad is dismissed.
                                    Log.d(TAG, "Ad dismissed fullscreen content.")
                                    mInterstitialAd = null
                                }

                                override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                                    // Called when ad fails to show.
                                    Log.e(TAG, "Ad failed to show fullscreen content.")
                                    mInterstitialAd = null
                                }

                                override fun onAdImpression() {
                                    // Called when an impression is recorded for an ad.
                                    Log.d(TAG, "Ad recorded an impression.")
                                }

                                override fun onAdShowedFullScreenContent() {
                                    // Called when ad is shown.
                                    Log.d(TAG, "Ad showed fullscreen content.")
                                }
                            }
                    } else {
                        Log.d("TAG", "The interstitial ad wasn't ready yet.")
                    }

                }
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

    Scaffold(
        topBar = {
            Column{
                BannerAd()
                TopNavBar (navController)
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