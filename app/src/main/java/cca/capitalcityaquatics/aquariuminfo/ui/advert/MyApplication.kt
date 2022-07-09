package cca.capitalcityaquatics.aquariuminfo.ui.advert

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import cca.capitalcityaquatics.aquariuminfo.R
import com.google.android.gms.ads.*
import com.google.android.gms.ads.appopen.AppOpenAd
import java.util.*

class MyApplication: Application (), Application.ActivityLifecycleCallbacks, LifecycleObserver {

    private var appOpenAdManager: AppOpenAdManager? = null
    private var currentActivity: Activity? = null

    companion object {
        private const val TAG = "MY_APPLICATION_TAG"
    }

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(this)

        MobileAds.initialize(this) {
            Log.d(TAG, "onCreate: onInitializationCompleted")
        }

        // Set your test devices. Check your logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList("6BCF308C3CD7950CD7409B0F17F762F2"))
        // to get test ads on this device."
        MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder()
                .setTestDeviceIds(listOf("6BCF308C3CD7950CD7409B0F17F762F2"))
                .build()
        )

        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
        appOpenAdManager = AppOpenAdManager()
    }

    interface OnShowAdCompletedListener {
        fun onShowAdComplete()
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onMoveToForeGround(){
        appOpenAdManager!!.showAdIfAvailable(currentActivity!!)
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        Log.d(TAG, "onActivityCreated")
    }

    override fun onActivityStarted(activity: Activity) {
        Log.d(TAG, "onActivityStarted")
        if (!appOpenAdManager!!.isShowingAd){
            currentActivity = activity
        }
    }

    override fun onActivityResumed(activity: Activity) {
        Log.d(TAG, "onActivityResumed")
    }

    override fun onActivityPaused(activity: Activity) {
        Log.d(TAG, "onActivityPaused")
    }

    override fun onActivityStopped(activity: Activity) {
        Log.d(TAG, "onActivityStopped")
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        Log.d(TAG, "onActivitySaveInstanceState")
    }

    override fun onActivityDestroyed(activity: Activity) {
        Log.d(TAG, "onActivityDestroyed")
    }

    fun showAdIfAvailable(activity: Activity, onShowAdCompletedListener: OnShowAdCompletedListener){
        appOpenAdManager!!.showAdIfAvailable(activity, onShowAdCompletedListener)
    }

    private inner class AppOpenAdManager {
        private var appOpenAd: AppOpenAd? = null
        private var isLoadingAd = false
        var isShowingAd = false

        private var loadTime: Long = 0


        private fun loadAd(
            context: Context
        ) {
            if (isLoadingAd || isAdAvailable()) {
                return
            }
            isLoadingAd = true
            val request = AdRequest.Builder().build()
            AppOpenAd.load(
                context,
                context.getString(R.string.id_app_open),
                request,
                AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT,
                object  : AppOpenAd.AppOpenAdLoadCallback(){
                    override fun onAdFailedToLoad(adError: LoadAdError){
                        super.onAdFailedToLoad(adError)
                        Log.d(TAG, "onAdFailedToLoad: ${adError.message}")
//                        Toast.makeText(context, "Failed to load AD due to ${adError.message}",
//                            Toast.LENGTH_LONG).show()
                    }

                    override fun onAdLoaded(ad: AppOpenAd) {
                        super.onAdLoaded(ad)
                        Log.d(TAG, "onAdLoaded: ")
                        appOpenAd = ad
                        isLoadingAd = false
                        loadTime = Date().time

//                        Toast.makeText(context, "AD loaded...", Toast.LENGTH_LONG).show()
                    }
                }
            )
        }

        private fun wasLoadTimeLessThanNHoursAgo (
            numHours: Long) : Boolean{
            val dateDifference = Date().time - loadTime
            val numMillisecondsPerHour: Long = 360000
            return dateDifference < numMillisecondsPerHour * numHours
        }

        private fun isAdAvailable(): Boolean{
            return appOpenAd != null && wasLoadTimeLessThanNHoursAgo( 4)
        }

        fun showAdIfAvailable (
            activity: Activity
        ){
            showAdIfAvailable(activity,
            object : OnShowAdCompletedListener {
                override fun onShowAdComplete() {
                    Log.d(TAG, "onShowAdComplete: ")
                }
            })
        }

        fun showAdIfAvailable(
            activity: Activity,
            onShowAdCompletedListener: OnShowAdCompletedListener
        ){
            if (isShowingAd){
                Log.d(TAG, "showAdIfAvailable: The app open AD is already showing...")
                return
            }
            
            if (!isAdAvailable()){
                Log.d(TAG, "showAdIfAvailable: The app open AD is not ready yet...")
                onShowAdCompletedListener.onShowAdComplete()
                loadAd(activity)
                return
            }

            appOpenAd!!.fullScreenContentCallback = object : FullScreenContentCallback(){
                override fun onAdClicked(){
                    super.onAdClicked()

                    Log.d(TAG, "onAdClicked: ")
                }

                override fun onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent()

                    Log.d(TAG, "onAdDismissedFullScreenContent: ")
                    appOpenAd = null
                    isShowingAd = false
                    onShowAdCompletedListener.onShowAdComplete()
                    loadAd(activity)
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                    super.onAdFailedToShowFullScreenContent(adError)

                    Log.d(TAG, "onAdFailedToShowFullScreenContent: ${adError.message}")
                    appOpenAd = null
                    isShowingAd = false
                    onShowAdCompletedListener.onShowAdComplete()
                    loadAd(activity)
                }

                override fun onAdImpression(){
                    super.onAdImpression()

                    Log.d(TAG, "onAdImpression: ")
                }

                override fun onAdShowedFullScreenContent() {
                    super.onAdShowedFullScreenContent()

                    Log.d(TAG, "onAdShowedFullScreenContent: ")
                }

            }

            isShowingAd = true
            appOpenAd!!.show(activity)
        }

    }

}