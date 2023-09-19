package com.ccaquatics.aquariuminformation.navigation

import com.ccaquatics.aquariuminformation.R

interface Destinations {
	val icon: Int
	val route: String
	val title: Int
	val subtitle: Int
}

object Home : Destinations {
	override val icon = R.drawable.ic_home
	override val route = "home"
	override val title = R.string.home
	override val subtitle = R.string.home
}

object Information : Destinations {
	override val icon = R.drawable.ic_info_2
	override val route = "info"
	override val title = R.string.text_title_info
	override val subtitle = R.string.text_title_info
}

object Overview : Destinations {
	override val icon = R.drawable.baseline_grid_view_24
	override val route = "overview"
	override val title = R.string.overview
	override val subtitle = R.string.overview
}

object TankVolume : Destinations {
	override val icon = R.drawable.ic_volume
	override val route = "volume"
	override val title = R.string.tank_volume
	override val subtitle = R.string.tank_volume
}

object Salinity : Destinations {
	override val icon = R.drawable.ic_salinity
	override val route = "salinity"
	override val title = R.string.salinity
	override val subtitle = R.string.text_subtitle_salinity
}

object Alkalinity : Destinations {
	override val icon = R.drawable.ic_water_do
	override val route = "alkalinity"
	override val title = R.string.alkalinity
	override val subtitle = R.string.text_subtitle_alk
}
//
object Temperature : Destinations {
	override val icon = R.drawable.baseline_thermostat_24
	override val route = "temp"
	override val title = R.string.temperature
	override val subtitle = R.string.text_subtitle_temp
}
//
object CarbonDioxide : Destinations {
	override val icon = R.drawable.baseline_co2_24
	override val route = "carbon"
	override val title = R.string.carbon_dioxide
	override val subtitle = R.string.text_subtitle_co2
}

object Rectangle : Destinations {
	override val icon = R.drawable.ic_rectangle
	override val route = "rectangle"
	override val title = R.string.text_title_rectangle
	override val subtitle = R.string.text_subtitle_tank_vol
}

object Cube : Destinations {
	override val icon = R.drawable.ic_cube_2
	override val route = "cube"
	override val title = R.string.text_title_cube
	override val subtitle = R.string.text_subtitle_tank_vol
}

object Cylinder : Destinations {
	override val icon = R.drawable.ic_cylinder
	override val route = "cylinder"
	override val title = R.string.text_title_cyl
	override val subtitle = R.string.text_subtitle_tank_vol
}

object Hexagonal : Destinations {
	override val icon = R.drawable.ic_hex
	override val route = "hexagonal"
	override val title = R.string.text_title_hex
	override val subtitle = R.string.text_subtitle_tank_vol
}

object BowFront : Destinations {
	override val icon = R.drawable.ic_bow_front
	override val route = "bow_front"
	override val title = R.string.text_title_bow_front
	override val subtitle = R.string.text_subtitle_tank_vol
}

object FishCompatability : Destinations {
	override val icon = R.drawable.ic_icon_question
	override val route = "fish_compatibility"
	override val title = R.string.compatibility
	override val subtitle = R.string.compatibility
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
	override val subtitle = R.string.converters
}

object Calculators : Destinations {
	override val icon = R.drawable.ic_calculate
	override val route = "calculators"
	override val title = R.string.calculators
	override val subtitle = R.string.calculators
}

val bottomNavRow = listOf(Overview, Converters, Calculators, FishCompatability)
//val allDestinations = listOf(Temperature, Alkalinity, Salinity, TankVolume, CarbonDioxide)
//val mainNavDrawer = listOf(FishCompat, TankVolume, Converters, Alkalinity, Salinity)
//val bottomNavRow = listOf(FishCompat, TankVolume, Converters, Alkalinity, Salinity)
//val tankVolumeNavRow = listOf(Rectangle, Cube, Cylinder, Hexagonal, BowFront)
//val convertersNavRow = listOf(Temperature, CarbonDioxide)
//val compatibilityNavRow = listOf(FishCompatFresh, FishCompatMarine)