package cca.capitalcityaquatics.aquariuminfo.calculators

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
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
import cca.capitalcityaquatics.aquariuminfo.common.EditNumberField2Vert
import cca.capitalcityaquatics.aquariuminfo.common.GeneralComposeHeader
import cca.capitalcityaquatics.aquariuminfo.common.GeneralComposeSubHeader
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInfoTheme

@Composable
fun CarbonDioxideScreen (
    modifier: Modifier = Modifier,
) {
    var inputPH by rememberSaveable {
        mutableStateOf("")
    }
    var inputDKH by rememberSaveable {
        mutableStateOf("")
    }

    val ph = inputPH.toDoubleOrNull() ?: 0.0
    val dkh = inputDKH.toDoubleOrNull() ?: 0.0
    val co2 = calculateCarbonDioxide(ph , dkh)

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
                
                GeneralComposeHeader(textHeader = R.string.text_title_co2)
                
                GeneralComposeSubHeader(textHeader = R.string.text_subtitle_co2)

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
                    Text(
                        text = stringResource(id = R.string.text_co2_units),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 20.dp, bottom = 20.dp)
                    )
                }
                EditNumberField2Vert(
                    label1 = R.string.field_label_ph,
                    label2 = R.string.button_label_dkh,
                    value1 = inputPH,
                    value2 = inputDKH,
                    onValueChange1 = { inputPH = it },
                    onValueChange2 = { inputDKH = it }
                )
                Text(
                    text = (stringResource(R.string.text_amount_ph_dkh, inputPH, inputDKH)),
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
                    text = stringResource(id = R.string.text_amount_co2, co2),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}

@VisibleForTesting
internal fun calculateCarbonDioxide (
    pH: Double,
    dKH: Double
): String {
    val base = 10
    val exponent = (6.37 - pH)
    val phSolution = base.toDouble().pow(exponent)
    val carbonDioxide = (12.839 * dKH) * phSolution

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(carbonDioxide)
}

@Preview(showBackground = true)
@Composable
fun TempPreview() {
    AquariumInfoTheme  {
        CarbonDioxideScreen()
    }
}
