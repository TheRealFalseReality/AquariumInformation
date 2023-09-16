package com.example.aquariuminformation.ui.commonui

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aquariuminformation.R
import com.example.aquariuminformation.ui.theme.AquariumInformationTheme
import com.example.aquariuminformation.ui.theme.Shapes


@Composable
fun TitleWideCard(
	modifier: Modifier = Modifier,
	text: String,
	icon: Painter,
	color: Color = MaterialTheme.colorScheme.onSurface,
	content: @Composable ColumnScope.() -> Unit,
) {
	Column(
		modifier = modifier,
	) {
		Row(
			verticalAlignment = Alignment.CenterVertically
		) {
			Icon(
				modifier = Modifier
					.padding(
						start = dimensionResource(id = R.dimen.padding_verySmall),
						end = dimensionResource(id = R.dimen.padding_small)
					),
				painter = icon,
				contentDescription = text,
				tint = color
			)
			HeaderTextLarge(
				text = text,
				color = color,
			)
		}
		AppDivider(
			color = color,
//			modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_verySmall))
		)
		Column(
			modifier = Modifier
				.fillMaxWidth(),
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
) {
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
) {
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
	modifier: Modifier = Modifier,
	content: @Composable ColumnScope.() -> Unit
) {
	Column(
		modifier = modifier.fillMaxSize(),
		verticalArrangement = Arrangement.Top,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_verySmall)))
		content()
	}
}

@Composable
fun PageViewCenter(
	modifier: Modifier = Modifier,
	content: @Composable ColumnScope.() -> Unit,
) {
	Column(
		modifier = modifier
			.fillMaxSize()
			.verticalScroll(rememberScrollState()),
		verticalArrangement = Arrangement.SpaceBetween,
	) {
		Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
		content()
	}
}

@Composable
fun PageViewLazy(
	content: @Composable ColumnScope.() -> Unit,
) {
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
) {
	Column(modifier = modifier) {
		ElevatedCard(
			modifier = Modifier
				.padding(
					top = dimensionResource(id = R.dimen.padding_small),
					bottom = dimensionResource(id = R.dimen.padding_small),
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
) {
	Column(modifier = modifier) {
		Text(
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
) {
	Column(modifier = modifier) {
		Text(
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
) {
	Column(modifier = modifier) {
		Text(
			text = text,
			color = color,
			style = style,
			textAlign = textAlign,
		)
	}
}

@Composable
fun HeaderTextIconLarge(
	modifier: Modifier = Modifier,
	icon: Painter,
	text: String,
	color: Color = MaterialTheme.colorScheme.onBackground,
	style: TextStyle = MaterialTheme.typography.titleLarge,
	textAlign: TextAlign = TextAlign.Start
) {
	Column(modifier = modifier) {
		Row(
			verticalAlignment = Alignment.CenterVertically
		) {
			Icon(
				modifier = Modifier
					.padding(
						start = dimensionResource(id = R.dimen.padding_verySmall),
						end = dimensionResource(id = R.dimen.padding_small)
					),
				painter = icon,
				contentDescription = text
			)
			Text(
				text = text,
				color = color,
				style = style,
				textAlign = textAlign,
			)
		}

	}
}

@Composable
fun PopOutCard(
	modifier: Modifier = Modifier,
	icon: Painter,
	headerText: String,
	bodyText: String,
) {
	Column(modifier = modifier) {
		SingleWideCard(
			backgroundCardColor = MaterialTheme.colorScheme.tertiary,
			contentColor = MaterialTheme.colorScheme.onTertiary
		) {

			Row(
				verticalAlignment = Alignment.CenterVertically,
			) {
				Column(
					modifier = Modifier
						.weight(1f),
					horizontalAlignment = Alignment.CenterHorizontally
				) {
					Icon(
						painter = icon,
						contentDescription = null
					)
				}

				Column(
					modifier = Modifier
						.weight(10f),
					horizontalAlignment = Alignment.CenterHorizontally
				) {
					HeaderTextCard(
						text = headerText,
					)
					BodyTextCard(
						text = bodyText
					)
				}
			}
		}
	}
}

@Composable
fun PopOutlinedCard(
	modifier: Modifier = Modifier,
	text: String,
	containerColor: Color = MaterialTheme.colorScheme.background,
	contentColor: Color = MaterialTheme.colorScheme.secondary,
) {
	Column(
		modifier = modifier,
	) {
		OutlinedCard(
			colors = CardDefaults.cardColors(
				containerColor = containerColor,
				contentColor = contentColor
			),
			border = BorderStroke(width = 4.dp, color = contentColor)
		) {
			Text(
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.padding_large)),
				text = text,
			)
		}
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

@Composable
fun AppDivider(
	modifier: Modifier = Modifier,
	color: Color = MaterialTheme.colorScheme.onBackground,
) {
	Column(modifier = modifier) {
		Divider(
			modifier = Modifier
				.fillMaxWidth(fraction = 0.8f),
			color = color
		)		
	}

}

@Preview(showBackground = true)
@Composable
fun PopOutlinedCardPreview() {
	AquariumInformationTheme {
		PopOutlinedCard(
			text = stringResource(id = R.string.tap_below_to_navigate)
		)
	}
}

@Preview(showBackground = true)
@Composable
fun PopOutlinedCarPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		PopOutlinedCard(
			text = stringResource(id = R.string.tap_below_to_navigate)
		)
	}
}

@Preview(showBackground = true)
@Composable
fun HeaderTextIconLargePreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			HeaderTextIconLarge(
				icon = painterResource(id = R.drawable.ic_conversion),
				text = stringResource(id = R.string.converters),
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun HeaderTextIconLargePreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			HeaderTextIconLarge(
				icon = painterResource(id = R.drawable.ic_conversion),
				text = stringResource(id = R.string.converters),
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun PopOutCardPreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			PopOutCard(
				icon = painterResource(id = R.drawable.baseline_new_releases_24),
				headerText = stringResource(id = R.string.text_welcome_compatibility_title),
				bodyText = stringResource(id = R.string.text_welcome_compatibility_2)
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun PopOutCardPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			PopOutCard(
				icon = painterResource(id = R.drawable.baseline_new_releases_24),
				headerText = stringResource(id = R.string.text_welcome_compatibility_title),
				bodyText = stringResource(id = R.string.text_welcome_compatibility_2)
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun CardTitlePreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			TitleWideCard(
				text = stringResource(id = R.string.app_name),
				icon = painterResource(id = R.drawable.baseline_info_24)
			) {
				SingleWideCard {
					BodyTextCard(text = stringResource(id = R.string.text_welcome))
				}
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun CardTitlePreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			TitleWideCard(
				text = stringResource(id = R.string.app_name),
				icon = painterResource(id = R.drawable.baseline_info_24)
			){
				SingleWideCard {
					BodyTextCard(text = stringResource(id = R.string.text_welcome))
				}
			}
		}
	}
}