package cca.capitalcityaquatics.aquariuminfo.ui.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.AquariumApp
import cca.capitalcityaquatics.aquariuminfo.navigation.Destinations
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AppTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavDrawerTEST() {
	val drawerState = rememberDrawerState(DrawerValue.Closed)
	val scope = rememberCoroutineScope()
	// icons to mimic drawer destinations
	val items = listOf(Icons.Default.Favorite, Icons.Default.Face, Icons.Default.Email)
	val selectedItem = remember { mutableStateOf(items[0]) }
	ModalNavigationDrawer(
		drawerState = drawerState,
		drawerContent = {
			items.forEach { item ->
				NavigationDrawerItem(
					icon = { Icon(item, contentDescription = null) },
					label = { Text(item.name) },
					selected = item == selectedItem.value,
					onClick = {
						scope.launch { drawerState.close() }
						selectedItem.value = item
					},
					modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
				)
			}
		},
		content = {
			Column(
				modifier = Modifier
					.fillMaxSize()
					.padding(16.dp),
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				Text(text = if (drawerState.isClosed) ">>> Swipe >>>" else "<<< Swipe <<<")
				Spacer(Modifier.height(20.dp))
				Button(onClick = { scope.launch { drawerState.open() } }
				) {
					Text("Click to open")
				}
			}
		}
	)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavDrawer(
	allScreens: List<Destinations>,
//	currentScreen: Destinations
) {
	val drawerState = rememberDrawerState(DrawerValue.Closed)
	val scope = rememberCoroutineScope()
	val selectedItem = remember { mutableStateOf(allScreens[0]) }
	ModalNavigationDrawer(
		drawerState = drawerState,
		drawerContent = {
			allScreens.forEach { screen ->
				NavigationDrawerItem(
//					icon = { Icon(screen.icon) },
					label = { Text(screen.title) },
					selected = screen == selectedItem.value,
					onClick = {
						scope.launch { drawerState.close() }
						selectedItem.value = screen
					},
					modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
				)
			}
		},
		content = {
			AquariumApp { scope.launch { drawerState.open() } }
		}
	)
}

@Preview(showBackground = true)
@Composable
fun NavDrawerPreview() {
	AppTheme {
	}
}