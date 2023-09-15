package com.example.aquariuminformation.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.aquariuminformation.R
import com.example.aquariuminformation.ui.commonui.AppDivider
import com.example.aquariuminformation.ui.commonui.HeaderTextLarge
import com.example.aquariuminformation.ui.commonui.NavButtonRow
import com.example.aquariuminformation.ui.commonui.NavRowButton
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
			ConvertersGrid()
			CalculatorsGrid()
			FishCompatability()
		}
	}
}

@Composable
fun ConvertersGrid(
	color: Color = MaterialTheme.colorScheme.primary
) {
	HeaderTextLarge(
		text = stringResource(id = R.string.converters),
		color = color
	)
	AppDivider()
	NavButtonRow(
		title1 = stringResource(id = R.string.converters),
		icon1 = painterResource(id = R.drawable.baseline_email_24),
		title2 = stringResource(R.string.calculators),
		icon2 = painterResource(id = R.drawable.baseline_email_24),
		contentColor = color
	)
	NavButtonRow(
		title1 = stringResource(id = R.string.converters),
		icon1 = painterResource(id = R.drawable.baseline_email_24),
		title2 = stringResource(R.string.calculators),
		icon2 = painterResource(id = R.drawable.baseline_email_24),
		contentColor = color
	)
}

@Composable
fun CalculatorsGrid(
	color: Color = MaterialTheme.colorScheme.secondary
) {
	HeaderTextLarge(
		text = stringResource(id = R.string.calculators),
		color = color,
	)
	AppDivider()
	NavButtonRow(
		title1 = stringResource(id = R.string.converters),
		icon1 = painterResource(id = R.drawable.baseline_email_24),
		title2 = stringResource(R.string.calculators),
		icon2 = painterResource(id = R.drawable.baseline_email_24),
		contentColor = color
	)
}

@Composable
fun FishCompatability(
	color: Color = MaterialTheme.colorScheme.tertiary
) {
	HeaderTextLarge(
		text = stringResource(id = R.string.calculators),
		color = color,
	)
	AppDivider()
	NavRowButton(
		title = stringResource(id = R.string.text_welcome_compatibility_title),
		icon = painterResource(id = R.drawable.baseline_email_24),
		contentColor = color,
		modifier = Modifier.fillMaxWidth().padding(dimensionResource(id = R.dimen.padding_small)),
	)
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