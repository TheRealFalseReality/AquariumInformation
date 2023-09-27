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
import com.ccaquatics.aquariuminformation.navigation.Cube
import com.ccaquatics.aquariuminformation.navigation.Cylinder
import com.ccaquatics.aquariuminformation.navigation.FishCompatability
import com.ccaquatics.aquariuminformation.navigation.FishCompatabilityFreshwater
import com.ccaquatics.aquariuminformation.navigation.FishCompatabilityMarine
import com.ccaquatics.aquariuminformation.navigation.Hexagonal
import com.ccaquatics.aquariuminformation.navigation.Rectangle
import com.ccaquatics.aquariuminformation.navigation.Salinity
import com.ccaquatics.aquariuminformation.navigation.TankVolume
import com.ccaquatics.aquariuminformation.navigation.Temperature
import com.ccaquatics.aquariuminformation.ui.commonui.NavButton
import com.ccaquatics.aquariuminformation.ui.commonui.NavButtonRow
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
//	onClickVolume: () -> Unit = {},
	onClickFreshwater: () -> Unit = {},
	onClickMarine: () -> Unit = {},
	onClickRectangle: () -> Unit = {},
	onClickCube: () -> Unit = {},
	onClickCylinder: () -> Unit = {},
	onClickHexagonal: () -> Unit = {},
	onClickBowFront: () -> Unit = {},
) {
	PageView {
		OverviewLayout(
			onClickTemperature = onClickTemperature,
			onClickCo2 = onClickCo2,
			onClickSalinity = onClickSalinity,
			onClickAlkalinity = onClickAlkalinity,
//			onClickVolume = onClickVolume,
			onClickFreshwater = onClickFreshwater,
			onClickMarine = onClickMarine,
			onClickRectangle = onClickRectangle,
			onClickCube = onClickCube,
			onClickCylinder = onClickCylinder,
			onClickHexagonal = onClickHexagonal,
			onClickBowFront = onClickBowFront
		)
	}
}

@Composable
fun OverviewLayout(
	onClickTemperature: () -> Unit,
	onClickCo2: () -> Unit,
	onClickSalinity: () -> Unit,
	onClickAlkalinity: () -> Unit,
//	onClickVolume: () -> Unit,
	onClickFreshwater: () -> Unit,
	onClickMarine: () -> Unit,
	onClickRectangle: () -> Unit,
	onClickCube: () -> Unit,
	onClickCylinder: () -> Unit,
	onClickHexagonal: () -> Unit,
	onClickBowFront: () -> Unit,
) {
	CalculatorsGrid(
		onClickTemperature = onClickTemperature,
		onClickSalinity = onClickSalinity,
		onClickAlkalinity = onClickAlkalinity,
		onClickCo2 = onClickCo2
	)
	TankVolumeGrid(
		onClickRectangle = onClickRectangle,
		onClickCube = onClickCube,
		onClickCylinder = onClickCylinder,
		onClickHexagonal = onClickHexagonal,
		onClickBowFront = onClickBowFront,
	)
	FishCompatability(
		onClickFreshwater = onClickFreshwater,
		onClickMarine = onClickMarine,
	)
}

//@Composable
//fun ConvertersOverviewPage(
//	onClickTemperature: () -> Unit,
//	onClickSalinity: () -> Unit,
//	onClickAlkalinity: () -> Unit,
//) {
//	PageViewCenter {
//		ConvertersGrid(
//			onClickTemperature = onClickTemperature,
//			onClickSalinity = onClickSalinity,
//			onClickAlkalinity = onClickAlkalinity
//		)
//	}
//}

//@Composable
//fun CalculatorsOverviewPage(
//	onClickVolume: () -> Unit,
//	onClickCo2: () -> Unit,
//) {
//	PageViewCenter {
//		CalculatorsGrid(
//			onClickVolume = onClickVolume,
//			onClickCo2 = onClickCo2,
//		)
//	}
//}

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
fun CalculatorsGrid(
	modifier: Modifier = Modifier,
	fontColor: Color = MaterialTheme.colorScheme.primary,
	contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
	containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
	onClickTemperature: () -> Unit,
	onClickSalinity: () -> Unit,
	onClickAlkalinity: () -> Unit,
	onClickCo2: () -> Unit,
) {
	Column(modifier = modifier) {
		TitleWideContent(
			text = Calculators.title,
			color = fontColor,
			icon = Calculators.icon
		) {
//			NavButtonWide(
//				title = Temperature.title,
//				icon = Temperature.icon,
//				onClick = onClickTemperature,
//				contentColor = contentColor,
//				containerColor = containerColor
//			)
			NavButtonRow(
				title1 = Salinity.title,
				icon1 = Salinity.icon,
				title2 = Alkalinity.title,
				icon2 = Alkalinity.icon,
				contentColor = contentColor,
				containerColor = containerColor,
				onClick1 = onClickSalinity,
				onClick2 = onClickAlkalinity,
			)
			NavButtonRow(
				title1 = Temperature.title,
				icon1 = Temperature.icon,
				title2 = CarbonDioxide.title,
				icon2 = CarbonDioxide.icon,
				containerColor = containerColor,
				contentColor = contentColor,
				onClick1 = onClickTemperature,
				onClick2 = onClickCo2
			)
		}
	}
}

//@Composable
//fun CalculatorsGrid(
//	modifier: Modifier = Modifier,
//	fontColor: Color =  MaterialTheme.colorScheme.secondary,
//	contentColor: Color = MaterialTheme.colorScheme.onSecondaryContainer,
//	containerColor: Color = MaterialTheme.colorScheme.secondaryContainer,
//	onClickVolume: () -> Unit,
//	onClickCo2: () -> Unit,
//) {
//	Column(modifier = modifier) {
//		TitleWideContent(
//			text = Calculators.title,
//			color = fontColor,
//			icon = Calculators.icon
//		) {
//			NavButtonRow(
//				title1 = TankVolume.title,
//				icon1 = TankVolume.icon,
//				title2 = CarbonDioxide.title,
//				icon2 = CarbonDioxide.icon,
//				contentColor = contentColor,
//				containerColor = containerColor,
//				onClick1 = onClickVolume,
//				onClick2 = onClickCo2,
//			)
//		}
//	}
//}

@Composable
fun TankVolumeGrid(
	modifier: Modifier = Modifier,
	fontColor: Color = MaterialTheme.colorScheme.secondary,
	contentColor: Color = MaterialTheme.colorScheme.onSecondaryContainer,
	containerColor: Color = MaterialTheme.colorScheme.secondaryContainer,
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
			color = fontColor
		) {
			NavButtonRow(
				title1 = Rectangle.title,
				icon1 = Rectangle.icon,
				title2 = Cube.title,
				icon2 = Cube.icon,
				onClick1 = onClickRectangle,
				onClick2 = onClickCube,
				contentColor = contentColor,
				containerColor = containerColor,
			)
			NavButtonRow(
				title1 = Cylinder.title,
				icon1 = Cylinder.icon,
				title2 = Hexagonal.title,
				icon2 = Hexagonal.icon,
				onClick1 = onClickCylinder,
				onClick2 = onClickHexagonal,
				contentColor = contentColor,
				containerColor = containerColor,
			)
			NavButton(
				modifier = Modifier
					.fillMaxWidth(fraction = 0.9f),
				title = BowFront.title,
				icon = BowFront.icon,
				onClick = onClickBowFront,
				contentColor = contentColor,
				containerColor = containerColor,
			)
		}
	}
}

@Composable
fun FishCompatability(
	modifier: Modifier = Modifier,
	fontColor: Color = MaterialTheme.colorScheme.tertiary,
	contentColor: Color = MaterialTheme.colorScheme.onTertiaryContainer,
	containerColor: Color = MaterialTheme.colorScheme.tertiaryContainer,
	onClickFreshwater: () -> Unit,
	onClickMarine: () -> Unit,
) {
	Column(modifier) {
		TitleWideContent(
			text = FishCompatability.title,
			color = fontColor,
			icon = R.drawable.ic_fish_2
		) {
			NavButtonRow(
				title1 = FishCompatabilityFreshwater.title,
				icon1 = FishCompatabilityFreshwater.icon,
				title2 = FishCompatabilityMarine.title,
				icon2 = FishCompatabilityMarine.icon,
				containerColor = containerColor,
				contentColor = contentColor,
				onClick1 = onClickFreshwater,
				onClick2 = onClickMarine
			)
//			NavButtonWide(
//				title = R.string.text_welcome_compatibility_title,
//				icon = FishCompatability.icon,
//				contentColor = contentColor,
//				containerColor = containerColor,
//				onClick = onClickFish,
//			)
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