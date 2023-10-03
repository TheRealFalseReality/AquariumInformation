package cca.capitalcityaquatics.aquariuminfo.ui.pages.calculators

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.data.calculators.salinityDataSource
import cca.capitalcityaquatics.aquariuminfo.data.tankvolumes.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.BodyText
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateField
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatedText
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatorSubtitleThree
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FormulaString
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.GenericCalculatePage
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.InputNumberField
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageView
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.RadioButtonTwoUnits
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.SingleWideCardExpandableRadio
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.VerySmallSpacer
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow

@Composable
fun SalinityPage(windowSize: WindowSizeClass) {
	PageView {
		SalinityLayout(windowSize = windowSize)
	}
}

@Composable
fun SalinityLayout(
	windowSize: WindowSizeClass,
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

	GenericCalculatePage(
		windowSize = windowSize,
		subtitleContent = {
			CalculatorSubtitleThree(
				contentColor = contentColor,
				text1 = salinityDataSource.subtitle1,
				text2 = salinityDataSource.subtitle2,
				text3 = salinityDataSource.subtitle3,
			)
		},
		selectContent = {
			SingleWideCardExpandableRadio(
				modifier = Modifier.fillMaxWidth(fraction = 0.75f),
				expandedState = true,
				header = R.string.select_input_units,
				content = {
					RadioButtonTwoUnits(
						onClick1 = { selected = salinityDataSource.radioTextPpt },
						onClick2 = { selected = salinityDataSource.radioTextSg },
						label1 = salinityDataSource.radioTextPpt,
						label2 = salinityDataSource.radioTextSg,
						selected = selected,
						selectedColor = color,
						textColor = color
					)
				}, contentColor = color
			)
		},
		inputFieldContent = {
			InputNumberField(
				label =
				when (selected) {
					salinityDataSource.radioTextSg -> {
						salinityDataSource.labelSg
					}

					else -> {
						salinityDataSource.labelPpt
					}
				},
				value = inputSal,
				onValueChange = { inputSal = it },
				focusedContainerColor = containerColor,
				focusedColor = contentColor,
				unfocusedColor = color,
				leadingIcon = calculatorDataSource.leadingIconSalinity,
			)
		},
		calculateFieldContent = {
			when (selected) {
				salinityDataSource.radioTextSg -> {
					CalculateField(
						inputText = salinityDataSource.inputTextSg,
						inputValue = inputSal,
						equalsText = salinityDataSource.equalsText,
						contentColor = color,
						containerColor = containerColor,
						calculateContent = {
							BodyText(
								text = salinityDataSource.labelSalinity,
								color = contentColor
							)
							CalculatedText(
								text = salinityDataSource.calculatedTextPpt,
								calculatedValue = ppt,
								textColor = contentColor,
							)
							VerySmallSpacer()
							BodyText(
								text = salinityDataSource.labelDensity,
								color = contentColor
							)
							CalculatedText(
								text = salinityDataSource.calculatedTextDensity,
								calculatedValue = salDensitySG,
								textColor = contentColor,
							)
						}
					)
				}

				else -> {
					CalculateField(
						inputText = salinityDataSource.inputTextPpt,
						inputValue = inputSal,
						equalsText = salinityDataSource.equalsText,
						contentColor = color,
						containerColor = containerColor,
						calculateContent = {
							BodyText(
								text = salinityDataSource.labelSpecificGravity,
								color = contentColor
							)
							CalculatedText(
								text = salinityDataSource.calculatedTextSg,
								calculatedValue = sg,
								textColor = contentColor,
							)
							VerySmallSpacer()
							BodyText(
								text = salinityDataSource.labelDensity,
								color = contentColor
							)
							CalculatedText(
								text = salinityDataSource.calculatedTextDensity,
								calculatedValue = salDensityPPT,
								textColor = contentColor,
							)
						},
					)
				}
			}
		}
	) {
		FormulaString(
			text = salinityDataSource.formulaText,
			contentColor = color
		)
	}
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

//@Preview(showBackground = true)
//@Composable
//fun SalinityPreview() {
//	AquariumInformationTheme {
//		Column(
//			modifier = Modifier
//				.background(color = MaterialTheme.colorScheme.background)
//		) {
//			SalinityPage()
//		}
//	}
//}
//
//@Preview(showBackground = true)
//@Composable
//fun SalinityPreviewDark(
//) {
//	AquariumInformationTheme(useDarkTheme = true) {
//		Column(
//			modifier = Modifier
//				.background(color = MaterialTheme.colorScheme.background)
//		) {
//			SalinityPage()
//		}
//	}
//}