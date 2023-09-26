package com.ccaquatics.aquariuminformation.ui.commonui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import com.ccaquatics.aquariuminformation.R
import com.ccaquatics.aquariuminformation.data.compatability.CompatabilityData

@Composable
fun PageView(
	content: @Composable () -> Unit,
) {
	Column(
		modifier = Modifier
//			.padding(
//				top = dimensionResource(id = R.dimen.padding_verySmall),
//				bottom = dimensionResource(id = R.dimen.padding_small)
//			),
	) {
		Column(
			modifier = Modifier
				.fillMaxSize()
				.verticalScroll(rememberScrollState()),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.SpaceBetween
		) {
			content()
		}
	}
}

@Composable
fun PageViewCenter(
	content: @Composable () -> Unit,
) {
	Column(
		modifier = Modifier
//			.padding(
//				top = dimensionResource(id = R.dimen.padding_verySmall),
//				bottom = dimensionResource(id = R.dimen.padding_small)
//			),
	) {
		Column(
			modifier = Modifier
				.fillMaxSize()
				.verticalScroll(rememberScrollState()),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center
		) {
			content()
			SmallSpacer()
		}
	}
}

@Composable
fun PageViewLazy(
	content: @Composable ColumnScope.() -> Unit,
) {
	Column(
		modifier = Modifier
//				.verticalScroll(rememberScrollState())
			.fillMaxSize(),//
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center
	) {
		content()
	}
}

@Composable
fun FishCardsCompatabilityData(
	modifier: Modifier = Modifier,
	compatabilityData: CompatabilityData,
	containerColor: Color = MaterialTheme.colorScheme.tertiaryContainer,
	contentColor: Color = MaterialTheme.colorScheme.onTertiaryContainer,
) {
	// TODO Make Common Composable
	Column(
		modifier = modifier
			.padding(vertical = dimensionResource(id = R.dimen.padding_small))
			.fillMaxWidth(),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
//		BodyText(
//				text = R.string.text_beta,
//				color = MaterialTheme.colorScheme.error,
//				style = MaterialTheme.typography.labelMedium
//			)
//		SmallSpacer()
		SingleWideCardExpandableFull(
			modifier = Modifier
				.fillMaxWidth(fraction = 0.95f),
			header = compatabilityData.title,
			headerModifier = Modifier
				.padding(
					top = dimensionResource(id = R.dimen.padding_medium),
					bottom = dimensionResource(id = R.dimen.padding_small)
				),
			headerStyle = MaterialTheme.typography.titleLarge,
			containerColor = containerColor,
			contentColor = contentColor,
			imageContent = {
				CardImage(
					image = compatabilityData.image,
					contentDescription = compatabilityData.title,
				)
			},
			subtitleContent = {
				BodyText(
					text = compatabilityData.latin,
					style = MaterialTheme.typography.labelLarge,
					fontStyle = FontStyle.Italic,
					textAlign = TextAlign.Start,
					color = contentColor
				)
//				VerySmallSpacer()
				SmallSpacer()
			},
//			descriptionContent = {
//				BodyText(
//					text = R.string.pleco_description,
//					color = contentColor
//				)
//				SmallSpacer()
//			},
			content = {
				Column(
					modifier = Modifier
						.padding(start = dimensionResource(id = R.dimen.padding_verySmall))
				) {
					HeaderText(
						text = R.string.text_compatible,
						color = contentColor
					)
					VerySmallSpacer()
					BodyText(
						text = compatabilityData.compatible,
						modifier = Modifier
							.padding(
								start = dimensionResource(id = R.dimen.padding_medium),
								end = dimensionResource(id = R.dimen.padding_medium)
							),
						textAlign = TextAlign.Justify,
						color = contentColor
					)
					MediumSpacer()
					HeaderText(
						text = R.string.text_caution,
						color = contentColor
					)
					VerySmallSpacer()
					BodyText(
						text = compatabilityData.caution,
						modifier = Modifier
							.padding(
								start = dimensionResource(id = R.dimen.padding_medium),
								end = dimensionResource(id = R.dimen.padding_medium)
							),
						textAlign = TextAlign.Justify,
						color = contentColor
					)
					MediumSpacer()
					HeaderText(
						text = R.string.text_incompatible,
						color = contentColor
					)
					VerySmallSpacer()
					BodyText(
						text = compatabilityData.incompatible,
						modifier = Modifier
							.padding(
								start = dimensionResource(id = R.dimen.padding_medium),
								end = dimensionResource(id = R.dimen.padding_medium)
							),
						textAlign = TextAlign.Justify,
						color = contentColor
					)
					VerySmallSpacer()
				}
			}
		)
	}
}

@Composable
fun GenericCalculatePage(
	@StringRes subtitle: Int,
	color: Color,
	selectContent: @Composable () -> Unit,
	optionsContent: @Composable () -> Unit = {},
	calculateFieldContent: @Composable () -> Unit,
	imageContent: @Composable () -> Unit = {},
	formulaContent: @Composable () -> Unit
) {
//	TitleWideContent(
//		text = title,
//		icon = icon,
//		color = color
//	) {
//		BodyText(
//			text = subtitle,
//			color = color,
//			style = MaterialTheme.typography.titleMedium
//		)
//	}
	SmallSpacer()
	BodyText(
		text = subtitle,
		color = color,
		style = MaterialTheme.typography.titleMedium
	)
	SmallSpacer()
	selectContent()
	SmallSpacer()
	optionsContent()
	SmallSpacer()
	calculateFieldContent()
	SmallSpacer()
	imageContent()
	SmallSpacer()
	formulaContent()
}