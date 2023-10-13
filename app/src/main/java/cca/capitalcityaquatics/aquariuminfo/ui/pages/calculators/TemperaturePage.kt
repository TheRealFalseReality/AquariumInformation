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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.data.calculators.temperatureDataSource
import cca.capitalcityaquatics.aquariuminfo.data.tankvolumes.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.model.calculators.CalculatorMethods
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.BodyText
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateField
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatedTextString
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatorSubtitleThree
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FormulaStringContent
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.GenericCalculatePage
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.InputNumberField
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageView
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.RadioButtonTwoUnits
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.SingleWideCardExpandableRadio
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme

@Composable
fun TemperaturePage(windowSize: WindowSizeClass) {
	PageView {
		TemperatureLayout(windowSize = windowSize)
	}
}

@SuppressLint("VisibleForTests")
@Composable
fun TemperatureLayout(
	windowSize: WindowSizeClass,
	color: Color = MaterialTheme.colorScheme.primary,
	containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
	contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
) {
	val dataSource = temperatureDataSource
	var inputTemperature by rememberSaveable {
		mutableStateOf("0")
	}
	var selected by rememberSaveable {
		mutableIntStateOf(dataSource.radioTextCelsius)
	}
	val temperature = inputTemperature.toDoubleOrNull() ?: 0.0
	val parameters = CalculatorMethods(selected = selected, temperature = temperature)

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
				contentColor = color,
				selected = selected,
				content = {
					RadioButtonTwoUnits(
						onClick1 = { selected = dataSource.radioTextCelsius },
						onClick2 = { selected = dataSource.radioTextFahrenheit },
						label1 = dataSource.radioTextCelsius,
						label2 = dataSource.radioTextFahrenheit,
						selected = selected,
						selectedColor = color,
						textColor = color
					)
				}
			)
		},
		inputFieldContent = {
			InputNumberField(
				label =
				when (selected) {
					dataSource.radioTextFahrenheit -> {
						dataSource.labelFahrenheit
					}

					else -> {
						dataSource.labelCelsius
					}
				},
				value = inputTemperature,
				onValueChange = { inputTemperature = it },
				focusedContainerColor = containerColor,
				focusedColor = contentColor,
				unfocusedColor = color,
				leadingIcon = calculatorDataSource.leadingIconTemperature,
			)
		},
		calculateFieldContent = {
			CalculateField(
				inputText =
				when (selected) {
					// Fahrenheit
					dataSource.radioTextFahrenheit -> {
						dataSource.inputTextFahrenheit
					}

					// Celsius
					else -> {
						dataSource.inputTextCelsius
					}
				},
				inputValue = inputTemperature,
				calculateContent = {
					when (selected) {
						// Fahrenheit
						dataSource.radioTextFahrenheit -> {
							CalculatedTextString(
								text = dataSource.calculatedTextCelsius,
								calculatedValue = parameters.convertTemperature(),
								textColor = contentColor,
							)
							CalculatedTextString(
								text = dataSource.calculatedTextKelvin,
								calculatedValue = parameters.calculateTemperatureKelvin(),
								textColor = contentColor,
							)
						}

						// Celsius
						else -> {
							CalculatedTextString(
								text = dataSource.calculatedTextCelsius,
								calculatedValue = parameters.convertTemperature(),
								textColor = contentColor,
							)
							CalculatedTextString(
								text = dataSource.calculatedTextKelvin,
								calculatedValue = parameters.calculateTemperatureKelvin(),
								textColor = contentColor,
							)
						}
					}
				},
				contentColor = color,
				containerColor = containerColor,
			)
		}
	) {
		FormulaStringContent(
			contentColor = color,
			content = {
				BodyText(
					text = dataSource.formulaText1,
					textAlign = TextAlign.Start,
					color = color
				)
				BodyText(
					text = dataSource.formulaText2,
					textAlign = TextAlign.Start,
					color = color
				)
				BodyText(
					text = dataSource.formulaText3,
					textAlign = TextAlign.Start,
					color = color
				)
			}
		)
	}
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun TemperaturePreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.surface)
		) {
			TemperaturePage(windowSize = WindowSizeClass.calculateFromSize(DpSize(300.dp, 400.dp)))
		}
	}
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun TemperaturePreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.surface)
		) {
			TemperaturePage(windowSize = WindowSizeClass.calculateFromSize(DpSize(300.dp, 400.dp)))
		}
	}
}