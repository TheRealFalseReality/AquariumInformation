package com.ccaquatics.aquariuminformation.ui.commonui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ccaquatics.aquariuminformation.R
import com.ccaquatics.aquariuminformation.data.tankvolumes.bowFrontDataSource
import com.ccaquatics.aquariuminformation.navigation.BowFront
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme
import com.ccaquatics.aquariuminformation.ui.theme.Shapes

@Composable
fun MediumSpacer(modifier: Modifier = Modifier) {
	Column(modifier = modifier) {
		Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
	}
}

@Composable
fun SmallSpacer(modifier: Modifier = Modifier) {
	Column(modifier = modifier) {
		Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
	}
}

@Composable
fun VerySmallSpacer(modifier: Modifier = Modifier) {
	Column(modifier = modifier) {
		Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_verySmall)))
	}
}

@Composable
fun AppDivider(
	modifier: Modifier = Modifier,
	color: Color = MaterialTheme.colorScheme.onBackground,
) {
	Column(modifier = modifier) {
		Divider(
			modifier = Modifier
				.fillMaxWidth(fraction = 0.8f),
			color = color
		)
	}
}

@Composable
fun TitleWideContent(
	modifier: Modifier = Modifier,
	@StringRes text: Int,
	@DrawableRes icon: Int,
	color: Color = MaterialTheme.colorScheme.onSurface,
	content: @Composable ColumnScope.() -> Unit,
) {
	Column(
		modifier = modifier,
	) {
		Row(
			verticalAlignment = Alignment.CenterVertically
		) {
			TitleTextIcon(
				text = text,
				icon = icon,
				color = color
			)
		}
		Column(
			modifier = Modifier
				.fillMaxWidth(),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			SmallSpacer()
			content()
		}
	}
}

@Composable
fun SingleWideCard(
	modifier: Modifier = Modifier,
	shape: Shape = Shapes.large,
	containerColor: Color = MaterialTheme.colorScheme.background,
	contentColor: Color = MaterialTheme.colorScheme.onBackground,
	content: @Composable ColumnScope.() -> Unit,
) {
	Column(modifier = modifier) {
		ElevatedCard(
			modifier = Modifier
				.padding(bottom = dimensionResource(id = R.dimen.padding_medium))
				.fillMaxWidth(fraction = 0.9f),
			shape = shape,
			colors = CardDefaults.cardColors(
				containerColor = containerColor,
				contentColor = contentColor
			),
			elevation = CardDefaults.cardElevation(
				defaultElevation = dimensionResource(id = R.dimen.elevation_medium)
			)
		) {
			Column(
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.padding_small))
					.fillMaxWidth(),
				horizontalAlignment = Alignment.CenterHorizontally,
			) {
				content()
			}
		}
	}
}

@Composable
fun TextCard(
	modifier: Modifier = Modifier,
	@StringRes text: Int,
	containerColor: Color = MaterialTheme.colorScheme.background,
	contentColor: Color,
	shape: Shape = Shapes.large
) {
	Column(modifier = modifier) {
		ElevatedCard(
			elevation = CardDefaults.cardElevation(8.dp),
			colors = CardDefaults.cardColors(
				containerColor = containerColor,
				contentColor = contentColor
			),
			shape = shape
		) {
			Column(
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.padding_small))
					.fillMaxWidth(fraction = 0.6f),
			) {
				Row(
					modifier = Modifier
						.fillMaxWidth(),
					horizontalArrangement = Arrangement.Center,
					verticalAlignment = Alignment.CenterVertically
				) {
					HeaderText(
						text = text,
						color = contentColor,
					)
				}
			}
		}
	}
}

@Composable
fun HeaderTextLarge(
	modifier: Modifier = Modifier,
	@StringRes text: Int,
	color: Color = MaterialTheme.colorScheme.onBackground,
	style: TextStyle = MaterialTheme.typography.titleLarge,
	textAlign: TextAlign = TextAlign.Start
) {
	Column(modifier = modifier) {
		Text(
			text = stringResource(id = text),
			color = color,
			style = style,
			textAlign = textAlign,
		)
	}
}

@Composable
fun CardImage(
	modifier: Modifier = Modifier,
	@DrawableRes image: Int,
	@StringRes contentDescription: Int,
) {
	Column(modifier = modifier) {
		Image(
			painter = painterResource(id = image),
			contentDescription = stringResource(contentDescription),
			modifier = Modifier
				.heightIn(max = dimensionResource(id = R.dimen.card_image_height)),
			contentScale = ContentScale.Crop
		)
	}
}

@Composable
fun HeaderText(
	modifier: Modifier = Modifier,
	@StringRes text: Int,
	style: TextStyle = MaterialTheme.typography.titleMedium,
	textAlign: TextAlign = TextAlign.Center,
	color: Color = MaterialTheme.colorScheme.onBackground,
	textDecoration: TextDecoration = TextDecoration.None
) {
	Column(modifier = modifier) {
		Text(
			text = stringResource(id = text),
			style = style,
			textAlign = textAlign,
			color = color,
			textDecoration = textDecoration
		)
	}
}

@Composable
fun BodyText(
	modifier: Modifier = Modifier,
	@StringRes text: Int,
	style: TextStyle = MaterialTheme.typography.bodyMedium,
	textAlign: TextAlign = TextAlign.Center,
	color: Color = MaterialTheme.colorScheme.onBackground,
	textDecoration: TextDecoration = TextDecoration.None,
	fontWeight: FontWeight = FontWeight.Normal,
	fontStyle: FontStyle = FontStyle.Normal
) {
	Column(modifier = modifier) {
		Text(
			text = stringResource(id = text),
			style = style,
			textAlign = textAlign,
			color = color,
			textDecoration = textDecoration,
			fontWeight = fontWeight,
			fontStyle = fontStyle
		)
	}
}

@Composable
fun TitleTextIcon(
	modifier: Modifier = Modifier,
	@StringRes text: Int,
	@DrawableRes icon: Int,
	color: Color = MaterialTheme.colorScheme.onSurface,
) {
	Column(
		modifier = modifier,
	) {
		Row(
			verticalAlignment = Alignment.CenterVertically
		) {
			Icon(
				modifier = Modifier
					.size(dimensionResource(id = R.dimen.icon_size_small))
					.padding(
						start = dimensionResource(id = R.dimen.padding_verySmall),
						end = dimensionResource(id = R.dimen.padding_small)
					),
				painter = painterResource(id = icon),
				contentDescription = stringResource(id = text),
				tint = color
			)
			HeaderTextLarge(
				text = text,
				color = color,
			)
		}
		AppDivider(color = color)
	}
}

@Composable
fun IconTextRow(
	modifier: Modifier = Modifier,
	@DrawableRes icon: Int,
	iconTint: Color = MaterialTheme.colorScheme.onBackground,
	@StringRes text: Int,
	textColor: Color = MaterialTheme.colorScheme.onBackground,
	textDecoration: TextDecoration = TextDecoration.None,
	fontWeight: FontWeight = FontWeight.Normal,
	style: TextStyle = MaterialTheme.typography.bodyMedium
) {
	Column(modifier = modifier) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(vertical = dimensionResource(id = R.dimen.padding_medium_small)),
			verticalAlignment = Alignment.CenterVertically,
		) {
			Icon(
				modifier = Modifier
					.weight(1f),
				painter = painterResource(id = icon),
				contentDescription = null,
				tint = iconTint
			)
			BodyText(
				modifier = Modifier
					.weight(5f),
				text = text,
				color = textColor,
				textDecoration = textDecoration,
				fontWeight = fontWeight,
				style = style,
			)
		}
	}
}

@Composable
fun RadioText(
	modifier: Modifier = Modifier,
	@StringRes text: Int,
	color: Color = MaterialTheme.colorScheme.onBackground,
	style: TextStyle = MaterialTheme.typography.titleMedium,
	textAlign: TextAlign = TextAlign.Center,
) {
	Column(modifier = modifier) {
		BodyText(
			text = text,
			color = color,
			style = style,
			textAlign = textAlign,
		)
	}
}

@Composable
fun CalculateImage(
	modifier: Modifier = Modifier,
	@DrawableRes painter: Int,
	@StringRes contentDescription: Int,
	colorFilter: Color
) {
	Column(
		modifier = modifier
//			.size(dimensionResource(id = R.dimen.image_size_large))
			.padding(dimensionResource(id = R.dimen.padding_verySmall))
	) {
		Image(
			modifier = Modifier
				.heightIn(
					min = dimensionResource(id = R.dimen.image_size_large),
					max = 1500.dp
				),
			painter = painterResource(id = painter),
			contentDescription = stringResource(id = contentDescription),
			colorFilter = ColorFilter.tint(colorFilter)
		)
	}
}

@Preview(showBackground = true)
@Composable
fun CarbonDioxidePreview() {
	AquariumInformationTheme {
		val color = MaterialTheme.colorScheme.onBackground
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.surface)
		) {
			CalculateImage(
				painter = bowFrontDataSource.image,
				contentDescription = BowFront.title,
				colorFilter = color,
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun CarbonDioxidePreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		val color = MaterialTheme.colorScheme.onBackground
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.surface)
		) {
			CalculateImage(
				painter = bowFrontDataSource.image,
				contentDescription = BowFront.title,
				colorFilter = color,
			)
		}
	}
}