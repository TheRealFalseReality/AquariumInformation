package com.example.aquariuminformation.ui.commonui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.aquariuminformation.R
import com.example.aquariuminformation.ui.theme.AquariumInformationTheme
import com.example.aquariuminformation.ui.theme.Shapes


@Composable
fun TitleWideCard(
	modifier: Modifier = Modifier,
	title: String,
	icon: Painter,
	content: @Composable ColumnScope.() -> Unit,
){
	Column(
		modifier = modifier,
	) {
		Row(
			modifier = Modifier
				.padding(start = dimensionResource(id = R.dimen.padding_verySmall)),
			verticalAlignment = Alignment.CenterVertically
		) {
			Icon(
				painter = icon,
				contentDescription = title
			)
			HeaderTextLarge(
				text = title,
				color = MaterialTheme.colorScheme.onSurface,
			)
		}
		Column(
			modifier = Modifier.fillMaxWidth(),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			content()
		}
	}
}

@Composable
fun IconTextRow(
	modifier: Modifier = Modifier,
	icon: Painter,
	iconTint: Color = MaterialTheme.colorScheme.onBackground,
	text: String,
	textColor: Color = MaterialTheme.colorScheme.onBackground
){
	Column(modifier = modifier) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(dimensionResource(id = R.dimen.padding_verySmall)),
			verticalAlignment = Alignment.CenterVertically
		) {
			Icon(
				modifier = Modifier
					.weight(1f),
				painter = icon,
				contentDescription = null,
				tint = iconTint
			)
			Text(
				modifier = Modifier
					.weight(5f),
				text = text,
				color = textColor
			)
		}
	}
}

@Composable
fun TextRow(
	modifier: Modifier = Modifier,
	text1: String,
	text2: String,
	){
	Column(modifier = modifier) {
		Row(
			modifier = Modifier
				.fillMaxWidth()
				.padding(dimensionResource(id = R.dimen.padding_verySmall)),
			verticalAlignment = Alignment.CenterVertically
		) {
			Text(
				modifier = Modifier
					.weight(1f),
				text = text1
			)
			Text(
				modifier = Modifier
					.weight(1f),
				text = text2
			)
		}
	}

}

@Composable
fun NavButton(
	modifier: Modifier = Modifier,
	shape: Shape = Shapes.large,
	containerColor: Color = MaterialTheme.colorScheme.background,
	contentColor: Color = MaterialTheme.colorScheme.onBackground,
	title: String,
	icon: ImageVector
){
	Button(
		modifier = modifier,
		onClick = { /*TODO*/ },
		shape = shape,
		colors = ButtonDefaults.buttonColors(
			containerColor = containerColor,
			contentColor = contentColor,
		),
		elevation = ButtonDefaults.buttonElevation(
			defaultElevation = dimensionResource(id = R.dimen.elevation_large),
			pressedElevation = dimensionResource(id = R.dimen.elevation_small)
		)
	) {
		Column(
			modifier = Modifier
				.padding(dimensionResource(id = R.dimen.padding_small)),
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally,
		) {
			Text(
				text = title
			)
			Icon(
				imageVector = icon,
				contentDescription = null
			)
		}

	}
}

@Composable
fun NavButtonRow(
	modifier: Modifier = Modifier,
	title1: String,
	icon1: ImageVector,
	title2: String,
	icon2: ImageVector,
	containerColor: Color = MaterialTheme.colorScheme.background,
	contentColor: Color = MaterialTheme.colorScheme.onBackground,
){
	Row(
		modifier = modifier
	) {
		NavButton(
			modifier = Modifier
				.weight(1f)
				.padding(dimensionResource(id = R.dimen.padding_small)),
			title = title1,
			icon = icon1,
			containerColor = containerColor,
			contentColor = contentColor,
		)
		NavButton(
			modifier = Modifier
				.weight(1f)
				.padding(dimensionResource(id = R.dimen.padding_small)),
			title = title2,
			icon = icon2,
			containerColor = containerColor,
			contentColor = contentColor,
		)
	}
}

@Composable
fun FishComCard(modifier: Modifier = Modifier){
	Column(modifier = modifier) {
		SingleWideCard(
			backgroundCardColor = MaterialTheme.colorScheme.tertiary,
			contentColor = MaterialTheme.colorScheme.onTertiary
		) {

			Row(
				modifier = Modifier.fillMaxWidth(),
				verticalAlignment = Alignment.CenterVertically,
				horizontalArrangement = Arrangement.Center
			) {
				Icon(
					modifier = Modifier
						.weight(1f),
					painter = painterResource(id = R.drawable.baseline_new_releases_24),
					contentDescription = null)
				Column(
					modifier = Modifier
						.weight(10f),
					horizontalAlignment = Alignment.CenterHorizontally
				) {
					HeaderTextCard(
						text = stringResource(id = R.string.text_welcome_compatibility_title),
					)
					BodyTextCard(
						text = stringResource(id =  R.string.text_welcome_compatibility_2)
					)
				}
			}
		}
	}
}

//@Composable
//fun AppInfo(
//) {
//
//	Row(
//		horizontalArrangement = Arrangement.Center,
//	) {
//		Text(
//			text = stringResource(R.string.app_version)
//		)
//		Text(
//			text = stringResource(id = R.string.text_label_version, version),
//		)
//	}
//}

@Composable
fun PageView(
	content: @Composable ColumnScope.() -> Unit,
){
	Column(
		modifier = Modifier
			.fillMaxSize()
			.verticalScroll(rememberScrollState()),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
		content()
	}
}

@Composable
fun PageViewCenter(
	content: @Composable ColumnScope.() -> Unit,
){
	Column(
		modifier = Modifier
			.fillMaxSize()
			.verticalScroll(rememberScrollState()),
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.Center,
	) {
		Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
		content()
	}
}

@Composable
fun PageViewLazy(
	content: @Composable ColumnScope.() -> Unit,
){
	Column(
		modifier = Modifier
			.fillMaxSize(),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
		content()
	}
}

@Composable
fun SingleWideCard(
	modifier: Modifier = Modifier,
	shape: Shape = Shapes.large,
	backgroundCardColor: Color = MaterialTheme.colorScheme.background,
	contentColor: Color = MaterialTheme.colorScheme.onBackground,
	content: @Composable ColumnScope.() -> Unit,
){
	Column(modifier = modifier) {
		ElevatedCard(
			modifier = Modifier
				.padding(
					top = dimensionResource(id = R.dimen.padding_small),
					bottom = dimensionResource(id = R.dimen.padding_small),
//				start = dimensionResource(id = R.dimen.padding_medium),
//				end = dimensionResource(id = R.dimen.padding_medium)
				)
				.fillMaxWidth(fraction = 0.9f),
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
					.padding(dimensionResource(id = R.dimen.padding_small)),
			) {
				content()
			}
		}
	}
}

@Composable
fun HeaderTextCard(
	modifier: Modifier = Modifier,
	text: String,
	style: TextStyle = MaterialTheme.typography.titleMedium,
	textAlign: TextAlign = TextAlign.Center
){
	Column(modifier = modifier) {
		Text(
			modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_small)),
			text = text,
			style = style,
			textAlign = textAlign,
		)
	}
}

@Composable
fun BodyTextCard(
	modifier: Modifier = Modifier,
	text: String,
	style: TextStyle = MaterialTheme.typography.bodyMedium,
	textAlign: TextAlign = TextAlign.Center
){
	Column(modifier = modifier) {
		Text(
			modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)),
			text = text,
			style = style,
			textAlign = textAlign,
		)
	}
}

@Composable
fun HeaderTextLarge(
	modifier: Modifier = Modifier,
	text: String,
	color: Color = MaterialTheme.colorScheme.onBackground,
	style: TextStyle = MaterialTheme.typography.titleLarge,
	textAlign: TextAlign = TextAlign.Start
){
	Column(modifier = modifier) {
		Text(
			modifier = Modifier
				.padding(start = dimensionResource(id = R.dimen.padding_small)),
			text = text,
			color = color,
			style = style,
			textAlign = textAlign,
		)
	}
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
fun NavButtonPreview(){
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		){
			NavButton(
				title = stringResource(R.string.converters),
				icon = Icons.Filled.Home
			)
		}
	}
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun NavButtonPreviewDark(
){
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		){
			NavButton(
				title = stringResource(R.string.converters),
				icon = Icons.Filled.Home
			)
		}
	}
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun FisComPreview(){
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		){
			FishComCard()
		}
	}
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun FisComPreviewDark(
){
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		){
			FishComCard()
		}
	}
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun CardTitlePreview(){
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		){
			TitleWideCard(
				title = stringResource(id = R.string.app_name),
				icon = painterResource(id = R.drawable.baseline_info_24)
			) {
				SingleWideCard {
					BodyTextCard(text = stringResource(id = R.string.text_welcome))
				}
			}
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
			TitleWideCard(
				title = stringResource(id = R.string.app_name),
				icon = painterResource(id = R.drawable.baseline_info_24)
			){
				SingleWideCard {
					BodyTextCard(text = stringResource(id = R.string.text_welcome))
				}
			}
		}
	}
}