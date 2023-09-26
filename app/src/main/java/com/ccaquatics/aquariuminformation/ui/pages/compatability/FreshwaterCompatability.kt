package com.ccaquatics.aquariuminformation.ui.pages.compatability

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ccaquatics.aquariuminformation.R
import com.ccaquatics.aquariuminformation.data.compatability.CompatabilityData
import com.ccaquatics.aquariuminformation.data.compatability.FreshwaterDataSource
import com.ccaquatics.aquariuminformation.ui.commonui.PageViewLazy
import com.ccaquatics.aquariuminformation.ui.theme.Shapes

@Composable
fun FreshwaterCompatabilityScreen() {
	PageViewLazy {
		FreshwaterList(FreshwaterDataSource().loadFishCardsFresh())
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FishCardsFresh(
	freshwater: CompatabilityData,
	modifier: Modifier = Modifier,
) {
	var expanded by remember { mutableStateOf(false) }

	ElevatedCard(
		modifier = modifier
			.padding(8.dp)
			.heightIn(min = 280.dp),
		onClick = { expanded = !expanded },
		shape = Shapes.large,
		elevation = CardDefaults.cardElevation(12.dp),
		colors = CardDefaults.cardColors(
			MaterialTheme.colorScheme.tertiaryContainer,
			MaterialTheme.colorScheme.onTertiaryContainer
		)
	) {
		Column(
			modifier = Modifier
				.clickable { expanded = !expanded }
				.animateContentSize(
					animationSpec = spring(
						dampingRatio = Spring.DampingRatioLowBouncy,
						stiffness = Spring.StiffnessLow
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
	freshwaterList: List<CompatabilityData>,
	modifier: Modifier = Modifier
) {
	Surface(
		modifier = modifier
			.fillMaxSize(),
		color = MaterialTheme.colorScheme.background
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
				columns = GridCells.Adaptive(minSize = dimensionResource(id = R.dimen.grid_colum_medium)),
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
	FishCardsFresh(
		freshwater = CompatabilityData(
			R.drawable.pleco,
			R.string.text_pleco,
			R.string.text_latin_pleco,
			R.string.text_app_errors,
			R.string.text_amount_fah,
			R.string.text_pleco
		)
	)
}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
	FreshwaterCompatabilityScreen()
}