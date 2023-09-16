package com.example.aquariuminformation.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.aquariuminformation.R
import com.example.aquariuminformation.ui.commonui.BodyTextCard
import com.example.aquariuminformation.ui.commonui.HeaderTextCard
import com.example.aquariuminformation.ui.commonui.IconTextRow
import com.example.aquariuminformation.ui.commonui.PageView
import com.example.aquariuminformation.ui.commonui.SingleWideCard
import com.example.aquariuminformation.ui.commonui.TextRow
import com.example.aquariuminformation.ui.commonui.TitleWideCard
import com.example.aquariuminformation.ui.theme.AquariumInformationTheme


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
		modifier = modifier,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		TitleWideCard(
			text = stringResource(id = R.string.text_title_info),
			icon = painterResource(id = R.drawable.baseline_info_24)
		) {
			SingleWideCard {
				BodyTextCard(text = stringResource(id = R.string.text_info_1))
				BodyTextCard(text = stringResource(id = R.string.text_info_2))
				BodyTextCard(text = stringResource(id = R.string.text_app_errors))
			}
		}
		TitleWideCard(
			text = stringResource(R.string.errors_or_bugs),
			icon = painterResource(id = R.drawable.baseline_build_24)
		) {
			SingleWideCard(
				backgroundCardColor = MaterialTheme.colorScheme.primary,
				contentColor = MaterialTheme.colorScheme.onPrimary
			) {
				BodyTextCard(text = stringResource(id = R.string.text_app_errors))
			}
		}
		TitleWideCard(
			text = stringResource(R.string.contact),
			icon = painterResource(id = R.drawable.baseline_person_search_24)
		) {
			SingleWideCard {
				IconTextRow(
					icon = painterResource(id = R.drawable.baseline_email_24),
					text = stringResource(id = R.string.text_email)
				)
				IconTextRow(
					icon = painterResource(id = R.drawable.baseline_web_24),
					text = stringResource(id = R.string.text_website)
				)
			}
		}
		TitleWideCard(
			text = stringResource(R.string.app_information),
			icon = painterResource(id = R.drawable.baseline_settings_suggest_24),
		) {
			SingleWideCard {
				HeaderTextCard(text = stringResource(id = R.string.app_name))
				TextRow(
					text1 = stringResource(id = R.string.app_version),
					text2 = stringResource(id = R.string.appVersion)
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