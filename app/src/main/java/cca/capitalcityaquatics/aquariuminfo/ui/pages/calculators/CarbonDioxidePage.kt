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
import cca.capitalcityaquatics.aquariuminfo.data.calculators.alkalinityDataSource
import cca.capitalcityaquatics.aquariuminfo.data.calculators.carbonDioxideDataSource
import cca.capitalcityaquatics.aquariuminfo.data.tankvolumes.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.model.calculators.CalculatorMethods
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateFieldTwoInputs
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatedTextString
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FormulaString
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.GenericCalculatePage
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.HeaderText
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.InputNumberFieldTwoInputsStacked
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageView
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.TextCard
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme

@Composable
fun CarbonDioxidePage(windowSize: WindowSizeClass) {
	PageView {
		CarbonDioxideLayout(windowSize = windowSize)
	}
}

@SuppressLint("VisibleForTests")
@Composable
fun CarbonDioxideLayout(
	windowSize: WindowSizeClass,
	color: Color = MaterialTheme.colorScheme.primary,
	containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
	contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
) {
	val dataSource = carbonDioxideDataSource
	var inputPH by rememberSaveable {
		mutableStateOf("")
	}
	var inputDKH by rememberSaveable {
		mutableStateOf("")
	}
	val ph = inputPH.toDoubleOrNull() ?: 0.0
	val dkh = inputDKH.toDoubleOrNull() ?: 0.0
	val parameters = CalculatorMethods(pH = ph, dKH = dkh)

	GenericCalculatePage(
		windowSize = windowSize,
		subtitleContent = {
			HeaderText(
				text = dataSource.subtitle,
				color = color
			)
		},
		selectContent = {
			TextCard(
				text = dataSource.unitsLabel,
				contentColor = color
			)
		},
		inputFieldContent = {
			InputNumberFieldTwoInputsStacked(
				label1 = dataSource.labelPh,
				label2 = dataSource.labelDkh,
				value1 = inputPH,
				onValueChange1 = { inputPH = it },
				value2 = inputDKH,
				onValueChange2 = { inputDKH = it },
				focusedContainerColor = containerColor,
				focusedColor = contentColor,
				unfocusedColor = color,
				leadingIcon1 = calculatorDataSource.leadingIconPH,
				leadingIcon2 = alkalinityDataSource.leadingIconTDS,
			)
		},
		calculateFieldContent = {
			CalculateFieldTwoInputs(
				inputText = dataSource.inputText,
				inputValue1 = inputPH,
				inputValue2 = inputDKH,
				contentColor = color,
				containerColor = containerColor,
				calculateContent = {
					CalculatedTextString(
						text = dataSource.calculatedText,
						calculatedValue = parameters.calculateCarbonDioxide(),
						textColor = contentColor,
					)
				}
			)
		}
	) {
		FormulaString(
			contentColor = color,
			text = dataSource.formulaText,
		)
	}
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun CarbonDioxidePreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.surface)
		) {
			CarbonDioxidePage(
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
fun CarbonDioxidePreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.surface)
		) {
			CarbonDioxidePage(
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