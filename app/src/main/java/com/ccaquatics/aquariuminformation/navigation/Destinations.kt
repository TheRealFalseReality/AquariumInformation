package com.ccaquatics.aquariuminformation.navigation

import com.example.aquariuminformation.R

interface Destinations {
	val icon: Int
	val route: String
	val title: Int
}

object Home : Destinations {
	override val icon = R.drawable.ic_launcher_foreground
	override val route = "home"
	override val title = R.string.home
}

object Information : Destinations {
	override val icon = R.drawable.ic_info_2
	override val route = "info"
	override val title = R.string.text_title_info
}

object Overview : Destinations {
	override val icon = R.drawable.baseline_grid_view_24
	override val route = "overview"
	override val title = R.string.overview
}

object TankVolume : Destinations {
	override val icon = R.drawable.ic_volume
	override val route = "volume"
	override val title = R.string.tank_volume
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
object Temperature : Destinations {
	override val icon = R.drawable.baseline_thermostat_24
	override val route = "temp"
	override val title = R.string.temperature
}
//
object CarbonDioxide : Destinations {
	override val icon = R.drawable.baseline_co2_24
	override val route = "carbon"
	override val title = R.string.carbon_dioxide
}
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
object FishCompatability : Destinations {
	override val icon = R.drawable.ic_icon_question
	override val route = "fish_compatibility"
	override val title = R.string.compatibility
}
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

object Converters : Destinations {
	override val icon = R.drawable.ic_conversion
	override val route = "converters"
	override val title = R.string.converters
}

object Calculators : Destinations {
	override val icon = R.drawable.baseline_calculate_24
	override val route = "calculators"
	override val title = R.string.calculators
}

val bottomNavRow = listOf(Overview, Converters, TankVolume, FishCompatability)
//val mainNavDrawer = listOf(FishCompat, TankVolume, Converters, Alkalinity, Salinity)
//val bottomNavRow = listOf(FishCompat, TankVolume, Converters, Alkalinity, Salinity)
//val tankVolumeNavRow = listOf(Rectangle, Cube, Cylinder, Hexagonal, BowFront)
//val convertersNavRow = listOf(Temperature, CarbonDioxide)
//val compatibilityNavRow = listOf(FishCompatFresh, FishCompatMarine)