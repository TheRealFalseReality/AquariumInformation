package cca.capitalcityaquatics.aquariuminfo.ui.appscreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.LoadFile
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.ui.commonComposables.*

@Preview(showBackground = true)
@Composable
fun InfoScreen(
	modifier: Modifier = Modifier,
) {
	val uriHandler = LocalUriHandler.current

	GeneralCard(verticalArrangement = Arrangement.Top) {
		GeneralComposeHeader(text = R.string.text_title_info)

		Spacer(modifier = Modifier.height(16.dp))

		LoadFile(
			file = "Info.txt",
			textAlign = TextAlign.Center
		)

		Spacer(modifier = Modifier.height(16.dp))

		ReviewApp()

		Spacer(modifier = Modifier.height(16.dp))

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