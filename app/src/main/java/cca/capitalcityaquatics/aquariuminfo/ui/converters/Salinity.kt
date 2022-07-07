package cca.capitalcityaquatics.aquariuminfo.ui.converters

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.LoadFile
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.ui.commonComposables.*
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow

@Preview(showBackground = true)
@Composable
fun SalScreen (
    modifier: Modifier = Modifier,
) {
    var inputSal by rememberSaveable {
        mutableStateOf("36")
    }
    var selected by rememberSaveable {
        mutableStateOf(R.string.button_label_ppt)
    }

    val tempTestWater = 25.0
    val tempPureWater = 25.0

    val sal = inputSal.toDoubleOrNull() ?: 0.0

    val ppt = calculateSalinity(sal, tempTestWater).toDoubleOrNull() ?: 0.0
    val sg = calculateSpecificGravity(sal, tempPureWater, tempTestWater).toDoubleOrNull() ?: 0.0
    val salDensityPPT = calculateDensityPPT(sal, tempTestWater).toDoubleOrNull() ?: 0.0
    val salDensitySG = calculateDensitySG(sal, tempPureWater).toDoubleOrNull() ?: 0.0

    GeneralCard(verticalArrangement = Arrangement.Top) {
        GeneralComposeHeader(text = R.string.text_header_salinity)

        GeneralComposeSubHeader(text = R.string.text_subtitle_salinity)

        RadioButtonCard {
            RadioButtonComp(
                text = R.string.button_label_ppt,
                onClick1 = { selected = R.string.button_label_ppt },
                selected = selected
            )
            RadioButtonComp(
                text = R.string.button_label_sg,
                onClick1 = { selected = R.string.button_label_sg },
                selected = selected
            )
        }

        when (selected) {
            R.string.button_label_ppt -> {
                DataOutputSalinity(
                    inputValue = inputSal,
                    label = R.string.field_label_ppt,
                    onValueChange = { inputSal = it },
                    salinity = sg,
                    density = salDensityPPT
                )
            }
            R.string.button_label_sg -> {
                DataOutputSalinity(
                    inputValue = inputSal,
                    label = R.string.field_label_sg,
                    onValueChange = { inputSal = it },
                    salinity = ppt,
                    density = salDensitySG
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        InfoCardContent(
            icon = painterResource(id = R.drawable.info_48px),
            title = R.string.text_more_info
        ) {
            LoadFile(
                file = "SalinityInformation.txt",
                textAlign = TextAlign.Start
            )

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

//@Preview(showBackground = true)
//@Composable
//fun SalPreview() {
//    AquariumInfoTheme  {
//        SalScreen()
//    }
//}