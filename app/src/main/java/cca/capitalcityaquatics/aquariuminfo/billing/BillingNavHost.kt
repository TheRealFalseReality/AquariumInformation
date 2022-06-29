package cca.capitalcityaquatics.aquariuminfo.billing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import cca.capitalcityaquatics.aquariuminfo.Constants.BASIC_PLANS_TAG
import cca.capitalcityaquatics.aquariuminfo.Constants.PREMIUM_PLANS_TAG
import cca.capitalcityaquatics.aquariuminfo.MainActivity
import cca.capitalcityaquatics.aquariuminfo.R

@Composable
fun BillingScreen(){
    BillingNavHost(viewModel = viewModel(), activity = MainActivity())
}

@Composable
fun BillingNavHost(viewModel: BillingViewModel, activity:MainActivity) {
    // State variable passed into Billing connection call and set to true when
    // connections is established.
    val isBillingConnected by viewModel.billingConnectionState.observeAsState()

    if (isBillingConnected == false) {
        // When false connection to the billing library is not established yet,
        // so a loading screen is rendered.
        LoadingScreen()
    } else {
        // When true connection to the billing library is established,
        // so the subscription composables are rendered.
        val navController = rememberNavController()

        // Collect available products to sale Flows from MainViewModel.
        val productsForSale by viewModel.productsForSaleFlows.collectAsState(
            initial = MainState()
        )

        // Collect current purchases Flows from MainViewModel.
        val currentPurchases by viewModel.currentPurchasesFlow.collectAsState(
            initial = listOf()
        )

        // Observe the ViewModel's destinationScreen object for changes in subscription status.
        val screen by viewModel.destinationScreen.observeAsState()

        // Load UI based on user's current subscription.
        when (screen) {
            // User has a Basic the corresponding profile is loaded.
            BillingViewModel.DestinationScreen.BASIC_PROFILE_SCREEN -> {
                UserProfile(
                    buttonModels =
                    listOf(
                        ButtonModel(R.string.topup_message) {
                            productsForSale.basicProductDetails?.let {
                                viewModel.buy(
                                    productDetails = it,
                                    currentPurchases = null,
                                    tag = BASIC_PLANS_TAG,
                                    activity = activity
                                )
                            }
                        },
                    ),
                    tag = BASIC_PLANS_TAG,
                    profileTextStringResource = null
                )
            }

            BillingViewModel.DestinationScreen.PREMIUM_PROFILE_SCREEN -> {
                UserProfile(
                    buttonModels =
                    listOf(
                        ButtonModel(R.string.topup_message) {
                            productsForSale.basicProductDetails?.let {
                                viewModel.buy(
                                    productDetails = it,
                                    currentPurchases = null,
                                    tag = PREMIUM_PLANS_TAG,
                                    activity = activity
                                )
                            }
                        },
                    ),
                    tag = PREMIUM_PLANS_TAG,
                    profileTextStringResource = null
                )
            }

            // User has no current subscription - the subscription composable
            // is loaded.
            BillingViewModel.DestinationScreen.SUBSCRIPTIONS_OPTIONS_SCREEN -> {
                SubscriptionNavigationComponent(
                    productsForSale = productsForSale,
                    navController = navController,
                    viewModel = viewModel
                )
            }
        }
    }
}