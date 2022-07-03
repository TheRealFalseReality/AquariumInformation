package cca.capitalcityaquatics.aquariuminfo.ui.tankVolume

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.ui.common.*
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.PI

@Preview(showBackground = true)
@Composable
fun TankVolBFScreen (
    modifier: Modifier = Modifier,
) {
    var inputLength by rememberSaveable {
        mutableStateOf("")
    }
    var inputWidth by rememberSaveable {
        mutableStateOf("")
    }
    var inputHeight by rememberSaveable {
        mutableStateOf("")
    }
    var inputFullWidth by rememberSaveable {
        mutableStateOf("")
    }

    var selected by rememberSaveable {
        mutableStateOf(R.string.button_label_inches)
    }

    val length = inputLength.toDoubleOrNull() ?: 0.0
    val width = inputWidth.toDoubleOrNull() ?: 0.0
    val height = inputHeight.toDoubleOrNull() ?: 0.0
    val fullWidth = inputFullWidth.toDoubleOrNull() ?: 0.0

    val volGallon = calculateVolGallonBF(length,width,height,fullWidth)
    val volLiter = calculateVolLiterBF(length,width,height,fullWidth)
    val waterWeight = calculateWaterWeightBF(length,width,height,fullWidth)
    val volGallonFT = calculateVolGallonFTBF(length, width, height,fullWidth)
    val volLiterFT = calculateVolLiterFTBF(length, width, height,fullWidth)
    val waterWeightFT = calculateWaterWeightFTBF(length, width, height,fullWidth)

    GeneralCard(verticalArrangement = Arrangement.Top) {
        GeneralComposeHeader(text = R.string.text_title_bow_front)

        GeneralComposeSubHeader(text = R.string.text_subtitle_tank_vol)

        RadioButtonCardTankVol(
            onClick1 = { selected = R.string.button_label_inches },
            onClick2 = { selected = R.string.button_label_feet },
            selected = selected
        )

        EditNumberFieldQuad(
            label1 = R.string.field_label_length,
            label2 = R.string.Field_label_width,
            label3 = R.string.Field_label_height,
            label4 = R.string.field_label_full_width,
            value1 = inputLength,
            value2 = inputWidth,
            value3 = inputHeight,
            value4 = inputFullWidth,
            onValueChange1 = { inputLength = it },
            onValueChange2 = { inputWidth = it },
            onValueChange3 = { inputHeight = it },
            onValueChange4 = { inputFullWidth = it }
        )

        InputUnitsDisplay4(
            textA = R.string.text_amount_length,
            textB = R.string.text_amount_width,
            textC = R.string.text_amount_height,
            textD = R.string.text_amount_full_width,
            valueA = length,
            valueB = width,
            valueC = height,
            valueD =fullWidth,
        )

        when (selected){
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
            image = R.drawable.bowfront_calc,
            contDesc = R.string.text_title_bow_front,
            modifier = Modifier
                .padding(start = 46.dp)
        )

        FormulaString(text =R.string.text_formula_soon )

    }
}

@VisibleForTesting
internal fun calculateVolGallonBF(
    length: Double,
    width: Double,
    height: Double,
    fullWidth: Double
): String {
    val volGallons = ((length * width + (PI * (length / 2) * (fullWidth - width)) / 2) * height) / 231.0

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(volGallons)
}

@VisibleForTesting
internal fun calculateVolLiterBF(
    length: Double,
    width: Double,
    height: Double,
    fullWidth: Double
): String {
    val volLiters = ((length * width + (PI * (length / 2) * (fullWidth - width)) / 2) * height) / 61.0237

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(volLiters)
}

@VisibleForTesting
internal fun calculateWaterWeightBF(
    length: Double,
    width: Double,
    height: Double,
    fullWidth: Double
): String {
    val waterWeight = (((length * width + (PI * (length / 2) * (fullWidth - width)) / 2) * height) / 231.0) * 8.33

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(waterWeight)
}

@VisibleForTesting
internal fun calculateVolGallonFTBF(
    length: Double,
    width: Double,
    height: Double,
    fullWidth: Double
): String {
    val volGallons = ((length * width + (PI * (length / 2) * (fullWidth - width)) / 2) * height) / 0.133681

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(volGallons)
}

@VisibleForTesting
internal fun calculateVolLiterFTBF(
    length: Double,
    width: Double,
    height: Double,
    fullWidth: Double
): String {
    val volLiters = ((length * width + (PI * (length / 2) * (fullWidth - width)) / 2) * height) / 0.0353147

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(volLiters)
}

@VisibleForTesting
internal fun calculateWaterWeightFTBF(
    length: Double,
    width: Double,
    height: Double,
    fullWidth: Double
): String {
    val waterWeight = (((length * width + (PI * (length / 2) * (fullWidth - width)) / 2) * height) / 0.133681) * 8.33

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(waterWeight)
}

//@Preview(showBackground = true)
//@Composable
//fun BFPreview() {
//    AquariumInfoTheme  {
//        TankVolBFScreen()
//    }
//}