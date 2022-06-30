package cca.capitalcityaquatics.aquariuminfo.billing

import android.app.Activity
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cca.capitalcityaquatics.aquariuminfo.repository.PremiumDataRepo
import com.android.billingclient.api.BillingFlowParams
import com.android.billingclient.api.ProductDetails
import com.android.billingclient.api.Purchase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class BillingViewModel (application: Application) :
    AndroidViewModel(application){
    var billingClient: BillingClientWrapper = BillingClientWrapper(application)
    private var repo: PremiumDataRepo =
        PremiumDataRepo(billingClientWrapper = billingClient)
    private val _billingConnectionState = MutableLiveData(false)
    val billingConnectionState: LiveData<Boolean> = _billingConnectionState

    private val _destinationScreen = MutableLiveData<DestinationScreen>()
    val destinationScreen: LiveData<DestinationScreen> = _destinationScreen

    // Start the billing connection when the viewModel is initialized.
    init {
        billingClient.startBillingConnection(billingConnectionState = _billingConnectionState)
    }

    // The productsForSaleFlows object combines all the Product flows into one for emission.
    val productsForSaleFlows = combine(
        repo.basicProductDetails,
        repo.premiumProductDetails
    ){
        basicProductDetails,
        premiumProductDetails
            ->
        MainState(
            basicProductDetails = basicProductDetails,
            premiumProductDetails = premiumProductDetails
        )
    }

    // The userCurrentSubscriptionFlow object combines all the possible subscription flows into one
    // for emission.
    private val userCurrentSubscriptionFlow = combine(
        repo.hasBasic,
        repo.hasPremium
    ){
        hasBasic,
        hasPremium
            ->
        MainState(
            hasBasic = hasBasic,
            hasPremium = hasPremium
        )
    }

    // Current purchases.
    val currentPurchasesFlow = repo.purchases

    init {
        viewModelScope.launch {
            userCurrentSubscriptionFlow.collectLatest { collectedSubscriptions ->
                when {
                    collectedSubscriptions.hasBasic == true -> {
                        _destinationScreen.postValue(DestinationScreen.BASIC_PROFILE_SCREEN)
                    }
                    collectedSubscriptions.hasPremium == true -> {
                        _destinationScreen.postValue(DestinationScreen.PREMIUM_PROFILE_SCREEN)
                    } else -> {
                        _destinationScreen.postValue(DestinationScreen.SUBSCRIPTIONS_OPTIONS_SCREEN)
                    }
                }
            }
        }
    }

    /**
     * BillingFlowParams Builder for normal purchases.
     *
     * @param productDetails ProductDetails object returned by the library.
     *
     * @return [BillingFlowParams] builder.
     */
    private fun billingFlowParamsBuilder(
        productDetails: ProductDetails
    ): BillingFlowParams.Builder {
        return BillingFlowParams.newBuilder().setProductDetailsParamsList(
            listOf(
                BillingFlowParams.ProductDetailsParams.newBuilder()
                    .setProductDetails(productDetails)
                    .build()
            )
        )
    }

    /**
     * Use the Google Play Billing Library to make a purchase.
     *
     * @param productDetails ProductDetails object returned by the library.
     * @param currentPurchases List of current [Purchase] objects needed for upgrades or downgrades.
     * @param billingClient Instance of [BillingClientWrapper].
     * @param activity [Activity] instance.
     */
    fun buy(
        productDetails: ProductDetails,
        activity: Activity,
    ){
        val billingParams = billingFlowParamsBuilder(
            productDetails = productDetails
        )

        billingClient.launchBillingFlow(
            activity,
            billingParams.build()
        )
    }

    // When an activity is destroyed the viewModel's onCleared is called, so we terminate the
    // billing connection.
        override fun onCleared() {
        billingClient.terminateBillingConnection()
    }

    /**
     * Enum representing the various screens a user can be redirected to.
     */

    /**
     * Enum representing the various screens a user can be redirected to.
     */
    enum class DestinationScreen {
        SUBSCRIPTIONS_OPTIONS_SCREEN,
        BASIC_PROFILE_SCREEN,
        PREMIUM_PROFILE_SCREEN,
    }

//    companion object {
//        private const val TAG: String = "MainViewModel"
//
//        private const val MAX_CURRENT_PURCHASES_ALLOWED = 1
//    }
}