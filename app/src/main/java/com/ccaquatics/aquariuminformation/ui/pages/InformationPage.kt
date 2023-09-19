package com.ccaquatics.aquariuminformation.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import com.ccaquatics.aquariuminformation.data.appInformationDataSource
import com.ccaquatics.aquariuminformation.data.appVersionDataSource
import com.ccaquatics.aquariuminformation.data.contactDataSource
import com.ccaquatics.aquariuminformation.data.emailDataSource
import com.ccaquatics.aquariuminformation.data.errorDataSource
import com.ccaquatics.aquariuminformation.data.informationDataSource
import com.ccaquatics.aquariuminformation.data.informationHeaderDataSource
import com.ccaquatics.aquariuminformation.data.websiteDataSource
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
		modifier = modifier.fillMaxSize(),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.SpaceBetween
	) {
		TitleWideCard(
			text = Information.title,
			icon = Information.icon
		) {
			SingleWideCard {
				BodyTextCard(text = informationHeaderDataSource.text)
				Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_verySmall)))
				BodyTextCard(text = informationDataSource.text)
			}
		}
		TitleWideCard(
			text = errorDataSource.title,
			icon = errorDataSource.icon,
		) {
			SingleWideCard {
				BodyTextCard(
					text = errorDataSource.text,
				)
			}
		}
		TitleWideCard(
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
		TitleWideCard(
			text = appInformationDataSource.title,
			icon = appInformationDataSource.icon,
		) {
			SingleWideCard {
				HeaderTextCard(
					text = appInformationDataSource.title,
				)
				TextRow(
					text1 = appVersionDataSource.title,
					text2 = appVersionDataSource.text,
				)
			}
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