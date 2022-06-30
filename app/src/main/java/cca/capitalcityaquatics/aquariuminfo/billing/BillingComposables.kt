package cca.capitalcityaquatics.aquariuminfo.billing

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cca.capitalcityaquatics.aquariuminfo.MainActivity
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.billing.Constants.BASIC_BASE_PLANS_ROUTE
import cca.capitalcityaquatics.aquariuminfo.billing.Constants.BASIC_PLANS_TAG
import cca.capitalcityaquatics.aquariuminfo.billing.Constants.PREMIUM_BASE_PLANS_ROUTE
import cca.capitalcityaquatics.aquariuminfo.billing.Constants.PREMIUM_PLANS_TAG
import cca.capitalcityaquatics.aquariuminfo.billing.Constants.SUBSCRIPTION_ROUTE

@Composable
fun BillingScreen(
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier
            .padding(start = 24.dp, end = 24.dp, top = 24.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Card(
            backgroundColor = MaterialTheme.colors.primary,
            modifier = Modifier
                .padding(bottom = 86.dp)
                .fillMaxHeight()
                .fillMaxWidth()
                .border(
                    BorderStroke(2.dp, MaterialTheme.colors.primaryVariant),
                    shape = RoundedCornerShape(4.dp)
                )
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .padding(14.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                BillingNavHost(viewModel = viewModel(), activity = MainActivity())

            }
        }
    }
}

@Composable
fun LoadingScreen() {
    CenteredSurfaceColumn {
        Text(
            text = stringResource(id = R.string.loading_message),
            style = MaterialTheme.typography.h1,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun CenteredSurfaceColumn(
    content: @Composable ColumnScope.() -> Unit
) {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            content()
        }
    }
}

@Composable
fun SubscriptionNavigationComponent(
    productsForSale: MainState,
    navController: NavHostController,
    viewModel: BillingViewModel
) {
    NavHost(
        navController = navController,
        startDestination = stringResource(id = R.string.subscription_composable_name)
    ) {
        composable(route = SUBSCRIPTION_ROUTE) {
            Subscription(
                navController = navController,
            )
        }
        composable(route = BASIC_BASE_PLANS_ROUTE) {
            BasicBasePlans(
                productsForSale = productsForSale,
                viewModel = viewModel
            )
        }
        composable(route = PREMIUM_BASE_PLANS_ROUTE) {
            PremiumBasePlans(
                productsForSale = productsForSale,
                viewModel = viewModel
            )
        }
    }
}

@Composable
private fun Subscription(
    navController: NavHostController,
) {
    CenteredSurfaceColumn {
        val buttonModels = remember(navController) {
            listOf(
                ButtonModel(R.string.basic_sub_text) {
                    navController.navigate(route = BASIC_BASE_PLANS_ROUTE)
                },
                ButtonModel(R.string.premium_sub_text) {
                    navController.navigate(route = PREMIUM_BASE_PLANS_ROUTE)
                }
            )
        }
        ButtonGroup(buttonModels = buttonModels)
    }
}

@Composable
private fun BasicBasePlans(
    productsForSale: MainState,
    viewModel: BillingViewModel,
) {
    val context = LocalContext.current
    val activity = context.findActivity()
    CenteredSurfaceColumn {
        val buttonModels = remember(productsForSale, viewModel, activity) {
            listOf(
                ButtonModel(R.string.monthly_basic_sub_text) {
                    productsForSale.basicProductDetails?.let {
                        viewModel.buy(
                            productDetails = it,
                            currentPurchases = null,
                            tag = BASIC_PLANS_TAG,
                            activity = activity
                        )
                    }
                }
            )
        }
        ButtonGroup(buttonModels = buttonModels)
    }
}

@Composable
private fun PremiumBasePlans(
    productsForSale: MainState,
    viewModel: BillingViewModel,
) {
    val context = LocalContext.current
    val activity = context.findActivity()
    CenteredSurfaceColumn {
        val buttonModels = remember(productsForSale, viewModel, activity) {
            listOf(
                ButtonModel(R.string.monthly_premium_sub_text) {
                    productsForSale.premiumProductDetails?.let {
                        viewModel.buy(
                            productDetails = it,
                            currentPurchases = null,
                            tag = PREMIUM_PLANS_TAG,
                            activity = activity
                        )
                    }
                }
            )
        }
        ButtonGroup(buttonModels = buttonModels)
    }
}

@Composable
fun UserProfile(
    buttonModels: List<ButtonModel>,
    tag: String?,
    profileTextStringResource: Int?
) {
    CenteredSurfaceColumn {
        if (tag.isNullOrEmpty()) {
            CenteredSurfaceColumn {
                profileTextStringResource?.let { stringResource(id = it) }
                    ?.let { ProfileText(text = it) }
                ButtonGroup(
                    buttonModels = buttonModels
                )
            }
        } else {
            CenteredSurfaceColumn {
                when (tag) {
                    BASIC_PLANS_TAG -> ProfileText(
                        text = stringResource(id = R.string.basic_prepaid_sub_message)
                    )
                    PREMIUM_PLANS_TAG -> ProfileText(
                        text = stringResource(id = R.string.premium_prepaid_sub_message)
                    )
                }
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_height)))
                ButtonGroup(buttonModels = buttonModels)
            }
        }
    }
}

@Composable
private fun ButtonGroup(
    buttonModels: List<ButtonModel>,
) {
    CenteredSurfaceColumn {
        for (buttonModel in buttonModels) {
            Button(
                modifier = Modifier.size(
                    width = dimensionResource(id = R.dimen.ui_button_width),
                    height = dimensionResource(R.dimen.ui_button_height)
                ),
                onClick = buttonModel.onClick
            ) {
                Text(text = stringResource(buttonModel.stringResource))
            }
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacer_height)))
        }
    }
}

@Composable
private fun ProfileText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.h3,
        textAlign = TextAlign.Center
    )
}

/**
 * Find the closest Activity in a given Context.
 */
/**
 * Find the closest Activity in a given Context.
 */
internal fun Context.findActivity(): Activity {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) return context
        context = context.baseContext
    }
    throw IllegalStateException(getString(R.string.context_finder_error))
}