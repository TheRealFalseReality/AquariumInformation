package com.example.aquariuminformation

import android.os.Bundle
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
					Column(modifier = Modifier
						.fillMaxSize()
						.padding(dimensionResource(id = R.dimen.padding_small))) {
						Greeting()
					}
				}
			}
		}
	}
}

@Composable
fun Greeting(
	modifier: Modifier = Modifier
) {
	Card(
		modifier = modifier,
		shape = Shapes.large
	) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.primary)
		) {
			Row(
				modifier = Modifier
					.fillMaxWidth(),
				verticalAlignment = Alignment.CenterVertically
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

@Composable
fun AquariumInfoApp(){
	Column(modifier = Modifier
		.fillMaxSize()
		.padding(dimensionResource(id = R.dimen.padding_small))) {
		Greeting()
	}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	AquariumInformationTheme {
		AquariumInfoApp()
	}
}

@Preview(showBackground = true)
@Composable
fun GreetingDarkPreview() {
	AquariumInformationTheme(useDarkTheme = true) {
		AquariumInfoApp()
	}
}