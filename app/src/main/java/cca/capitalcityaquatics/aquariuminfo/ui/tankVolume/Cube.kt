package cca.capitalcityaquatics.aquariuminfo.ui.tankVolume

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.ui.commonComposables.*
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AppTheme
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun TankVolCubeScreen(
	modifier: Modifier = Modifier,
) {
	var inputSide by rememberSaveable {
		mutableStateOf("")
	}

	var selected by rememberSaveable {
		mutableStateOf(R.string.button_label_inches)
	}

	val side = inputSide.toDoubleOrNull() ?: 0.0

	val volGallon = calculateVolGallonCube(side)
	val volLiter = calculateVolLiterCube(side)
	val waterWeight = calculateWaterWeightCube(side)
	val volGallonFT = calculateVolGallonFTCube(side)
	val volLiterFT = calculateVolLiterFTCube(side)
	val waterWeightFT = calculateWaterWeightFTCube(side)

	GeneralCard(verticalArrangement = Arrangement.Top) {
		GeneralComposeHeader(text = R.string.text_title_cube)

		GeneralComposeSubHeader(text = R.string.text_subtitle_tank_vol)

		RadioButtonCardTankVol(
			onClick1 = { selected = R.string.button_label_inches },
			onClick2 = { selected = R.string.button_label_feet },
			selected = selected
		)

		EditNumberFieldSingle(
			label = R.string.field_label_side,
			value = inputSide,
			onValueChange = { inputSide = it }
		)

		Spacer(modifier = modifier.height(12.dp))

		InputUnitsDisplay1(
			textA = R.string.text_amount_length_side,
			valueA = side,

			)

		when (selected) {
			R.string.button_label_inches -> {

				DataOutputTankVol(
					valueA = volGallon,
					valueB = volLiter,
					valueC = waterWeight
				)

			}
			R.string.button_label_feet -> {

				DataOutputTankVol(
					valueA = volGallonFT,
					valueB = volLiterFT,
					valueC = waterWeightFT
				)

			}
		}

		ImageGeneral(
			image = R.drawable.cube_calc,
			contDesc = R.string.text_title_cube,
			modifier = Modifier
				.padding(start = 40.dp)
		)

		FormulaString {
			GeneralComposeBody(
				text = R.string.text_formula_vol_cube,
				textAlign = TextAlign.Center
			)
		}
	}
}

@VisibleForTesting
fun calculateVolGallonCube(
	side: Double
): String {
	val volGallons = (side * side * side) / 231.0

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volGallons)
}

@VisibleForTesting
fun calculateVolLiterCube(
	side: Double
): String {
	val volLiters = (side * side * side) / 61.0237

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volLiters)
}

@VisibleForTesting
fun calculateWaterWeightCube(
	side: Double
): String {
	val waterWeight = ((side * side * side) / 231.0) * 8.33

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(waterWeight)
}

@VisibleForTesting
fun calculateVolGallonFTCube(
	side: Double
): String {
	val volGallons = (side * side * side) / 0.133681

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volGallons)
}

@VisibleForTesting
fun calculateVolLiterFTCube(
	side: Double
): String {
	val volLiters = (side * side * side) / 0.0353147

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volLiters)
}

@VisibleForTesting
fun calculateWaterWeightFTCube(
	side: Double
): String {
	val waterWeight = ((side * side * side) / 0.133681) * 8.33

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(waterWeight)
}


@Preview(showBackground = true)
@Composable
fun CubePreview() {
	AppTheme() {
		TankVolCubeScreen()
	}
}