package cca.capitalcityaquatics.aquariuminfo.ui.pages.calculators

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.data.calculators.FlowRateData
import cca.capitalcityaquatics.aquariuminfo.data.calculators.flowRateDataSourceFreshwater
import cca.capitalcityaquatics.aquariuminfo.data.calculators.flowRateDataSourceMarine
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.GenericCalculatePage
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.HeaderText
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageView
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme

@Composable
fun FlowRatePage(windowSize: WindowSizeClass) {
	PageView(
		verticalArrangement = Arrangement.SpaceBetween
	) {
		FlowRateLayout(windowSize = windowSize)
	}

}

@SuppressLint("VisibleForTests")
@Composable
fun FlowRateLayout(
	windowSize: WindowSizeClass,
	color: Color = MaterialTheme.colorScheme.primary,
	containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
	contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
) {
	val dataSource = flowRateDataSourceFreshwater

	HeaderText(text = dataSource.subtitle)
	FlowRateCard(
		windowSize = windowSize,
		dataSource = flowRateDataSourceFreshwater
	)
	FlowRateCard(
		windowSize = windowSize,
		dataSource = flowRateDataSourceMarine
	)
}

@Composable
fun FlowRateCard(
	windowSize: WindowSizeClass,
	dataSource: FlowRateData,
) {
	Card(
		modifier = Modifier
			.padding(vertical = dimensionResource(id = R.dimen.padding_small))
	) {
		Column {
			Image(
				modifier = Modifier
					.fillMaxWidth(fraction = 0.9f)
					.height(150.dp),
				painter = painterResource(id = dataSource.image),
				contentDescription = null,
				contentScale = ContentScale.Crop
			)
			GenericCalculatePage(
				windowSize = windowSize,
				subtitleContent = {
					HeaderText(text = dataSource.header)
				},
				inputFieldContent = {

				},
				calculateFieldContent = { /*TODO*/ },
			)
		}
	}
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun FlowRatePagePreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.surface)
		) {
			FlowRatePage(
				windowSize = WindowSizeClass.calculateFromSize(
					DpSize(
						300.dp,
						400.dp
					)
				)
			)
		}
	}
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun FlowRate(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.surface)
		) {
			FlowRatePage(
				windowSize = WindowSizeClass.calculateFromSize(
					DpSize(
						300.dp,
						400.dp
					)
				)
			)
		}
	}
}