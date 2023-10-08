package cca.capitalcityaquatics.aquariuminfo.ui.pages.calculators

import android.annotation.SuppressLint
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.data.calculators.salinityDataSource
import cca.capitalcityaquatics.aquariuminfo.data.tankvolumes.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.model.calculators.CalculatorMethods
import cca.capitalcityaquatics.aquariuminfo.model.calculators.SalinityMethods
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.BodyText
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateField
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatedText
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatedTextString
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatorSubtitleThree
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FormulaString
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.GenericCalculatePage
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.InputNumberField
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageView
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.RadioButtonTwoUnits
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.SingleWideCardExpandableRadio
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.VerySmallSpacer
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow

@Composable
fun SalinityPage(windowSize: WindowSizeClass) {
	PageView {
		SalinityLayout(windowSize = windowSize)
	}
}

@SuppressLint("VisibleForTests")
@Composable
fun SalinityLayout(
	windowSize: WindowSizeClass,
	color: Color = MaterialTheme.colorScheme.primary,
	containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
	contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
) {
	val dataSource = salinityDataSource
	var inputSal by rememberSaveable {
		mutableStateOf("36")
	}
	var selected by rememberSaveable {
		mutableIntStateOf(dataSource.radioTextPpt)
	}
	val tds = inputSal.toDoubleOrNull() ?: 0.0
	val parameters = SalinityMethods(selected = selected, tds = tds)

	GenericCalculatePage(
		windowSize = windowSize,
		subtitleContent = {
			CalculatorSubtitleThree(
				contentColor = color,
				text1 = dataSource.subtitle1,
				text2 = dataSource.subtitle2,
				text3 = dataSource.subtitle3,
			)
		},
		selectContent = {
			SingleWideCardExpandableRadio(
				modifier = Modifier.fillMaxWidth(fraction = 0.75f),
				expandedState = true,
				header = R.string.select_input_units,
				content = {
					RadioButtonTwoUnits(
						onClick1 = { selected = dataSource.radioTextPpt },
						onClick2 = { selected = dataSource.radioTextSg },
						label1 = dataSource.radioTextPpt,
						label2 = dataSource.radioTextSg,
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
					dataSource.radioTextSg -> {
						dataSource.labelSg
					}

					else -> {
						dataSource.labelPpt
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
			CalculateField(
				inputText =
				when (selected) {
					// Specific Gravity
					dataSource.radioTextSg -> {
						dataSource.inputTextSg
					}

					// Salinity
					else -> {
						dataSource.inputTextPpt
					}
				},
				inputValue = inputSal,
				calculateContent = {
					when (selected) {
						// Specific Gravity
						dataSource.radioTextSg -> {
							BodyText(
								text = dataSource.labelSalinity,
								color = contentColor
							)
							CalculatedTextString(
								text = dataSource.calculatedTextPpt,
								calculatedValue = parameters.calculateSalinity(),
								textColor = contentColor,
							)
						}

						// Salinity
						else -> {
							BodyText(
								text = dataSource.labelSpecificGravity,
								color = contentColor
							)
							CalculatedTextString(
								text = dataSource.calculatedTextPpt,
								calculatedValue = parameters.calculateSpecificGravity(),
								textColor = contentColor,
							)
						}
					}
					VerySmallSpacer()
					BodyText(
						text = dataSource.labelDensity,
						color = contentColor
					)
					when (selected) {
						// Specific Gravity
						dataSource.radioTextSg -> {
							CalculatedTextString(
								text = dataSource.calculatedTextDensity,
								calculatedValue = parameters.calculateDensitySG(),
								textColor = contentColor,
							)
						}

						// Salinity
						else -> {
							CalculatedTextString(
								text = dataSource.calculatedTextDensity,
								calculatedValue = parameters.calculateDensityPPT(),
								textColor = contentColor,
							)
						}
					}
				},
				contentColor = color,
				containerColor = containerColor
			)
		}
	) {
		FormulaString(
			text = dataSource.formulaText,
			contentColor = color
		)
	}
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun SalinityPreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			SalinityPage(windowSize = WindowSizeClass.calculateFromSize(DpSize(300.dp, 400.dp)))
		}
	}
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun SalinityPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			SalinityPage(windowSize = WindowSizeClass.calculateFromSize(DpSize(300.dp, 400.dp)))
		}
	}
}