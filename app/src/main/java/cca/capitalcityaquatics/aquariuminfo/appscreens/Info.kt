package cca.capitalcityaquatics.aquariuminfo.appscreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInfoTheme
import cca.capitalcityaquatics.aquariuminfo.common.AppInfo
import cca.capitalcityaquatics.aquariuminfo.common.GeneralComposeBody
import cca.capitalcityaquatics.aquariuminfo.common.GeneralComposeFooter
import cca.capitalcityaquatics.aquariuminfo.common.GeneralComposeHeader
import cca.capitalcityaquatics.aquariuminfo.R

@Composable
fun InfoScreen(
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier
            .padding(start = 24.dp, end = 24.dp, top = 24.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Card(
            backgroundColor = MaterialTheme.colors.primary,
            modifier = Modifier
                .padding(bottom = 86.dp)
                .fillMaxHeight()
                .fillMaxWidth()
                .border(
                    BorderStroke(2.dp, MaterialTheme.colors.primaryVariant),
                    shape = RoundedCornerShape(4.dp)
                )
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .padding(14.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                
                GeneralComposeHeader(textHeader = R.string.text_title_info)

                GeneralComposeBody(
                    textBody = R.string.text_body_info,
                    textAlign = TextAlign.Center
                )

                GeneralComposeBody(
                    textBody = R.string.text_info_body_errors,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(26.dp))
                
                GeneralComposeFooter(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textFooter = R.string.text_label_email,
                    textAlign = TextAlign.Center,
                    style = TextStyle(textDecoration = TextDecoration.None),
                    fontWeight = FontWeight.Bold
                )
                
                GeneralComposeFooter(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textFooter = R.string.text_email,
                    textAlign = TextAlign.Center,
                    style = TextStyle(textDecoration = TextDecoration.Underline),
                    fontWeight = FontWeight.Bold
                )
                
                Spacer(modifier = Modifier.height(16.dp))

                GeneralComposeFooter(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textFooter = R.string.text_label_web,
                    textAlign = TextAlign.Center,
                    style = TextStyle(textDecoration = TextDecoration.None),
                    fontWeight = FontWeight.Bold
                    )

                GeneralComposeFooter(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textFooter = R.string.text_website,
                    textAlign = TextAlign.Center,
                    style = TextStyle(textDecoration = TextDecoration.Underline),
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(24.dp))

                AppInfo()

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InfoPreview() {
    AquariumInfoTheme {
        InfoScreen()
    }
}