package cca.capitalcityaquatics.aquariuminfo.converters

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.common.*
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInfoTheme
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow

@Composable
fun SalScreen (
    modifier: Modifier = Modifier,
) {
    var inputSal by rememberSaveable {
        mutableStateOf("")
    }
    var selected by rememberSaveable {
        mutableStateOf(R.string.button_label_ppt)
    }

    val tempTestWater = 25.0
    val tempPureWater = 25.0

    val sal = inputSal.toDoubleOrNull() ?: 0.0

    val ppt = calculateSalinity(sal, tempTestWater)
    val sg = calculateSpecificGravity(sal, tempPureWater, tempTestWater)
    val salDensityPPT = calculateDensityPPT(sal, tempTestWater)
    val salDensitySG = calculateDensitySG(sal, tempPureWater)

        Column(
            modifier = modifier
                .padding(start = 24.dp, end = 24.dp, top = 24.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Card(
                backgroundColor = MaterialTheme.colors.primary,
                modifier = Modifier
                    .padding(bottom = 86.dp)
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .border(
                        BorderStroke(2.dp, MaterialTheme.colors.primaryVariant),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .verticalScroll(rememberScrollState())
            ) {
                Column(
                    modifier = Modifier
                        .padding(14.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    GeneralComposeHeader(textHeader = R.string.text_header_salinity)

                    GeneralComposeSubHeader(textHeader = R.string.text_subtitle_salinity)

                    RadioButtonCardSal(
                        text1 = R.string.button_label_ppt,
                        text2 = R.string.button_label_sg,
                        onClick1 = { selected = R.string.button_label_ppt },
                        onClick2 = { selected = R.string.button_label_sg },
                        selected = selected
                    )

                    when (selected) {
                        R.string.button_label_ppt -> {

                            DataOutputLines4Salinity(
                                value = inputSal,
                                label = R.string.field_label_ppt,
                                onValueChange = { inputSal = it },
                                inputText = R.string.text_amount_ppt,
                                equalsText = R.string.text_equiv,
                                outputTextA = R.string.text_amount_sg,
                                valueA = sg,
                                outputTextB = R.string.text_amount_density,
                                valueB = salDensityPPT
                            )
                        }
                        R.string.button_label_sg -> {

                            DataOutputLines4Salinity(
                                value = inputSal,
                                label = R.string.field_label_sg,
                                onValueChange = { inputSal = it },
                                inputText = R.string.text_amount_sg,
                                equalsText = R.string.text_equiv,
                                outputTextA = R.string.text_amount_ppt,
                                valueA = ppt,
                                outputTextB = R.string.text_amount_density,
                                valueB = salDensitySG
                            )
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))

                    InfoCardContent6(
                        title = R.string.text_more_info,
                        textBody1 = R.string.text_temp_set,
                        textBody2 = R.string.text_sal_den,
                        textBody3 = R.string.text_sg_sal,
                        textBody4 = R.string.text_cond_sal,
                        textBody5 = R.string.text_cond_text,
                        textBody6 = R.string.text_sal_values,
                        textBody7 = R.string.text_sal_calc
                    )

                }
            }
        }
    }

@VisibleForTesting
internal fun calculateSpecificGravity (
    sal: Double,
    tempTestWater: Double,
    tempPureWater: Double,
): String{
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
            6.536332e-9 * tempPureWater * tempPureWater* tempPureWater * tempPureWater*
            tempPureWater
    val salDensityPPT = rROo + aA * sal + bB * kotlin.math.sqrt(sal.pow(3)) + cC * sal * sal

    val sg = salDensityPPT / rROoTD

    val df = DecimalFormat("#.###")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(sg)
}

@VisibleForTesting
internal fun calculateSalinity (
    sal:Double,
    tempTestWater: Double,
): String{
    val ppt = sal * 1240.63326 + tempTestWater * -3.26377 + sal * tempTestWater * 3.20800 + sal *
            sal * 4.58072 + tempTestWater * tempTestWater * 0.00719 + -1246.10737

    val df = DecimalFormat("#.###")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(ppt)
}

@VisibleForTesting
internal fun calculateDensityPPT (
    sal:Double,
    tempTestWater: Double,
): String{
    val aB = 8.24493e-1 - 4.0899e-3 * tempTestWater + 7.6438e-5 * tempTestWater * tempTestWater -
            8.2467e-7 * tempTestWater * tempTestWater * tempTestWater + 5.3875e-9 * tempTestWater *
            tempTestWater * tempTestWater * tempTestWater
    val bC = -5.72466e-3 + 1.0227e-4 * tempTestWater - 1.6546e-6 * tempTestWater * tempTestWater
    val cD = 4.8314e-4
    val rOO = 999.842594 + 6.793952e-2 * tempTestWater - 9.095290e-3 * tempTestWater * tempTestWater
    + 1.001685e-4 * tempTestWater * tempTestWater * tempTestWater - 1.120083e-6 *
            tempTestWater * tempTestWater * tempTestWater * tempTestWater + 6.536332e-9 *
            tempTestWater * tempTestWater * tempTestWater * tempTestWater * tempTestWater
    val rO = rOO + aB * sal + bC * kotlin.math.sqrt(sal.pow(3)) + cD * sal * sal

    val df = DecimalFormat("#.###")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(rO)
}

@VisibleForTesting
internal fun calculateDensitySG (
    sal:Double,
    tempPureWater: Double
): String{
    val rOoTDc = 999.842594 + 6.793952e-2 * tempPureWater - 9.095290e-3 * tempPureWater*
            tempPureWater + 1.001685e-4 * tempPureWater * tempPureWater * tempPureWater -
            1.120083e-6 * tempPureWater * tempPureWater * tempPureWater * tempPureWater +
            6.536332e-9 * tempPureWater * tempPureWater * tempPureWater * tempPureWater *
            tempPureWater
    val rO1 = sal * rOoTDc

    val df = DecimalFormat("#.###")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(rO1)
}

@Preview(showBackground = true)
@Composable
fun SalPreview() {
    AquariumInfoTheme  {
        SalScreen()
    }
}