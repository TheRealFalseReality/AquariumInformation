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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.common.*
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInfoTheme
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun TempScreen (
    modifier: Modifier = Modifier,
) {
    var inputTemp by rememberSaveable {
        mutableStateOf("")
    }
    var selected by rememberSaveable {
        mutableStateOf(R.string.button_label_cel)
    }

    val temp = inputTemp.toDoubleOrNull() ?: 0.0
    val celsius = calculateCelsius(temp)
    val kelvinCel = calculateKelvinCel(temp)
    val kelvinFah = calculateKelvinFah(temp)
    val fahrenheit = calculateFahrenheit(temp)

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
                
                GeneralComposeHeader(textHeader = R.string.text_title_temp)
                
                GeneralComposeSubHeader(textHeader = R.string.text_subtitle_temp)

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
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        RadioButton(
                            selected = selected == R.string.button_label_cel,
                            onClick = { selected = R.string.button_label_cel }
                        )
                        RadioButtonText(
                            text = R.string.button_label_cel,
                            modifier = Modifier
                                .weight(1f)
                                .padding(top = 10.dp)
                                .clickable(
                                    onClick = { selected = R.string.button_label_cel }
                                )
                        )
                        RadioButton(
                            selected = selected == R.string.button_label_fah,
                            onClick = { selected = R.string.button_label_fah }
                        )
                        RadioButtonText(
                            text = R.string.button_label_fah,
                            modifier = Modifier
                                .weight(1f)
                                .padding(top = 10.dp)
                                .clickable(
                                    onClick = { selected = R.string.button_label_fah }
                                )
                        )
                    }
                }
                    
                    when (selected){
                        R.string.button_label_cel -> {
                            DataOutputLines4(
                                value = inputTemp,
                                label = R.string.field_label_cel,
                                onValueChange = { inputTemp = it },
                                inputText = R.string.text_amount_celsius,
                                equalsText = R.string.text_equal_to,
                                outputTextA = R.string.text_amount_fah,
                                valueA = fahrenheit,
                                outputTextB =  R.string.text_amount_kelvin,
                                valueB =  kelvinCel
                            )
                        }
                        R.string.button_label_fah -> {

                            DataOutputLines4(
                                value = inputTemp,
                                label = R.string.field_label_fah,
                                onValueChange = { inputTemp = it },
                                inputText = R.string.text_amount_fah,
                                equalsText = R.string.text_equal_to,
                                outputTextA = R.string.text_amount_celsius,
                                valueA = celsius,
                                outputTextB = R.string.text_amount_kelvin,
                                valueB = kelvinFah
                            )
                        }
                    }

                FormulaFieldTemp()

                }
            }
        }
    }

@Composable
fun FormulaFieldTemp (){

    FormulaString(text = R.string.text_formula_fahrenheit)

    FormulaString(text = R.string.text_formula_celsius)

    FormulaString(text = R.string.text_formula_kelvin)

}

@VisibleForTesting
internal fun calculateCelsius(
    temp: Double,
): String{
    val celsius = (temp - 32) * (5.0/9.0)
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(celsius)
}

@VisibleForTesting
internal fun calculateFahrenheit (
    temp: Double
): String {
    val fahrenheit = (temp * (9.0/5.0) + 32)
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(fahrenheit)
}

@VisibleForTesting
internal fun calculateKelvinFah(
    temp: Double,
): String{
    val kelvin = ((temp - 32) * (5.0/9.0)) + 273.15
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(kelvin)
}

@VisibleForTesting
internal fun calculateKelvinCel(
    temp: Double,
): String{
    val kelvin = (temp + 273.15)
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP

    return df.format(kelvin)
}

@Preview(showBackground = true)
@Composable
fun TempPreview() {
    AquariumInfoTheme   {
        TempScreen()
    }
}