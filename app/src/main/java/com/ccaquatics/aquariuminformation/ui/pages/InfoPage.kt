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
import com.ccaquatics.aquariuminformation.ui.commonui.BodyTextCard
import com.ccaquatics.aquariuminformation.ui.commonui.HeaderTextCard
import com.ccaquatics.aquariuminformation.ui.commonui.IconTextRow
import com.ccaquatics.aquariuminformation.ui.commonui.PageView
import com.ccaquatics.aquariuminformation.ui.commonui.SingleWideCard
import com.ccaquatics.aquariuminformation.ui.commonui.TextRow
import com.ccaquatics.aquariuminformation.ui.commonui.TitleWideCard
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme
import com.example.aquariuminformation.R


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
			icon = R.drawable.ic_info_2
		) {
			SingleWideCard {
				BodyTextCard(text = R.string.text_info_1)
				BodyTextCard(text =  R.string.text_info_2)
				BodyTextCard(text =  R.string.text_app_errors)
			}
		}
		TitleWideCard(
			text = R.string.errors_or_bugs,
			icon = R.drawable.ic_build,
//			color = MaterialTheme.colorScheme.primary
		) {
			SingleWideCard(
//				backgroundCardColor = MaterialTheme.colorScheme.primary,
//				contentColor = MaterialTheme.colorScheme.onPrimary
			) {
				BodyTextCard(
					text =  R.string.text_app_errors,
//					color = MaterialTheme.colorScheme.onPrimary
				)
			}
		}
		TitleWideCard(
			text = R.string.contact,
			icon = R.drawable.ic_person_search,
//			color = MaterialTheme.colorScheme.secondary
		) {
			SingleWideCard {
				IconTextRow(
					icon = R.drawable.ic_mail,
					text = R.string.text_email,
//					textColor = MaterialTheme.colorScheme.secondary,
//					iconTint = MaterialTheme.colorScheme.secondary,
				)
				IconTextRow(
					icon = R.drawable.ic_public,
					text = R.string.text_website,
//					textColor = MaterialTheme.colorScheme.secondary,
//					iconTint = MaterialTheme.colorScheme.secondary,
				)
			}
		}
		TitleWideCard(
			text = R.string.app_information,
			icon = R.drawable.ic_settings_alert,
//			color =  MaterialTheme.colorScheme.tertiary
		) {
			SingleWideCard {
				HeaderTextCard(
					text = R.string.app_name,
//					color = MaterialTheme.colorScheme.tertiary
				)
				TextRow(
					text1 = R.string.app_version,
					text2 = R.string.appVersion,
//					color = MaterialTheme.colorScheme.tertiary
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