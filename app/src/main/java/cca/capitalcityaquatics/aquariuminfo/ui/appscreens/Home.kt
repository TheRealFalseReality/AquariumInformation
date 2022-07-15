package cca.capitalcityaquatics.aquariuminfo.ui.appscreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.ui.commonComposables.*
import cca.capitalcityaquatics.aquariuminfo.ui.misc.LoadFile
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AppTheme


@Composable
fun HomeScreen(
) {
	GeneralCard(verticalArrangement = Arrangement.Top) {

		GeneralComposeHeader(text = R.string.text_title_welcome)

		Spacer(modifier = Modifier.height(16.dp))

		LoadFile(
			file = "Welcome.txt",
			textAlign = TextAlign.Center
		)
		Spacer(modifier = Modifier.height(16.dp))

		ReviewApp()

		Spacer(modifier = Modifier.height(16.dp))

		ContentBorder {
			AppInfo()

			Spacer(modifier = Modifier.height(8.dp))

			ChangelogCardContent()
		}
	}
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
	AppTheme {
		HomeScreen()
	}
}