package com.example.aquariuminformation.ui.pages

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
import com.example.aquariuminformation.R
import com.example.aquariuminformation.ui.commonui.BodyTextCard
import com.example.aquariuminformation.ui.commonui.PageView
import com.example.aquariuminformation.ui.commonui.PopOutCard
import com.example.aquariuminformation.ui.commonui.PopOutlinedCard
import com.example.aquariuminformation.ui.commonui.SingleWideCard
import com.example.aquariuminformation.ui.commonui.TitleWideCard
import com.example.aquariuminformation.ui.theme.AquariumInformationTheme

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
			text = R.string.about,
			icon = R.drawable.baseline_home_24
		) {
			SingleWideCard {
				BodyTextCard(text = R.string.text_welcome)
			}
		}
		PopOutCard(
			icon = R.drawable.baseline_new_releases_24,
			headerText = R.string.text_welcome_compatibility_title,
			bodyText = R.string.text_welcome_compatibility_2
		)
		PopOutlinedCard(
			text = R.string.tap_below_to_navigate
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