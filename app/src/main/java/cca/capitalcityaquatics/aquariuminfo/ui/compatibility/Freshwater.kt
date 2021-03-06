package cca.capitalcityaquatics.aquariuminfo.ui.compatibility

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.data.compatibility.Freshwater
import cca.capitalcityaquatics.aquariuminfo.data.compatibility.FreshwaterDataSource
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AppTheme
import cca.capitalcityaquatics.aquariuminfo.ui.theme.Shapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FreshwaterScreen() {
	AppTheme {
		Scaffold { innerPadding ->
			FreshwaterList(FreshwaterDataSource().loadFishCardsFresh())
			Modifier
				.padding(innerPadding)
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FishCardsFresh(
	freshwater: Freshwater,
	modifier: Modifier = Modifier,
) {
	var expanded by remember { mutableStateOf(false) }

	ElevatedCard(
		modifier = modifier
			.padding(8.dp)
			.heightIn(min = 280.dp),
		onClick = { expanded = !expanded },
		shape = Shapes.small,
		elevation = CardDefaults.cardElevation(12.dp),
		colors = CardDefaults.cardColors(
			MaterialTheme.colorScheme.secondary,
			MaterialTheme.colorScheme.onSecondary
		)
	) {
		Column(
			modifier = Modifier
				.clickable { expanded = !expanded }
				.animateContentSize(
					animationSpec = spring(
						dampingRatio = Spring.DampingRatioLowBouncy,
						stiffness = Spring.StiffnessMediumLow
					),
				)
		) {
			Column {
				freshwater.image?.let { painterResource(id = it) }?.let {
					Image(
						painter = it,
						contentDescription = stringResource(id = freshwater.title),
						modifier = Modifier
							.heightIn(max = 200.dp),
						contentScale = ContentScale.Crop
					)
				}
				Text(
					text = stringResource(id = freshwater.title),
					modifier = Modifier
						.padding(12.dp)
						.align(Alignment.Start),
					style = MaterialTheme.typography.titleLarge
				)
				Text(
					text = stringResource(id = freshwater.latin),
					modifier = Modifier
						.padding(start = 12.dp, bottom = 12.dp)
						.align(Alignment.Start),
					style = (MaterialTheme.typography.labelMedium),
					fontStyle = FontStyle.Italic
				)
				if (expanded) {
					Text(
						text = stringResource(id = R.string.text_compatible),
						modifier = Modifier.padding(start = 12.dp, end = 12.dp),
						style = MaterialTheme.typography.labelMedium
					)
					Spacer(modifier = Modifier.height(6.dp))
					Text(
						text = stringResource(id = freshwater.compatible),
						modifier = Modifier.padding(start = 18.dp, end = 12.dp),
						style = MaterialTheme.typography.bodySmall
					)
					Spacer(modifier = Modifier.height(12.dp))
					Text(
						text = stringResource(id = R.string.text_caution),
						modifier = Modifier.padding(start = 12.dp, end = 12.dp),
						style = MaterialTheme.typography.labelMedium
					)
					Spacer(modifier = Modifier.height(6.dp))
					Text(
						text = stringResource(id = freshwater.caution),
						modifier = Modifier.padding(start = 18.dp, end = 12.dp),
						style = MaterialTheme.typography.bodySmall
					)
					Spacer(modifier = Modifier.height(12.dp))
					Text(
						text = stringResource(id = R.string.text_incompatible),
						modifier = Modifier.padding(start = 12.dp, end = 12.dp),
						style = MaterialTheme.typography.labelMedium
					)
					Spacer(modifier = Modifier.height(6.dp))
					Text(
						text = stringResource(id = freshwater.incompatible),
						modifier = Modifier.padding(start = 18.dp, end = 12.dp),
						style = MaterialTheme.typography.bodySmall
					)
					Spacer(modifier = Modifier.height(12.dp))
				}
			}
		}
	}
}

@Composable
fun FreshwaterList(
	freshwaterList: List<Freshwater>,
	modifier: Modifier = Modifier
) {
	Surface(
		modifier = modifier
			.fillMaxSize(),
		color = MaterialTheme.colorScheme.primary
	) {
		Column(
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			Text(
				text = stringResource(R.string.text_beta),
				modifier = Modifier.padding(12.dp),
				color = MaterialTheme.colorScheme.error,
				style = MaterialTheme.typography.labelMedium
			)
			LazyVerticalGrid(
				columns = GridCells.Adaptive(minSize = 250.dp),
				userScrollEnabled = true,
				state = LazyGridState(),
				content = {
					items(freshwaterList) { freshwater ->
						FishCardsFresh(freshwater = freshwater)
					}
				}
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun FishCardPreview() {
	AppTheme {
		FishCardsFresh(
			freshwater = Freshwater(
				R.drawable.pleco,
				R.string.text_pleco,
				R.string.text_latin_pleco,
				R.string.text_app_errors,
				R.string.text_amount_fah,
				R.string.text_pleco
			)
		)
	}
}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
	FreshwaterScreen()
}