package com.example.aquariuminformation.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.aquariuminformation.R
import com.example.aquariuminformation.ui.commonui.NavButton
import com.example.aquariuminformation.ui.commonui.NavButtonRow
import com.example.aquariuminformation.ui.commonui.PageView
import com.example.aquariuminformation.ui.commonui.TitleWideCard
import com.example.aquariuminformation.ui.theme.AquariumInformationTheme

@Composable
fun OverviewPage(
	onClickTemperature: () -> Unit = {},
	onClickCo2: () -> Unit = {},
	onClickSalinity: () -> Unit = {},
	onClickAlkalinity: () -> Unit = {},
	onClickVolume: () -> Unit = {},
	onClickFish: () -> Unit = {},
) {
	PageView {
		OverviewLayout(
			onClickTemperature = onClickTemperature,
			onClickCo2 = onClickCo2,
			onClickSalinity = onClickSalinity,
			onClickAlkalinity = onClickAlkalinity,
			onClickVolume = onClickVolume,
			onClickFish = onClickFish,
		)
	}
}

@Composable
fun OverviewLayout(
	modifier: Modifier = Modifier,
	onClickTemperature: () -> Unit,
	onClickCo2: () -> Unit,
	onClickSalinity: () -> Unit,
	onClickAlkalinity: () -> Unit,
	onClickVolume: () -> Unit,
	onClickFish: () -> Unit,
) {
	Column(
		modifier = modifier,
	) {
		Column(
			modifier = Modifier.fillMaxSize(),
			verticalArrangement = Arrangement.SpaceEvenly
		) {
			ConvertersGrid(
				onClickTemperature = onClickTemperature,
				onClickCo2 = onClickCo2,
				onClickSalinity = onClickSalinity,
				onClickAlkalinity = onClickAlkalinity
			)
			CalculatorsGrid(
				onClickVolume = onClickVolume,
				onClickCo2 = onClickCo2,
			)
			FishCompatability(
				onClickFish = onClickFish,
			)
		}
	}
}

@Composable
fun ConvertersGrid(
	modifier: Modifier = Modifier,
	color: Color = MaterialTheme.colorScheme.primary,
	onClickTemperature: () -> Unit,
	onClickCo2: () -> Unit,
	onClickSalinity: () -> Unit,
	onClickAlkalinity: () -> Unit,
) {
	Column(
		modifier = modifier,
	) {
		TitleWideCard(
			text = stringResource(id = R.string.converters),
			color = color,
			icon = painterResource(id = R.drawable.ic_conversion)
		) {
			NavButtonRow(
				title1 = stringResource(id = R.string.temperature),
				icon1 = painterResource(id = R.drawable.ic_thermostat),
				title2 = stringResource(R.string.carbon_dioxide),
				icon2 = painterResource(id = R.drawable.baseline_co2_24),
				contentColor = color,
				onClick1 = onClickTemperature,
				onClick2 = onClickCo2,
				modifier = Modifier.fillMaxWidth(fraction = 0.9f)
			)
			NavButtonRow(
				title1 = stringResource(R.string.salinity),
				icon1 = painterResource(id = R.drawable.ic_salinity),
				title2 = stringResource(R.string.alkalinity),
				icon2 = painterResource(id = R.drawable.ic_water_drop),
				contentColor = color,
				onClick1 = onClickSalinity,
				onClick2 = onClickAlkalinity,
				modifier = Modifier.fillMaxWidth(fraction = 0.9f)
			)
		}
	}
}

@Composable
fun CalculatorsGrid(
	color: Color = MaterialTheme.colorScheme.secondary,
	onClickVolume: () -> Unit,
	onClickCo2: () -> Unit,
) {
	TitleWideCard(
		text = stringResource(id = R.string.calculators),
		color = color,
		icon = painterResource(id = R.drawable.baseline_calculate_24)
	) {
		NavButtonRow(
			title1 = stringResource(R.string.tank_volume),
			icon1 = painterResource(id = R.drawable.ic_cube),
			title2 = stringResource(R.string.carbon_dioxide),
			icon2 = painterResource(id = R.drawable.baseline_co2_24),
			contentColor = color,
			onClick1 = onClickVolume,
			onClick2 = onClickCo2,
			modifier = Modifier.fillMaxWidth(fraction = 0.9f)
		)
	}
}

@Composable
fun FishCompatability(
	color: Color = MaterialTheme.colorScheme.tertiary,
	onClickFish: () -> Unit,
) {
	TitleWideCard(
		text = stringResource(id = R.string.text_fish_compatibility),
		color = color,
		icon = painterResource(id = R.drawable.baseline_set_meal_24)
	) {
		NavButton(
			title = stringResource(id = R.string.text_welcome_compatibility_title),
			icon = painterResource(id = R.drawable.baseline_set_meal_24),
			contentColor = color,
			modifier = Modifier
				.fillMaxWidth(fraction = 0.9f)
				.padding(top = dimensionResource(id = R.dimen.padding_small)),
			onClick = onClickFish,
		)
	}
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun OverviewPreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			OverviewPage()
		}
	}
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun OverviewPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			OverviewPage()
		}
	}
}