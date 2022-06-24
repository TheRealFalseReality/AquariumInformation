package cca.capitalcityaquatics.aquariuminfo.common

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

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