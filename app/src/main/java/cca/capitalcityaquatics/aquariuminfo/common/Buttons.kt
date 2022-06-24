package cca.capitalcityaquatics.aquariuminfo.common

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.converters.AlkalinityScreen
import cca.capitalcityaquatics.aquariuminfo.converters.TempScreen
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