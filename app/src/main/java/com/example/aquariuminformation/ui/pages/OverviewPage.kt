package com.example.aquariuminformation.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.aquariuminformation.R
import com.example.aquariuminformation.ui.commonui.HeaderTextLarge
import com.example.aquariuminformation.ui.commonui.NavButtonRow
import com.example.aquariuminformation.ui.commonui.PageViewCenter
import com.example.aquariuminformation.ui.theme.AquariumInformationTheme

@Composable
fun OverviewPage(){
	PageViewCenter {
		OverviewLayout()
	}
}

@Composable
fun OverviewLayout(
	modifier: Modifier = Modifier
){
	Column(
		modifier = modifier,
	) {
		Column(
			modifier = Modifier
				.fillMaxWidth(fraction = 0.9f),
		) {
			HeaderTextLarge(
				text = stringResource(id = R.string.converters),
				color = MaterialTheme.colorScheme.primary
			)
			Divider(
				modifier = Modifier
					.fillMaxWidth(fraction = 0.8f)
					.padding(start = dimensionResource(id = R.dimen.padding_small)),
				color = MaterialTheme.colorScheme.primary
			)
			NavButtonRow(
				title1 = stringResource(id = R.string.converters),
				icon1 = Icons.Filled.Email,
				title2 = stringResource(R.string.calculators),
				icon2 = Icons.Filled.Home,
//				containerColor = MaterialTheme.colorScheme.secondary,
//				contentColor = MaterialTheme.colorScheme.onPrimary
			)
			NavButtonRow(
				title1 = stringResource(id = R.string.converters),
				icon1 = Icons.Filled.Email,
				title2 = stringResource(R.string.calculators),
				icon2 = Icons.Filled.Home
			)
		}
	}
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun OverviewPreview(){
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		){
			OverviewPage()
		}
	}
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun OverviewPreviewDark(
){
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		){
			OverviewPage()
		}
	}
}