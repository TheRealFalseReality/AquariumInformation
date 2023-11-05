package cca.capitalcityaquatics.aquariuminfo.ui.pages.calculators

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.data.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.data.calculators.flowRateDataSource
import cca.capitalcityaquatics.aquariuminfo.model.calculators.CalculatorMethods
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateField
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatedTextString
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.GenericCalculatePage
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.HeaderText
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.InputNumberField
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.TextCard
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme

@Composable
fun FlowRatePage(windowSize: WindowSizeClass) {
	FlowRateLayout(windowSize = windowSize)
}

@SuppressLint("VisibleForTests")
@Composable
fun FlowRateLayout(
	windowSize: WindowSizeClass,
	color: Color = MaterialTheme.colorScheme.primary,
	containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
	contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
) {
	val dataSourceCommon = calculatorDataSource
	val dataSourceSpecific = flowRateDataSource
	var inputVolume  by rememberSaveable {
		mutableStateOf("60")
	}
	val tankVolume = inputVolume.toDoubleOrNull() ?: 0.0
	val parameters = CalculatorMethods(tankVolume = tankVolume)

	GenericCalculatePage(
		windowSize = windowSize,
		subtitleContent = {
			HeaderText(
				text = dataSourceSpecific.subtitle, // TODO
				color = color
			)
		},
		selectContent = {
			TextCard(
				text = dataSourceSpecific.subtitle, // TODO
				contentColor = color
			)
		},
		inputFieldContent = {
			InputNumberField(
				label = dataSourceCommon.labelTankVolume,
				value = inputVolume,
				onValueChange = { inputVolume = it },
				focusedContainerColor = containerColor,
				focusedColor = contentColor,
				unfocusedColor = color,
				leadingIcon = dataSourceCommon.leadingIconPH, // TODO
			)
		},
		calculateFieldContent = {
			CalculateField(
				inputText = dataSourceCommon.inputText,
				inputValue = inputVolume,
				contentColor = color,
				containerColor = containerColor,
				calculateContent = {
					CalculatedTextString(
						text = dataSourceCommon.calculatedTextCO2,
						calculatedValue = parameters.calculatePumpFlowLowFreshwater(),
						textColor = contentColor,
					)
				}
			)
		}
	)
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