package cca.capitalcityaquatics.aquariuminfo.tankVolume

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

@Composable
fun TankVolRecScreen (
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

    var selected by rememberSaveable {
        mutableStateOf(R.string.button_label_inches)
    }

    val length = inputLength.toDoubleOrNull() ?: 0.0
    val width = inputWidth.toDoubleOrNull() ?: 0.0
    val height = inputHeight.toDoubleOrNull() ?: 0.0

    val volGallon = calculateVolGallon(length, width, height)
    val volLiter = calculateVolLiter(length, width, height)
    val waterWeight = calculateWaterWeight(length, width, height)
    val volGallonFT = calculateVolGallonFT(length, width, height)
    val volLiterFT = calculateVolLiterFT(length, width, height)
    val waterWeightFT = calculateWaterWeightFT(length, width, height)

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

                GeneralComposeHeader(textHeader = R.string.text_title_rectangle)

                GeneralComposeSubHeader(textHeader = R.string.text_subtitle_tank_vol)

                RadioButtonCardTankVol(
                    onClick1 = { selected = R.string.button_label_inches },
                    onClick2 = { selected = R.string.button_label_feet },
                    selected = selected
                )

                EditNumberField3Hor(
                    label1 = R.string.field_label_length,
                    label2 = R.string.Field_label_width,
                    label3 = R.string.Field_label_height,
                    value1 = inputLength,
                    value2 = inputWidth,
                    value3 = inputHeight,
                    onValueChange1 = { inputLength = it },
                    onValueChange2 = { inputWidth = it },
                    onValueChange3 = { inputHeight = it },
                )

                InputUnitsDisplay3(
                    textA = R.string.text_amount_length,
                    textB = R.string.text_amount_width,
                    textC = R.string.text_amount_height,
                    valueA = length,
                    valueB = width,
                    valueC = height
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
                                valueC = waterWeightFT)

                        }
                    }

                ImageGeneral(
                    image = R.drawable.box_calc,
                    contDesc = R.string.text_title_rectangle,
                    modifier = Modifier
                        .padding(start = 46.dp)
                )
                
                FormulaString(text =R.string.text_formula_vol_rec )
                
                }
            }
        }
    }

@VisibleForTesting
internal fun calculateVolGallon(
    length: Double,
    width: Double,
    height: Double
): String {
    val volGallons = (length * width * height) / 231.0

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(volGallons)
}

@VisibleForTesting
internal fun calculateVolLiter(
    length: Double,
    width: Double,
    height: Double,
): String {
    val volLiters = (length * width * height) / 61.0237

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(volLiters)
}

@VisibleForTesting
internal fun calculateWaterWeight(
    length: Double,
    width: Double,
    height: Double,
): String {
    val waterWeight = ((length * width * height) / 231.0) * 8.33

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(waterWeight)
}

@VisibleForTesting
internal fun calculateVolGallonFT(
    length: Double,
    width: Double,
    height: Double
): String {
    val volGallons = (length * width * height) / 0.133681

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(volGallons)
}

@VisibleForTesting
internal fun calculateVolLiterFT(
    length: Double,
    width: Double,
    height: Double,
): String {
    val volLiters = (length * width * height) / 0.0353147

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(volLiters)
}

@VisibleForTesting
internal fun calculateWaterWeightFT(
    length: Double,
    width: Double,
    height: Double,
): String {
    val waterWeight = ((length * width * height) / 0.133681) * 8.33

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(waterWeight)
}

@Preview(showBackground = true)
@Composable
fun RecPreview() {
    AquariumInfoTheme  {
        TankVolRecScreen()
    }
}