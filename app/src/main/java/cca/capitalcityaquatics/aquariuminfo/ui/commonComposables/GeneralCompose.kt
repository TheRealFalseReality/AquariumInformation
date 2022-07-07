package cca.capitalcityaquatics.aquariuminfo.ui.commonComposables

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cca.capitalcityaquatics.aquariuminfo.BuildConfig
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.ui.appscreens.HomeScreen
import cca.capitalcityaquatics.aquariuminfo.ui.converters.TempScreen
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInfoTheme

@Composable
fun GeneralComposeHeader (
    modifier: Modifier = Modifier,
    @StringRes text: Int,
) {
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        text = stringResource(id = text),
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
    @StringRes text: Int,
) {
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        text = stringResource(id = text),
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
    @StringRes text: Int,
    textAlign: TextAlign,
) {
    Text(
        text = stringResource(id = text),
        modifier = modifier,
        textAlign = textAlign,
        style = MaterialTheme.typography.body1
    )
    Spacer(modifier = Modifier.height(12.dp))
}

@Composable
fun GeneralComposeFooter(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    textAlign: TextAlign,
    fontWeight: FontWeight,
    style: TextStyle
){
    Text(
        text = stringResource(id = text),
        modifier = modifier,
        fontSize = 15.sp,
        fontWeight = fontWeight,
        textAlign = textAlign,
        style = style
    )
}

@Composable
fun FormulaString (
    content: @Composable ColumnScope.() -> Unit,
){
    Spacer(
        modifier = Modifier.height(10.dp)
    )
    InfoCardContent(
        icon = painterResource(id = R.drawable.functions_48px),
        title = R.string.text_formula,
        content = content
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