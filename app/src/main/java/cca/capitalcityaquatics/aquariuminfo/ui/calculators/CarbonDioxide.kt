package cca.capitalcityaquatics.aquariuminfo.ui.calculators

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.ui.advert.BannerAd
import cca.capitalcityaquatics.aquariuminfo.ui.commonComposables.*
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow

@Preview(showBackground = true)
@Composable
fun CarbonDioxideScreen () {
    var inputPH by rememberSaveable {
        mutableStateOf("")
    }
    var inputDKH by rememberSaveable {
        mutableStateOf("")
    }

    val ph = inputPH.toDoubleOrNull() ?: 0.0
    val dkh = inputDKH.toDoubleOrNull() ?: 0.0
    val co2 = calculateCarbonDioxide(ph , dkh).toDoubleOrNull() ?: 0.0

    GeneralCard(verticalArrangement = Arrangement.Top) {
        GeneralComposeHeader(text = R.string.text_title_co2)

        GeneralComposeSubHeader(text = R.string.text_subtitle_co2)

        RadioButtonCard {
            Text(
                text = stringResource(id = R.string.text_co2_units),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 20.dp)
            )
        }



        DataOutputLines3Inputs2(
            value1 = inputPH,
            label1 = R.string.field_label_ph,
            onValueChange1 = { inputPH = it },
            value2 = inputDKH,
            label2 = R.string.field_label_dkh,
            onValueChange2 = { inputDKH = it },
            inputText = R.string.text_amount_ph_dkh,
            equalsText = R.string.text_equal_to,
            outputTextA = R.string.text_amount_co2,
            valueA = co2
        )
        Spacer(modifier = Modifier.height(8.dp))
        BannerAd()
    }
}

@VisibleForTesting
internal fun calculateCarbonDioxide (
    pH: Double,
    dKH: Double
): String {
    val phSolution = 10.toDouble().pow(6.37 - pH)
    val carbonDioxide = (12.839 * dKH) * phSolution

    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(carbonDioxide)
}

//@Preview(showBackground = true)
//@Composable
//fun TempPreview() {
//    AquariumInfoTheme  {
//        CarbonDioxideScreen()
//    }
//}