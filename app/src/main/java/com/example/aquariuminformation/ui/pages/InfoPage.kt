package com.example.aquariuminformation.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.aquariuminformation.R
import com.example.aquariuminformation.data.Home
import com.example.aquariuminformation.data.Info
import com.example.aquariuminformation.data.homeData
import com.example.aquariuminformation.data.infoData
import com.example.aquariuminformation.ui.commonui.CardTitle
import com.example.aquariuminformation.ui.theme.AquariumInformationTheme

@Composable
fun InfoPage(){
	InfoCards()
}

@Composable
fun InfoCards(
	modifier: Modifier = Modifier
){
	Column(modifier = modifier) {
		LazyColumn(content = {
			items(infoData) {
				InfoItem(
					dataSource = it,
					modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)),
				)
			}
		})
	}
}


@Composable
fun InfoItem(
	modifier: Modifier = Modifier,
	dataSource: Info
) {
	Column(modifier = modifier) {
		CardTitle(title = dataSource.title, body = dataSource.body)
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