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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.ui.commonComposables.*
import java.math.RoundingMode
import java.text.DecimalFormat

@Preview(showBackground = true)
@Composable
fun TankVolHexScreen (
    modifier: Modifier = Modifier,
) {
    var inputEdge by rememberSaveable {
        mutableStateOf("")
    }
    var inputHeight by rememberSaveable {
        mutableStateOf("")
    }

    var selected by rememberSaveable {
        mutableStateOf(R.string.button_label_inches)
    }

    val edge = inputEdge.toDoubleOrNull() ?: 0.0
    val height = inputHeight.toDoubleOrNull() ?: 0.0

    val volGallon = calculateVolGallonHex(edge,height)
    val volLiter = calculateVolLiterHex(edge,height)
    val waterWeight = calculateWaterWeightHex(edge,height)
    val volGallonFT = calculateVolGallonFTHex(edge,height)
    val volLiterFT = calculateVolLiterFTHex(edge,height)
    val waterWeightFT = calculateWaterWeightFTHex(edge,height)

    GeneralCard(verticalArrangement = Arrangement.Top) {
        GeneralComposeHeader(text = R.string.text_title_hex)

        GeneralComposeSubHeader(text = R.string.text_subtitle_tank_vol)

        RadioButtonCardTankVol(
            onClick1 = { selected = R.string.button_label_inches },
            onClick2 = { selected = R.string.button_label_feet },
            selected = selected
        )

        EditNumberField2Hor(
            label1 = R.string.field_label_edge,
            label2 = R.string.Field_label_height,
            value1 = inputEdge,
            value2 = inputHeight,
            onValueChange1 = { inputEdge = it },
            onValueChange2 = { inputHeight = it }
        )

        InputUnitsDisplay2(
            textA = R.string.text_amount_length,
            textB = R.string.text_amount_height,
            valueA = edge,
            valueB = height
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
            image = R.drawable.hexagonal_prism,
            contDesc = R.string.text_title_hex,
            modifier = Modifier
                .padding(start = 15.dp)
        )

        FormulaString {
            GeneralComposeBody(
                text = R.string.text_formula_soon,
                textAlign = TextAlign.Center
            )
        }
    }
}

@VisibleForTesting
internal fun calculateVolGallonHex(
    edge: Double,
    height: Double
): String {
    val volGallons = (((3 * kotlin.math.sqrt(3.0)) / 2) * edge * edge * height) / 231.0

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(volGallons)
}

@VisibleForTesting
internal fun calculateVolLiterHex(
    edge: Double,
    height: Double
): String {
    val volLiters = (((3 * kotlin.math.sqrt(3.0)) / 2) * edge * edge * height) / 61.0237

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(volLiters)
}

@VisibleForTesting
internal fun calculateWaterWeightHex(
    edge: Double,
    height: Double
): String {
    val waterWeight = ((((3 * kotlin.math.sqrt(3.0)) / 2) * edge * edge * height) / 231.0) * 8.33

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(waterWeight)
}

@VisibleForTesting
internal fun calculateVolGallonFTHex(
    edge: Double,
    height: Double
): String {
    val volGallons = (((3 * kotlin.math.sqrt(3.0)) / 2) * edge * edge * height) / 0.133681

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(volGallons)
}

@VisibleForTesting
internal fun calculateVolLiterFTHex(
    edge: Double,
    height: Double
): String {
    val volLiters = (((3 * kotlin.math.sqrt(3.0)) / 2) * edge * edge * height) / 0.0353147

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(volLiters)
}

@VisibleForTesting
internal fun calculateWaterWeightFTHex(
    edge: Double,
    height: Double
): String {
    val waterWeight = ((((3 * kotlin.math.sqrt(3.0)) / 2) * edge * edge * height) / 0.133681) * 8.33

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(waterWeight)
}

//@Preview(showBackground = true)
//@Composable
//fun HexPreview() {
//    AquariumInfoTheme  {
//        TankVolHexScreen()
//    }
//}