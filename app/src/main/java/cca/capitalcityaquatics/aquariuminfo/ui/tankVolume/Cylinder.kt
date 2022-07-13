package cca.capitalcityaquatics.aquariuminfo.ui.tankVolume

import androidx.annotation.VisibleForTesting
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.ui.commonComposables.*
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.PI
import kotlin.math.pow

@Preview(showBackground = true)
@Composable
fun TankVolCylScreen(
	modifier: Modifier = Modifier,
) {
	var inputDiameter by rememberSaveable {
		mutableStateOf("")
	}
	var inputHeight by rememberSaveable {
		mutableStateOf("")
	}

	var selected by rememberSaveable {
		mutableStateOf(R.string.button_label_inches)
	}

	var halfCyl by remember {
		mutableStateOf(false)
	}
	var quartCyl by remember {
		mutableStateOf(false)
	}

	val diameter = inputDiameter.toDoubleOrNull() ?: 0.0
	val height = inputHeight.toDoubleOrNull() ?: 0.0

	val volGallon = calculateVolGallonCyl(diameter, height, halfCyl, quartCyl)
	val volLiter = calculateVolLiterCyl(diameter, height, halfCyl, quartCyl)
	val waterWeight = calculateWaterWeightCyl(diameter, height, halfCyl, quartCyl)
	val volGallonFT = calculateVolGallonFTCyl(diameter, height, halfCyl, quartCyl)
	val volLiterFT = calculateVolLiterFTCyl(diameter, height, halfCyl, quartCyl)
	val waterWeightFT = calculateWaterWeightFTCyl(diameter, height, halfCyl, quartCyl)

	GeneralCard(verticalArrangement = Arrangement.Top) {
		GeneralComposeHeader(text = R.string.text_title_cyl)

		GeneralComposeSubHeader(text = R.string.text_subtitle_tank_vol)

		RadioButtonCardTankVol(
			onClick1 = { selected = R.string.button_label_inches },
			onClick2 = { selected = R.string.button_label_feet },
			selected = selected
		)

		InfoCardContentSwitch2(
			halfCyl = halfCyl,
			quartCyl = quartCyl,
			onHalfChanged = { halfCyl = it },
			onQuartChanged = { quartCyl = it }
		)

		Spacer(modifier = Modifier.height(16.dp))

		EditNumberField2Hor(
			label1 = R.string.field_label_diameter,
			label2 = R.string.Field_label_height,
			value1 = inputDiameter,
			value2 = inputHeight,
			onValueChange1 = { inputDiameter = it },
			onValueChange2 = { inputHeight = it }
		)

		InputUnitsDisplay2(
			textA = R.string.text_amount_diameter,
			textB = R.string.text_amount_height,
			valueA = diameter,
			valueB = height
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
			image = R.drawable.cylinder_calc,
			contDesc = R.string.text_title_cyl,
			modifier = Modifier
				.padding(start = 46.dp)
		)

		FormulaString {
			GeneralComposeBody(
				text = R.string.text_formula_vol_cylinder,
				textAlign = TextAlign.Center
			)
		}

	}
}

@Composable
fun InfoCardContentSwitch2(
	halfCyl: Boolean,
	quartCyl: Boolean,
	onHalfChanged: (Boolean) -> Unit,
	onQuartChanged: (Boolean) -> Unit
) {
	var expanded by remember {
		mutableStateOf(false)
	}

	Card(
		backgroundColor = MaterialTheme.colors.onPrimary,
		modifier = Modifier
			.padding(vertical = 4.dp, horizontal = 8.dp),
		contentColor = MaterialTheme.colors.background
	) {
		Row(
			modifier = Modifier
				.clickable { expanded = !expanded }
				.widthIn(max = 400.dp)
				.animateContentSize(
					animationSpec = spring(
						dampingRatio = Spring.DampingRatioMediumBouncy,
						stiffness = Spring.StiffnessLow
					),
				)
		) {
			Column(
				modifier = Modifier
					.weight(1f)
					.padding(12.dp),
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				Text(
					text = stringResource(id = R.string.text_options),
					style = MaterialTheme.typography.body2.copy(
						fontWeight = FontWeight.ExtraBold
					),
				)
				if (expanded) {
					Spacer(modifier = Modifier.height(10.dp))

					Text(
						text = stringResource(id = R.string.text_choose_one),
						style = MaterialTheme.typography.body2
					)

					Row(
						modifier = Modifier
							.fillMaxWidth(),
						verticalAlignment = Alignment.CenterVertically,
					) {
						Text(
							text = stringResource(id = R.string.text_cyl_half)
						)
						Switch(
							checked = halfCyl,
							onCheckedChange = onHalfChanged,
							modifier = Modifier
								.fillMaxWidth()
						)
					}
					Row(
						modifier = Modifier
							.fillMaxWidth(),
						verticalAlignment = Alignment.CenterVertically
					) {
						Text(
							text = stringResource(id = R.string.text_cyl_quart)
						)
						Switch(
							checked = quartCyl,
							onCheckedChange = onQuartChanged,
							modifier = Modifier
								.fillMaxWidth()
						)
					}
				}
			}
			IconButton(
				onClick = { expanded = !expanded },
			) {
				Icon(
					painter = if (expanded)
						painterResource(id = R.drawable.ic_baseline_expand_less_24)
					else painterResource(id = R.drawable.ic_baseline_expand_more_24),
					contentDescription = if (expanded) {
						stringResource(R.string.text_show_less)
					} else {
						stringResource(R.string.text_show_more)
					},
				)
			}
		}
	}
}

@VisibleForTesting
internal fun calculateVolGallonCyl(
	diameter: Double,
	height: Double,
	halfCyl: Boolean,
	quartCyl: Boolean,
): String {
	val radius = 0.5 * diameter
	var volGallons = (PI * radius.pow(2) * height) / 231.0
	if (halfCyl)
		volGallons = ((PI * radius.pow(2) * height) / 2) / 231.0
	if (quartCyl)
		volGallons = ((PI * radius.pow(2) * height) / 4) / 231.0

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volGallons)
}

@VisibleForTesting
internal fun calculateVolLiterCyl(
	diameter: Double,
	height: Double,
	halfCyl: Boolean,
	quartCyl: Boolean,
): String {
	val radius = 0.5 * diameter
	var volLiters = (PI * radius.pow(2) * height) / 61.0237
	if (halfCyl)
		volLiters = ((PI * radius.pow(2) * height) / 2) / 61.0237
	if (quartCyl)
		volLiters = ((PI * radius.pow(2) * height) / 4) / 61.0237

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volLiters)
}

@VisibleForTesting
internal fun calculateWaterWeightCyl(
	diameter: Double,
	height: Double,
	halfCyl: Boolean,
	quartCyl: Boolean,
): String {
	val radius = 0.5 * diameter
	var waterWeight = ((PI * radius.pow(2) * height) / 231.0) * 8.33
	if (halfCyl)
		waterWeight = (((PI * radius.pow(2) * height) / 2) / 231.0) * 8.33
	if (quartCyl)
		waterWeight = (((PI * radius.pow(2) * height) / 4) / 231.0) * 8.33

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(waterWeight)
}

@VisibleForTesting
internal fun calculateVolGallonFTCyl(
	diameter: Double,
	height: Double,
	halfCyl: Boolean,
	quartCyl: Boolean,
): String {
	val radius = 0.5 * diameter
	var volGallons = (PI * radius.pow(2) * height) / 0.133681
	if (halfCyl)
		volGallons = ((PI * radius.pow(2) * height) / 2) / 0.133681
	if (quartCyl)
		volGallons = ((PI * radius.pow(2) * height) / 4) / 0.133681

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volGallons)
}

@VisibleForTesting
internal fun calculateVolLiterFTCyl(
	diameter: Double,
	height: Double,
	halfCyl: Boolean,
	quartCyl: Boolean,
): String {
	val radius = 0.5 * diameter
	var volLiters = (PI * radius.pow(2) * height) / 0.0353147
	if (halfCyl)
		volLiters = ((PI * radius.pow(2) * height) / 2) / 0.0353147
	if (quartCyl)
		volLiters = ((PI * radius.pow(2) * height) / 4) / 0.0353147

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(volLiters)
}

@VisibleForTesting
internal fun calculateWaterWeightFTCyl(
	diameter: Double,
	height: Double,
	halfCyl: Boolean,
	quartCyl: Boolean,
): String {
	val radius = 0.5 * diameter
	var waterWeight = ((PI * radius.pow(2) * height) / 0.133681) * 8.33
	if (halfCyl)
		waterWeight = (((PI * radius.pow(2) * height) / 2) / 0.133681) * 8.33
	if (quartCyl)
		waterWeight = (((PI * radius.pow(2) * height) / 4) / 0.133681) * 8.33

	val df = DecimalFormat("#.##")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(waterWeight)
}
//
//@Preview(showBackground = true)
//@Composable
//fun CylPreview() {
//    AquariumInfoTheme  {
//        TankVolCylScreen()
//    }
//}