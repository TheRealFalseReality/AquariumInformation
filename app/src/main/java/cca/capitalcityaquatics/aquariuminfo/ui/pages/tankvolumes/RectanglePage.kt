package cca.capitalcityaquatics.aquariuminfo.ui.pages.tankvolumes

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
import cca.capitalcityaquatics.aquariuminfo.data.tankvolumes.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.data.tankvolumes.rectangleDataSource
import cca.capitalcityaquatics.aquariuminfo.model.tankvolumes.CalculateVolumeRectangle
import cca.capitalcityaquatics.aquariuminfo.navigation.Rectangle
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateFieldThreeInputs
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateImageTitle
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatorSubtitleTwo
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FormulaString
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.GenericCalculatePage
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.InputNumberFieldThreeStackedInputs
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageView
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.RadioButtonTwoUnits
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.SingleWideCardExpandableRadio
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.TankVolumeResultsString
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme

@Composable
fun RectanglePage(windowSize: WindowSizeClass) {
	PageView {
		RectangleLayout(windowSize = windowSize)
	}
}

@SuppressLint("VisibleForTests")
@Composable
fun RectangleLayout(
	windowSize: WindowSizeClass,
	color: Color = MaterialTheme.colorScheme.secondary,
	containerColor: Color = MaterialTheme.colorScheme.secondaryContainer,
	contentColor: Color = MaterialTheme.colorScheme.onSecondaryContainer,

) {
	val dataSourceCommon = calculatorDataSource
	val dataSourceSpecific = rectangleDataSource
	var inputLength by rememberSaveable {
		mutableStateOf("")
	}
	var inputWidth by rememberSaveable {
		mutableStateOf("")
	}
	var inputHeight by rememberSaveable {
		mutableStateOf("")
	}
	var selected by rememberSaveable {
		mutableIntStateOf(dataSourceCommon.radioTextFeet)
	}
	val length = inputLength.toDoubleOrNull() ?: 0.0
	val width = inputWidth.toDoubleOrNull() ?: 0.0
	val height = inputHeight.toDoubleOrNull() ?: 0.0
	val dimensions = CalculateVolumeRectangle(selected, length, width, height)

	GenericCalculatePage(
		windowSize = windowSize,
		subtitleContent = {
			CalculatorSubtitleTwo(
				contentColor = color,
				text1 = dataSourceCommon.subtitle1,
				text2 = dataSourceCommon.subtitle2,
			)
		},
		selectContent = {
			SingleWideCardExpandableRadio(
				modifier = Modifier.fillMaxWidth(fraction = 0.75f),
				header = R.string.select_input_units,
				content = {
					RadioButtonTwoUnits(
						onClick1 = { selected = dataSourceCommon.radioTextFeet },
						onClick2 = { selected = dataSourceCommon.radioTextInches },
						selected = selected,
						selectedColor = color,
						textColor = color
					)
				},
				contentColor = color,
			)
		},
		inputFieldContent = {
			InputNumberFieldThreeStackedInputs(
				label1 = dataSourceCommon.labelLength,
				label2 = dataSourceCommon.labelWidth,
				label3 = dataSourceCommon.labelHeight,
				value1 = inputLength,
				onValueChange1 = { inputLength = it },
				value2 = inputWidth,
				onValueChange2 = { inputWidth = it },
				value3 = inputHeight,
				onValueChange3 = { inputHeight = it },
				focusedContainerColor = containerColor,
				focusedColor = contentColor,
				unfocusedColor = color,
				leadingIcon1 = dataSourceCommon.leadingIconLength,
				leadingIcon2 = dataSourceCommon.leadingIconWidth,
				leadingIcon3 = dataSourceCommon.leadingIconHeight,
			)
		},
		calculateFieldContent = {
			CalculateFieldThreeInputs(
				inputText =
				if (selected == dataSourceCommon.radioTextFeet) dataSourceSpecific.inputTextFeet
				else dataSourceSpecific.inputTextInches,
				inputValue1 = inputLength,
				inputValue2 = inputWidth,
				inputValue3 = inputHeight,
				equalsText = dataSourceCommon.equalsText,
				contentColor = color,
				containerColor = containerColor,
				calculateContent = {
					TankVolumeResultsString(
						contentColor = contentColor,
						calculatedValue1 = dimensions.calculateVolumeRectangleGallons(),
						calculatedValue2 = dimensions.calculateVolumeRectangleLiters(),
						calculatedValue3 = dimensions.calculateWaterWeight()
					)
				}
			)
		},
		imageContent = {
			CalculateImageTitle(
				image = dataSourceSpecific.image,
				contentDescription = Rectangle.title,
				color = color
			)
		},
	) {
		FormulaString(
			text = dataSourceSpecific.formulaText,
			contentColor = color
		)
	}
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun RectanglePreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			RectanglePage(windowSize = WindowSizeClass.calculateFromSize(DpSize(300.dp, 400.dp)))
		}
	}
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun RectanglePreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			RectanglePage(windowSize = WindowSizeClass.calculateFromSize(DpSize(300.dp, 400.dp)))
		}
	}
}