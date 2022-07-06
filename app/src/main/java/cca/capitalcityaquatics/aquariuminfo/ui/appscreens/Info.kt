package cca.capitalcityaquatics.aquariuminfo.ui.appscreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.LoadFile
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.ui.common.*

@Preview(showBackground = true)
@Composable
fun InfoScreen(
    modifier: Modifier = Modifier,
) {
    val uriHandler = LocalUriHandler.current

    GeneralCard(verticalArrangement = Arrangement.Top) {
        GeneralComposeHeader(text = R.string.text_title_info)

        Spacer(modifier = Modifier.height(36.dp))

        LoadFile(
            file = "Info.txt",
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(26.dp))

        ContentBorder {
            GeneralComposeFooter(
                modifier = Modifier
                    .fillMaxWidth(),
                text = R.string.text_label_email,
                textAlign = TextAlign.Center,
                style = TextStyle(textDecoration = TextDecoration.None),
                fontWeight = FontWeight.Bold
            )

            GeneralComposeFooter(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        uriHandler.openUri("mailto:AppInfo@CapitalCityAquatics.com")
                    },
                text = R.string.text_email,
                textAlign = TextAlign.Center,
                style = TextStyle(textDecoration = TextDecoration.Underline),
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            GeneralComposeFooter(
                modifier = Modifier
                    .fillMaxWidth(),
                text = R.string.text_label_web,
                textAlign = TextAlign.Center,
                style = TextStyle(textDecoration = TextDecoration.None),
                fontWeight = FontWeight.Bold
            )

            GeneralComposeFooter(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        uriHandler.openUri("https://www.capitalcityaquatics.com/")
                    },
                text = R.string.text_website,
                textAlign = TextAlign.Center,
                style = TextStyle(textDecoration = TextDecoration.Underline),
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            AppInfo()

            Spacer(modifier = Modifier.height(16.dp))

            ChangelogCardContent()
        }
    }
}