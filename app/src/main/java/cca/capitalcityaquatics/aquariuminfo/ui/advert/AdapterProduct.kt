package cca.capitalcityaquatics.aquariuminfo.ui.advert

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import cca.capitalcityaquatics.aquariuminfo.R
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.nativead.MediaView
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdOptions
import com.google.android.gms.ads.nativead.NativeAdView

const val AD_UNIT_ID_NATIVE_AD = "ca-app-pub-3940256099942544/2247696110"

class AdapterProduct (
    val context: Context,
    val productArrayList: ArrayList<ModelProduct>,
        ) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    companion object {
         const val TAG = "PRODUCT_TAG"

        private const val VIEW_TYPE_CONTENT = 0
        private const val VIEW_TYPE_AD = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        if (viewType == VIEW_TYPE_CONTENT){
            view = LayoutInflater.from(context).inflate(R.layout.row_product, parent, false)
            return HolderProduct(view)
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.row_native_ad, parent, false)
            return HolderNativeAd(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == VIEW_TYPE_CONTENT){
            val model = productArrayList[position]
            val title = model.title
            val description = model.description
            val rating = model.rating

            val holderProduct = holder as HolderProduct
            holderProduct.titleTV.text = title
            holderProduct.descriptionTv.text = description
            holderProduct.ratingBar.rating = rating

            holder.itemView.setOnClickListener{
                Toast.makeText(context, "$title", Toast.LENGTH_SHORT).show()
            }

        } else if (getItemViewType(position) == VIEW_TYPE_AD){
            val adLoader = AdLoader.Builder(context, AD_UNIT_ID_NATIVE_AD )
                .forNativeAd { nativeAd ->
                    Log.d(TAG, "onNativeAdLoaded: ")

                    val holderNativeAd = holder as HolderNativeAd
                    displayNativeAd(holderNativeAd, nativeAd)
                }.withAdListener(object : AdListener(){
                    override fun onAdClicked() {
                        super.onAdClicked()
                        Log.d(TAG, "onAdClicked: ")
                    }

                    override fun onAdClosed() {
                        super.onAdClosed()
                        Log.d(TAG, "onAdClosed: ")
                    }

                    override fun onAdFailedToLoad(p0: LoadAdError) {
                        super.onAdFailedToLoad(p0)
                        Log.d(TAG, "onAdFailedToLoad: ${p0.message}")
                    }

                    override fun onAdImpression() {
                        super.onAdImpression()
                        Log.d(TAG, "onAdImpression: ")
                    }

                    override fun onAdLoaded() {
                        super.onAdLoaded()
                        Log.d(TAG, "onAdLoaded: ")
                    }

                    override fun onAdOpened() {
                        super.onAdOpened()
                        Log.d(TAG, "onAdOpened: ")
                    }
                })
                .withNativeAdOptions(NativeAdOptions.Builder().build()).build()
            adLoader.loadAd(AdRequest.Builder().build())
        }
    }

    private fun displayNativeAd(holderNativeAd: HolderNativeAd, nativeAd: NativeAd){
        val headline = nativeAd.headline
        val body = nativeAd.body
        val callToAction = nativeAd.callToAction
        val icon = nativeAd.icon
        val price = nativeAd.price
        val store = nativeAd.store
        val starRating = nativeAd.starRating
        val advertiser = nativeAd.advertiser
        val mediaContext = nativeAd.mediaContent

        if (headline == null){
            holderNativeAd.ad_headline.visibility = View.INVISIBLE
        } else {
            holderNativeAd.ad_headline.visibility = View.VISIBLE
            holderNativeAd.ad_headline.text = headline
        }

        if (body == null){
            holderNativeAd.ad_body.visibility = View.INVISIBLE
        } else {
            holderNativeAd.ad_body.visibility = View.VISIBLE
            holderNativeAd.ad_body.text = body
        }

        if (icon == null){
            holderNativeAd.ad_app_icon.visibility = View.INVISIBLE
        } else {
            holderNativeAd.ad_app_icon.visibility = View.VISIBLE
            holderNativeAd.ad_app_icon.setImageDrawable(icon.drawable)
        }

        if (starRating == null){
            holderNativeAd.ad_stars.visibility = View.INVISIBLE
        } else {
            holderNativeAd.ad_stars.visibility = View.VISIBLE
            holderNativeAd.ad_stars.rating = starRating.toFloat()
        }

        if (price == null){
            holderNativeAd.ad_price.visibility = View.INVISIBLE
        } else {
            holderNativeAd.ad_price.visibility = View.VISIBLE
            holderNativeAd.ad_price.text = price
        }

        if (store == null){
            holderNativeAd.ad_store.visibility = View.INVISIBLE
        } else {
            holderNativeAd.ad_store.visibility = View.VISIBLE
            holderNativeAd.ad_store.text = store
        }

        if (advertiser == null){
            holderNativeAd.ad_advertiser.visibility = View.INVISIBLE
        } else {
            holderNativeAd.ad_advertiser.visibility = View.VISIBLE
            holderNativeAd.ad_advertiser.text = advertiser
        }

        if (mediaContext == null){
            holderNativeAd.media_view.visibility = View.INVISIBLE
        } else {
            holderNativeAd.media_view.visibility = View.VISIBLE
            holderNativeAd.media_view.setImageScaleType(ImageView.ScaleType.CENTER_CROP)
            holderNativeAd.media_view.setMediaContent(mediaContext)
        }

        if (callToAction == null){
            holderNativeAd.ad_call_to_action.visibility = View.INVISIBLE
        } else {
            holderNativeAd.ad_call_to_action.visibility = View.VISIBLE
            holderNativeAd.ad_call_to_action.text = callToAction
            holderNativeAd.nativeAdView.callToActionView = holderNativeAd.ad_call_to_action
        }

        holderNativeAd.nativeAdView.setNativeAd(nativeAd)
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    override fun getItemViewType(position: Int): Int {
        if (position % 5 == 0){
            return VIEW_TYPE_AD
        } else {
            return VIEW_TYPE_CONTENT
        }
    }

    inner class HolderProduct(itemView: View): RecyclerView.ViewHolder(itemView){
        val iconIv:ImageView = itemView.findViewById(R.id.iconIv)
        val titleTV:TextView = itemView.findViewById(R.id.titleTV)
        val ratingBar:RatingBar = itemView.findViewById(R.id.ratingBar)
        val descriptionTv:TextView = itemView.findViewById(R.id.descriptionTV)
    }

    inner class HolderNativeAd (itemView: View): RecyclerView.ViewHolder(itemView){
        val ad_app_icon:ImageView = itemView.findViewById(R.id.ad_app_icon)
        val ad_headline:TextView = itemView.findViewById(R.id.ad_headline)
        val ad_advertiser:TextView = itemView.findViewById(R.id.ad_advertiser)
        val ad_stars:RatingBar = itemView.findViewById(R.id.ad_stars)
        val ad_body:TextView = itemView.findViewById(R.id.ad_body)
        val media_view:MediaView = itemView.findViewById(R.id.media_view)
        val ad_price:TextView = itemView.findViewById(R.id.ad_price)
        val ad_store:TextView = itemView.findViewById(R.id.ad_store)
        val ad_call_to_action: Button = itemView.findViewById(R.id.ad_call_to_action)
        val nativeAdView: NativeAdView = itemView.findViewById(R.id.nativeAdView)
    }
}