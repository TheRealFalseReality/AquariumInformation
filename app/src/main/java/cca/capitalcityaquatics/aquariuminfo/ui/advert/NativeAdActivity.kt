package cca.capitalcityaquatics.aquariuminfo.ui.advert

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import cca.capitalcityaquatics.aquariuminfo.R
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration

class NativeAdActivity : AppCompatActivity() {

    private companion object{
        private const val TAG = "NATIVE_AD_TAG"
    }

    private lateinit var productsRv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_native_adactivity)

        title = getString(R.string.text_native_ad2)

        productsRv = findViewById(R.id.productsRv)

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

        loadProducts()

    }

    private fun loadProducts(){
        val titles = arrayListOf(
            "Android 1.0",
            "Android 1.1"
        )

        val descriptions = arrayOf(
            "Android Alpha - September 23, 2008",
            "Android Beta - February 9, 2009"
        )

        val productsArrayList = ArrayList<ModelProduct>()
        for (i in titles.indices){
            val model = ModelProduct(R.drawable.ic_android_black, titles[i], descriptions[i], 3.6f)
            productsArrayList.add(model)
        }

        val adapterProduct = AdapterProduct(this, productsArrayList)
        productsRv.adapter = adapterProduct

    }
}