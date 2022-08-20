package cca.capitalcityaquatics.aquariuminfo.ui.appscreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.ui.commonComposables.*
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AppTheme

@Composable
fun InfoScreen(
	modifier: Modifier = Modifier,
) {
	GeneralCard(verticalArrangement = Arrangement.Top) {
		GeneralComposeHeader(text = R.string.text_title_info)

		Spacer(modifier = Modifier.height(16.dp))

		GeneralComposeBody(text = R.string.text_info_1, textAlign = TextAlign.Center)

		GeneralComposeBody(text = R.string.text_info_2, textAlign = TextAlign.Center)

		GeneralComposeBody(text = R.string.text_app_errors, textAlign = TextAlign.Center)

		UrlClickSmall(
			url = "https://www.capitalcityaquatics.com/photo-attributes",
			urlLabel = R.string.text_photo_attributes
		)


		Spacer(modifier = Modifier.height(16.dp))

		ReviewApp()

		Spacer(modifier = modifier.height(16.dp))

		ContentBorder {

			UrlClickFoot(
				title = R.string.text_label_email,
				url = stringResource(id = R.string.url_email),
				urlLabel = R.string.text_email
			)

			Spacer(modifier = Modifier.height(8.dp))

			UrlClickFoot(
				title = R.string.text_label_web,
				url = stringResource(id = R.string.url_website),
				urlLabel = R.string.text_email,
			)

			Spacer(modifier = Modifier.height(8.dp))

			AppInfo()

			Spacer(modifier = Modifier.height(8.dp))

			ChangelogCardContent()

		}
	}
}

@Preview(showBackground = true)
@Composable
fun InfoView() {
	AppTheme() {
		InfoScreen()
	}
}