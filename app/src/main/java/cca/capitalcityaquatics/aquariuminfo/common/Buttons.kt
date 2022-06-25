package cca.capitalcityaquatics.aquariuminfo.common

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.converters.AlkalinityScreen
import cca.capitalcityaquatics.aquariuminfo.converters.SalScreen
import cca.capitalcityaquatics.aquariuminfo.converters.TempScreen
import cca.capitalcityaquatics.aquariuminfo.tankVolume.TankVolBFScreen
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInfoTheme

@Composable
fun RadioButtonText (
    modifier: Modifier = Modifier,
    @StringRes text: Int,
){
    Text(
        text = stringResource(id = text),
        modifier = modifier
            .padding(top = 2.dp, bottom = 2.dp),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun RadioButtonCardSal (
    @StringRes text1: Int,
    @StringRes text2: Int,
    onClick1: () -> Unit,
    onClick2: () -> Unit,
    selected: Int
){
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
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            RadioButton(
                selected = selected == text1,
                onClick = onClick1,
            )
            Text(
                text = stringResource(id = text1),
                modifier = Modifier
                    .padding(top = 12.dp, end = 25.dp, bottom = 2.dp)
                    .clickable(
                        onClick = onClick1),
                fontWeight = FontWeight.Bold
            )
            RadioButton(
                selected = selected ==text2,
                onClick = onClick2,
                modifier = Modifier
                    .padding(start = 25.dp)
            )
            Text(
                text = stringResource(id = text2),
                modifier = Modifier
                    .padding(top = 12.dp, bottom = 2.dp, end = 4.dp)
                    .clickable(
                        onClick = onClick2),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun RadioButtonCard3 (
    @StringRes text1: Int,
    @StringRes text2: Int,
    @StringRes text3: Int,
    onClick1: () -> Unit,
    onClick2: () -> Unit,
    onClick3: () -> Unit,
    selected: Int
){
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
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            RadioButton(
                selected = selected == text1,
                onClick = onClick1,
                modifier = Modifier
                    .weight(1f)
            )
            Text(
                text = stringResource(id = text1),
                modifier = Modifier
                    .padding(top = 12.dp, end = 25.dp, bottom = 2.dp)
                    .clickable(
                        onClick = onClick1),
                fontWeight = FontWeight.Bold
            )
            RadioButton(
                selected = selected ==text2,
                onClick = onClick2,
                modifier = Modifier
                    .weight(1f)
            )
            Text(
                text = stringResource(id = text2),
                modifier = Modifier
                    .padding(top = 12.dp, bottom = 2.dp)
                    .weight(1f)
                    .clickable(
                        onClick = onClick2),
                fontWeight = FontWeight.Bold
            )
            RadioButton(
                selected = selected ==text3,
                onClick = onClick2,
                modifier = Modifier
                    .weight(1f)
            )
            Text(
                text = stringResource(id = text3),
                modifier = Modifier
                    .padding(top = 12.dp, bottom = 2.dp, end = 10.dp)
                    .clickable(
                        onClick = onClick3),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun RadioButtonCardTemp (
    @StringRes text1: Int,
    @StringRes text2: Int,
    onClick1: () -> Unit,
    onClick2: () -> Unit,
    selected: Int,

){
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
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            RadioButton(
                selected = selected == text1,
                onClick = onClick1,
            )
            Text(
                text = stringResource(id = text1),
                modifier = Modifier
                    .padding(top = 12.dp, bottom = 2.dp)
                    .clickable(
                        onClick = onClick1
                    ),
                fontWeight = FontWeight.Bold
            )
            RadioButton(
                selected = selected ==text2,
                onClick = onClick2,
                modifier = Modifier
                    .padding(start = 30.dp)
            )
            Text(
                text = stringResource(id = text2),
                modifier = Modifier
                    .padding(top = 12.dp, bottom = 2.dp, end = 4.dp)
                    .clickable(
                        onClick = onClick2
                    ),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun RadioButtonCardTankVol (
    onClick1: () -> Unit,
    onClick2: () -> Unit,
    selected: Int,
){
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
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            RadioButton(
                selected = selected == R.string.button_label_inches,
                onClick = onClick1,
            )
            Text(
                text = stringResource(id = R.string.button_label_inches),
                modifier = Modifier
                    .padding(top = 12.dp, bottom = 2.dp, end = 20.dp)
                    .clickable(
                        onClick = onClick1
                    ),
                fontWeight = FontWeight.Bold
            )
            RadioButton(
                selected = selected == R.string.button_label_feet,
                onClick = onClick2,
                modifier = Modifier
                    .padding(start = 20.dp)
            )
            Text(
                text = stringResource(id = R.string.button_label_feet),
                modifier = Modifier
                    .padding(top = 12.dp, bottom = 2.dp, end = 4.dp)
                    .clickable(
                        onClick = onClick2
                    ),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SalPreview6() {
    AquariumInfoTheme  {
        SalScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun TempPreview2() {
    AquariumInfoTheme   {
        TempScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun Alk2Preview() {
    AquariumInfoTheme {
        AlkalinityScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun BFPreview5() {
    AquariumInfoTheme  {
        TankVolBFScreen()
    }
}