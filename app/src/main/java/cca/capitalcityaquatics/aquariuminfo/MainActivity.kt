package cca.capitalcityaquatics.aquariuminfo

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cca.capitalcityaquatics.aquariuminfo.navigation.*
import cca.capitalcityaquatics.aquariuminfo.ui.advert.AdvertView
import cca.capitalcityaquatics.aquariuminfo.ui.appscreens.HomeScreen
import cca.capitalcityaquatics.aquariuminfo.ui.appscreens.InfoScreen
import cca.capitalcityaquatics.aquariuminfo.ui.converters.AlkalinityScreen
import cca.capitalcityaquatics.aquariuminfo.ui.converters.SalScreen
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInfoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        super.onCreate(savedInstanceState)
        setContent {
            AquariumInfoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun NavigationMain(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Home.route
    ){
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }
        composable(NavigationItem.Info.route){
            InfoScreen()
        }
        composable(NavigationItem.Sal.route){
            SalScreen()
        }
        composable(NavigationItem.Converts.route){
            ConvertNavScreen()
        }
        composable(NavigationItem.TankVol.route){
            TankVolumeNavScreen()
        }
        composable(NavigationItem.Alk.route){
            AlkalinityScreen()
        }
    }
}

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            Column{
                AdvertView()
                TopBar(navController = navController)
            }
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) {
        NavigationMain(
            navController = navController,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AquariumInfoTheme {
        MainScreen()
    }
}