package com.ccaquatics.aquariuminformation.ui.commonui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

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
fun GenericCalculatePage(
	@StringRes title: Int,
	@StringRes subtitle: Int,
	@DrawableRes icon: Int,
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