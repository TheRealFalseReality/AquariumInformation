package com.example.aquariuminformation.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.aquariuminformation.R
import com.example.aquariuminformation.ui.commonui.CardBodyText
import com.example.aquariuminformation.ui.commonui.HeaderText
import com.example.aquariuminformation.ui.commonui.SingleCard
import com.example.aquariuminformation.ui.theme.AquariumInformationTheme

@Composable
fun WelcomePage(
){
	Column(
		modifier = Modifier.verticalScroll(rememberScrollState()),
		horizontalAlignment = CenterHorizontally
	) {
		HeaderText(
			text = "Welcome!",
			style = MaterialTheme.typography.displaySmall,
			color = MaterialTheme.colorScheme.onSurface,
		)
		Column(
			modifier = Modifier.align(alignment = Alignment.Start),
		) {
			HeaderText(
				text = "About",
				color = MaterialTheme.colorScheme.onSurface,
				style = MaterialTheme.typography.titleLarge
			)
			SingleCard(
				content = {
					CardBodyText(
						text = stringResource(id = R.string.text_welcome),
						textAlign = TextAlign.Center
					)
				}
			)
			Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
			HeaderText(
				text = stringResource(id = R.string.text_title_info),
				color = MaterialTheme.colorScheme.onSurface,
				style = MaterialTheme.typography.titleLarge
			)
			SingleCard(
				content = {
					CardBodyText(
						text = stringResource(id = R.string.text_info_1),
						textAlign = TextAlign.Center
					)
				}
			)
			SingleCard(
				content = {
					CardBodyText(
						text = stringResource(id = R.string.text_welcome),
						textAlign = TextAlign.Center
					)
				}
			)
		}
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
		HeaderText(
			text = "Information",
			style = MaterialTheme.typography.displaySmall,
			color = MaterialTheme.colorScheme.onSurface,
		)
		Column(
			modifier = Modifier.align(alignment = Alignment.Start)
		) {
			HeaderText(
				text = "About",
				color = MaterialTheme.colorScheme.onSurface,
				style = MaterialTheme.typography.titleLarge
			)
			SingleCard(
				content = {
					CardBodyText(
						text = stringResource(id = R.string.text_welcome),
						textAlign = TextAlign.Center
					)
				}
			)
			Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
			HeaderText(
				text = stringResource(id = R.string.text_title_info),
				color = MaterialTheme.colorScheme.onSurface,
				style = MaterialTheme.typography.titleLarge
			)
			SingleCard(
				content = {
					CardBodyText(
						text = stringResource(id = R.string.text_info_1),
						textAlign = TextAlign.Center
					)
				}
			)
			SingleCard(
				content = {
					CardBodyText(
						text = stringResource(id = R.string.text_welcome),
						textAlign = TextAlign.Center
					)
				}
			)
		}
	}
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun WelcomePreview(){
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.fillMaxSize()
				.background(color = MaterialTheme.colorScheme.surface)
		){
			WelcomePage()
		}
	}
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun WelcomePreviewDark(
){
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.fillMaxSize()
				.background(color = MaterialTheme.colorScheme.surface)
		){
			WelcomePage()
		}
	}
}