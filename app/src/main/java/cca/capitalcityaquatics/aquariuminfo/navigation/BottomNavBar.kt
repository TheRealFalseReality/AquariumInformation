package cca.capitalcityaquatics.aquariuminfo.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavBar(
    allScreens: List<Destinations>,
    onTabSelected: (Destinations) -> Unit,
    currentScreen: Destinations
){
    Surface(
        Modifier
            .height(TabHeight)
            .fillMaxWidth(),
        color = MaterialTheme.colors.primary
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                Modifier.selectableGroup(),
            ) {
                allScreens.forEach{ screen ->
                    NavTab(
                        text = screen.title,
                        icon =screen.icon,
                        onSelected = { onTabSelected(screen) },
                        selected = currentScreen == screen
                    )
                }
            }
        }
    }
}

private val TabHeight = 56.dp