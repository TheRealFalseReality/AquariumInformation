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
import cca.capitalcityaquatics.aquariuminfo.data.calculators.alkalinityDataSource
import cca.capitalcityaquatics.aquariuminfo.data.tankvolumes.calculatorDataSource
import cca.capitalcityaquatics.aquariuminfo.model.calculators.CalculatorMethods
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculateField
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatedTextString
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.CalculatorSubtitleThree
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.FormulaString
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.GenericCalculatePage
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.InputNumberField
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.PageView
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.RadioButtonThreeUnits
import cca.capitalcityaquatics.aquariuminfo.ui.commonui.SingleWideCardExpandableRadio
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInformationTheme
import com.google.android.gms.common.util.VisibleForTesting
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun AlkalinityPage(windowSize: WindowSizeClass) {
	PageView {
		AlkalinityLayout(windowSize = windowSize)
	}
}

@SuppressLint("VisibleForTests")
@Composable
fun AlkalinityLayout(
	windowSize: WindowSizeClass,
	color: Color = MaterialTheme.colorScheme.primary,
	containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
	contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
) {
	val dataSource = alkalinityDataSource
	var inputAlk by rememberSaveable {
		mutableStateOf("10")
	}
	var selected by rememberSaveable {
		mutableIntStateOf(dataSource.radioTextDkh)
	}
	val alkalinity = inputAlk.toDoubleOrNull() ?: 0.0
	val parameters = CalculatorMethods(selected = selected, alkalinity = alkalinity)

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
					RadioButtonThreeUnits(
						onClick1 = { selected = dataSource.radioTextDkh },
						onClick2 = { selected = dataSource.radioTextPpm },
						onClick3 = { selected = dataSource.radioTextMeq },
						selected = selected,
						selectedColor = color,
						textColor = color
					)
				},
				contentColor = color,
			)
		},
		inputFieldContent = {
			InputNumberField(
				label =
				when (selected) {
					dataSource.radioTextPpm -> {
						dataSource.labelPpm
					}

					dataSource.radioTextMeq -> {
						dataSource.labelMeq
					}

					else -> {
						dataSource.labelDkh
					}
				},
				value = inputAlk,
				onValueChange = { inputAlk = it },
				focusedContainerColor = containerColor,
				focusedColor = contentColor,
				unfocusedColor = color,
				leadingIcon = calculatorDataSource.leadingIconTDS,
			)
		},
		calculateFieldContent = {
			CalculateField(
				inputText =
				when (selected) {
					// ppm
					dataSource.radioTextPpm -> {
						dataSource.inputTextPpm
					}

					// meq/L
					dataSource.radioTextMeq -> {
						dataSource.inputTextMeq
					}

					// dKH
					else -> {
						dataSource.inputTextDkh
					}
				},
				inputValue = inputAlk,
				calculateContent = {
					when (selected) {
						// ppm
						dataSource.radioTextPpm -> {
							CalculatedTextString(
								text = dataSource.calculatedTextDkh,
								calculatedValue = parameters.calculateAlkalinityDKH(),
								textColor = contentColor,
							)
							CalculatedTextString(
								text = dataSource.calculatedTextMeq,
								calculatedValue = parameters.calculateAlkalinityMEQ(),
								textColor = contentColor,
							)
						}

						// meq/L
						dataSource.radioTextMeq -> {
							CalculatedTextString(
								text = dataSource.calculatedTextDkh,
								calculatedValue = parameters.calculateAlkalinityDKH(),
								textColor = contentColor,
							)
							CalculatedTextString(
								text = dataSource.calculatedTextPpm,
								calculatedValue = parameters.calculateAlkalinityPPM(),
								textColor = contentColor,
							)
						}

						// dKH
						else -> {
							CalculatedTextString(
								text = dataSource.calculatedTextPpm,
								calculatedValue = parameters.calculateAlkalinityPPM(),
								textColor = contentColor,
							)
							CalculatedTextString(
								text = dataSource.calculatedTextMeq,
								calculatedValue = parameters.calculateAlkalinityMEQ(),
								textColor = contentColor,
							)
						}
					}
				},
				contentColor = color,
				equalsText = dataSource.equalsText,
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

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun AlkalinityPreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			AlkalinityPage(windowSize = WindowSizeClass.calculateFromSize(DpSize(300.dp, 400.dp)))
		}
	}
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Preview(showBackground = true)
@Composable
fun AlkalinityPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			AlkalinityPage(windowSize = WindowSizeClass.calculateFromSize(DpSize(300.dp, 400.dp)))
		}
	}
}