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
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.ccaquatics.aquariuminformation.R
import com.ccaquatics.aquariuminformation.navigation.Alkalinity
import com.ccaquatics.aquariuminformation.navigation.BowFront
import com.ccaquatics.aquariuminformation.navigation.Calculators
import com.ccaquatics.aquariuminformation.navigation.CalculatorsNavHost
import com.ccaquatics.aquariuminformation.navigation.CarbonDioxide
import com.ccaquatics.aquariuminformation.navigation.Converters
import com.ccaquatics.aquariuminformation.navigation.ConvertersNavHost
import com.ccaquatics.aquariuminformation.navigation.Cube
import com.ccaquatics.aquariuminformation.navigation.Cylinder
import com.ccaquatics.aquariuminformation.navigation.FishCompatability
import com.ccaquatics.aquariuminformation.navigation.Hexagonal
import com.ccaquatics.aquariuminformation.navigation.Rectangle
import com.ccaquatics.aquariuminformation.navigation.Salinity
import com.ccaquatics.aquariuminformation.navigation.TankVolume
import com.ccaquatics.aquariuminformation.navigation.Temperature
import com.ccaquatics.aquariuminformation.ui.commonui.NavButton
import com.ccaquatics.aquariuminformation.ui.commonui.NavButtonRow
import com.ccaquatics.aquariuminformation.ui.commonui.NavButtonWide
import com.ccaquatics.aquariuminformation.ui.commonui.PageView
import com.ccaquatics.aquariuminformation.ui.commonui.TitleWideCard
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme

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
	onClickTemperature: () -> Unit,
	onClickSalinity: () -> Unit,
	onClickAlkalinity: () -> Unit,
){
	PageView {
		OverviewGenericLayout {
			ConvertersGrid(
				onClickTemperature = onClickTemperature,
				onClickSalinity = onClickSalinity,
				onClickAlkalinity = onClickAlkalinity
			)
		}
	}
}

@Composable
fun CalculatorsOverviewPage(
	onClickVolume: () -> Unit,
	onClickCo2: () -> Unit,
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
fun TankVolumeOverviewPage() {
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
	Column(modifier = modifier) {
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
	onClickSalinity: () -> Unit,
	onClickAlkalinity: () -> Unit,
) {
	Column(
		modifier = modifier,
	) {
		TitleWideCard(
			text = Converters.title,
			color = color,
			icon = Converters.icon
		) {
			NavButtonWide(
				title = Temperature.title,
				icon = Temperature.icon,
				onClick = onClickTemperature,
				contentColor = color
			)
			NavButtonRow(
				title1 = Salinity.title,
				icon1 = Salinity.icon,
				title2 = Alkalinity.title,
				icon2 = Alkalinity.icon,
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
		text = Calculators.title,
		color = color,
		icon = Calculators.icon
	) {
		NavButtonRow(
			title1 = TankVolume.title,
			icon1 = TankVolume.icon,
			title2 = CarbonDioxide.title,
			icon2 = CarbonDioxide.icon,
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
		text = TankVolume.title,
		icon = TankVolume.icon,
		color = color
	) {
		NavButtonRow(
			title1 = Rectangle.title,
			icon1 = Rectangle.icon,
			title2 = Cube.title,
			icon2 = Cube.icon,
			onClick1 = { /*TODO*/ },
			onClick2 = { /*TODO*/ },
			contentColor = color
		)
		NavButtonRow(
			title1 = Cylinder.title,
			icon1 = Cylinder.icon,
			title2 = Hexagonal.title,
			icon2 = Hexagonal.icon,
			onClick1 = { /*TODO*/ },
			onClick2 = {/*TODO*/},
			contentColor = color
		)
		Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
		NavButton(
			modifier = Modifier
				.fillMaxWidth(fraction = 0.9f),
			title = BowFront.title,
			icon = BowFront.icon,
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
		text = FishCompatability.title,
		color = color,
		icon = R.drawable.ic_fish_2
	) {
		NavButtonWide(
			title = R.string.text_welcome_compatibility_title,
			icon = FishCompatability.icon,
			contentColor = color,
			onClick = onClickFish,
		)
	}
}

@Composable
fun ConvertersNavHostScreen() {
	val navController = rememberNavController()
	Surface {
		ConvertersNavHost(navController = navController)
	}
}

@Composable
fun CalculatorsNavHostScreen() {
	val navController = rememberNavController()
	Surface {
		CalculatorsNavHost(navController = navController)
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
			TankVolumeOverviewPage()
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
			TankVolumeOverviewPage()
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