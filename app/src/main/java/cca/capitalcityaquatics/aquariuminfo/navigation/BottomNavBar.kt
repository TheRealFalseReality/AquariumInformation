package cca.capitalcityaquatics.aquariuminfo.navigation

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun BottomNavBar(
    allScreens: List<Destinations>,
    onTabSelected: (Destinations) -> Unit,
    currentScreen: Destinations
) {
    NavBar(
        content = {
            allScreens.forEach { screen ->
                NavTab(
                    text = screen.title,
                    icon = screen.icon,
                    onSelected = { onTabSelected(screen) },
                    selected = currentScreen == screen
                )
            }
        },
        color = MaterialTheme.colors.primary
    )
}