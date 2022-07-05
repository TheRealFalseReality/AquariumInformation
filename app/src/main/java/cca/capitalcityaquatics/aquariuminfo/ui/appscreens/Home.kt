package cca.capitalcityaquatics.aquariuminfo.ui.appscreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.LoadFile
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.ui.common.ChangelogCardContent
import cca.capitalcityaquatics.aquariuminfo.ui.common.GeneralCard
import cca.capitalcityaquatics.aquariuminfo.ui.common.GeneralComposeHeader
import cca.capitalcityaquatics.aquariuminfo.ui.common.InfoCardContent

@Preview(showBackground = true)
@Composable
fun HomeScreen (
) {
    GeneralCard(verticalArrangement = Arrangement.Top) {

        GeneralComposeHeader(text = R.string.text_title_welcome )

        Spacer(modifier = Modifier.height(36.dp))

        LoadFile(
            file = "Welcome.txt",
            textAlign = TextAlign.Center
        )


        Spacer(modifier = Modifier.height(26.dp))

        ChangelogCardContent()

        Spacer(modifier = Modifier.height(26.dp))

    }
}