package com.ccaquatics.aquariuminformation.ui.commonui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.ccaquatics.aquariuminformation.R
import com.ccaquatics.aquariuminformation.data.compatability.CompatibilityData
import com.ccaquatics.aquariuminformation.data.compatability.disclaimerDataSource
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme

@Composable
fun CompatibilityDataList(
	marineList: List<CompatibilityData>,
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
			LazyVerticalGrid(
				columns = GridCells.Adaptive(minSize = dimensionResource(id = R.dimen.grid_colum_medium)),
				userScrollEnabled = true,
				state = LazyGridState(),
				content = {
					items(marineList) { compatibilityData ->
						FishCardsCompatibilityData(compatibilityData = compatibilityData)
					}
					item {
						Disclaimer()
					}
				}
			)
		}
	}
}

@Composable
fun FishCardsCompatibilityData(
	modifier: Modifier = Modifier,
	compatibilityData: CompatibilityData,
	containerColor: Color = MaterialTheme.colorScheme.tertiaryContainer,
	contentColor: Color = MaterialTheme.colorScheme.onTertiaryContainer,
) {
	Column(
		modifier = modifier
			.padding(vertical = dimensionResource(id = R.dimen.padding_small))
			.fillMaxWidth(),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		SingleWideCardExpandableFull(
			modifier = Modifier
				.fillMaxWidth(fraction = 0.95f),
			header = compatibilityData.title,
			headerStyle = MaterialTheme.typography.titleLarge,
			containerColor = containerColor,
			contentColor = contentColor,
			imageContent = {
				CardImage(
					image = compatibilityData.image,
					contentDescription = compatibilityData.title,
				)
			},
			subtitleContent = {
				BodyText(
					text = compatibilityData.latin,
					style = MaterialTheme.typography.labelLarge,
					fontStyle = FontStyle.Italic,
					textAlign = TextAlign.Start,
					color = contentColor
				)
			},
			descriptionContent = {
				BodyText(
					text = compatibilityData.description,
					color = contentColor,
					style = MaterialTheme.typography.bodySmall,
					textAlign = TextAlign.Justify
				)
			},
			content = {
				Column(
					modifier = Modifier
						.padding(start = dimensionResource(id = R.dimen.padding_verySmall))
				) {
					HeaderText(
						text = R.string.text_compatible,
						color = contentColor,
						style = MaterialTheme.typography.titleSmall
					)
					VerySmallSpacer()
					BodyText(
						text = compatibilityData.compatible,
						modifier = Modifier
							.padding(
								start = dimensionResource(id = R.dimen.padding_medium),
								end = dimensionResource(id = R.dimen.padding_medium)
							),
						textAlign = TextAlign.Justify,
						color = contentColor,
						style = MaterialTheme.typography.bodySmall
					)
					SmallSpacer()
					HeaderText(
						text = R.string.text_caution,
						color = contentColor,
						style = MaterialTheme.typography.titleSmall
					)
					VerySmallSpacer()
					BodyText(
						text = compatibilityData.caution,
						modifier = Modifier
							.padding(
								start = dimensionResource(id = R.dimen.padding_medium),
								end = dimensionResource(id = R.dimen.padding_medium)
							),
						textAlign = TextAlign.Justify,
						color = contentColor,
						style = MaterialTheme.typography.bodySmall
					)
					SmallSpacer()
					HeaderText(
						text = R.string.text_incompatible,
						color = contentColor,
						style = MaterialTheme.typography.titleSmall
					)
					VerySmallSpacer()
					BodyText(
						text = compatibilityData.incompatible,
						modifier = Modifier
							.padding(
								start = dimensionResource(id = R.dimen.padding_medium),
								end = dimensionResource(id = R.dimen.padding_medium)
							),
						textAlign = TextAlign.Justify,
						color = contentColor,
						style = MaterialTheme.typography.bodySmall
					)
				}
			}
		)
	}
}

@Composable
fun BetaFeature(modifier: Modifier = Modifier) {
	Column(modifier = modifier) {
		BodyText(
			text = R.string.text_beta,
			color = MaterialTheme.colorScheme.error,
			style = MaterialTheme.typography.labelMedium
		)
	}
}

@Composable
fun Disclaimer(modifier: Modifier = Modifier) {
	Column(modifier = modifier) {
		IconTextRow(
			icon = disclaimerDataSource.icon,
			text = disclaimerDataSource.text,
			fontWeight = FontWeight.Bold
		)
	}
}

@Preview(showBackground = true)
@Composable
fun TankVolumePreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			Disclaimer()
		}
	}
}