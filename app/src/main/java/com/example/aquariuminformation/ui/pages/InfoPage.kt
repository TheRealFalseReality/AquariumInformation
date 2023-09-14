package com.example.aquariuminformation.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.aquariuminformation.R
import com.example.aquariuminformation.ui.commonui.BodyTextCard
import com.example.aquariuminformation.ui.commonui.IconTextRow
import com.example.aquariuminformation.ui.commonui.PageView
import com.example.aquariuminformation.ui.commonui.SingleWideCard
import com.example.aquariuminformation.ui.commonui.TextRow
import com.example.aquariuminformation.ui.commonui.TitleWideCard
import com.example.aquariuminformation.ui.theme.AquariumInformationTheme

@Composable
fun InfoPage(){
	PageView {
		InfoLayout()
	}
}

//@Composable
//fun InfoCards(
//	modifier: Modifier = Modifier
//){
//	Column(modifier = modifier) {
//		LazyColumn(
//			content = {
//				items(infoData) {
//					InfoItem(
//						dataSource = it,
//						modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)),
//					)
//				}
//			}
//		)
//	}
//}

@Composable
fun InfoLayout(
	modifier: Modifier = Modifier,
) {
	Column(
		modifier = modifier,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		TitleWideCard(
			title = stringResource(id = R.string.text_title_info),
			icon = Icons.Filled.Info
		){
			SingleWideCard {
				BodyTextCard(text = stringResource(id = R.string.text_info_1))
				BodyTextCard(text = stringResource(id = R.string.text_info_2))
				BodyTextCard(text = stringResource(id = R.string.text_app_errors))
			}
		}
		TitleWideCard(
			title = stringResource(R.string.errors_or_bugs),
			icon = Icons.Filled.Build
		) {
			SingleWideCard(
				backgroundCardColor = MaterialTheme.colorScheme.primary,
				contentColor = MaterialTheme.colorScheme.onPrimary
			) {
				BodyTextCard(text = stringResource(id = R.string.text_app_errors))
			}
		}
		TitleWideCard(
			title = stringResource(R.string.contact),
			icon = Icons.Filled.Search
		){
			SingleWideCard {
				IconTextRow(
					icon = Icons.Filled.Email,
					text = stringResource(id = R.string.text_email)
				)
				IconTextRow(
					icon = Icons.Filled.AccountCircle,
					text = stringResource(id = R.string.text_website)
				)
			}
		}
		TitleWideCard(
			title = stringResource(R.string.app_information),
			icon = Icons.Filled.Settings
		) {
			SingleWideCard {
				TextRow(
					text1 = stringResource(id = R.string.text_label_version),
					text2 = "2.0"
				)
			}
		}
	}
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun InfoPreview(){
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.fillMaxSize()
				.background(color = MaterialTheme.colorScheme.surface)
		){
			InfoPage()
		}
	}
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun InfoPreviewDark(
){
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.fillMaxSize()
				.background(color = MaterialTheme.colorScheme.surface)
		){
			InfoPage()
		}
	}
}