package com.example.aquariuminformation.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.aquariuminformation.R
import com.example.aquariuminformation.ui.commonui.CardBodyText
import com.example.aquariuminformation.ui.commonui.HeaderText
import com.example.aquariuminformation.ui.commonui.HeaderTextLarge
import com.example.aquariuminformation.ui.commonui.SingleCard
import com.example.aquariuminformation.ui.theme.AquariumInformationTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun WelcomePage(
	modifier: Modifier = Modifier.verticalScroll(rememberScrollState()),
){
	Column(
		modifier = modifier,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		HeaderText(
			text = "Welcome!",
			style = MaterialTheme.typography.displayLarge,
			color = MaterialTheme.colorScheme.onSurface,
			modifier = Modifier
				.padding(
					top= dimensionResource(id = R.dimen.padding_small),
					start = dimensionResource(id = R.dimen.padding_medium),
					end = dimensionResource(id = R.dimen.padding_medium))
				)
		HeaderTextLarge(
			text = "About",
			modifier = Modifier
				.padding(
					top = dimensionResource(id = R.dimen.padding_small),
					start = dimensionResource(id = R.dimen.padding_medium),
					end = dimensionResource(id = R.dimen.padding_medium)
				)
				.align(alignment = Start),
			color = MaterialTheme.colorScheme.onSurface,
		)
		SingleCard(
			modifier = Modifier
				.padding(
				top= dimensionResource(id = R.dimen.padding_small),
				bottom = dimensionResource(id = R.dimen.padding_small),
				start = dimensionResource(id = R.dimen.padding_medium),
				end = dimensionResource(id = R.dimen.padding_medium)
			),
			content = {
				CardBodyText(
					text = stringResource(id = R.string.text_welcome),
					modifier = Modifier
						.padding(dimensionResource(id = R.dimen.padding_small)),
					textAlign = TextAlign.Center
				)
			}
		)
		HeaderTextLarge(
			text = stringResource(id = R.string.text_title_info),
			modifier = Modifier
				.padding(
					top = dimensionResource(id = R.dimen.padding_small),
					start = dimensionResource(id = R.dimen.padding_medium),
					end = dimensionResource(id = R.dimen.padding_medium)
				)
				.align(alignment = Start),
			color = MaterialTheme.colorScheme.onSurface,
		)
		SingleCard(
			modifier = Modifier
				.padding(
					top= dimensionResource(id = R.dimen.padding_small),
					bottom = dimensionResource(id = R.dimen.padding_small),
					start = dimensionResource(id = R.dimen.padding_medium),
					end = dimensionResource(id = R.dimen.padding_medium)
				),
			content = {
				CardBodyText(
					text = stringResource(id = R.string.text_info_1),
					modifier = Modifier
						.padding(dimensionResource(id = R.dimen.padding_small)),
					textAlign = TextAlign.Center
				)
			}
		)
		SingleCard(
			modifier = Modifier
				.padding(
					top= dimensionResource(id = R.dimen.padding_small),
					bottom = dimensionResource(id = R.dimen.padding_small),
					start = dimensionResource(id = R.dimen.padding_medium),
					end = dimensionResource(id = R.dimen.padding_medium)
				),
			content = {
				CardBodyText(
					text = stringResource(id = R.string.text_welcome),
					modifier = Modifier
						.padding(dimensionResource(id = R.dimen.padding_small)),
					textAlign = TextAlign.Center
				)
			}
		)
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