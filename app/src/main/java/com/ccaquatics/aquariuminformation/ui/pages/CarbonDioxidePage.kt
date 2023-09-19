package com.ccaquatics.aquariuminformation.ui.pages

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ccaquatics.aquariuminformation.data.carbonDioxideData
import com.ccaquatics.aquariuminformation.navigation.CarbonDioxide
import com.ccaquatics.aquariuminformation.ui.commonui.BodyTextCard
import com.ccaquatics.aquariuminformation.ui.commonui.CalculateFieldTwoInputs
import com.ccaquatics.aquariuminformation.ui.commonui.CalculatedText
import com.ccaquatics.aquariuminformation.ui.commonui.FormulaString
import com.ccaquatics.aquariuminformation.ui.commonui.GenericPage
import com.ccaquatics.aquariuminformation.ui.commonui.InputNumberFieldTwoInputs
import com.ccaquatics.aquariuminformation.ui.commonui.PageView
import com.ccaquatics.aquariuminformation.ui.commonui.TextCard
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow

@Composable
fun CarbonDioxidePage() {
	PageView {
		CarbonDioxideLayout()
	}
}

@Composable
fun CarbonDioxideLayout(
	modifier: Modifier = Modifier,
	color: Color = MaterialTheme.colorScheme.secondary
) {
	var inputPH by rememberSaveable {
		mutableStateOf("")
	}
	var inputDKH by rememberSaveable {
		mutableStateOf("")
	}
	val ph = inputPH.toDoubleOrNull() ?: 0.0
	val dkh = inputDKH.toDoubleOrNull() ?: 0.0
	val co2 = calculateCarbonDioxide(ph, dkh).toDoubleOrNull() ?: 0.0

	Column(modifier = modifier) {
		GenericPage(
			title = CarbonDioxide.title,
			subtitle = CarbonDioxide.subtitle,
			icon = CarbonDioxide.icon,
			color = color,
			selectContent = {
				TextCard(
					text = carbonDioxideData.unitsLabel,
					contentColor = color
				)
			},
			calculateFieldContent = {
				CalculateFieldTwoInputs(
					inputContent = {
						InputNumberFieldTwoInputs(
							label1 = carbonDioxideData.label1,
							placeholder1 = carbonDioxideData.placeholder1,
							label2 = carbonDioxideData.label2,
							placeholder2 = carbonDioxideData.placeholder2,
							value1 = inputPH,
							onValueChange1 = { inputPH = it },
							value2 = inputDKH,
							onValueChange2 = { inputDKH = it },
							color = color,
						)
					},
					inputText = carbonDioxideData.inputText,
					inputValue1 = inputPH,
					inputValue2 = inputDKH,
					equalsText = carbonDioxideData.equalsText,
					color = color,
					calculateContent = {
						CalculatedText(
							text = carbonDioxideData.calculatedText,
							calculatedValue = co2,
							color = color,
						)
					}
				)
			},
			formulaContent = {
				FormulaString(
					color = color,
					content = {
						BodyTextCard(
							text = carbonDioxideData.formulaText,
							color = color
						)
					}
				)
			}
		)
	}
}

@VisibleForTesting
fun calculateCarbonDioxide(
	pH: Double,
	dKH: Double
): String {
	val phSolution = 10.0.pow(6.37 - pH)
	val carbonDioxide = (12.839 * dKH) * phSolution

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(carbonDioxide)
}

@Preview(showBackground = true)
@Composable
fun CarbonDioxidePreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.surface)
		) {
			CarbonDioxideLayout()
		}
	}
}

@Preview(showBackground = true)
@Composable
fun CarbonDioxidePreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.surface)
		) {
			CarbonDioxideLayout()
		}
	}
}