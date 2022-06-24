package cca.capitalcityaquatics.aquariuminfo.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import cca.capitalcityaquatics.aquariuminfo.NavigationItem
import cca.capitalcityaquatics.aquariuminfo.calculators.CarbonDioxideScreen
import cca.capitalcityaquatics.aquariuminfo.converters.TempScreen

@Composable
fun ConvertNavScreen (){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            ConvertBottomNavBar(navController)
        },
        modifier = Modifier.padding(bottom = 56.dp)
    ) {
        NavigationConvert(
            navController = navController
        )
    }
}

@Composable
fun NavigationConvert(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Temp.route
    ){
        composable(NavigationItem.Temp.route) {
            TempScreen()
        }
        composable(NavigationItem.CO2.route){
            CarbonDioxideScreen()
        }
    }
}

@Composable
fun ConvertBottomNavBar(
    navController: NavController
){
    val items = listOf(
        NavigationItem.Temp,
        NavigationItem.CO2,
    )
    BottomNavigation (
        backgroundColor = MaterialTheme.colors.primaryVariant,
    ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach{ item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = item.icon),
                        contentDescription = item.title,
                        modifier = Modifier
                            .padding(1.dp)
                            .height(26.dp)
                            .width(86.dp),
                    )
                },
                selected = false,
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(item.route){
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
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConvertPreview() {
    ConvertNavScreen()
}