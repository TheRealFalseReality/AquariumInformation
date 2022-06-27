package cca.capitalcityaquatics.aquariuminfo.navigation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import cca.capitalcityaquatics.aquariuminfo.MainScreen
import cca.capitalcityaquatics.aquariuminfo.NavigationItem
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInfoTheme

@Composable
fun TopBar(
    navController: NavController
) {
    TopAppBar(
        modifier= Modifier
            .fillMaxWidth(),
        title = { Text(
            text = stringResource(R.string.app_name),
            modifier = Modifier
                .clickable {
                    navController.navigate(NavigationItem.Home.route){
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route){
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            fontSize = 18.sp)
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        navigationIcon = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            IconButton(
                onClick = {
                    navController.navigate(NavigationItem.Home.route){
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route){
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.white_fish),
                    contentDescription = "stringResource(R.string.text_home)",
                    modifier = Modifier
                        .padding(4.dp)
                )
            }
        },
        actions = {
            IconButton(
                onClick = {
                    navController.navigate(NavigationItem.Info.route){
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route){
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.informationwhite),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(4.dp)
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    AquariumInfoTheme {
        MainScreen()
    }
}