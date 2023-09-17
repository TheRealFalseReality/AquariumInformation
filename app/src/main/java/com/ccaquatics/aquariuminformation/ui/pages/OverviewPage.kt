package com.ccaquatics.aquariuminformation.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.ccaquatics.aquariuminformation.ui.commonui.NavButton
import com.ccaquatics.aquariuminformation.ui.commonui.NavButtonRow
import com.ccaquatics.aquariuminformation.ui.commonui.NavButtonWide
import com.ccaquatics.aquariuminformation.ui.commonui.PageView
import com.ccaquatics.aquariuminformation.ui.commonui.TitleWideCard
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme
import com.example.aquariuminformation.R

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
		OverviewGenericLayout {
			ConvertersGrid(
				onClickTemperature = onClickTemperature,
//				onClickCo2 = onClickCo2,
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
fun ConvertersOverviewPage(
	onClickTemperature: () -> Unit = {},
	onClickCo2: () -> Unit = {},
	onClickSalinity: () -> Unit = {},
	onClickAlkalinity: () -> Unit = {},
){
	PageView {
		OverviewGenericLayout {
			ConvertersGrid(
				onClickTemperature = onClickTemperature,
//				onClickCo2 = onClickCo2,
				onClickSalinity = onClickSalinity,
				onClickAlkalinity = onClickAlkalinity
			)
		}
	}
}

@Composable
fun CalculatorsOverviewPage(
	onClickVolume: () -> Unit = {},
	onClickCo2: () -> Unit = {},
){
	PageView {
		OverviewGenericLayout {
			CalculatorsGrid(
				onClickVolume = onClickVolume,
				onClickCo2 = onClickCo2,
			)
		}
	}
}

@Composable
fun TankOverviewPage() {
	PageView {
		OverviewGenericLayout {
			TankVolumeGrid()
		}
	}
}

@Composable
fun OverviewGenericLayout(
	modifier: Modifier = Modifier,
	content: @Composable ColumnScope.() -> Unit,
) {
	Column(
		modifier = modifier,
	) {
		Column(
			modifier = Modifier.fillMaxSize(),
			verticalArrangement = Arrangement.SpaceEvenly,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
//			HeaderTextLarge(text = "Tap to Choose")
			content()
		}
	}
}

@Composable
fun ConvertersGrid(
	modifier: Modifier = Modifier,
	color: Color = MaterialTheme.colorScheme.primary,
	onClickTemperature: () -> Unit,
//	onClickCo2: () -> Unit,
	onClickSalinity: () -> Unit,
	onClickAlkalinity: () -> Unit,
) {
	Column(
		modifier = modifier,
	) {
		TitleWideCard(
			text = R.string.converters,
			color = color,
			icon = R.drawable.ic_conversion
		) {
			NavButtonWide(
				title = R.string.temperature,
				icon = R.drawable.ic_thermostat,
				onClick = onClickTemperature,
				contentColor = color
			)
//			Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
//			NavButton(
//				modifier = Modifier
//					.fillMaxWidth(fraction = 0.9f),
//				title = R.string.temperature,
//				icon = R.drawable.ic_thermostat,
//				onClick = onClickTemperature,
//				contentColor = color
//			)
//			Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
//			NavButtonRow(
//				title1 = R.string.temperature,
//				icon1 = R.drawable.ic_thermostat,
//				title2 = R.string.carbon_dioxide,
//				icon2 = R.drawable.baseline_co2_24,
//				contentColor = color,
//				onClick1 = onClickTemperature,
//				onClick2 = onClickCo2,
//			)
			NavButtonRow(
				title1 = R.string.salinity,
				icon1 = R.drawable.ic_salinity_alt,
				title2 = R.string.alkalinity,
				icon2 = R.drawable.ic_water_do,
				contentColor = color,
				onClick1 = onClickSalinity,
				onClick2 = onClickAlkalinity,
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
		text = R.string.calculators,
		color = color,
		icon = R.drawable.ic_calculate
	) {
		NavButtonRow(
			title1 = R.string.tank_volume,
			icon1 = R.drawable.ic_volume,
			title2 = R.string.carbon_dioxide,
			icon2 = R.drawable.baseline_co2_24,
			contentColor = color,
			onClick1 = onClickVolume,
			onClick2 = onClickCo2,
		)
	}
}

@Composable
fun TankVolumeGrid(
	color: Color = MaterialTheme.colorScheme.secondary
) {
	TitleWideCard(
		text = R.string.tank_volume,
		icon = R.drawable.ic_volume,
		color = color
	) {
		NavButtonRow(
			title1 = R.string.text_title_rectangle,
			icon1 = R.drawable.ic_rectangle,
			title2 = R.string.text_title_cube,
			icon2 = R.drawable.ic_cube_2,
			onClick1 = { /*TODO*/ },
			onClick2 = { /*TODO*/ },
			contentColor = color
		)
		NavButtonRow(
			title1 = R.string.text_title_cyl,
			icon1 = R.drawable.ic_cylinder,
			title2 = R.string.text_title_hex,
			icon2 = R.drawable.ic_hex,
			onClick1 = { /*TODO*/ },
			onClick2 = {/*TODO*/},
			contentColor = color
		)
		Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
		NavButton(
			modifier = Modifier
				.fillMaxWidth(fraction = 0.9f),
			title = R.string.text_title_bow_front,
			icon = R.drawable.ic_bow_front,
			onClick = { /*TODO*/},
			contentColor = color
		)
	}
}

@Composable
fun FishCompatability(
	color: Color = MaterialTheme.colorScheme.tertiary,
	onClickFish: () -> Unit = {},
) {
	TitleWideCard(
		text = R.string.text_fish_compatibility,
		color = color,
		icon = R.drawable.ic_fish_2
	) {
		NavButtonWide(
			title = R.string.text_welcome_compatibility_title,
			icon = R.drawable.ic_icon_question,
			contentColor = color,
			onClick = onClickFish,
		)
//		NavButton(
//			modifier = Modifier
//				.fillMaxWidth(fraction = 0.9f),
//			title = R.string.text_welcome_compatibility_title,
//			icon = R.drawable.ic_icon_question,
//			contentColor = color,
//			onClick = onClickFish,
//		)
	}
}

@Preview(showBackground = true)
@Composable
fun TankVolumePreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			TankOverviewPage()
		}
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
			TankOverviewPage()
		}
	}
}

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