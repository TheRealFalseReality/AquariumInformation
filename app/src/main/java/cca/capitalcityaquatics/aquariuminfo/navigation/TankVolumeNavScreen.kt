package cca.capitalcityaquatics.aquariuminfo.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import cca.capitalcityaquatics.aquariuminfo.tankVolume.*

@Composable
fun TankVolumeNavScreen (){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            TankVolumeBottomNavBar(navController)
        },
        modifier = Modifier.padding(bottom = 56.dp)
    ) {
        NavigationTankVolume(
            navController = navController
        )
    }
}

@Composable
fun NavigationTankVolume(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.VolRec.route
    ){
        composable(NavigationItem.VolRec.route){
            TankVolRecScreen()
        }
        composable(NavigationItem.VolCube.route){
            TankVolCubeScreen()
        }
        composable(NavigationItem.VolCyl.route){
            TankVolCylScreen()
        }
        composable(NavigationItem.VolHex.route){
            TankVolHexScreen()
        }
        composable(NavigationItem.VolBFront.route){
            TankVolBFScreen()
        }
    }
}

@Composable
fun TankVolumeBottomNavBar(
    navController: NavController
){
    val items = listOf(
        NavigationItem.VolRec,
        NavigationItem.VolCube,
        NavigationItem.VolCyl,
        NavigationItem.VolHex,
        NavigationItem.VolBFront
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
                            .padding(top = 1.dp)
                            .height(26.dp)
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
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TankVolPreview() {
    TankVolumeNavScreen()
}