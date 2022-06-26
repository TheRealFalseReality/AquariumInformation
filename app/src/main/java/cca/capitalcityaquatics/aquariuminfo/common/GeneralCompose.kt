package cca.capitalcityaquatics.aquariuminfo.common

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import cca.capitalcityaquatics.aquariuminfo.appscreens.HomeScreen
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

        style = MaterialTheme.typography.h4.copy(
            fontWeight = FontWeight.ExtraBold
        )
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
        style = MaterialTheme.typography.h5.copy(
            fontWeight = FontWeight.Bold
        )
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
        textAlign = textAlign,
        style = MaterialTheme.typography.body1
    )
    Spacer(modifier = Modifier.height(12.dp))
}

@Composable
fun GeneralComposeBody2 (
    modifier: Modifier = Modifier,
    @StringRes textBody: Int,
) {
    Text(
        text = stringResource(id = textBody),
        modifier = modifier,
    )
    Spacer(modifier = Modifier.height(12.dp))
}

@Composable
fun GeneralComposeHeader2 (
    modifier: Modifier = Modifier,
    @StringRes textHeader: Int,
) {

    Text(
        text = stringResource(id = textHeader),
        modifier = modifier,
        style = MaterialTheme.typography.h6.copy(
            fontWeight = FontWeight.Bold
        )
    )
    Spacer(modifier = Modifier.height(4.dp))
}

@Composable
fun GeneralComposeTitleCard (
    modifier: Modifier = Modifier,
    @StringRes textBody: Int,
) {
    Text(
        text = stringResource(id = textBody),
        modifier = modifier,
        style = MaterialTheme.typography.body2.copy(
            fontWeight = FontWeight.ExtraBold),
    )

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
fun FormulaString (
    @StringRes text: Int,
){
    Spacer(
        modifier = Modifier.height(10.dp)
    )
    InfoCardContent(
        title = R.string.text_formula,
        textBody = text
    )

    Spacer(modifier = Modifier.height(2.dp))

}

@Composable
fun AppInfo (
){
    val version = BuildConfig.VERSION_NAME

    Row (
        horizontalArrangement = Arrangement.Center,
            ){
        Text(
            text = stringResource(id = R.string.text_label_version, version),
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

@Preview(showBackground = true)
@Composable
fun HomePreview6() {
    AquariumInfoTheme {
        HomeScreen()
    }
}