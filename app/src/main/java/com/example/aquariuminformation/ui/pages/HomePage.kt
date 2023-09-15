package com.example.aquariuminformation.ui.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aquariuminformation.R
import com.example.aquariuminformation.ui.commonui.BodyTextCard
import com.example.aquariuminformation.ui.commonui.PageView
import com.example.aquariuminformation.ui.commonui.PopOutCard
import com.example.aquariuminformation.ui.commonui.SingleWideCard
import com.example.aquariuminformation.ui.commonui.TitleWideCard
import com.example.aquariuminformation.ui.theme.AquariumInformationTheme

@Composable
fun HomePage(){
	PageView{
		HomeLayout()
		PopOutCard(
			icon = painterResource(id = R.drawable.baseline_new_releases_24), 
			headerText = stringResource(id = R.string.text_welcome_compatibility_title), 
			bodyText = stringResource(id = R.string.text_welcome_compatibility_2)
		)
		TapBelow(
			modifier = Modifier.weight(1f),
		)
	}
}

@Composable
fun HomeLayout(
	modifier: Modifier = Modifier,
) {
	Column(modifier = modifier) {
		TitleWideCard(
			title = stringResource(id = R.string.about),
//			body = stringResource(id = R.string.text_welcome),
			icon = painterResource(id = R.drawable.baseline_home_24)
		){
			SingleWideCard {
				BodyTextCard(text = stringResource(id = R.string.text_welcome))
			}
		}
	}
}

@Composable
fun TapBelow(modifier: Modifier = Modifier,){
	Column(
		modifier = modifier,
		verticalArrangement = Arrangement.Center
		) {
		OutlinedCard(
			colors = CardDefaults.cardColors(
				containerColor = MaterialTheme.colorScheme.background,
				contentColor = MaterialTheme.colorScheme.secondary
			),
			border = BorderStroke(width = 4.dp, color = MaterialTheme.colorScheme.secondary)
		) {
			Text(
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.padding_large)),
				text = stringResource(R.string.tap_below_to_navigate),
			)
		}
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