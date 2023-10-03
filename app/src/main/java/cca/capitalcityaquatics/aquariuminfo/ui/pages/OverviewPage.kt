package cca.capitalcityaquatics.aquariuminfo.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.navigation.Alkalinity
import cca.capitalcityaquatics.aquariuminfo.navigation.BowFront
import cca.capitalcityaquatics.aquariuminfo.navigation.Calculators
import cca.capitalcityaquatics.aquariuminfo.navigation.CarbonDioxide
import cca.capitalcityaquatics.aquariuminfo.navigation.Cube
import cca.capitalcityaquatics.aquariuminfo.navigation.Cylinder
import cca.capitalcityaquatics.aquariuminfo.navigation.FishCompatibility
import cca.capitalcityaquatics.aquariuminfo.navigation.FishCompatibilityFreshwater
import cca.capitalcityaquatics.aquariuminfo.navigation.FishCompatibilityMarine
import cca.capitalcityaquatics.aquariuminfo.navigation.Hexagonal
import cca.capitalcityaquatics.aquariuminfo.navigation.Home
import cca.capitalcityaquatics.aquariuminfo.navigation.HomeInfo
import cca.capitalcityaquatics.aquariuminfo.navigation.Information
import cca.capitalcityaquatics.aquariuminfo.navigation.Rectangle
import cca.capitalcityaquatics.aquariuminfo.navigation.Salinity
import cca.capitalcityaquatics.aquariuminfo.navigation.TankVolume
import cca.capitalcityaquatics.aquariuminfo.navigation.Temperature
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.MediumSpacer
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.NavButton
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.NavButtonRow
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageView
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.TitleWideContent
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.VerySmallSpacer
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme

@Composable
fun OverviewPage(
	windowSize: WindowSizeClass,
	onClickTemperature: () -> Unit = {},
	onClickCo2: () -> Unit = {},
	onClickSalinity: () -> Unit = {},
	onClickAlkalinity: () -> Unit = {},
	onClickFreshwater: () -> Unit = {},
	onClickMarine: () -> Unit = {},
	onClickRectangle: () -> Unit = {},
	onClickCube: () -> Unit = {},
	onClickCylinder: () -> Unit = {},
	onClickHexagonal: () -> Unit = {},
	onClickBowFront: () -> Unit = {},
	onClickHome: () -> Unit = {},
	onClickInformation: () -> Unit = {},
) {
	PageView {
		OverviewLayout(
			windowSize = windowSize,
			onClickTemperature = onClickTemperature,
			onClickCo2 = onClickCo2,
			onClickSalinity = onClickSalinity,
			onClickAlkalinity = onClickAlkalinity,
			onClickFreshwater = onClickFreshwater,
			onClickMarine = onClickMarine,
			onClickRectangle = onClickRectangle,
			onClickCube = onClickCube,
			onClickCylinder = onClickCylinder,
			onClickHexagonal = onClickHexagonal,
			onClickBowFront = onClickBowFront,
			onClickHome = onClickHome,
			onClickInformation = onClickInformation
		)
	}
}

@Composable
fun OverviewLayout(
	windowSize: WindowSizeClass,
	onClickTemperature: () -> Unit,
	onClickCo2: () -> Unit,
	onClickSalinity: () -> Unit,
	onClickAlkalinity: () -> Unit,
	onClickFreshwater: () -> Unit,
	onClickMarine: () -> Unit,
	onClickRectangle: () -> Unit,
	onClickCube: () -> Unit,
	onClickCylinder: () -> Unit,
	onClickHexagonal: () -> Unit,
	onClickBowFront: () -> Unit,
	onClickHome: () -> Unit,
	onClickInformation: () -> Unit,
) {
	CalculatorsGrid(
		onClickTemperature = onClickTemperature,
		onClickSalinity = onClickSalinity,
		onClickAlkalinity = onClickAlkalinity,
		onClickCo2 = onClickCo2
	)
	VerySmallSpacer()
	TankVolumeGrid(
		onClickRectangle = onClickRectangle,
		onClickCube = onClickCube,
		onClickCylinder = onClickCylinder,
		onClickHexagonal = onClickHexagonal,
		onClickBowFront = onClickBowFront,
	)
	VerySmallSpacer()
	FishCompatibilityGrid(
		onClickFreshwater = onClickFreshwater,
		onClickMarine = onClickMarine,
	)
	when (windowSize.widthSizeClass) {
		WindowWidthSizeClass.Expanded -> {
			HomeInfoGrid(
				onClickHome = onClickHome,
				onClickInformation = onClickInformation
			)
		}
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
	PageView {
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
	onClickTemperature: () -> Unit = {},
	onClickSalinity: () -> Unit = {},
	onClickAlkalinity: () -> Unit = {},
	onClickCo2: () -> Unit = {},
) {
	Column(modifier = modifier) {
		TitleWideContent(
			text = Calculators.title,
			color = fontColor,
			icon = Calculators.icon
		) {
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
			MediumSpacer()
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

@Composable
fun TankVolumeGrid(
	modifier: Modifier = Modifier,
	fontColor: Color = MaterialTheme.colorScheme.secondary,
	contentColor: Color = MaterialTheme.colorScheme.onSecondaryContainer,
	containerColor: Color = MaterialTheme.colorScheme.secondaryContainer,
	onClickRectangle: () -> Unit = {},
	onClickCube: () -> Unit = {},
	onClickCylinder: () -> Unit = {},
	onClickHexagonal: () -> Unit = {},
	onClickBowFront: () -> Unit = {},
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
			MediumSpacer()
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
			MediumSpacer()
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
fun FishCompatibilityGrid(
	modifier: Modifier = Modifier,
	fontColor: Color = MaterialTheme.colorScheme.tertiary,
	contentColor: Color = MaterialTheme.colorScheme.onTertiaryContainer,
	containerColor: Color = MaterialTheme.colorScheme.tertiaryContainer,
	onClickFreshwater: () -> Unit = {},
	onClickMarine: () -> Unit = {},
) {
	Column(modifier) {
		TitleWideContent(
			text = FishCompatibility.title,
			color = fontColor,
			icon = FishCompatibility.icon
		) {
			NavButtonRow(
				title1 = FishCompatibilityFreshwater.title,
				icon1 = FishCompatibilityFreshwater.icon,
				title2 = FishCompatibilityMarine.title,
				icon2 = FishCompatibilityMarine.icon,
				containerColor = containerColor,
				contentColor = contentColor,
				onClick1 = onClickFreshwater,
				onClick2 = onClickMarine
			)
		}
	}
}

@Composable
fun HomeInfoGrid(
	modifier: Modifier = Modifier,
	fontColor: Color = MaterialTheme.colorScheme.onBackground,
	contentColor: Color = MaterialTheme.colorScheme.onSurface,
	containerColor: Color = MaterialTheme.colorScheme
		.surfaceColorAtElevation(dimensionResource(id = R.dimen.tonal_elevation_medium)),
	onClickHome: () -> Unit = {},
	onClickInformation: () -> Unit = {},
) {
	Column(modifier) {
		TitleWideContent(
			text = HomeInfo.title,
			color = fontColor,
			icon = HomeInfo.icon
		) {
			NavButtonRow(
				title1 = Home.title,
				icon1 = Home.icon,
				title2 = Information.title,
				icon2 = Information.icon,
				containerColor = containerColor,
				contentColor = contentColor,
				onClick1 = onClickHome,
				onClick2 = onClickInformation
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
			CalculatorsGrid()
			VerySmallSpacer()
			TankVolumeGrid()
			VerySmallSpacer()
			FishCompatibilityGrid()
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
			CalculatorsGrid()
			VerySmallSpacer()
			TankVolumeGrid()
			VerySmallSpacer()
			FishCompatibilityGrid()
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