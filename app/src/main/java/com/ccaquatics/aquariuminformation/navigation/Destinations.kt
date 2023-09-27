package com.ccaquatics.aquariuminformation.navigation

import com.ccaquatics.aquariuminformation.R

interface Destinations {
	val icon: Int
	val iconFilled: Int
	val route: String
	val title: Int
}

object Home : Destinations {
	override val icon = R.drawable.ic_home
	override val iconFilled = R.drawable.baseline_home_24
	override val route = "home"
	override val title = R.string.home
}

object Information : Destinations {
	override val icon = R.drawable.ic_info_2
	override val iconFilled = R.drawable.baseline_info_24
	override val route = "info"
	override val title = R.string.text_title_info
}

object Overview : Destinations {
	override val icon = R.drawable.baseline_grid_view_24
	override val iconFilled = R.drawable.baseline_grid_view_24
	override val route = "overview"
	override val title = R.string.overview
}

object TankVolume : Destinations {
	override val icon = R.drawable.ic_volume
	override val iconFilled = R.drawable.ic_volume // TODO
	override val route = "volume"
	override val title = R.string.tank_volume
}

object Salinity : Destinations {
	override val icon = R.drawable.ic_salinity_alt
	override val iconFilled = R.drawable.ic_salinity_filled
	override val route = "salinity"
	override val title = R.string.salinity
}

object Alkalinity : Destinations {
	override val icon = R.drawable.ic_water_do
	override val iconFilled = R.drawable.ic_water_do_filled
	override val route = "alkalinity"
	override val title = R.string.alkalinity
}

//
object Temperature : Destinations {
	override val icon = R.drawable.ic_thermostat
	override val iconFilled = R.drawable.ic_thermostat
	override val route = "temp"
	override val title = R.string.temperature
}

//
object CarbonDioxide : Destinations {
	override val icon = R.drawable.baseline_co2_24
	override val iconFilled = R.drawable.baseline_co2_24
	override val route = "carbon"
	override val title = R.string.carbon_dioxide
}

object Rectangle : Destinations {
	override val icon = R.drawable.ic_rectangle
	override val iconFilled = R.drawable.ic_rectangle
	override val route = "rectangle"
	override val title = R.string.text_title_rectangle
}

object Cube : Destinations {
	override val icon = R.drawable.ic_cube_2
	override val iconFilled = R.drawable.ic_cube_2
	override val route = "cube"
	override val title = R.string.text_title_cube
}

object Cylinder : Destinations {
	override val icon = R.drawable.ic_cylinder
	override val iconFilled = R.drawable.ic_cylinder
	override val route = "cylinder"
	override val title = R.string.text_title_cyl
}

object Hexagonal : Destinations {
	override val icon = R.drawable.ic_hex
	override val iconFilled = R.drawable.ic_hex
	override val route = "hexagonal"
	override val title = R.string.text_title_hex
}

object BowFront : Destinations {
	override val icon = R.drawable.ic_bow_front
	override val iconFilled = R.drawable.ic_bow_front
	override val route = "bow_front"
	override val title = R.string.text_title_bow_front
}

object FishCompatability : Destinations {
	override val icon = R.drawable.ic_icon_question
	override val iconFilled = R.drawable.ic_icon_question
	override val route = "fish_compatibility"
	override val title = R.string.compatibility
}

object FishCompatabilityFreshwater : Destinations {
	override val icon = R.drawable.ic_fish_2
	override val iconFilled = R.drawable.ic_icon_question
	override val route = "fish_compat_fresh"
	override val title = R.string.freshwater
}

object FishCompatabilityMarine : Destinations {
	override val icon = R.drawable.ic_fish
	override val iconFilled = R.drawable.ic_icon_question
	override val route = "fish_compat_marine"
	override val title = R.string.marine
}

object Converters : Destinations {
	override val icon = R.drawable.ic_conversion
	override val iconFilled = R.drawable.ic_conversion
	override val route = "converters"
	override val title = R.string.converters
}

object Calculators : Destinations {
	override val icon = R.drawable.ic_calculate
	override val iconFilled = R.drawable.ic_calculate
	override val route = "calculators"
	override val title = R.string.calculators
}

val bottomNavRow = listOf(Overview, Calculators, TankVolume, FishCompatability)
val compatibilityTabRow = listOf(FishCompatabilityFreshwater, FishCompatabilityMarine)
val calculatorsTabRow = listOf(Salinity, Alkalinity, Temperature, CarbonDioxide)
val tankVolumeTabRow = listOf(Rectangle, Cube, Cylinder, Hexagonal, BowFront)
//val destinations = listOf(Converters, Calculators, FishCompatability, Temperature)
//val allDestinations = listOf(Temperature, Alkalinity, Salinity, TankVolume, CarbonDioxide)
//val mainNavDrawer = listOf(FishCompat, TankVolume, Converters, Alkalinity, Salinity)
//val bottomNavRow = listOf(FishCompat, TankVolume, Converters, Alkalinity, Salinity)
//val tankVolumeNavRow = listOf(Rectangle, Cube, Cylinder, Hexagonal, BowFront)
//val convertersNavRow = listOf(Temperature, CarbonDioxide)