package cca.capitalcityaquatics.aquariuminfo.repository

import cca.capitalcityaquatics.aquariuminfo.billing.BillingClientWrapper
import com.android.billingclient.api.ProductDetails
import com.android.billingclient.api.Purchase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

/**
 * The [PremiumDataRepo] processes and transforms the [StateFlow] data received from
 * the [BillingClientWrapper] into [Flow] data available to the viewModel.
 *
 */
class PremiumDataRepo (
    billingClientWrapper: BillingClientWrapper
){
    // Set to true when a returned purchase is Basic.
    val hasBasic: Flow<Boolean> = billingClientWrapper.purchases.map { purchaseList ->
            purchaseList.any { purchase ->
                purchase.products.contains(BASIC) && purchase.isAcknowledged
            }
    }

    // Set to true when a returned purchase is Premium.
    val hasPremium: Flow<Boolean> = billingClientWrapper.purchases.map { purchaseList ->
        purchaseList.any { purchase ->
            purchase.products.contains(PREMIUM) && purchase.isAcknowledged
        }
    }

    // ProductDetails for the Basic app.
    val basicProductDetails: Flow<ProductDetails> =
        billingClientWrapper.productWithProductDetails.filter {
            it.containsKey(
                BASIC
            )
        }.map { it[BASIC]!! }

    // ProductDetails for the Premium app.
    val premiumProductDetails: Flow<ProductDetails> =
        billingClientWrapper.productWithProductDetails.filter {
            it.containsKey(
                PREMIUM
            )
        }.map { it[PREMIUM]!! }

    // List of current purchases returned by the Google PLay Billing client library.
    val purchases: Flow<List<Purchase>> = billingClientWrapper.purchases

    // Set to true when a purchase is acknowledged.
    val isNewPurchaseAcknowledged: Flow<Boolean> = billingClientWrapper.isNewPurchaseAcknowledged

    companion object {
        // List of product offerings
        private const val BASIC = "removeads"
        private const val PREMIUM = "removeads_premium"
    }
}