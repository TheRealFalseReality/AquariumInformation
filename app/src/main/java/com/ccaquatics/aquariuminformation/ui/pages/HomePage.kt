package com.ccaquatics.aquariuminformation.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.ccaquatics.aquariuminformation.R
import com.ccaquatics.aquariuminformation.data.homeCompatibilityDataSource
import com.ccaquatics.aquariuminformation.data.homeHeaderDataSource
import com.ccaquatics.aquariuminformation.data.homeNavigateDataSource
import com.ccaquatics.aquariuminformation.navigation.Home
import com.ccaquatics.aquariuminformation.ui.commonui.BodyText
import com.ccaquatics.aquariuminformation.ui.commonui.PageView
import com.ccaquatics.aquariuminformation.ui.commonui.PopOutCard
import com.ccaquatics.aquariuminformation.ui.commonui.PopOutlinedCard
import com.ccaquatics.aquariuminformation.ui.commonui.SingleWideCard
import com.ccaquatics.aquariuminformation.ui.commonui.SmallSpacer
import com.ccaquatics.aquariuminformation.ui.commonui.TitleWideContent
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme

@Composable
fun HomePage() {
	PageView {
		HomeLayout()
	}
}

@Composable
fun HomeLayout() {
	TitleWideContent(
		text = Home.title,
		icon = Home.icon
	) {
		SingleWideCard {
			BodyText(text = homeHeaderDataSource.text)
		}
	}
	SmallSpacer()
	PopOutCard(
		icon = homeCompatibilityDataSource.icon,
		title = homeCompatibilityDataSource.title,
		body = homeCompatibilityDataSource.text
	)
	SmallSpacer()
	PopOutlinedCard(
		modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_medium)),
		text = homeNavigateDataSource.text
	)
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.surface)
		) {
			HomePage()
		}
	}
}

@Preview(showBackground = true)
@Composable
fun HomePreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.surface)
		) {
			HomePage()
		}
	}
}