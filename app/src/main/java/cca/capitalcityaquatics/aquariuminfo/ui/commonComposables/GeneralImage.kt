package cca.capitalcityaquatics.aquariuminfo.ui.commonComposables

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import cca.capitalcityaquatics.aquariuminfo.ui.converters.AlkalinityScreen
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInfoTheme

@Composable
fun ImageGeneral (
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    @StringRes contDesc: Int,
){
    Image(
        painter = painterResource(id = image),
        contentDescription = stringResource(id = contDesc),
        modifier = modifier
            .fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun Alk3Preview() {
    AquariumInfoTheme {
        AlkalinityScreen()
    }
}