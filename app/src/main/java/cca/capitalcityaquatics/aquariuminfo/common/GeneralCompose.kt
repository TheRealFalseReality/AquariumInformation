package cca.capitalcityaquatics.aquariuminfo.common

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cca.capitalcityaquatics.aquariuminfo.BuildConfig
import cca.capitalcityaquatics.aquariuminfo.R

@Composable
fun GeneralComposeHeader (
    modifier: Modifier = Modifier,
    @StringRes textHeader: Int,
) {
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        text = stringResource(id = textHeader),
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 4.dp, bottom = 4.dp),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 26.sp,
    )
    Spacer(modifier = Modifier.height(12.dp))
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
            .fillMaxWidth()
            .padding(top = 4.dp, bottom = 12.dp),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
    )
    Spacer(modifier = Modifier.height(12.dp))
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
fun FormulaField (
    modifier: Modifier = Modifier,
    @StringRes text: Int,
){
    Spacer(
        modifier = modifier.height(15.dp)
    )
    Text(
        text = stringResource(id = text),
        modifier = Modifier
            .padding(bottom = 16.dp)
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
        modifier = Modifier.height(6.dp)
    )
    Text(
        text = stringResource(id = text),
        modifier = modifier
            .padding(top = 8.dp, bottom = 16.dp)
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