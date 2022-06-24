package cca.capitalcityaquatics.aquariuminfo


sealed class NavigationItem (
    var route: String,
    var icon: Int,
    var title: String
){
    object Home: NavigationItem("home", R.drawable.squarewh,"Home")
    object Temp : NavigationItem("temp", R.drawable.temp, "Temperature")
    object CO2 : NavigationItem("co2", R.drawable.screenshot__12_, "CO₂")
    object Alk : NavigationItem("alk", R.drawable.alk2, "Alkalinity")
    object Info : NavigationItem("info", R.drawable.information,"Info")
    object Sal : NavigationItem("sal", R.drawable.salinity,"Salinity")
    object TankVol : NavigationItem("tankVolume", R.drawable.tankvolume,"Tank Volume")
    object Converts : NavigationItem("converts", R.drawable.convert, "Converters")
    object VolRec : NavigationItem("volRec", R.drawable.box_calcicon, "Rec.")
    object VolCube : NavigationItem("volCube", R.drawable.cube_calcicon, "Cube")
    object VolCyl : NavigationItem("volCyl",R.drawable.cylinder_calcicon, "Cyl.")
    object VolHex : NavigationItem("volHex", R.drawable.hexagonal_prismicon, "Hex.")
    object VolBFront : NavigationItem("volBFront", R.drawable.bowfront_calcicon, "B.Front")
}
