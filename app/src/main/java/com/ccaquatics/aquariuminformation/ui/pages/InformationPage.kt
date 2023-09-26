package com.ccaquatics.aquariuminformation.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ccaquatics.aquariuminformation.data.appInformationDataSource
import com.ccaquatics.aquariuminformation.data.contactDataSource
import com.ccaquatics.aquariuminformation.data.emailDataSource
import com.ccaquatics.aquariuminformation.data.errorDataSource
import com.ccaquatics.aquariuminformation.data.informationDataSource
import com.ccaquatics.aquariuminformation.data.informationHeaderDataSource
import com.ccaquatics.aquariuminformation.data.websiteDataSource
import com.ccaquatics.aquariuminformation.navigation.Information
import com.ccaquatics.aquariuminformation.ui.commonui.AppVersion
import com.ccaquatics.aquariuminformation.ui.commonui.BodyText
import com.ccaquatics.aquariuminformation.ui.commonui.HeaderText
import com.ccaquatics.aquariuminformation.ui.commonui.IconTextRow
import com.ccaquatics.aquariuminformation.ui.commonui.PageView
import com.ccaquatics.aquariuminformation.ui.commonui.SingleWideCard
import com.ccaquatics.aquariuminformation.ui.commonui.SmallSpacer
import com.ccaquatics.aquariuminformation.ui.commonui.TitleWideContent
import com.ccaquatics.aquariuminformation.ui.commonui.VerySmallSpacer
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme

@Composable
fun InfoPage() {
	PageView {
		InfoLayout()
	}
}

// TODO Add Changelog and URLs
@Composable
fun InfoLayout() {
	TitleWideContent(
		text = Information.title,
		icon = Information.icon
	) {
		SingleWideCard {
			BodyText(text = informationHeaderDataSource.text)
			VerySmallSpacer()
			BodyText(text = informationDataSource.text)
		}
	}
	SmallSpacer()
	TitleWideContent(
		text = errorDataSource.title,
		icon = errorDataSource.icon,
	) {
		SingleWideCard {
			BodyText(
				text = errorDataSource.text,
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
				icon = emailDataSource.icon,
				text = emailDataSource.title,
			)
			IconTextRow(
				icon = websiteDataSource.icon,
				text = websiteDataSource.title,
			)
		}
	}
	SmallSpacer()
	TitleWideContent(
		text = appInformationDataSource.title,
		icon = appInformationDataSource.icon,
	) {
		SingleWideCard {
			HeaderText(
				text = appInformationDataSource.title,
			)
			AppVersion()
		}
	}

}

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