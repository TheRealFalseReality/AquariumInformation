package com.example.aquariuminformation.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.aquariuminformation.R
import com.example.aquariuminformation.data.Home
import com.example.aquariuminformation.data.homeData
import com.example.aquariuminformation.ui.commonui.FishComCard
import com.example.aquariuminformation.ui.commonui.TitleWideCard
import com.example.aquariuminformation.ui.theme.AquariumInformationTheme

@Composable
fun HomePage(){
	Column(
		modifier = Modifier.fillMaxWidth(),
		horizontalAlignment = Alignment.CenterHorizontally
	){
		HomeCards()
		FishComCard()
	}
}

@Composable
fun HomeCards(
	modifier: Modifier = Modifier
){
	Column(modifier = modifier) {
		LazyColumn(content = {
			items(homeData) {
				HomeItem(
					dataSource = it,
					modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)),
				)
			}
		})
	}
}


@Composable
fun HomeItem(
	modifier: Modifier = Modifier,
	dataSource: Home
) {
	Column(modifier = modifier) {
		TitleWideCard(title = dataSource.title, body = dataSource.body)
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