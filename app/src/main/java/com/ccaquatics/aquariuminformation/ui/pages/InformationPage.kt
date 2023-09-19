package com.ccaquatics.aquariuminformation.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.ccaquatics.aquariuminformation.R
import com.ccaquatics.aquariuminformation.data.appInformationData
import com.ccaquatics.aquariuminformation.data.appVersionData
import com.ccaquatics.aquariuminformation.data.contactData
import com.ccaquatics.aquariuminformation.data.emailData
import com.ccaquatics.aquariuminformation.data.errorData
import com.ccaquatics.aquariuminformation.data.informationData
import com.ccaquatics.aquariuminformation.data.informationHeaderData
import com.ccaquatics.aquariuminformation.data.websiteData
import com.ccaquatics.aquariuminformation.navigation.Information
import com.ccaquatics.aquariuminformation.ui.commonui.BodyTextCard
import com.ccaquatics.aquariuminformation.ui.commonui.HeaderTextCard
import com.ccaquatics.aquariuminformation.ui.commonui.IconTextRow
import com.ccaquatics.aquariuminformation.ui.commonui.PageView
import com.ccaquatics.aquariuminformation.ui.commonui.SingleWideCard
import com.ccaquatics.aquariuminformation.ui.commonui.TextRow
import com.ccaquatics.aquariuminformation.ui.commonui.TitleWideCard
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme

@Composable
fun InfoPage() {
	PageView {
		InfoLayout()
	}
}

@Composable
fun InfoLayout(
	modifier: Modifier = Modifier,
) {
	Column(
		modifier = modifier.fillMaxHeight(),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.SpaceBetween
	) {
		TitleWideCard(
			text = Information.title,
			icon = Information.icon
		) {
			SingleWideCard {
				BodyTextCard(text = informationHeaderData.text)
				Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_verySmall)))
				BodyTextCard(text = informationData.text)
			}
		}
		TitleWideCard(
			text = errorData.title,
			icon = errorData.icon,
		) {
			SingleWideCard {
				BodyTextCard(
					text = errorData.text,
				)
			}
		}
		TitleWideCard(
			text = contactData.title,
			icon = contactData.icon,
		) {
			SingleWideCard {
				IconTextRow(
					icon = emailData.icon,
					text = emailData.title,
				)
				IconTextRow(
					icon = websiteData.icon,
					text = websiteData.title,
				)
			}
		}
		TitleWideCard(
			text = appInformationData.title,
			icon = appInformationData.icon,
		) {
			SingleWideCard {
				HeaderTextCard(
					text = appInformationData.title,
				)
				TextRow(
					text1 = appVersionData.title,
					text2 = appVersionData.text,
				)
			}
		}
		Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_verySmall)))
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