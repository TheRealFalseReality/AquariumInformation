package cca.capitalcityaquatics.aquariuminfo.tankVolume

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.common.*
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInfoTheme
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun TankVolCubeScreen (
    modifier: Modifier = Modifier,
) {
    var inputSide by rememberSaveable {
        mutableStateOf("")
    }

    var selected by rememberSaveable {
        mutableStateOf(R.string.button_label_inches)
    }

    val side = inputSide.toDoubleOrNull() ?: 0.0

    val volGallon = calculateVolGallonCube(side)
    val volLiter = calculateVolLiterCube(side)
    val waterWeight = calculateWaterWeightCube(side)
    val volGallonFT = calculateVolGallonFTCube(side)
    val volLiterFT = calculateVolLiterFTCube(side)
    val waterWeightFT = calculateWaterWeightFTCube(side)

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

                GeneralComposeHeader(textHeader = R.string.text_title_cube)

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

                EditNumberFieldSingle(
                    label = R.string.field_label_side,
                    value = inputSide,
                    onValueChange = { inputSide = it }
                )

                InputUnitsDisplay1(
                    textA = R.string.text_amount_length,
                    valueA = side
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
                    image = R.drawable.cube_calc,
                    contDesc = R.string.text_title_cube,
                    modifier = Modifier
                        .padding(start = 40.dp)
                )

                FormulaString(text = R.string.text_formula_vol_cube)


            }
        }
    }
}

@VisibleForTesting
internal fun calculateVolGallonCube(
    side:Double
): String {
    val volGallons = (side * side * side) / 231.0

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(volGallons)
}

@VisibleForTesting
internal fun calculateVolLiterCube(
    side:Double
): String {
    val volLiters = (side * side * side) / 61.0237

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(volLiters)
}

@VisibleForTesting
internal fun calculateWaterWeightCube(
    side:Double
): String {
    val waterWeight = ((side * side * side) / 231.0) * 8.33

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(waterWeight)
}

@VisibleForTesting
internal fun calculateVolGallonFTCube(
    side:Double
): String {
    val volGallons = (side * side * side) / 0.133681

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(volGallons)
}

@VisibleForTesting
internal fun calculateVolLiterFTCube(
    side:Double
): String {
    val volLiters = (side * side * side) / 0.0353147

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(volLiters)
}

@VisibleForTesting
internal fun calculateWaterWeightFTCube(
    side:Double
): String {
    val waterWeight = ((side * side * side) / 0.133681) * 8.33

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(waterWeight)
}

@Preview(showBackground = true)
@Composable
fun CubePreview() {
    AquariumInfoTheme  {
        TankVolCubeScreen()
    }
}