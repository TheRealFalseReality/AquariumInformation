package com.example.aquariuminformation.ui.pages

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
import androidx.compose.ui.tooling.preview.Preview
import com.example.aquariuminformation.R
import com.example.aquariuminformation.ui.commonui.BodyTextCard
import com.example.aquariuminformation.ui.commonui.CalculateFieldTwoInputs
import com.example.aquariuminformation.ui.commonui.CalculatedText
import com.example.aquariuminformation.ui.commonui.FormulaString
import com.example.aquariuminformation.ui.commonui.GenericPage
import com.example.aquariuminformation.ui.commonui.InputNumberFieldTwoInputs
import com.example.aquariuminformation.ui.commonui.PageView
import com.example.aquariuminformation.ui.commonui.TextCard
import com.example.aquariuminformation.ui.theme.AquariumInformationTheme
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
fun CarbonDioxideLayout(modifier: Modifier = Modifier) {
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
		val color = MaterialTheme.colorScheme.secondary

		GenericPage(
			title = R.string.text_title_co2,
			subtitle = R.string.text_subtitle_co2,
			icon = R.drawable.baseline_co2_24,
			color = color,
			selectContent = {
				TextCard(
					text = R.string.text_co2_units,
					contentColor = color
				)
			},
			calculateFieldContent = {
				CalculateFieldTwoInputs(
					inputContent = {
						InputNumberFieldTwoInputs(
							label1 = R.string.ph,
							placeholder1 = R.string.field_label_ph,
							label2 = R.string.button_label_dkh,
							placeholder2 = R.string.field_label_dkh,
							value1 = inputPH,
							onValueChange1 = { inputPH = it },
							value2 = inputDKH,
							onValueChange2 = { inputDKH = it },
							color = color,
						)
					},
					inputText = R.string.text_amount_ph_dkh,
					inputValue1 = inputPH,
					inputValue2 = inputDKH,
					equalsText = R.string.text_equal_to,
					color = color,
					calculateContent = {
						CalculatedText(
							label = R.string.text_amount_co2,
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
							text = R.string.text_formula_soon
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