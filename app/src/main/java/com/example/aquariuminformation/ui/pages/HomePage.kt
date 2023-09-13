package com.example.aquariuminformation.ui.pages

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.aquariuminformation.R
import com.example.aquariuminformation.data.Home
import com.example.aquariuminformation.data.homeData
import com.example.aquariuminformation.ui.commonui.CardBodyText
import com.example.aquariuminformation.ui.commonui.HeaderTextLarge
import com.example.aquariuminformation.ui.commonui.SingleWideCard
import com.example.aquariuminformation.ui.theme.AquariumInformationTheme

@Composable
fun HomePage(){
	HomeCards()
}

@Composable
fun HomeCards(
	modifier: Modifier = Modifier
){
	Column(modifier = modifier) {
		LazyColumn(content = {
			items(homeData) {
				HomeItem(
					home = it,
					modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)),
				)
			}
		})
	}
}


@Composable
fun HomeItem(
	modifier: Modifier = Modifier,
	home: Home
) {
	Column(modifier = modifier) {
		HomeInfo(homeTitle = home.title, homeBody = home.body)
	}
}

@Composable
fun HomeInfo(
	modifier: Modifier = Modifier,
	@StringRes homeTitle: Int,
	@StringRes homeBody: Int,
){
	Column(
		modifier = modifier
	) {
		HeaderTextLarge(
			text = stringResource(homeTitle),
			color = MaterialTheme.colorScheme.onSurface,
		)
		SingleWideCard(
			content = {
				CardBodyText(
					text = stringResource(homeBody)
				)
			}
		)
	}
}

@Composable
fun InformationPage(
	modifier: Modifier = Modifier,
){
	Column(
		modifier = modifier,
		horizontalAlignment = CenterHorizontally
	) {

	}
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun HomePreview(){
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.fillMaxSize()
				.background(color = MaterialTheme.colorScheme.surface)
		){
			HomePage()
		}
	}
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun HomePreviewDark(
){
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.fillMaxSize()
				.background(color = MaterialTheme.colorScheme.surface)
		){
			HomePage()
		}
	}
}