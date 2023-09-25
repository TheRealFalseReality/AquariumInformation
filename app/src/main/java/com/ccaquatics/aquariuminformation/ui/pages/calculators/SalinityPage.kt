package com.ccaquatics.aquariuminformation.ui.pages.calculators

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ccaquatics.aquariuminformation.data.calculators.salinityDataSource
import com.ccaquatics.aquariuminformation.navigation.Salinity
import com.ccaquatics.aquariuminformation.ui.commonui.CalculateField
import com.ccaquatics.aquariuminformation.ui.commonui.CalculatedText
import com.ccaquatics.aquariuminformation.ui.commonui.FormulaString
import com.ccaquatics.aquariuminformation.ui.commonui.GenericCalculatePage
import com.ccaquatics.aquariuminformation.ui.commonui.InputNumberField
import com.ccaquatics.aquariuminformation.ui.commonui.LabelConductivity
import com.ccaquatics.aquariuminformation.ui.commonui.LabelSalinity
import com.ccaquatics.aquariuminformation.ui.commonui.LabelSpecificGravity
import com.ccaquatics.aquariuminformation.ui.commonui.PageView
import com.ccaquatics.aquariuminformation.ui.commonui.RadioButtonComposable
import com.ccaquatics.aquariuminformation.ui.commonui.UnitButtonCard
import com.ccaquatics.aquariuminformation.ui.commonui.VerySmallSpacer
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow

@Composable
fun SalinityPage() {
	PageView {
		SalinityLayout()
	}
}

@Composable
fun SalinityLayout(
	color: Color = MaterialTheme.colorScheme.primary,
	containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
	contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
	) {
	var inputSal by rememberSaveable {
		mutableStateOf("36")
	}
	var selected by rememberSaveable {
		mutableIntStateOf(salinityDataSource.radioTextPpt)
	}
	val tempTestWater = 25.0
	val tempPureWater = 25.0
	val sal = inputSal.toDoubleOrNull() ?: 0.0
	val ppt = calculateSalinity(sal, tempTestWater).toDoubleOrNull() ?: 0.0
	val sg = calculateSpecificGravity(sal, tempPureWater, tempTestWater).toDoubleOrNull() ?: 0.0
	val salDensityPPT = calculateDensityPPT(sal, tempTestWater).toDoubleOrNull() ?: 0.0
	val salDensitySG = calculateDensitySG(sal, tempPureWater).toDoubleOrNull() ?: 0.0

	GenericCalculatePage(title = Salinity.title,
		subtitle = salinityDataSource.subtitle,
		icon = Salinity.icon,
		color = color,
		selectContent = {
			UnitButtonCard(
				content = {
					RadioButtonComposable(
						modifier = Modifier.weight(1f),
						text = salinityDataSource.radioTextPpt,
						onClick = { selected = salinityDataSource.radioTextPpt },
						selected = selected,
						selectedColor = color,
						textColor =
						if (selected == salinityDataSource.radioTextPpt) color
						else MaterialTheme.colorScheme.onBackground
					)
					RadioButtonComposable(
						modifier = Modifier.weight(1f),
						text = salinityDataSource.radioTextSg,
						onClick = { selected = salinityDataSource.radioTextSg },
						selected = selected,
						selectedColor = color,
						textColor =
						if (selected == salinityDataSource.radioTextSg) color
						else MaterialTheme.colorScheme.onBackground
					)
				}, contentColor = color
			)
		},
		calculateFieldContent = {
			when (selected) {
				salinityDataSource.radioTextPpt -> {
					CalculateField(
						inputContent = {
							InputNumberField(
								label = salinityDataSource.labelPpt,
								placeholder = salinityDataSource.placeholderPpt,
								value = inputSal,
								onValueChange = { inputSal = it },
								focusedContainerColor = containerColor,
								focusedColor = contentColor,
								unfocusedColor = color,
							)
						},
						inputText = salinityDataSource.inputTextPpt,
						inputValue = inputSal,
						equalsText = salinityDataSource.equalsText,
						contentColor = color,
						containerColor = containerColor,
						calculateContent = {
							LabelSpecificGravity()
							CalculatedText(
								text = salinityDataSource.calculatedTextSg,
								calculatedValue = sg,
								textColor = contentColor,
							)
							VerySmallSpacer()
							LabelConductivity()
							CalculatedText(
								text = salinityDataSource.calculatedTextDensity,
								calculatedValue = salDensityPPT,
								textColor = contentColor,
							)
						},
					)
				}

				salinityDataSource.radioTextSg -> {
					CalculateField(inputContent = {
						InputNumberField(
							label = salinityDataSource.labelSg,
							placeholder = salinityDataSource.placeholderSg,
							value = inputSal,
							onValueChange = { inputSal = it },
							focusedContainerColor = containerColor,
							focusedColor = contentColor,
							unfocusedColor = color,
						)
					},
						inputText = salinityDataSource.inputTextSg,
						inputValue = inputSal,
						equalsText = salinityDataSource.equalsText,
						contentColor = color,
						containerColor = containerColor,
						calculateContent = {
							LabelSalinity()
							CalculatedText(
								text = salinityDataSource.calculatedTextPpt,
								calculatedValue = ppt,
								textColor = contentColor,
							)
							VerySmallSpacer()
							LabelConductivity()
							CalculatedText(
								text = salinityDataSource.calculatedTextDensity,
								calculatedValue = salDensitySG,
								textColor = contentColor,
							)
						}
					)
				}
			}
		},
		formulaContent = {
			FormulaString(
				text = salinityDataSource.formulaText,
				color = color
			)
		}
	)
}


@VisibleForTesting
fun calculateSpecificGravity(
	sal: Double,
	tempTestWater: Double,
	tempPureWater: Double,
): String {
	val aA = 8.24493e-1 - 4.0899e-3 * tempTestWater + 7.6438e-5 * tempTestWater * tempTestWater -
			8.2467e-7 * tempTestWater * tempTestWater * tempTestWater + 5.3875e-9 * tempTestWater *
			tempTestWater * tempTestWater * tempTestWater
	val bB = -5.72466e-3 + 1.0227e-4 * tempTestWater - 1.6546e-6 * tempTestWater * tempTestWater
	val cC = 4.8314e-4
	val rROo = 999.842594 + 6.793952e-2 * tempTestWater - 9.095290e-3 * tempTestWater *
			tempTestWater + 1.001685e-4 * tempTestWater * tempTestWater * tempTestWater -
			1.120083e-6 * tempTestWater * tempTestWater * tempTestWater * tempTestWater +
			6.536332e-9 * tempTestWater * tempTestWater * tempTestWater * tempTestWater *
			tempTestWater
	val rROoTD = 999.842594 + 6.793952e-2 * tempPureWater - 9.095290e-3 * tempPureWater *
			tempPureWater + 1.001685e-4 * tempPureWater * tempPureWater * tempPureWater -
			1.120083e-6 * tempPureWater * tempPureWater * tempPureWater * tempPureWater +
			6.536332e-9 * tempPureWater * tempPureWater * tempPureWater * tempPureWater *
			tempPureWater
	val salDensityPPT = rROo + aA * sal + bB * kotlin.math.sqrt(sal.pow(3)) + cC * sal * sal

	val sg = salDensityPPT / rROoTD

	val df = DecimalFormat("#.###")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(sg)
}

@VisibleForTesting
fun calculateSalinity(
	sal: Double,
	tempTestWater: Double,
): String {
	val ppt = sal * 1240.63326 + tempTestWater * -3.26377 + sal * tempTestWater * 3.20800 + sal *
			sal * 4.58072 + tempTestWater * tempTestWater * 0.00719 + -1246.10737

	val df = DecimalFormat("#.###")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(ppt)
}

@VisibleForTesting
fun calculateDensityPPT(
	sal: Double,
	tempTestWater: Double,
): String {
	val aB = 8.24493e-1 - 4.0899e-3 * tempTestWater + 7.6438e-5 * tempTestWater * tempTestWater -
			8.2467e-7 * tempTestWater * tempTestWater * tempTestWater + 5.3875e-9 * tempTestWater *
			tempTestWater * tempTestWater * tempTestWater
	val bC = -5.72466e-3 + 1.0227e-4 * tempTestWater - 1.6546e-6 * tempTestWater * tempTestWater
	val cD = 4.8314e-4
	val rOO = 999.842594 + 6.793952e-2 * tempTestWater - 9.095290e-3 * tempTestWater * tempTestWater
	+1.001685e-4 * tempTestWater * tempTestWater * tempTestWater - 1.120083e-6 *
			tempTestWater * tempTestWater * tempTestWater * tempTestWater + 6.536332e-9 *
			tempTestWater * tempTestWater * tempTestWater * tempTestWater * tempTestWater
	val rO = rOO + aB * sal + bC * kotlin.math.sqrt(sal.pow(3)) + cD * sal * sal

	val df = DecimalFormat("#.###")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(rO)
}

@VisibleForTesting
fun calculateDensitySG(
	sal: Double,
	tempPureWater: Double
): String {
	val rOoTDc = 999.842594 + 6.793952e-2 * tempPureWater - 9.095290e-3 * tempPureWater *
			tempPureWater + 1.001685e-4 * tempPureWater * tempPureWater * tempPureWater -
			1.120083e-6 * tempPureWater * tempPureWater * tempPureWater * tempPureWater +
			6.536332e-9 * tempPureWater * tempPureWater * tempPureWater * tempPureWater *
			tempPureWater
	val rO1 = sal * rOoTDc

	val df = DecimalFormat("#.###")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(rO1)
}

@Preview(showBackground = true)
@Composable
fun SalinityPreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			SalinityPage()
		}
	}
}

@Preview(showBackground = true)
@Composable
fun SalinityPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			SalinityPage()
		}
	}
}