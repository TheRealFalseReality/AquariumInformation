package cca.capitalcityaquatics.aquariuminfo.converters

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.common.EditNumberFieldSingle
import cca.capitalcityaquatics.aquariuminfo.common.GeneralComposeHeader
import cca.capitalcityaquatics.aquariuminfo.common.GeneralComposeSubHeader
import cca.capitalcityaquatics.aquariuminfo.common.RadioButtonText
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInfoTheme
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun AlkalinityScreen(
    modifier: Modifier = Modifier,
) {
    var inputAlk by rememberSaveable {
        mutableStateOf("")
    }
    var selected by rememberSaveable {
        mutableStateOf(R.string.button_label_dkh)
    }

    val alk = inputAlk.toDoubleOrNull() ?: 0.0
    val ppmDKH = calculatePpmDkh(alk)
    val dkhPPM = calculateDkhPpm(alk)
    val meqDKH = calculateMeqDkh(alk)
    val meqPPM = calculateMeqPpm(alk)
    val ppmMEQ = calculatePpmMeq(alk)
    val dkhMEQ = calculateDkhMeq(alk)

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
                    .padding(14.dp)
            ) {

                GeneralComposeHeader(textHeader = R.string.text_title_alk)

                GeneralComposeSubHeader(textHeader = R.string.text_subtitle_alk)

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
                            selected = selected == R.string.button_label_dkh,
                            onClick = { selected = R.string.button_label_dkh }
                        )
                        RadioButtonText(
                            text = R.string.button_label_dkh,
                            modifier = Modifier
                                .weight(1f)
                                .padding(top = 10.dp)
                                .clickable(
                                    onClick = { selected = R.string.button_label_dkh }
                                )
                        )
                        RadioButton(
                            selected = selected == R.string.button_label_ppm,
                            onClick = { selected = R.string.button_label_ppm }
                        )
                        RadioButtonText(
                            text = R.string.button_label_ppm,
                            modifier = Modifier
                                .weight(1f)
                                .padding(top = 10.dp)
                                .clickable(
                                    onClick = { selected = R.string.button_label_ppm }
                                )
                        )
                        RadioButton(
                            selected = selected == R.string.button_label_meq,
                            onClick = { selected = R.string.button_label_meq }
                        )
                        RadioButtonText(
                            text = R.string.button_label_meq,
                            modifier = Modifier
                                .weight(1f)
                                .padding(top = 10.dp)
                                .clickable(
                                    onClick = { selected = R.string.button_label_meq }
                                )
                        )
                    }
                }

                    when (selected) {
                        R.string.button_label_dkh -> {
                            EditNumberFieldSingle(
                                label = R.string.field_label_dkh,
                                value = inputAlk,
                                onValueChange = { inputAlk = it }
                            )
                            Text(
                                text = (stringResource(R.string.text_amount_dkh, inputAlk)),
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )
                            Spacer(
                                modifier = Modifier
                                    .height(16.dp)
                            )
                            Text(
                                text = stringResource(R.string.text_equal_to),
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally),
                            )
                            Spacer(
                                modifier = Modifier
                                    .height(16.dp)
                            )
                            Text(
                                text = stringResource(id = R.string.text_amount_ppm, ppmDKH),
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )
                            Spacer(
                                modifier = Modifier
                                    .height(16.dp)
                            )
                            Text(
                                text = stringResource(id = R.string.text_amount_meq, meqDKH),
                                modifier = Modifier
                                    .padding(bottom = 16.dp)
                                    .align(Alignment.CenterHorizontally),
                                fontSize = 20.sp,
                            )
                        }
                        R.string.button_label_ppm -> {
                            EditNumberFieldSingle(
                                label = R.string.field_label_ppm,
                                value = inputAlk,
                                onValueChange = { inputAlk = it }
                            )
                            Text(
                                text = (stringResource(R.string.text_amount_ppm, inputAlk)),
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )
                            Spacer(
                                modifier = Modifier
                                    .height(16.dp)
                            )
                            Text(
                                text = stringResource(R.string.text_equal_to),
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally),
                            )
                            Spacer(
                                modifier = Modifier
                                    .height(16.dp)
                            )
                            Text(
                                text = stringResource(id = R.string.text_amount_dkh, dkhPPM),
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )
                            Spacer(
                                modifier = Modifier
                                    .height(16.dp)
                            )
                            Text(
                                text = stringResource(id = R.string.text_amount_meq, meqPPM),
                                modifier = Modifier
                                    .padding(bottom = 16.dp)
                                    .align(Alignment.CenterHorizontally),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                        R.string.button_label_meq -> {
                            EditNumberFieldSingle(
                                label = R.string.field_label_meq,
                                value = inputAlk,
                                onValueChange = { inputAlk = it }
                            )
                            Text(
                                text = (stringResource(R.string.text_amount_meq, inputAlk)),
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )
                            Spacer(
                                modifier = Modifier
                                    .height(16.dp)
                            )
                            Text(
                                text = stringResource(R.string.text_equal_to),
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally),
                            )
                            Spacer(
                                modifier = Modifier
                                    .height(16.dp)
                            )
                            Text(
                                text = stringResource(id = R.string.text_amount_dkh, dkhMEQ),
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )
                            Spacer(
                                modifier = Modifier
                                    .height(16.dp)
                            )
                            Text(
                                text = stringResource(id = R.string.text_amount_ppm, ppmMEQ),
                                modifier = Modifier
                                    .padding(bottom = 16.dp)
                                    .align(Alignment.CenterHorizontally),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                    }

                AlkalinityFormula()

                WaterHardnessChart()

                }
            }
        }
    }


@Composable
fun AlkalinityFormula (){
    Spacer(
        modifier = Modifier.height(16.dp)
    )
    Text(
        text = stringResource(R.string.text_formula_alk),
        modifier = Modifier
            .padding(bottom = 16.dp)
            .fillMaxWidth()
            .wrapContentWidth()
    )
}

@Composable
fun WaterHardnessChart (){
    Spacer(
        modifier = Modifier.height(16.dp)
    )
    Image(
        painter = painterResource(id = R.drawable.screenshot_20220618_122436),
        contentDescription = stringResource(
            R.string.text_water_hardness_chart)
    )
    Spacer(
        modifier = Modifier.height(16.dp)
    )
}

@VisibleForTesting
internal fun calculatePpmDkh(
    alk: Double,
): String{
    val ppmDKH = alk * 17.857
    val df = DecimalFormat("#")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(ppmDKH)
}

@VisibleForTesting
internal fun calculateMeqDkh(
    alk: Double,
): String{
    val meqDKH = alk * 0.357
    val df = DecimalFormat("#.#")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(meqDKH)
}

@VisibleForTesting
internal fun calculateDkhPpm(
    alk: Double,
): String{
    val dkhPPM = alk * 0.056
    val df = DecimalFormat("#.#")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(dkhPPM)
}

@VisibleForTesting
internal fun calculateMeqPpm(
    alk: Double,
): String{
    val meqPPM = alk * 0.02
    val df = DecimalFormat("#.#")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(meqPPM)
}

@VisibleForTesting
internal fun calculatePpmMeq(
    alk: Double,
): String{
    val ppmMEQ = alk * 50
    val df = DecimalFormat("#.#")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(ppmMEQ)
}

@VisibleForTesting
internal fun calculateDkhMeq(
    alk: Double,
): String{
    val dkhMEQ = alk * 2.8
    val df = DecimalFormat("#.#")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(dkhMEQ)
}

@Preview(showBackground = true)
@Composable
fun AlkPreview() {
    AquariumInfoTheme {
        AlkalinityScreen()
    }
}