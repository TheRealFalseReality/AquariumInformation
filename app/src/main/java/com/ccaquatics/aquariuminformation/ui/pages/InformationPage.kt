package com.ccaquatics.aquariuminformation.ui.pages

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.ccaquatics.aquariuminformation.R
import com.ccaquatics.aquariuminformation.data.appInformationDataSource
import com.ccaquatics.aquariuminformation.data.contactDataSource
import com.ccaquatics.aquariuminformation.data.emailDataSource
import com.ccaquatics.aquariuminformation.data.errorDataSource
import com.ccaquatics.aquariuminformation.data.informationHeaderDataSource
import com.ccaquatics.aquariuminformation.data.shareDataSource
import com.ccaquatics.aquariuminformation.data.websiteDataSource
import com.ccaquatics.aquariuminformation.navigation.Information
import com.ccaquatics.aquariuminformation.ui.commonui.AppVersion
import com.ccaquatics.aquariuminformation.ui.commonui.BodyText
import com.ccaquatics.aquariuminformation.ui.commonui.IconTextRow
import com.ccaquatics.aquariuminformation.ui.commonui.PageView
import com.ccaquatics.aquariuminformation.ui.commonui.SingleWideCard
import com.ccaquatics.aquariuminformation.ui.commonui.SmallSpacer
import com.ccaquatics.aquariuminformation.ui.commonui.TitleWideContent
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme

@Composable
fun InfoPage() {
	PageView {
		InfoLayout()
	}
}

// TODO Add Changelog
@Composable
fun InfoLayout(
	text: String = stringResource(id = R.string.url_app),
	shareDialogTitle: String = stringResource(R.string.share),
) {
	val uriHandler = LocalUriHandler.current
	val emailURL = stringResource(id = R.string.url_email)
	val websiteURL = stringResource(id = R.string.url_website)
	val appURL = stringResource(id = R.string.url_app)
	val context = LocalContext.current

	TitleWideContent(
		text = Information.title,
		icon = Information.icon
	) {
		SingleWideCard {
			BodyText(text = informationHeaderDataSource.text)
//			VerySmallSpacer()
//			BodyText(text = informationDataSource.text)
		}
	}
	SmallSpacer()
	TitleWideContent(
		text = errorDataSource.title,
		icon = errorDataSource.icon,
	) {
		SingleWideCard {
			BodyText(
				modifier = Modifier
					.clickable { uriHandler.openUri(emailURL) },
				text = errorDataSource.text
			)
		}
	}
	SmallSpacer()
	TitleWideContent(
		text = contactDataSource.title,
		icon = contactDataSource.icon,
	) {
		SingleWideCard {
			IconTextRow(
				modifier = Modifier
//					.padding(vertical = dimensionResource(id = R.dimen.padding_verySmall))
					.clickable { uriHandler.openUri(emailURL) },
				icon = emailDataSource.icon,
				text = emailDataSource.title,
				textDecoration = TextDecoration.Underline,
				fontWeight = FontWeight.Bold
			)
			IconTextRow(
				modifier = Modifier
//					.padding(vertical = dimensionResource(id = R.dimen.padding_verySmall))
					.clickable { uriHandler.openUri(websiteURL) },
				icon = websiteDataSource.icon,
				text = websiteDataSource.title,
				textDecoration = TextDecoration.Underline,
				fontWeight = FontWeight.Bold
			)
			IconTextRow(
				modifier = Modifier
//					.padding(vertical = dimensionResource(id = R.dimen.padding_verySmall))
					.clickable {
						val shareIntent = Intent(Intent.ACTION_SEND)
						shareIntent.type = "text/plain"
						shareIntent.putExtra(Intent.EXTRA_TEXT, text)
						context.startActivity(Intent.createChooser(shareIntent, shareDialogTitle))
					},
				icon = shareDataSource.icon,
				text = shareDataSource.text,
				textDecoration = TextDecoration.Underline,
				fontWeight = FontWeight.Bold
			)
		}
	}
	SmallSpacer()
//	ShareAppButton()
//	SearchBar()
//	SmallSpacer()
	TitleWideContent(
		text = appInformationDataSource.title,
		icon = appInformationDataSource.icon,
	) {
		SingleWideCard(
			modifier = Modifier
				.clickable { uriHandler.openUri(appURL) },
		) {
//			HeaderText(
//				text = appInformationDataSource.title,
//				textDecoration = TextDecoration.Underline
//			)
//			SmallSpacer()
			Row(
				verticalAlignment = Alignment.CenterVertically
			) {
				AppVersion(modifier = Modifier.weight(8f))
				Icon(
					modifier = Modifier.weight(1f),
					painter = painterResource(id = R.drawable.ic_open_new),
					contentDescription = null
				)
			}
		}
	}
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(onSearch: (String) -> Unit) {
	var text by remember { mutableStateOf("") }
	val keyboardController = LocalSoftwareKeyboardController.current
	val focusManager = LocalFocusManager.current

	TextField(
		value = text,
		onValueChange = { text = it },
		label = { Text("Search") },
		leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
		modifier = Modifier.fillMaxWidth(),
		keyboardActions = KeyboardActions(onSearch = {
			onSearch(text)
			// Hide the keyboard after submitting the search
			keyboardController?.hide()
			//or hide keyboard
			focusManager.clearFocus()

		})
	)
}

//@Composable
//fun ShareAppButton(
//	modifier: Modifier = Modifier,
//	text: String = stringResource(id = R.string.url_app),
//	shareDialogText: String = stringResource(R.string.share_this_app),
//	shareDialogTitle: String = stringResource(R.string.share),
//) {
//	val context = LocalContext.current
//
//	IconButton(
//		modifier = modifier,
//		onClick = {
//			val shareIntent = Intent(Intent.ACTION_SEND)
//			shareIntent.type = "text/plain"
//			shareIntent.putExtra(Intent.EXTRA_TEXT, text)
//			context.startActivity(Intent.createChooser(shareIntent, shareDialogTitle))
//		}
//	) {
//		Icon(
//			imageVector = Icons.Filled.Share,
//			contentDescription = shareDialogText,
//		)
//	}
//}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun InfoPreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.fillMaxSize()
				.background(color = MaterialTheme.colorScheme.surface)
		) {
			InfoPage()
		}
	}
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun InfoPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.fillMaxSize()
				.background(color = MaterialTheme.colorScheme.surface)
		) {
			InfoPage()
		}
	}
}