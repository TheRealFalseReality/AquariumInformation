package cca.capitalcityaquatics.aquariuminfo.tankVolume

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
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
import kotlin.math.PI
import kotlin.math.pow

@Composable
fun TankVolCylScreen (
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

    val diameter = inputDiameter.toDoubleOrNull() ?: 0.0
    val height = inputHeight.toDoubleOrNull() ?: 0.0

    val volGallon = calculateVolGallonCyl(diameter,height)
    val volLiter = calculateVolLiterCyl(diameter,height)
    val waterWeight = calculateWaterWeightCyl(diameter,height)
    val volGallonFT = calculateVolGallonFTCyl(diameter,height)
    val volLiterFT = calculateVolLiterFTCyl(diameter,height)
    val waterWeightFT = calculateWaterWeightFTCyl(diameter,height)

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

                GeneralComposeHeader(textHeader = R.string.text_title_cyl)

                GeneralComposeSubHeader(textHeader = R.string.text_subtitle_tank_vol)

                Card(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .border(
                            BorderStroke(3.dp, MaterialTheme.colors.primaryVariant),
                            shape = RoundedCornerShape(2.dp)
                        )
                        .heightIn(50.dp),
                    backgroundColor = MaterialTheme.colors.background,
                ) {
                    //Radio Group
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        RadioButton(
                            selected = selected == R.string.button_label_inches,
                            onClick = { selected = R.string.button_label_inches }
                        )
                        RadioButtonText(
                            text = R.string.button_label_inches,
                            modifier = Modifier
                                .weight(1f)
                                .padding(top = 10.dp)
                                .clickable(
                                    onClick = { selected = R.string.button_label_inches }
                                )
                        )
                        RadioButton(
                            selected = selected == R.string.button_label_feet,
                            onClick = { selected = R.string.button_label_feet }
                        )
                        RadioButtonText(
                            text = R.string.button_label_feet,
                            modifier = Modifier
                                .weight(1f)
                                .padding(top = 10.dp)
                                .clickable(
                                    onClick = { selected = R.string.button_label_feet }
                                )
                        )
                    }
                }

                EditNumberField2Hor(
                    label1 = R.string.field_label_diameter,
                    label2 = R.string.Field_label_height,
                    value1 = inputDiameter,
                    value2 = inputHeight,
                    onValueChange1 = { inputDiameter = it },
                    onValueChange2 = { inputHeight = it }
                )

                InputUnitsDisplay2(
                    textA = R.string.text_amount_length,
                    textB = R.string.text_amount_height,
                    valueA = diameter,
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
                    image = R.drawable.cylinder_calc,
                    contDesc = R.string.text_title_cyl,
                    modifier = Modifier
                        .padding(start = 46.dp)
                )
                
                FormulaString(text =R.string.text_formula_vol_cylinder )
                
                }
            }
        }
    }

@VisibleForTesting
internal fun calculateVolGallonCyl(
    diameter: Double,
    height: Double
): String {
    val radius = 0.5 * diameter
    val volGallons = (PI * radius.pow(2) * height) / 231.0

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(volGallons)
}

@VisibleForTesting
internal fun calculateVolLiterCyl(
    diameter: Double,
    height: Double
): String {
    val radius = 0.5 * diameter
    val volLiters = (PI * radius.pow(2) * height) / 61.0237

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(volLiters)
}

@VisibleForTesting
internal fun calculateWaterWeightCyl(
    diameter: Double,
    height: Double
): String {
    val radius = 0.5 * diameter
    val waterWeight = ((PI * radius.pow(2) * height) / 231.0) * 8.33

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(waterWeight)
}

@VisibleForTesting
internal fun calculateVolGallonFTCyl(
    diameter: Double,
    height: Double
): String {
    val radius = 0.5 * diameter
    val volGallons = (PI * radius.pow(2) * height) / 0.133681

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(volGallons)
}

@VisibleForTesting
internal fun calculateVolLiterFTCyl(
    diameter: Double,
    height: Double
): String {
    val radius = 0.5 * diameter
    val volLiters = (PI * radius.pow(2) * height) / 0.0353147

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(volLiters)
}

@VisibleForTesting
internal fun calculateWaterWeightFTCyl(
    diameter: Double,
    height: Double
): String {
    val radius = 0.5 * diameter
    val waterWeight = ((PI * radius.pow(2) * height) / 0.133681) * 8.33

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(waterWeight)
}

@Preview(showBackground = true)
@Composable
fun CylPreview() {
    AquariumInfoTheme  {
        TankVolCylScreen()
    }
}