package com.example.aquariuminformation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector

interface Destinations {
	val icon: ImageVector
	val route: String
	val title: String
}

object Home : Destinations {
	override val icon = Icons.Filled.Home
	override val route = "home"
	override val title = "Home"
}

object Information : Destinations {
	override val icon = Icons.Filled.Info
	override val route = "info"
	override val title = "Information"
}

//object Salinity : Destinations {
//	override val icon = R.drawable.salinity
//	override val route = "salinity"
//	override val title = "Salinity"
//}
//
//object Alkalinity : Destinations {
//	override val icon = R.drawable.alkalinity
//	override val route = "alkalinity"
//	override val title = "Alkalinity"
//}
//
//object Temperature : Destinations {
//	override val icon = R.drawable.thermostat_48px
//	override val route = "temp"
//	override val title = "Temperature"
//}
//
//object CarbonDioxide : Destinations {
//	override val icon = R.drawable.carbondiox
//	override val route = "carbon"
//	override val title = "Carbon Dioxide"
//}
//
//object Rectangle : Destinations {
//	override val icon = R.drawable.rectangle
//	override val route = "rectangle"
//	override val title = "Rectangle"
//}
//
//object Cube : Destinations {
//	override val icon = R.drawable.cube
//	override val route = "cube"
//	override val title = "Cube"
//}
//
//object Cylinder : Destinations {
//	override val icon = R.drawable.cylinder
//	override val route = "cylinder"
//	override val title = "Cylinder"
//}
//
//object Hexagonal : Destinations {
//	override val icon = R.drawable.hex
//	override val route = "hexagonal"
//	override val title = "Hex"
//}
//
//object BowFront : Destinations {
//	override val icon = R.drawable.bfront
//	override val route = "bow_front"
//	override val title = "Bow-Fr."
//}
//
//object Converters : Destinations {
//	override val icon = R.drawable.convert
//	override val route = "converters"
//	override val title = "Converters"
//}
//
//object TankVolume : Destinations {
//	override val icon = R.drawable.volume
//	override val route = "tank_volume"
//	override val title = "Tank Volume"
//}
//
//object FishCompat : Destinations {
//	override val icon = R.drawable.compaticon
//	override val route = "fish_compat"
//	override val title = "Compatibility"
//}
//
//object FishCompatFresh : Destinations {
//	override val icon = R.drawable.combatfresh
//	override val route = "fish_compat_fresh"
//	override val title = "Freshwater"
//}
//
//object FishCompatMarine : Destinations {
//	override val icon = R.drawable.combatmarine
//	override val route = "fish_compat_marine"
//	override val title = "Marine"
//}

val bottomNavRow = listOf(Home, Information)
//val mainNavDrawer = listOf(FishCompat, TankVolume, Converters, Alkalinity, Salinity)
//val bottomNavRow = listOf(FishCompat, TankVolume, Converters, Alkalinity, Salinity)
//val tankVolumeNavRow = listOf(Rectangle, Cube, Cylinder, Hexagonal, BowFront)
//val convertersNavRow = listOf(Temperature, CarbonDioxide)
//val compatibilityNavRow = listOf(FishCompatFresh, FishCompatMarine)