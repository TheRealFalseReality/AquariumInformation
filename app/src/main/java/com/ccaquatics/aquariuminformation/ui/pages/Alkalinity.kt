package com.ccaquatics.aquariuminformation.ui.pages

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ccaquatics.aquariuminformation.R
import com.ccaquatics.aquariuminformation.ui.commonui.BodyTextCard
import com.ccaquatics.aquariuminformation.ui.commonui.CalculateField
import com.ccaquatics.aquariuminformation.ui.commonui.CalculatedText
import com.ccaquatics.aquariuminformation.ui.commonui.FormulaString
import com.ccaquatics.aquariuminformation.ui.commonui.GenericPage
import com.ccaquatics.aquariuminformation.ui.commonui.InputNumberField
import com.ccaquatics.aquariuminformation.ui.commonui.RadioButtonComp
import com.ccaquatics.aquariuminformation.ui.commonui.UnitButtonCard
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun AlkalinityPage() {
	AlkalinityLayout()
}

@Composable
fun AlkalinityLayout() {
	val color = MaterialTheme.colorScheme.primary

	var inputAlk by rememberSaveable {
		mutableStateOf("10")
	}
	var selected by rememberSaveable {
		mutableIntStateOf(R.string.button_label_dkh)
	}
	val alk = inputAlk.toDoubleOrNull() ?: 0.0
	val ppmDKH = calculatePpmDkh(alk).toDoubleOrNull() ?: 0.0
	val dkhPPM = calculateDkhPpm(alk).toDoubleOrNull() ?: 0.0
	val meqDKH = calculateMeqDkh(alk).toDoubleOrNull() ?: 0.0
	val meqPPM = calculateMeqPpm(alk).toDoubleOrNull() ?: 0.0
	val ppmMEQ = calculatePpmMeq(alk).toDoubleOrNull() ?: 0.0
	val dkhMEQ = calculateDkhMeq(alk).toDoubleOrNull() ?: 0.0

	GenericPage(
		title = R.string.text_title_alk,
		subtitle = R.string.text_subtitle_alk,
		icon = R.drawable.ic_alkalinity,
		color = color,
		selectContent = {
			UnitButtonCard(
				content = {
					Row(
						modifier = Modifier
							.fillMaxWidth(),
					) {
						RadioButtonComp(
							modifier = Modifier
								.weight(1f),
							text = R.string.button_label_dkh,
							onClick = { selected = R.string.button_label_dkh },
							selected = selected,
							selectedColor = color
						)
						RadioButtonComp(
							modifier = Modifier
								.weight(1f),
							text = R.string.button_label_ppm,
							onClick = { selected = R.string.button_label_ppm },
							selected = selected,
							selectedColor = color
						)
						RadioButtonComp(
							modifier = Modifier
								.weight(1f),
							text = R.string.button_label_meq,
							onClick = { selected = R.string.button_label_meq },
							selected = selected,
							selectedColor = color
						)
					}
				},
				contentColor = color,
			)
		},
		calculateFieldContent = {
			when (selected) {
				R.string.button_label_dkh -> {
					CalculateField(
						inputContent = {
							InputNumberField(
								label = R.string.button_label_dkh,
								placeholder = R.string.field_label_dkh,
								value = inputAlk,
								onValueChange = { inputAlk = it },
								color = color,
							)
						},
						inputText = R.string.text_amount_dkh,
						inputValue = inputAlk,
						equalsText = R.string.text_equal_to,
						calculateContent = {
							CalculatedText(
								text = R.string.text_amount_ppm,
								calculatedValue = ppmDKH,
								color = color
							)
							CalculatedText(
								text = R.string.text_amount_meq,
								calculatedValue = meqDKH,
								color = color
							)
						}
					)
				}

				R.string.button_label_ppm -> {
					CalculateField(
						inputContent = {
							InputNumberField(
								label = R.string.button_label_ppm,
								placeholder = R.string.field_label_ppm,
								value = inputAlk,
								onValueChange = { inputAlk = it },
								color = color
							)
						},
						inputText = R.string.text_amount_ppm,
						inputValue = inputAlk,
						equalsText = R.string.text_equal_to,
						calculateContent = {
							CalculatedText(
								text = R.string.text_amount_dkh,
								calculatedValue = dkhPPM,
								color = color
							)
							CalculatedText(
								text = R.string.text_amount_meq,
								calculatedValue = meqPPM,
								color = color
							)
						}
					)
				}

				R.string.button_label_meq -> {
					CalculateField(
						inputContent = {
							InputNumberField(
								label = R.string.button_label_meq,
								placeholder = R.string.field_label_meq,
								value = inputAlk,
								onValueChange = { inputAlk = it },
								color = color
							)
						},
						inputText = R.string.text_amount_meq,
						inputValue = inputAlk,
						equalsText = R.string.text_equal_to,
						calculateContent = {
							CalculatedText(
								text = R.string.text_amount_dkh,
								calculatedValue = dkhMEQ,
								color = color
							)
							CalculatedText(
								text = R.string.text_amount_ppm,
								calculatedValue = ppmMEQ,
								color = color
							)
						}
					)
				}
			}
		},
		formulaContent = {
			FormulaString(
				content = {
					BodyTextCard(
						text = R.string.text_formula_alk
					)
				},
				color = color
			)
		}
	)
}

//@Composable
//fun WaterHardnessDKH(
//	ppmDKH: Double,
//) {
//	val vSoft = stringResource(id = R.string.text_hardness_very_soft)
//	val soft = stringResource(id = R.string.text_hardness_soft)
//	val modHard = stringResource(id = R.string.text_hardness_mod_hard)
//	val hard = stringResource(id = R.string.text_hardness_hard)
//	val veryHard = stringResource(id = R.string.text_hardness_very_hard)
//	val outBounds = stringResource(id = R.string.text_hardness_else)
//
//	when (ppmDKH) {
//		in 0.0..70.0 -> {
//			Text(text = stringResource(R.string.text_hardness_label, vSoft))
//			Spacer(modifier = Modifier.height(10.dp))
//			Image(
//				painter = painterResource(id = R.drawable.ic_vsoftdkh),
//				contentDescription = stringResource(id = R.string.text_hardness_very_soft)
//			)
//		}
//		in 70.1..140.0 -> {
//			Text(text = stringResource(R.string.text_hardness_label, soft))
//			Spacer(modifier = Modifier.height(10.dp))
//			Image(
//				painter = painterResource(id = R.drawable.softdkh),
//				contentDescription = stringResource(id = R.string.text_hardness_soft)
//			)
//		}
//		in 140.1..210.0 -> {
//			Text(text = stringResource(R.string.text_hardness_label, modHard))
//			Spacer(modifier = Modifier.height(10.dp))
//			Image(
//				painter = painterResource(id = R.drawable.mhardtdkh),
//				contentDescription = stringResource(id = R.string.text_hardness_mod_hard)
//			)
//		}
//		in 210.1..320.0 -> {
//			Text(text = stringResource(R.string.text_hardness_label, hard))
//			Spacer(modifier = Modifier.height(10.dp))
//			Image(
//				painter = painterResource(id = R.drawable.hardtdkh),
//				contentDescription = stringResource(id = R.string.text_hardness_hard)
//			)
//		}
//		in 320.1..530.0 -> {
//			Text(text = stringResource(R.string.text_hardness_label, veryHard))
//			Spacer(modifier = Modifier.height(10.dp))
//			Image(
//				painter = painterResource(id = R.drawable.vhardtdkh),
//				contentDescription = stringResource(id = R.string.text_hardness_very_hard)
//			)
//		}
//		else -> {
//			Column {
//				Text(
//					text = stringResource(id = R.string.text_hardness_label, outBounds),
//					style = MaterialTheme.typography.labelMedium
//				)
//				Spacer(modifier = Modifier.height(10.dp))
//				Image(
//					painter = painterResource(id = R.drawable.outdkh),
//					contentDescription = stringResource(id = R.string.text_hardness_very_hard)
//				)
//			}
//
//		}
//	}
//	Spacer(modifier = Modifier.height(8.dp))
//}

//@Composable
//fun WaterHardnessPPM(
//	dkhPPM: Double,
//) {
//	val vSoft = stringResource(id = R.string.text_hardness_very_soft)
//	val soft = stringResource(id = R.string.text_hardness_soft)
//	val modHard = stringResource(id = R.string.text_hardness_mod_hard)
//	val hard = stringResource(id = R.string.text_hardness_hard)
//	val veryHard = stringResource(id = R.string.text_hardness_very_hard)
//	val outBounds = stringResource(id = R.string.text_hardness_else)
//
//	when (dkhPPM) {
//		in 0.0..4.0 -> {
//			Text(text = stringResource(R.string.text_hardness_label, vSoft))
//			Spacer(modifier = Modifier.height(10.dp))
//			Image(
//				painter = painterResource(id = R.drawable.ic_vsoftdkh),
//				contentDescription = stringResource(id = R.string.text_hardness_very_soft)
//			)
//		}
//		in 4.1..8.0 -> {
//			Text(text = stringResource(R.string.text_hardness_label, soft))
//			Spacer(modifier = Modifier.height(10.dp))
//			Image(
//				painter = painterResource(id = R.drawable.softdkh),
//				contentDescription = stringResource(id = R.string.text_hardness_soft)
//			)
//		}
//		in 8.1..12.0 -> {
//			Text(text = stringResource(R.string.text_hardness_label, modHard))
//			Spacer(modifier = Modifier.height(10.dp))
//			Image(
//				painter = painterResource(id = R.drawable.mhardtdkh),
//				contentDescription = stringResource(id = R.string.text_hardness_mod_hard)
//			)
//		}
//		in 12.1..18.0 -> {
//			Text(text = stringResource(R.string.text_hardness_label, hard))
//			Spacer(modifier = Modifier.height(10.dp))
//			Image(
//				painter = painterResource(id = R.drawable.hardtdkh),
//				contentDescription = stringResource(id = R.string.text_hardness_hard)
//			)
//		}
//		in 18.1..30.0 -> {
//			Text(text = stringResource(R.string.text_hardness_label, veryHard))
//			Spacer(modifier = Modifier.height(10.dp))
//			Image(
//				painter = painterResource(id = R.drawable.vhardtdkh),
//				contentDescription = stringResource(id = R.string.text_hardness_very_hard)
//			)
//		}
//		else -> {
//			Text(text = stringResource(id = R.string.text_hardness_label, outBounds))
//			Spacer(modifier = Modifier.height(10.dp))
//			Image(
//				painter = painterResource(id = R.drawable.outdkh),
//				contentDescription = stringResource(id = R.string.text_hardness_very_hard)
//			)
//		}
//	}
//	Spacer(modifier = Modifier.height(8.dp))
//}
//
//@Composable
//fun WaterHardnessMEQ(
//	ppmMEQ: Double,
//) {
//	val vSoft = stringResource(id = R.string.text_hardness_very_soft)
//	val soft = stringResource(id = R.string.text_hardness_soft)
//	val modHard = stringResource(id = R.string.text_hardness_mod_hard)
//	val hard = stringResource(id = R.string.text_hardness_hard)
//	val veryHard = stringResource(id = R.string.text_hardness_very_hard)
//	val outBounds = stringResource(id = R.string.text_hardness_else)
//
//	when (ppmMEQ) {
//		in 0.0..70.0 -> {
//			Text(text = stringResource(R.string.text_hardness_label, vSoft))
//			Spacer(modifier = Modifier.height(10.dp))
//			Image(
//				painter = painterResource(id = R.drawable.ic_vsoftdkh),
//				contentDescription = stringResource(id = R.string.text_hardness_very_soft)
//			)
//		}
//		in 70.1..140.0 -> {
//			Text(text = stringResource(R.string.text_hardness_label, soft))
//			Spacer(modifier = Modifier.height(10.dp))
//			Image(
//				painter = painterResource(id = R.drawable.softdkh),
//				contentDescription = stringResource(id = R.string.text_hardness_soft)
//			)
//		}
//		in 140.1..210.0 -> {
//			Text(text = stringResource(R.string.text_hardness_label, modHard))
//			Spacer(modifier = Modifier.height(10.dp))
//			Image(
//				painter = painterResource(id = R.drawable.mhardtdkh),
//				contentDescription = stringResource(id = R.string.text_hardness_mod_hard)
//			)
//		}
//		in 210.1..320.0 -> {
//			Text(text = stringResource(R.string.text_hardness_label, hard))
//			Spacer(modifier = Modifier.height(10.dp))
//			Image(
//				painter = painterResource(id = R.drawable.hardtdkh),
//				contentDescription = stringResource(id = R.string.text_hardness_hard)
//			)
//		}
//		in 320.1..530.0 -> {
//			Text(text = stringResource(R.string.text_hardness_label, veryHard))
//			Spacer(modifier = Modifier.height(10.dp))
//			Image(
//				painter = painterResource(id = R.drawable.vhardtdkh),
//				contentDescription = stringResource(id = R.string.text_hardness_very_hard)
//			)
//		}
//		else -> {
//			Text(text = stringResource(id = R.string.text_hardness_label, outBounds))
//			Spacer(modifier = Modifier.height(10.dp))
//			Image(
//				painter = painterResource(id = R.drawable.outdkh),
//				contentDescription = stringResource(id = R.string.text_hardness_very_hard)
//			)
//		}
//	}
//}

@VisibleForTesting
fun calculatePpmDkh(
	alk: Double,
): String {
	val ppmDKH = alk * 17.857
	val df = DecimalFormat("#")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(ppmDKH)
}

@VisibleForTesting
fun calculateMeqDkh(
	alk: Double,
): String {
	val meqDKH = alk * 0.357
	val df = DecimalFormat("#.#")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(meqDKH)
}

@VisibleForTesting
fun calculateDkhPpm(
	alk: Double,
): String {
	val dkhPPM = alk * 0.056
	val df = DecimalFormat("#.#")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(dkhPPM)
}

@VisibleForTesting
fun calculateMeqPpm(
	alk: Double,
): String {
	val meqPPM = alk * 0.02
	val df = DecimalFormat("#.#")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(meqPPM)
}

@VisibleForTesting
fun calculatePpmMeq(
	alk: Double,
): String {
	val ppmMEQ = alk * 50
	val df = DecimalFormat("#.#")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(ppmMEQ)
}

@VisibleForTesting
fun calculateDkhMeq(
	alk: Double,
): String {
	val dkhMEQ = alk * 2.8
	val df = DecimalFormat("#.#")
	df.roundingMode = RoundingMode.HALF_UP

	return df.format(dkhMEQ)
}

@Preview(showBackground = true)
@Composable
fun AlkalinityPreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			AlkalinityPage()
		}
	}
}

@Preview(showBackground = true)
@Composable
fun AlkalinityPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			AlkalinityPage()
		}
	}
}