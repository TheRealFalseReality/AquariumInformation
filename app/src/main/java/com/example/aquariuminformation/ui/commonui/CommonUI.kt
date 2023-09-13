package com.example.aquariuminformation.ui.commonui

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.aquariuminformation.R
import com.example.aquariuminformation.ui.theme.AquariumInformationTheme
import com.example.aquariuminformation.ui.theme.Shapes

@Composable
fun CardTitle(
	modifier: Modifier = Modifier,
	@StringRes title: Int,
	@StringRes body: Int,
){
	Column(
		modifier = modifier
	) {
		HeaderTextLarge(
			text = stringResource(title),
			color = MaterialTheme.colorScheme.onSurface,
		)
		SingleWideCard(
			content = {
				CardBodyText(
					text = stringResource(body)
				)
			}
		)
	}
}

@Composable
fun SingleWideCard(
	shape: Shape = Shapes.extraLarge,
	backgroundCardColor: Color = MaterialTheme.colorScheme.background,
	contentColor: Color = MaterialTheme.colorScheme.onBackground,
	content: @Composable ColumnScope.() -> Unit,
){
	ElevatedCard(
		modifier = Modifier
			.padding(
				top= dimensionResource(id = R.dimen.padding_small),
				bottom = dimensionResource(id = R.dimen.padding_small),
				start = dimensionResource(id = R.dimen.padding_medium),
				end = dimensionResource(id = R.dimen.padding_medium)
			),
		shape = shape,
		colors = CardDefaults.cardColors(
			containerColor = backgroundCardColor,
			contentColor = contentColor
		),
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
	text: String,
	style: TextStyle = MaterialTheme.typography.titleMedium,
	textAlign: TextAlign = TextAlign.Start
){
	Text(
		modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_small)),
		text = text,
		style = style,
		textAlign = textAlign,
	)
}

@Composable
fun CardBodyText(
	text: String,
	style: TextStyle = MaterialTheme.typography.bodyMedium,
	textAlign: TextAlign = TextAlign.Center
){
	Text(
		modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)),
		text = text,
		style = style,
		textAlign = textAlign,
	)
}

@Composable
fun HeaderTextLarge(
	text: String,
	color: Color = MaterialTheme.colorScheme.onBackground,
	style: TextStyle = MaterialTheme.typography.titleLarge,
	textAlign: TextAlign = TextAlign.Start
){
	Text(
		modifier = Modifier
			.padding(start = dimensionResource(id = R.dimen.padding_small)),
		text = text,
		color = color,
		style = style,
		textAlign = textAlign,
	)
}

//@Composable
//fun HeaderText(
//	text: String,
//	color: Color = MaterialTheme.colorScheme.onBackground,
//	style: TextStyle = MaterialTheme.typography.titleMedium,
//	textAlign: TextAlign = TextAlign.Center
//){
//	Text(
//		modifier = Modifier
//			.padding(start = dimensionResource(id = R.dimen.padding_small)),
//		text = text,
//		color = color,
//		style = style,
//		textAlign = textAlign,
//	)
//}

//@Composable
//fun BodyText(
//	modifier: Modifier = Modifier,
//	text: String,
//	color: Color = MaterialTheme.colorScheme.onBackground,
//	style: TextStyle = MaterialTheme.typography.bodyMedium,
//	textAlign: TextAlign = TextAlign.Start
//){
//	Text(
//		modifier = modifier,
//		text = text,
//		color = color,
//		style = style,
//		textAlign = textAlign,
//	)
//}
//
//@Composable
//fun GenericText(
//	modifier: Modifier = Modifier,
//	text: Int,
//	color: Color = MaterialTheme.colorScheme.onBackground,
//	style: TextStyle = MaterialTheme.typography.bodyMedium,
//	textAlign: TextAlign = TextAlign.Start
//){
//	Text(
//		modifier = modifier,
//		text = stringResource(id = text),
//		color = color,
//		style = style,
//		textAlign = textAlign,
//	)
//}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun CardTitlePreview(){
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		){
			CardTitle(
				title = R.string.app_name,
				body = R.string.text_welcome
			)
		}
	}
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun CardTitlePreviewDark(
){
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		){
			CardTitle(
				title = R.string.app_name,
				body = R.string.text_welcome
			)
		}
	}
}