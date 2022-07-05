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
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun ConvertNavScreen (){
    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination
    val currentScreen = convertersNavRow.find {
        it.route == currentDestination?.route
    } ?: Temperature

    Scaffold(
        bottomBar = {
                    ConvertBottomNavBar(
                        navController = navController,
                        allScreens = convertersNavRow,
                        currentScreen = currentScreen
                    )
        },
    ) { innerPadding ->
        ConvertNavHost(
            navController = navController,
            modifier = Modifier
                .padding(innerPadding)
        )
    }
}

@Composable
fun ConvertBottomNavBar(
    navController: NavHostController,
    allScreens: List<Destinations>,
    currentScreen: Destinations
){
    BottomNavigation (
        backgroundColor = MaterialTheme.colors.secondary,
    ){
        allScreens.forEach{ screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = screen.title,
                        modifier = Modifier
                            .padding(1.dp, bottom = 2.dp)
                            .height(25.dp)
                            .width(86.dp),
                    )
                },
                selected = currentScreen == screen,
                label = { Text(text = screen.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                onClick = {
                    navController.navigateSingleTopTo(screen.route)
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