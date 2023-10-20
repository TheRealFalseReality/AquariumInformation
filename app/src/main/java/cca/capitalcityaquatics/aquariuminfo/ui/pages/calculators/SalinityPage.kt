package cca.capitalcityaquatics.aquariuminfo.ui.pages.calculators

import android.annotation.SuppressLint
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
import cca.capitalcityaquatics.aquariuminfo.model.calculators.SalinityMethods
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateField
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatorSubtitleFour
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FormulaString
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.GenericCalculatePage
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.InputNumberField
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageView
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.RadioButtonFourUnits
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.SalinityCalculatedString
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.SingleWideCardExpandableRadio
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme

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
		mutableStateOf("1.026")
	}
	var selected by rememberSaveable {
		mutableIntStateOf(dataSource.radioTextSpecificGravity)
	}
	val tds = inputSal.toDoubleOrNull() ?: 0.0
	val parameters = SalinityMethods(selected = selected, tds = tds)

	GenericCalculatePage(
		windowSize = windowSize,
		subtitleContent = {
			CalculatorSubtitleFour(
				contentColor = color,
				text1 = dataSource.subtitle1,
				text2 = dataSource.subtitle2,
				text3 = dataSource.subtitle3,
				text4 = dataSource.subtitle4,
			)
		},
		selectContent = {
			SingleWideCardExpandableRadio(
				modifier = Modifier.fillMaxWidth(fraction = 0.75f),
				header = R.string.select_input_units,
				content = {
						  RadioButtonFourUnits(
							  onClick2 = { selected = dataSource.radioTextSalinity },
							  onClick1 = { selected = dataSource.radioTextSpecificGravity },
							  selected = selected,
							  selectedColor = color,
							  textColor = color,
							  onClick3 = { selected = dataSource.radioTextDensity },
							  onClick4 = { selected = dataSource.radioTextConductivity },
						  )
				}, contentColor = color,
				selected = selected
			)
		},
		inputFieldContent = {
			InputNumberField(
				label =
				when (selected) {
					// Specific Gravity
					dataSource.radioTextSpecificGravity -> {
						dataSource.labelSg
					}

					// Density
					dataSource.radioTextDensity -> {
						dataSource.labelDensity
					}

					// Conductivity
					dataSource.radioTextConductivity -> {
						dataSource.labelConductivity
					}

					// Salinity
					else -> {
						dataSource.labelPpt
					}
				},
				value = inputSal,
				onValueChange = { inputSal = it },
				focusedContainerColor = containerColor,
				focusedColor = contentColor,
				unfocusedColor = color,
				leadingIcon =
				when (selected) {
					// Specific Gravity
					dataSource.radioTextSpecificGravity -> {
						dataSource.leadingIconSpecificGravity
					}

					// Density
					dataSource.radioTextDensity -> {
						dataSource.leadingIconDensity
					}

					// Conductivity
					dataSource.radioTextConductivity -> {
						dataSource.leadingIconConductivity
					}

					// Salinity
					else -> {
						dataSource.leadingIconSalinity
					}
				},
			)
		},
		calculateFieldContent = {
			CalculateField(
				inputText =
				when (selected) {
					// Specific Gravity
					dataSource.radioTextSpecificGravity -> {
						dataSource.inputTextSg
					}

					// Density
					dataSource.radioTextDensity -> {
						dataSource.inputTextDensity
					}

					// Conductivity
					dataSource.radioTextConductivity -> {
						dataSource.inputTextConductivity
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
						dataSource.radioTextSpecificGravity -> {
							SalinityCalculatedString(
								label1 = dataSource.labelSalinity,
								inputText1 = dataSource.calculatedTextPpt,
								value1 = parameters.calculateSalinity(),
								label2 = dataSource.labelDensity,
								inputText2 = dataSource.calculatedTextDensity,
								value2 = parameters.calculateDensity(),
								label3 = dataSource.labelConductivity,
								inputText3 = dataSource.calculatedTextConductivity,
								value3 = parameters.calculateConductivity(),
								contentColor = contentColor,
							)
						}

						// Density
						dataSource.radioTextDensity -> {
							SalinityCalculatedString(
								label1 = dataSource.labelSalinity,
								inputText1 = dataSource.calculatedTextPpt,
								value1 = parameters.calculateSalinity(),
								label2 = dataSource.labelSpecificGravity,
								inputText2 = dataSource.calculatedTextSg,
								value2 = parameters.calculateSpecificGravity(),
								label3 = dataSource.labelConductivity,
								inputText3 = dataSource.calculatedTextConductivity,
								value3 = parameters.calculateConductivity(),
								contentColor = contentColor,
							)
						}

						// Conductivity
						dataSource.radioTextConductivity -> {
							SalinityCalculatedString(
								label1 = dataSource.labelSalinity,
								inputText1 = dataSource.calculatedTextPpt,
								value1 = parameters.calculateSalinity(),
								label2 = dataSource.labelSpecificGravity,
								inputText2 = dataSource.calculatedTextSg,
								value2 = parameters.calculateSpecificGravity(),
								label3 = dataSource.labelDensity,
								inputText3 = dataSource.calculatedTextDensity,
								value3 = parameters.calculateDensity(),
								contentColor = contentColor,
							)
						}

						// Salinity
						else -> {
							SalinityCalculatedString(
								label1 = dataSource.labelSpecificGravity,
								inputText1 = dataSource.calculatedTextPpt,
								value1 = parameters.calculateSpecificGravity(),
								label2 = dataSource.labelDensity,
								inputText2 = dataSource.calculatedTextDensity,
								value2 = parameters.calculateDensity(),
								label3 = dataSource.labelConductivity,
								inputText3 = dataSource.calculatedTextConductivity,
								value3 = parameters.calculateConductivity(),
								contentColor = contentColor,
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
			text = dataSource.formulaText, // TODO
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