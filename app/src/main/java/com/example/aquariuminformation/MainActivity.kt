package com.example.aquariuminformation

import android.app.Activity
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.aquariuminformation.ui.commonui.AquariumAppBar
import com.example.aquariuminformation.ui.theme.AquariumInformationTheme
import com.example.aquariuminformation.ui.theme.Shapes

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			AquariumInformationTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {
					AquariumInfoApp()

					val color = MaterialTheme.colorScheme.background.value
					changeStatusBarColor(
						ContextCompat.getColor(
							this,
							R.color.status_bar
						), false
					)
				}
			}
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AquariumInfoApp() {
	Scaffold(
		topBar = {
			AquariumAppBar()
		}
	) {innerPadding ->
		Column(
			modifier = Modifier
				.padding(innerPadding)
				.fillMaxWidth()
				.background(MaterialTheme.colorScheme.background),
		) {
			CardTest(
				modifier = Modifier
					.align(alignment = Alignment.CenterHorizontally)
					.padding(dimensionResource(id = R.dimen.padding_small))
			)
		}
	}
}

@Composable
fun CardTest(
	modifier: Modifier = Modifier
) {
	Card(
		modifier = modifier,
		shape = Shapes.large,
	) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.primary),
//			horizontalAlignment = Alignment.CenterHorizontally
		) {
			Row(
				modifier = Modifier
					.fillMaxWidth(fraction = 0.8f),
				verticalAlignment = Alignment.CenterVertically,
			) {
				Icon(
					painter = painterResource(
						id = R.drawable.ic_launcher_foreground
					),
					contentDescription = null,
					tint = MaterialTheme.colorScheme.inversePrimary,
					modifier = Modifier
						.size(dimensionResource(id = R.dimen.icon_size))
				)
				Text(
					text = stringResource(id = R.string.app_name),
					color = MaterialTheme.colorScheme.primaryContainer,
					style = MaterialTheme.typography.titleLarge
				)
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.fillMaxSize()
				.background(color = MaterialTheme.colorScheme.background)
		) {
			AquariumInfoApp()
		}	}
}

@Preview(showBackground = true)
@Composable
fun GreetingDarkPreview() {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.fillMaxSize()
				.background(color = MaterialTheme.colorScheme.background)
		) {
			AquariumInfoApp()
		}

	}
}

fun Activity.changeStatusBarColor(color: Int, isLight: Boolean) {
	window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
	window.statusBarColor = color

	WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = isLight
}