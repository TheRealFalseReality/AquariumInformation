package cca.capitalcityaquatics.aquariuminfo.common

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cca.capitalcityaquatics.aquariuminfo.converters.TempScreen
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInfoTheme

//Alkalinity
@Composable
fun DataOutputLines4 (
    value: String,
    @StringRes label: Int,
    onValueChange: (String) -> Unit,
    @StringRes inputText: Int,
    @StringRes equalsText: Int,
    @StringRes outputTextA: Int,
    valueA: String,
    @StringRes outputTextB: Int,
    valueB: String
){
    Column {
        EditNumberFieldSingle(
            label = label,
            value = value,
            onValueChange = onValueChange
        )
        Text(
            text = (stringResource(id =  inputText, value)),
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
            text = stringResource(id = equalsText),
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
        )
        Spacer(
            modifier = Modifier
                .height(16.dp)
        )
        Text(
            text = stringResource(id = outputTextA, valueA),
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
            text = stringResource(id = outputTextB, valueB),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.CenterHorizontally),
            fontSize = 18.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TempPreview3() {
    AquariumInfoTheme   {
        TempScreen()
    }
}