package com.ccaquatics.aquariuminformation.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ccaquatics.aquariuminformation.R
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
			text = R.string.about,
			icon = R.drawable.ic_home
		) {
			SingleWideCard {
				BodyTextCard(text = R.string.text_welcome)
			}
		}
		HomeScreen()
		PopOutCard(
			icon = R.drawable.ic_new_releases,
			headerText = R.string.text_welcome_compatibility_title,
			bodyText = R.string.text_welcome_compatibility_2
		)
		PopOutlinedCard(
			text = R.string.tap_below_to_navigate
		)
		Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_verySmall)))
	}
}

@Composable
fun HomeScreen(
	home: Home = Home
) {

	Column {
		Icon(
			painter = painterResource(id = home.icon),
			contentDescription = stringResource(id = home.title),
			modifier = Modifier.padding(16.dp)
		)

		Text(
			text = stringResource(id = home.title),
			style = MaterialTheme.typography.headlineMedium,
			modifier = Modifier.padding(16.dp)
		)
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