package cca.capitalcityaquatics.aquariuminfo.common

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

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