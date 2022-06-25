package cca.capitalcityaquatics.aquariuminfo.common

import androidx.annotation.StringRes
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cca.capitalcityaquatics.aquariuminfo.BuildConfig
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.converters.SalScreen
import cca.capitalcityaquatics.aquariuminfo.converters.TempScreen
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInfoTheme

@Composable
fun GeneralComposeHeader (
    modifier: Modifier = Modifier,
    @StringRes textHeader: Int,
) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = stringResource(id = textHeader),
                    modifier = modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 26.sp,
                )
                Spacer(modifier = Modifier.height(4.dp))
            }

@Composable
fun GeneralComposeSubHeader (
    modifier: Modifier = Modifier,
    @StringRes textHeader: Int,
) {
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        text = stringResource(id = textHeader),
        modifier = modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
    )
    Spacer(modifier = Modifier.height(4.dp))
}

@Composable
fun GeneralComposeBody (
    modifier: Modifier = Modifier,
    @StringRes textBody: Int,
    textAlign: TextAlign,
) {
    Text(
        text = stringResource(id = textBody),
        modifier = modifier,
        fontSize = 18.sp,
        textAlign = textAlign,
    )
    Spacer(modifier = Modifier.height(12.dp))
}

@Composable
fun GeneralComposeFooter(
    modifier: Modifier = Modifier,
    @StringRes textFooter: Int,
    textAlign: TextAlign,
    fontWeight: FontWeight,
    style: TextStyle
){
    Text(
        text = stringResource(id = textFooter),
        modifier = modifier,
        fontSize = 15.sp,
        fontWeight = fontWeight,
        textAlign = textAlign,
        style = style
    )
}

@Composable
fun FormulaStringNT (
    modifier: Modifier = Modifier,
    @StringRes text: Int,
){
    Spacer(
        modifier = Modifier.height(10.dp)
    )
    Text(
        text = stringResource(id = text),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentWidth(),
        fontSize = 16.sp,
    )
}

@Composable
fun FormulaString (
    modifier: Modifier = Modifier,
    @StringRes text: Int,
){
    Spacer(
        modifier = Modifier.height(10.dp)
    )
    Text(
        text = stringResource(R.string.text_formula),
        fontSize = 14.sp,
    )
    Spacer(modifier = Modifier.height(2.dp))
    Text(
        text = stringResource(id = text),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentWidth(),
        fontSize = 16.sp,
    )

}

@Composable
fun AppInfo (
){
    val version = BuildConfig.VERSION_NAME

    Row (
        horizontalArrangement = Arrangement.Center,
            ){
        Text(
            text = stringResource(id = R.string.text_label_version),
        )
        Text(
            text = version,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SalPreview23() {
    AquariumInfoTheme  {
        TempScreen()
    }
}