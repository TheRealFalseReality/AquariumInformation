package com.example.aquariuminformation.ui.pages

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
		modifier = modifier.fillMaxHeight(),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.SpaceBetween
	) {
		TitleWideCard(
			text = R.string.text_title_info,
			icon = R.drawable.baseline_info_24
		) {
			SingleWideCard {
				BodyTextCard(text = R.string.text_info_1)
				BodyTextCard(text =  R.string.text_info_2)
				BodyTextCard(text =  R.string.text_app_errors)
			}
		}
		TitleWideCard(
			text = R.string.errors_or_bugs,
			icon = R.drawable.baseline_build_24,
			color = MaterialTheme.colorScheme.primary
		) {
			SingleWideCard(
				backgroundCardColor = MaterialTheme.colorScheme.primary,
				contentColor = MaterialTheme.colorScheme.onPrimary
			) {
				BodyTextCard(
					text =  R.string.text_app_errors,
					color = MaterialTheme.colorScheme.onPrimary
				)
			}
		}
		TitleWideCard(
			text = R.string.contact,
			icon = R.drawable.baseline_person_search_24,
			color = MaterialTheme.colorScheme.secondary
		) {
			SingleWideCard {
				IconTextRow(
					icon = R.drawable.baseline_email_24,
					text = R.string.text_email,
					textColor = MaterialTheme.colorScheme.secondary,
					iconTint = MaterialTheme.colorScheme.secondary,
				)
				IconTextRow(
					icon = R.drawable.baseline_web_24,
					text = R.string.text_website,
					textColor = MaterialTheme.colorScheme.secondary,
					iconTint = MaterialTheme.colorScheme.secondary,
				)
			}
		}
		TitleWideCard(
			text = R.string.app_information,
			icon = R.drawable.baseline_settings_suggest_24,
			color =  MaterialTheme.colorScheme.tertiary
		) {
			SingleWideCard {
				HeaderTextCard(
					text = R.string.app_name,
					color = MaterialTheme.colorScheme.tertiary
				)
				TextRow(
					text1 = R.string.app_version,
					text2 = R.string.appVersion,
					color = MaterialTheme.colorScheme.tertiary
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