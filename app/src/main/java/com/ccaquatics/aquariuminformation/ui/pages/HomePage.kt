package com.ccaquatics.aquariuminformation.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.ccaquatics.aquariuminformation.R
import com.ccaquatics.aquariuminformation.data.homeCompatibilityData
import com.ccaquatics.aquariuminformation.data.homeHeaderData
import com.ccaquatics.aquariuminformation.data.homeNavigateData
import com.ccaquatics.aquariuminformation.navigation.Home
import com.ccaquatics.aquariuminformation.ui.commonui.BodyTextCard
import com.ccaquatics.aquariuminformation.ui.commonui.PageView
import com.ccaquatics.aquariuminformation.ui.commonui.PopOutCard
import com.ccaquatics.aquariuminformation.ui.commonui.PopOutlinedCard
import com.ccaquatics.aquariuminformation.ui.commonui.SingleWideCard
import com.ccaquatics.aquariuminformation.ui.commonui.TitleWideCard
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme

@Composable
fun HomePage() {
	PageView {
		HomeLayout()
	}
}

@Composable
fun HomeLayout(
	modifier: Modifier = Modifier,
) {
	Column(
		modifier = modifier.fillMaxHeight(),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.SpaceBetween
	) {
		TitleWideCard(
			text = Home.title,
			icon = Home.icon
		) {
			SingleWideCard {
				BodyTextCard(text = homeHeaderData.text)
			}
		}
		PopOutCard(
			icon = homeCompatibilityData.icon,
			title = homeCompatibilityData.title,
			body = homeCompatibilityData.text
		)
		PopOutlinedCard(
			text = homeNavigateData.text
		)
		Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_verySmall)))
	}
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