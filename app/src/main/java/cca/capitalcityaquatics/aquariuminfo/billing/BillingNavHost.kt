package cca.capitalcityaquatics.aquariuminfo.billing

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.compose.rememberNavController
import cca.capitalcityaquatics.aquariuminfo.Constants
import cca.capitalcityaquatics.aquariuminfo.MainActivity
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.ui.ButtonModel
import cca.capitalcityaquatics.aquariuminfo.ui.MainState
import cca.capitalcityaquatics.aquariuminfo.ui.MainViewModel
import cca.capitalcityaquatics.aquariuminfo.ui.composable.LoadingScreen
import cca.capitalcityaquatics.aquariuminfo.ui.composable.SubscriptionNavigationComponent
import cca.capitalcityaquatics.aquariuminfo.ui.composable.UserProfile

@Composable
fun BillingNavHost(
    viewModel: MainViewModel,
    activity: MainActivity
) {
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
            // User has a Basic Prepaid subscription
            // the corresponding profile is loaded.
            MainViewModel.DestinationScreen.BASIC_PROFILE_SCREEN -> {
                UserProfile(
                    buttonModels =
                    listOf(
                        ButtonModel(R.string.topup_message) {
                            productsForSale.basicProductDetails?.let {
                                viewModel.buy(
                                    productDetails = it,
                                    currentPurchases = null,
                                    tag = Constants.PREPAID_BASIC_PLANS_TAG,
                                    activity = activity
                                )
                            }
                        },
                        ButtonModel(R.string.convert_to_basic_monthly_message) {
                            productsForSale.basicProductDetails?.let {
                                viewModel.buy(
                                    productDetails = it,
                                    currentPurchases = currentPurchases,
                                    tag = Constants.MONTHLY_BASIC_PLANS_TAG,
                                    activity = activity
                                )
                            }
                        },
                        ButtonModel(R.string.convert_to_basic_yearly_message) {
                            productsForSale.basicProductDetails?.let {
                                viewModel.buy(
                                    productDetails = it,
                                    currentPurchases = currentPurchases,
                                    tag = Constants.YEARLY_BASIC_PLANS_TAG,
                                    activity = activity
                                )
                            }
                        },
                    ),
                    tag = Constants.PREPAID_BASIC_PLANS_TAG,
                    profileTextStringResource = null
                )
            }
            // User has a renewable basic subscription
            // the corresponding profile is loaded.
            MainViewModel.DestinationScreen.BASIC_PROFILE -> {
                UserProfile(
                    buttonModels =
                    listOf(
                        ButtonModel(R.string.monthly_premium_upgrade_message) {
                            productsForSale.premiumProductDetails?.let {
                                viewModel.buy(
                                    productDetails = it,
                                    currentPurchases = currentPurchases,
                                    tag = Constants.MONTHLY_PREMIUM_PLANS_TAG,
                                    activity = activity
                                )
                            }
                        },
                        ButtonModel(R.string.yearly_premium_upgrade_message) {
                            productsForSale.premiumProductDetails?.let {
                                viewModel.buy(
                                    productDetails = it,
                                    currentPurchases = currentPurchases,
                                    tag = Constants.YEARLY_PREMIUM_PLANS_TAG,
                                    activity = activity
                                )
                            }
                        },
                        ButtonModel(R.string.prepaid_premium_upgrade_message) {
                            productsForSale.premiumProductDetails?.let {
                                viewModel.buy(
                                    productDetails = it,
                                    currentPurchases = currentPurchases,
                                    tag = Constants.PREPAID_PREMIUM_PLANS_TAG,
                                    activity = activity
                                )
                            }
                        }
                    ),
                    tag = null,
                    profileTextStringResource = R.string.basic_sub_message
                )
            }
            // User has a prepaid Premium subscription
            // the corresponding profile is loaded.
            MainViewModel.DestinationScreen.PREMIUM_PROFILE_SCREEN -> {
                UserProfile(
                    buttonModels =
                    listOf(
                        ButtonModel(R.string.topup_message) {
                            productsForSale.premiumProductDetails?.let {
                                viewModel.buy(
                                    productDetails = it,
                                    currentPurchases = null,
                                    tag = Constants.PREPAID_PREMIUM_PLANS_TAG,
                                    activity = activity
                                )
                            }
                        },
                        ButtonModel(R.string.convert_to_premium_monthly_message) {
                            productsForSale.premiumProductDetails?.let {
                                viewModel.buy(
                                    productDetails = it,
                                    currentPurchases = currentPurchases,
                                    tag = Constants.MONTHLY_PREMIUM_PLANS_TAG,
                                    activity = activity
                                )
                            }
                        },
                        ButtonModel(R.string.convert_to_premium_yearly_message) {
                            productsForSale.premiumProductDetails?.let {
                                viewModel.buy(
                                    productDetails = it,
                                    currentPurchases = currentPurchases,
                                    tag = Constants.YEARLY_PREMIUM_PLANS_TAG,
                                    activity = activity
                                )
                            }
                        },
                    ),
                    tag = Constants.PREPAID_PREMIUM_PLANS_TAG,
                    profileTextStringResource = null
                )
            }
            // User has a renewable Premium subscription
            // the corresponding profile is loaded.
            MainViewModel.DestinationScreen.PREMIUM_PROFILE -> {
                UserProfile(
                    listOf(
                        ButtonModel(R.string.monthly_basic_downgrade_message) {
                            productsForSale.basicProductDetails?.let {
                                viewModel.buy(
                                    productDetails = it,
                                    currentPurchases = currentPurchases,
                                    tag = Constants.MONTHLY_BASIC_PLANS_TAG,
                                    activity = activity
                                )
                            }
                        },
                        ButtonModel(R.string.yearly_basic_downgrade_message) {
                            productsForSale.basicProductDetails?.let {
                                viewModel.buy(
                                    productDetails = it,
                                    currentPurchases = currentPurchases,
                                    tag = Constants.YEARLY_BASIC_PLANS_TAG,
                                    activity = activity
                                )
                            }
                        },
                        ButtonModel(R.string.prepaid_basic_downgrade_message) {
                            productsForSale.basicProductDetails?.let {
                                viewModel.buy(
                                    productDetails = it,
                                    currentPurchases = currentPurchases,
                                    tag = Constants.PREPAID_BASIC_PLANS_TAG,
                                    activity = activity
                                )
                            }
                        }
                    ),
                    tag = null,
                    profileTextStringResource = R.string.premium_sub_message
                )
            }
            // User has no current subscription - the subscription composable
            // is loaded.
            MainViewModel.DestinationScreen.SUBSCRIPTIONS_OPTIONS_SCREEN -> {
                SubscriptionNavigationComponent(
                    productsForSale = productsForSale,
                    navController = navController,
                    viewModel = viewModel
                )
            }
        }
    }
}