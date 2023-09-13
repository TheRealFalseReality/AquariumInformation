package com.example.aquariuminformation.ui.commonui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.aquariuminformation.R
import com.example.aquariuminformation.ui.theme.AquariumInformationTheme
import com.example.aquariuminformation.ui.theme.Shapes


@Composable
fun SingleCard(
	modifier: Modifier = Modifier
		.padding(
			top= dimensionResource(id = R.dimen.padding_small),
			bottom = dimensionResource(id = R.dimen.padding_small),
			start = dimensionResource(id = R.dimen.padding_medium),
			end = dimensionResource(id = R.dimen.padding_medium)
		),
	shape: Shape = Shapes.extraLarge,
	backgroundCardColor: Color = MaterialTheme.colorScheme.background,
	contentColor: Color = MaterialTheme.colorScheme.onBackground,
	content: @Composable ColumnScope.() -> Unit,
){
	ElevatedCard(
		modifier = modifier,
		shape = shape,
		colors = CardDefaults.cardColors(
			containerColor = backgroundCardColor,
			contentColor = contentColor
		),
//		border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)
		elevation = CardDefaults.cardElevation(
			defaultElevation = dimensionResource(id = R.dimen.elevation_medium)
		)
	) {
		Column(
			modifier = Modifier
				.padding(dimensionResource(id = R.dimen.padding_small))
				.fillMaxWidth(),
		) {
			content()
		}
	}
}

@Composable
fun CardHeaderText(
	modifier: Modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_small)),
	text: String,
	style: TextStyle = MaterialTheme.typography.titleMedium,
	textAlign: TextAlign = TextAlign.Start
){
	Text(
		modifier = modifier,
		text = text,
		style = style,
		textAlign = textAlign,
	)
}

@Composable
fun CardBodyText(
	modifier: Modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)),
	text: String,
	style: TextStyle = MaterialTheme.typography.bodyMedium,
	textAlign: TextAlign = TextAlign.Start
){
	Text(
		modifier = modifier,
		text = text,
		style = style,
		textAlign = textAlign,
	)
}

@Composable
fun HeaderText(
	modifier: Modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_small)),
	text: String,
	color: Color = MaterialTheme.colorScheme.onBackground,
	style: TextStyle = MaterialTheme.typography.titleMedium,
	textAlign: TextAlign = TextAlign.Start
){
	Text(
		modifier = modifier,
		text = text,
		color = color,
		style = style,
		textAlign = textAlign,
	)
}

@Composable
fun BodyText(
	modifier: Modifier = Modifier,
	text: String,
	color: Color = MaterialTheme.colorScheme.onBackground,
	style: TextStyle = MaterialTheme.typography.bodyMedium,
	textAlign: TextAlign = TextAlign.Start
){
	Text(
		modifier = modifier,
		text = text,
		color = color,
		style = style,
		textAlign = textAlign,
	)
}

@Composable
fun GenericText(
	modifier: Modifier = Modifier,
	text: Int,
	color: Color = MaterialTheme.colorScheme.onBackground,
	style: TextStyle = MaterialTheme.typography.bodyMedium,
	textAlign: TextAlign = TextAlign.Start
){
	Text(
		modifier = modifier,
		text = stringResource(id = text),
		color = color,
		style = style,
		textAlign = textAlign,
	)
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun SingleCardPreview(){
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		){
			SingleCard (
				content = {
					CardHeaderText(text =  stringResource(id = R.string.app_name))
					CardBodyText(text = stringResource(id = R.string.text_welcome))
				}
			)
		}
	}
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun SingleCardPreviewDark(
){
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		){
			SingleCard (
				content = {
					CardHeaderText(text = stringResource(id = R.string.app_name))
					CardBodyText(text = stringResource(id = R.string.text_welcome))
				}
			)
		}
	}
}