package com.ccaquatics.aquariuminformation.ui.commonui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.ccaquatics.aquariuminformation.R
import com.ccaquatics.aquariuminformation.data.calculators.bowFrontDataSource
import com.ccaquatics.aquariuminformation.navigation.BowFront
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme

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
fun HeaderText(
	modifier: Modifier = Modifier,
	@StringRes text: Int,
	style: TextStyle = MaterialTheme.typography.titleMedium,
	textAlign: TextAlign = TextAlign.Center,
	color: Color = MaterialTheme.colorScheme.onBackground
) {
	Column(modifier = modifier) {
		Text(
			text = stringResource(id = text),
			style = style,
			textAlign = textAlign,
			color = color
		)
	}
}

@Composable
fun BodyText(
	modifier: Modifier = Modifier,
	@StringRes text: Int,
	style: TextStyle = MaterialTheme.typography.bodyMedium,
	textAlign: TextAlign = TextAlign.Center,
	color: Color = MaterialTheme.colorScheme.onBackground
) {
	Column(modifier = modifier) {
		Text(
			text = stringResource(id = text),
			style = style,
			textAlign = textAlign,
			color = color
		)
	}
}

@Composable
fun TextRow(
	modifier: Modifier = Modifier,
	@StringRes text1: Int,
	@StringRes text2: Int,
	color: Color = MaterialTheme.colorScheme.onBackground
) {
	Column(modifier = modifier) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(dimensionResource(id = R.dimen.padding_verySmall)),
			verticalAlignment = Alignment.CenterVertically
		) {
			BodyText(
				modifier = Modifier
					.weight(1f),
				text = text1,
				color = color
			)
			BodyText(
				modifier = Modifier
					.weight(1f),
				text = text2,
				color = color
			)
		}
	}
}

@Composable
fun IconTextRow(
	modifier: Modifier = Modifier,
	@DrawableRes icon: Int,
	iconTint: Color = MaterialTheme.colorScheme.onBackground,
	@StringRes text: Int,
	textColor: Color = MaterialTheme.colorScheme.onBackground
) {
	Column(modifier = modifier) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(dimensionResource(id = R.dimen.padding_verySmall)),
			verticalAlignment = Alignment.CenterVertically
		) {
			Icon(
				modifier = Modifier
					.weight(1f),
				painter = painterResource(id = icon),
				contentDescription = null,
				tint = iconTint
			)
			Text(
				modifier = Modifier
					.weight(5f),
				text = stringResource(id = text),
				color = textColor
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
	textAlign: TextAlign = TextAlign.Start,
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
				.height(dimensionResource(id = R.dimen.image_size_large)),
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