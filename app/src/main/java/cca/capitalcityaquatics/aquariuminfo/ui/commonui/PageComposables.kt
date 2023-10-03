package cca.capitalcityaquatics.aquariuminfo.ui.commonui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import cca.capitalcityaquatics.aquariuminfo.R

@Composable
fun PageView(
	modifier: Modifier = Modifier,
	verticalArrangement: Arrangement.Vertical = Arrangement.SpaceAround,
	content: @Composable () -> Unit,
) {
	Column(modifier = modifier) {
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(vertical = dimensionResource(id = R.dimen.padding_verySmall))
				.verticalScroll(rememberScrollState()),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = verticalArrangement
		) {
			content()
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
			modifier = Modifier
				.padding(vertical = dimensionResource(id = R.dimen.padding_verySmall))
				.fillMaxSize(),
			horizontalAlignment = Alignment.CenterHorizontally,
		) {
			content()
		}
	}
}

@Composable
fun GenericCalculatePage(
	windowSize: WindowSizeClass,
	subtitleContent: @Composable () -> Unit = {},
	selectContent: @Composable () -> Unit = {},
	optionsContent: @Composable () -> Unit = {},
	inputFieldContent: @Composable () -> Unit,
	calculateFieldContent: @Composable () -> Unit,
	imageContent: @Composable (() -> Unit)? = null,
	formulaContent: @Composable () -> Unit
) {
	when (windowSize.widthSizeClass) {
		WindowWidthSizeClass.Expanded -> {
			Row(
				verticalAlignment = Alignment.CenterVertically
			) {
				Column(
					modifier = Modifier
						.heightIn(min = dimensionResource(id = R.dimen.landscape_column_height))
						.weight(1f),
					horizontalAlignment = Alignment.CenterHorizontally,
					verticalArrangement = Arrangement.SpaceAround
				) {
					subtitleContent()
					SmallSpacer()
					selectContent()
					SmallSpacer()
					optionsContent()
					SmallSpacer()
					inputFieldContent()
				}
				Column(
					modifier = Modifier
						.heightIn(min = dimensionResource(id = R.dimen.landscape_column_height))
						.weight(1f),
					horizontalAlignment = Alignment.CenterHorizontally,
					verticalArrangement = Arrangement.Center
				) {
					calculateFieldContent()
				}
			}
			MediumSpacer()
			Row(
				verticalAlignment = Alignment.Top
			) {
				if (imageContent != null) {
					Column(
						modifier = Modifier
							.weight(1f),
						horizontalAlignment = Alignment.CenterHorizontally,
					) {
						imageContent()
					}
					Column(
						modifier = Modifier.weight(1f),
						horizontalAlignment = Alignment.CenterHorizontally,
					) {
						formulaContent()
					}
				} else {
					Column(
						horizontalAlignment = Alignment.CenterHorizontally,
					) {
						formulaContent()
					}
				}
			}
		}

		else -> {
			subtitleContent()
			SmallSpacer()
			selectContent()
			SmallSpacer()
			optionsContent()
			SmallSpacer()
			inputFieldContent()
			MediumSpacer()
			calculateFieldContent()
			SmallSpacer()
			if (imageContent != null) {
				imageContent()
			}
			SmallSpacer()
			formulaContent()
		}
	}
}