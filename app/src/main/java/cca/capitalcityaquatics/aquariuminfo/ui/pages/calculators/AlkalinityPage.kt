package cca.capitalcityaquatics.aquariuminfo.ui.pages.calculators

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.data.calculators.alkalinityDataSource
import cca.capitalcityaquatics.aquariuminfo.data.tankvolumes.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateField
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatedText
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FormulaString
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.GenericCalculatePage
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.InputNumberField
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageView
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.RadioButtonThreeUnits
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.SingleWideCardExpandableRadio
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun AlkalinityPage() {
	PageView {
		AlkalinityLayout()
	}
}

@Composable
fun AlkalinityLayout(
	color: Color = MaterialTheme.colorScheme.primary,
	containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
	contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
) {
	var inputAlk by rememberSaveable {
		mutableStateOf("10")
	}
	var selected by rememberSaveable {
		mutableIntStateOf(alkalinityDataSource.radioTextDkh)
	}
	val alk = inputAlk.toDoubleOrNull() ?: 0.0
	val ppmDKH = calculatePpmDkh(alk).toDoubleOrNull() ?: 0.0
	val dkhPPM = calculateDkhPpm(alk).toDoubleOrNull() ?: 0.0
	val meqDKH = calculateMeqDkh(alk).toDoubleOrNull() ?: 0.0
	val meqPPM = calculateMeqPpm(alk).toDoubleOrNull() ?: 0.0
	val ppmMEQ = calculatePpmMeq(alk).toDoubleOrNull() ?: 0.0
	val dkhMEQ = calculateDkhMeq(alk).toDoubleOrNull() ?: 0.0

	GenericCalculatePage(
		subtitle = alkalinityDataSource.subtitle,
		color = color,
		selectContent = {
			SingleWideCardExpandableRadio(
				modifier = Modifier.fillMaxWidth(fraction = 0.75f),
				expandedState = true,
				header = R.string.select_input_units,
				content = {
					RadioButtonThreeUnits(
						onClick1 = { selected = alkalinityDataSource.radioTextDkh },
						onClick2 = { selected = alkalinityDataSource.radioTextPpm },
						onClick3 = { selected = alkalinityDataSource.radioTextMeq },
						selected = selected,
						selectedColor = color,
						textColor = color
					)
				},
				contentColor = color,
			)
		},
		calculateFieldContent = {
			when (selected) {
				alkalinityDataSource.radioTextDkh -> {
					CalculateField(
						inputContent = {
							InputNumberField(
								label = alkalinityDataSource.labelDkh,
//								placeholder = alkalinityDataSource.placeholderDkh,
								value = inputAlk,
								onValueChange = { inputAlk = it },
								focusedContainerColor = containerColor,
								focusedColor = contentColor,
								unfocusedColor = color,
								leadingIcon = calculatorDataSource.leadingIconTDS,

							)
						},
						inputText = alkalinityDataSource.inputTextDkh,
						inputValue = inputAlk,
						equalsText = alkalinityDataSource.equalsText,
						contentColor = color,
						containerColor = containerColor,
						calculateContent = {
							CalculatedText(
								text = alkalinityDataSource.calculatedTextPpm,
								calculatedValue = ppmDKH,
								textColor = contentColor,
							)
							CalculatedText(
								text = alkalinityDataSource.calculatedTextMeq,
								calculatedValue = meqDKH,
								textColor = contentColor,
							)
						}
					)
				}

				alkalinityDataSource.radioTextPpm -> {
					CalculateField(
						inputContent = {
							InputNumberField(
								label = alkalinityDataSource.labelPpm,
//								placeholder = alkalinityDataSource.placeholderPpm,
								value = inputAlk,
								onValueChange = { inputAlk = it },
								focusedContainerColor = containerColor,
								focusedColor = contentColor,
								unfocusedColor = color,
								leadingIcon = calculatorDataSource.leadingIconTDS,
							)
						},
						inputText = alkalinityDataSource.inputTextPpm,
						inputValue = inputAlk,
						equalsText = alkalinityDataSource.equalsText,
						contentColor = color,
						containerColor = containerColor,
						calculateContent = {
							CalculatedText(
								text = alkalinityDataSource.calculatedTextDkh,
								calculatedValue = dkhPPM,
								textColor = contentColor,
							)
							CalculatedText(
								text = alkalinityDataSource.calculatedTextMeq,
								calculatedValue = meqPPM,
								textColor = contentColor,
							)
						}
					)
				}

				alkalinityDataSource.radioTextMeq -> {
					CalculateField(
						inputContent = {
							InputNumberField(
								label = alkalinityDataSource.labelMeq,
//								placeholder = alkalinityDataSource.placeholderMeq,
								value = inputAlk,
								onValueChange = { inputAlk = it },
								focusedContainerColor = containerColor,
								focusedColor = contentColor,
								unfocusedColor = color,
								leadingIcon = calculatorDataSource.leadingIconTDS,
							)
						},
						inputText = alkalinityDataSource.inputTextMeq,
						inputValue = inputAlk,
						equalsText = alkalinityDataSource.equalsText,
						contentColor = color,
						containerColor = containerColor,
						calculateContent = {
							CalculatedText(
								text = alkalinityDataSource.calculatedTextDkh,
								calculatedValue = dkhMEQ,
								textColor = contentColor,
							)
							CalculatedText(
								text = alkalinityDataSource.calculatedTextPpm,
								calculatedValue = ppmMEQ,
								textColor = contentColor,
							)
						}
					)
				}
			}
		},
		formulaContent = {
			FormulaString(
				text = alkalinityDataSource.formulaText,
				contentColor = color
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