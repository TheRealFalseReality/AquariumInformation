package com.ccaquatics.aquariuminformation.ui.commonui

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
	modifier: Modifier = Modifier,
	content: @Composable () -> Unit,
) {
	Column(modifier = modifier) {
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
	modifier: Modifier = Modifier,
	content: @Composable () -> Unit,
) {
	Column(modifier = modifier) {
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
	modifier: Modifier = Modifier,
	content: @Composable ColumnScope.() -> Unit,
) {
	Column(modifier = modifier) {
		Column(
			modifier = Modifier.fillMaxSize(),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center
		) {
			content()
		}
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