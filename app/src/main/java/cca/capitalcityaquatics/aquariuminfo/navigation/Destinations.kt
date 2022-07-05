package cca.capitalcityaquatics.aquariuminfo.navigation

import cca.capitalcityaquatics.aquariuminfo.R

interface Destinations {
    val icon: Int
    val route: String
    val title: String
}

object Home : Destinations {
    override val icon =  R.drawable.mylogo
    override val route = "home"
    override val title = "Home"
}

object Information : Destinations {
    override val icon = R.drawable.information
    override val route = "info"
    override val title = "Information"
}

object Salinity : Destinations {
    override val icon = R.drawable.format_overline_48px
    override val route = "salinity"
    override val title = "Salinity"
}

object Alkalinity : Destinations {
    override val icon = R.drawable.linear_scale_48px
    override val route = "alkalinity"
    override val title = "Alkalinity"
}

object Temperature : Destinations {
    override val icon = R.drawable.thermostat_48px
    override val route = "temp"
    override val title = "Temperature"
}

object CarbonDioxide : Destinations {
    override val icon = R.drawable.co2_48px
    override val route = "carbon"
    override val title = "Carbon Dioxide"
}

object Rectangle : Destinations {
    override val icon = R.drawable.box_calcicon
    override val route = "rectangle"
    override val title = "Rectangle"
}

object Cube : Destinations {
    override val icon = R.drawable.cube_calcicon
    override val route = "cube"
    override val title = "Cube"
}

object Cylinder : Destinations {
    override val icon = R.drawable.cylinder_calcicon
    override val route = "cylinder"
    override val title = "Cylinder"
}

object Hexagonal : Destinations {
    override val icon = R.drawable.hexagonal_prismicon
    override val route = "hexagonal"
    override val title = "Hex"
}

object BowFront : Destinations {
    override val icon = R.drawable.bowfront_calcicon
    override val route = "bow_front"
    override val title = "Bow-Fr."
}

object Converters : Destinations {
    override val icon = R.drawable.conversion_path_48px
    override val route = "converters"
    override val title = "Converters"
}

object TankVolume : Destinations {
    override val icon = R.drawable.calculate_48px
    override val route = "tank_volume"
    override val title = "Tank Volume"
}

val bottomNavRow = listOf(TankVolume, Converters, Alkalinity, Salinity)
val tankVolumeNavRow = listOf(Rectangle, Cube, Cylinder, Hexagonal, BowFront)
val convertersNavRow =  listOf(Temperature, CarbonDioxide)