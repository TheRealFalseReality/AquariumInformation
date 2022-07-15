package cca.capitalcityaquatics.aquariuminfo.ui.commonComposables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R

@Composable
fun ReviewApp() {
	ContentBorderClick(
		content = {
			Column(
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				GeneralComposeHeader(text = R.string.text_rate_app)

				Spacer(modifier = Modifier.height(8.dp))

				GeneralComposeFooter(
					text = R.string.text_kindly_review,
					textAlign = TextAlign.Center,
					fontWeight = FontWeight.Normal,
					style = TextStyle.Default
				)

				GeneralComposeFooter(
					text = R.string.text_valuable_review,
					textAlign = TextAlign.Center,
					fontWeight = FontWeight.Normal,
					style = TextStyle.Default
				)
				Spacer(modifier = Modifier.height(8.dp))

				Row {
					repeat(5) {
						Icon(
							painter = painterResource(id = R.drawable.grade_48px),
							contentDescription = null,
							Modifier
								.height(30.dp)
						)
					}
				}
			}
		},
		url = stringResource(id = R.string.url_app)
	)
}