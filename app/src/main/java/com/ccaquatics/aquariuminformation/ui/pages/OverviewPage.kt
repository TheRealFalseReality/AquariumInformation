package com.ccaquatics.aquariuminformation.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ccaquatics.aquariuminformation.R
import com.ccaquatics.aquariuminformation.navigation.Alkalinity
import com.ccaquatics.aquariuminformation.navigation.BowFront
import com.ccaquatics.aquariuminformation.navigation.Calculators
import com.ccaquatics.aquariuminformation.navigation.CarbonDioxide
import com.ccaquatics.aquariuminformation.navigation.Converters
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
import com.ccaquatics.aquariuminformation.ui.commonui.PageViewCenter
import com.ccaquatics.aquariuminformation.ui.commonui.TitleWideContent
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
	onClickTemperature: () -> Unit,
	onClickCo2: () -> Unit,
	onClickSalinity: () -> Unit,
	onClickAlkalinity: () -> Unit,
	onClickVolume: () -> Unit,
	onClickFish: () -> Unit,
) {
	ConvertersGrid(
		onClickTemperature = onClickTemperature,
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

@Composable
fun ConvertersOverviewPage(
	onClickTemperature: () -> Unit,
	onClickSalinity: () -> Unit,
	onClickAlkalinity: () -> Unit,
) {
	PageViewCenter {
		ConvertersGrid(
			onClickTemperature = onClickTemperature,
			onClickSalinity = onClickSalinity,
			onClickAlkalinity = onClickAlkalinity
		)
	}
}

@Composable
fun CalculatorsOverviewPage(
	onClickVolume: () -> Unit,
	onClickCo2: () -> Unit,
) {
	PageViewCenter {
		CalculatorsGrid(
			onClickVolume = onClickVolume,
			onClickCo2 = onClickCo2,
		)
	}
}

@Composable
fun TankVolumeOverviewPage(
	onClickRectangle: () -> Unit = {},
	onClickCube: () -> Unit = {},
	onClickCylinder: () -> Unit = {},
	onClickHexagonal: () -> Unit = {},
	onClickBowFront: () -> Unit = {},
) {
	PageViewCenter {
		TankVolumeGrid(
			onClickRectangle = onClickRectangle,
			onClickCube = onClickCube,
			onClickCylinder = onClickCylinder,
			onClickHexagonal = onClickHexagonal,
			onClickBowFront = onClickBowFront
		)
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
	Column(modifier = modifier) {
		TitleWideContent(
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
	modifier: Modifier = Modifier,
	color: Color = MaterialTheme.colorScheme.secondary,
	onClickVolume: () -> Unit,
	onClickCo2: () -> Unit,
) {
	Column(modifier = modifier) {
		TitleWideContent(
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
}

@Composable
fun TankVolumeGrid(
	modifier: Modifier = Modifier,
	color: Color = MaterialTheme.colorScheme.secondary,
	onClickRectangle: () -> Unit,
	onClickCube: () -> Unit,
	onClickCylinder: () -> Unit,
	onClickHexagonal: () -> Unit,
	onClickBowFront: () -> Unit,
) {
	Column(modifier = modifier) {
		TitleWideContent(
			text = TankVolume.title,
			icon = TankVolume.icon,
			color = color
		) {
			NavButtonRow(
				title1 = Rectangle.title,
				icon1 = Rectangle.icon,
				title2 = Cube.title,
				icon2 = Cube.icon,
				onClick1 = onClickRectangle,
				onClick2 = onClickCube,
				contentColor = color
			)
			NavButtonRow(
				title1 = Cylinder.title,
				icon1 = Cylinder.icon,
				title2 = Hexagonal.title,
				icon2 = Hexagonal.icon,
				onClick1 = onClickCylinder,
				onClick2 = onClickHexagonal,
				contentColor = color
			)
			NavButton(
				modifier = Modifier
					.fillMaxWidth(fraction = 0.9f),
				title = BowFront.title,
				icon = BowFront.icon,
				onClick = onClickBowFront,
				contentColor = color
			)
		}
	}
}

@Composable
fun FishCompatability(
	modifier: Modifier = Modifier,
	color: Color = MaterialTheme.colorScheme.tertiary,
	onClickFish: () -> Unit = {},
) {
	Column(modifier) {
		TitleWideContent(
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