package cca.capitalcityaquatics.aquariuminfo.ui.commonComposables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.ui.theme.Shapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneralCard(
	modifier: Modifier = Modifier,
	verticalArrangement: Arrangement.Vertical,
	content: @Composable ColumnScope.() -> Unit,
) {
	Surface(
		modifier = modifier
			.fillMaxSize(),
		color = MaterialTheme.colorScheme.onBackground
	) {
		Column(
			modifier = Modifier
				.padding(6.dp),
			verticalArrangement = verticalArrangement
		) {
			Card(
				modifier = Modifier
					.fillMaxSize()
					.verticalScroll(rememberScrollState()),
				colors = CardDefaults.cardColors(
					MaterialTheme.colorScheme.surfaceTint,
					MaterialTheme.colorScheme.primaryContainer
				),
				shape = Shapes.medium,
			) {
				Column(
					modifier = Modifier
						.padding(14.dp),
					horizontalAlignment = Alignment.CenterHorizontally,
				) {
					content()
				}
			}
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentBorder(
	modifier: Modifier = Modifier,
	content: @Composable ColumnScope.() -> Unit,
) {
	ElevatedCard(
		modifier = modifier
			.fillMaxHeight()
			.widthIn(max = 500.dp, min = 400.dp),
		shape = Shapes.small,
		elevation = CardDefaults.cardElevation(12.dp),
		colors = CardDefaults.cardColors(
			MaterialTheme.colorScheme.secondary,
			MaterialTheme.colorScheme.primaryContainer
		)
	) {
		Column(
			modifier = Modifier
				.padding(12.dp)
				.fillMaxWidth(),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			content()
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentBorderClick(
	modifier: Modifier = Modifier,
	content: @Composable ColumnScope.() -> Unit,
	url: String
) {
	val uriHandler = LocalUriHandler.current

	ElevatedCard(
		onClick = { uriHandler.openUri(url) },
		modifier = modifier
			.fillMaxHeight()
			.widthIn(max = 500.dp, min = 400.dp),
		shape = Shapes.small,
		elevation = CardDefaults.cardElevation(6.dp),
		colors = CardDefaults.cardColors(
			MaterialTheme.colorScheme.secondary,
			MaterialTheme.colorScheme.primaryContainer
		),
	) {
		Column(
			modifier = Modifier.padding(6.dp),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			content()
		}
	}
}