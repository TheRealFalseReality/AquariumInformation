package com.example.aquariuminformation.ui.commonui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aquariuminformation.R
import com.example.aquariuminformation.ui.theme.AquariumInformationTheme
import com.example.aquariuminformation.ui.theme.Shapes


@Composable
fun TitleWideCard(
	modifier: Modifier = Modifier,
	@StringRes text: Int,
	@DrawableRes icon: Int,
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
				painter = painterResource(id = icon),
				contentDescription = stringResource(id = text),
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
fun TitleText(
	modifier: Modifier = Modifier,
	@StringRes text: Int,
	@DrawableRes icon: Int,
	color: Color = MaterialTheme.colorScheme.onSurface,
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
				painter = painterResource(id = icon),
				contentDescription = stringResource(id = text),
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
	}
}

@Composable
fun IconTextRow(
	modifier: Modifier = Modifier,
	@DrawableRes icon: Int,
	iconTint: Color = MaterialTheme.colorScheme.onBackground,
	@StringRes text: Int,
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
				painter = painterResource(id = icon),
				contentDescription = null,
				tint = iconTint
			)
			Text(
				modifier = Modifier
					.weight(5f),
				text = stringResource(id = text),
				color = textColor
			)
		}
	}
}

@Composable
fun TextRow(
	modifier: Modifier = Modifier,
	@StringRes text1: Int,
	@StringRes text2: Int,
	color: Color = MaterialTheme.colorScheme.onBackground
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
				text = stringResource(id = text1),
				color = color
			)
			Text(
				modifier = Modifier
					.weight(1f),
				text = stringResource(id = text2),
				color = color
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
		modifier = modifier
			.fillMaxSize()
			.padding(
//				top = dimensionResource(id = R.dimen.padding_verySmall),
				bottom = dimensionResource(id = R.dimen.padding_small)
			),
		verticalArrangement = Arrangement.Top,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
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
					.padding(dimensionResource(id = R.dimen.padding_small))
					.fillMaxWidth()
			) {
				content()
			}
		}
	}
}

@Composable
fun HeaderTextCard(
	modifier: Modifier = Modifier,
	@StringRes text: Int,
	style: TextStyle = MaterialTheme.typography.titleMedium,
	textAlign: TextAlign = TextAlign.Center,
	color: Color = MaterialTheme.colorScheme.onBackground
) {
	Column(modifier = modifier) {
		Text(
			text = stringResource(id = text),
			style = style,
			textAlign = textAlign,
			color = color
		)
	}
}

@Composable
fun BodyTextCard(
	modifier: Modifier = Modifier,
	@StringRes text: Int,
	style: TextStyle = MaterialTheme.typography.bodyMedium,
	textAlign: TextAlign = TextAlign.Center,
	color: Color = MaterialTheme.colorScheme.onBackground
) {
	Column(modifier = modifier) {
		Text(
			text = stringResource(id = text),
			style = style,
			textAlign = textAlign,
			color = color
		)
	}
}

@Composable
fun GenericPageHeader(
	modifier: Modifier = Modifier,
	@StringRes title: Int,
	@StringRes subtitle: Int,
	@DrawableRes icon: Int,
	color: Color,
	selectContent: @Composable ColumnScope.() -> Unit,
	calculateFieldContent: @Composable ColumnScope.() -> Unit,
) {
	Column(
		modifier = modifier.fillMaxSize(),
		verticalArrangement = Arrangement.SpaceBetween,
		horizontalAlignment = Alignment.CenterHorizontally

	) {
		Column {
			TitleText(
				text = title,
				icon = icon,
				color = color
			)
			Column(
				modifier = Modifier.fillMaxWidth(),
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				Text(
					modifier = Modifier
						.padding(dimensionResource(id = R.dimen.padding_verySmall)),
					text = stringResource(id = subtitle),
					color = color,
					style = MaterialTheme.typography.titleMedium
				)
//				Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_verySmall)))
			}
		}
		selectContent()
		calculateFieldContent()

//		Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_verySmall)))
	}
}

@Composable
fun RadioButtonCard(
	modifier: Modifier = Modifier,
	content: @Composable RowScope.() -> Unit,
	containerColor: Color = MaterialTheme.colorScheme.background,
	contentColor: Color,
) {
	Column(modifier = modifier) {
		ElevatedCard(
			elevation = CardDefaults.cardElevation(8.dp),
			colors = CardDefaults.cardColors(
				containerColor = containerColor,
				contentColor = contentColor
			)
		) {
			Column(
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.padding_small))
					.fillMaxWidth(fraction = 0.6f),
			) {
				HeaderTextCard(
					text = R.string.select_input_units,
					color = contentColor
				)
				Row(
					modifier = Modifier
						.fillMaxWidth(),
					horizontalArrangement = Arrangement.Center,
					verticalAlignment = Alignment.CenterVertically
				) {
					content()
				}
			}

		}
	}
}

@Composable
fun RadioButtonComp(
	modifier: Modifier = Modifier,
	@StringRes text: Int,
	onClick: () -> Unit,
	selected: Int,
	selectedColor: Color,
	unselectedColor: Color = MaterialTheme.colorScheme.outline,
) {
	Column(
		modifier = modifier,
//			.padding(dimensionResource(id = R.dimen.padding_small)),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		RadioButton(
			selected = selected == text,
			onClick = onClick,
			colors = RadioButtonDefaults.colors(
				selectedColor = selectedColor,
				unselectedColor = unselectedColor
			)
		)
		Text(
			text = stringResource(id = text),
			modifier = Modifier
				.clickable(
					onClick = onClick
				),
			fontWeight = FontWeight.Bold,
		)
	}
}

@Composable
fun InputNumberField(
	modifier: Modifier = Modifier,
	@StringRes label: Int,
	@StringRes placeholder: Int,
	value: String,
	onValueChange: (String) -> Unit,
	shape: Shape = RoundedCornerShape(
		bottomStart = 0.dp,
		bottomEnd = 0.dp,
		topStart = dimensionResource(id = R.dimen.shape_medium),
		topEnd = dimensionResource(id = R.dimen.shape_medium),
	),
	color: Color
) {
	val focusManager = LocalFocusManager.current

	Column(
		modifier = modifier,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		TextField(
			modifier = Modifier
				.align(Alignment.CenterHorizontally),
			value = value,
			onValueChange = onValueChange,
			colors = TextFieldDefaults.colors(
				focusedIndicatorColor = color
			),
			label = {
				Text(
					stringResource(id = label),
				)
			},
			placeholder = {
				Text(
					stringResource(id = placeholder),
				)
			},
			keyboardOptions = KeyboardOptions(
				keyboardType = KeyboardType.Number,
				imeAction = ImeAction.Done
			),
			keyboardActions = KeyboardActions(
				onDone = { focusManager.clearFocus() }
			),
			shape = shape
		)
	}
}

@Composable
fun CalculateField(
	modifier: Modifier = Modifier,
	inputContent: @Composable () -> Unit,
	@StringRes inputText: Int,
	inputValue: String,
	@StringRes equalsText: Int,
	calculateContent: @Composable () -> Unit,
	color: Color = MaterialTheme.colorScheme.primary
) {
	Column(modifier = modifier) {
		inputContent()
		Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
		Text(
			text = stringResource(id = inputText, inputValue),
			modifier = Modifier
				.align(Alignment.CenterHorizontally)
				.padding(dimensionResource(id = R.dimen.padding_verySmall)),
			color = color
		)
		Text(
			text = stringResource(id = equalsText),
			modifier = Modifier
				.align(Alignment.CenterHorizontally)
				.padding(dimensionResource(id = R.dimen.padding_verySmall)),
			color = color
//			style = MaterialTheme.typography.bodySmall
		)
		calculateContent()
	}
}

@Composable
fun CalculatedText(
	modifier: Modifier = Modifier,
	@StringRes label: Int,
	calculatedValue: Double,
	color: Color
) {
	Column(modifier = modifier) {
		Text(
			modifier = Modifier
				.padding(dimensionResource(id = R.dimen.padding_verySmall))
				.align(Alignment.CenterHorizontally),
			text = stringResource(id = label, calculatedValue),
			fontSize = 20.sp,
			fontWeight = FontWeight.Bold,
			color = color
		)
	}
}

@Composable
fun FormulaString(
	content: @Composable () -> Unit,
	color: Color = MaterialTheme.colorScheme.primary,
) {
	TitleWideCard(
		text = R.string.formula,
		icon = R.drawable.baseline_functions_24,
		color = color,
	) {
		SingleWideCard {
			Column(
				modifier = Modifier.fillMaxWidth(),
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				Column {
					content()
				}
			}
		}
	}
}

@Composable
fun HeaderTextLarge(
	modifier: Modifier = Modifier,
	@StringRes text: Int,
	color: Color = MaterialTheme.colorScheme.onBackground,
	style: TextStyle = MaterialTheme.typography.titleLarge,
	textAlign: TextAlign = TextAlign.Start
) {
	Column(modifier = modifier) {
		Text(
			text = stringResource(id = text),
			color = color,
			style = style,
			textAlign = textAlign,
		)
	}
}

@Composable
fun HeaderTextIconLarge(
	modifier: Modifier = Modifier,
	@DrawableRes icon: Int,
	@StringRes text: Int,
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
				painter = painterResource(id = icon),
				contentDescription = stringResource(id = text)
			)
			Text(
				text = stringResource(id = text),
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
	@DrawableRes icon: Int,
	@StringRes headerText: Int,
	@StringRes bodyText: Int,
) {
	Column(modifier = modifier) {
		SingleWideCard(
			backgroundCardColor = MaterialTheme.colorScheme.tertiary,
			contentColor = MaterialTheme.colorScheme.onTertiary
		) {

			Row(
				verticalAlignment = Alignment.CenterVertically,
			) {
				Icon(
					modifier = Modifier
						.padding(end = dimensionResource(id = R.dimen.padding_small))
						.weight(1f),
					painter = painterResource(id = icon),
					contentDescription = null
				)
				Column(
					modifier = Modifier
						.weight(10f),
					horizontalAlignment = Alignment.CenterHorizontally
				) {
					Text(
						text = stringResource(id = headerText),
						style = MaterialTheme.typography.titleMedium
					)
					Text(
						text = stringResource(id = bodyText),
						style = MaterialTheme.typography.bodyMedium,
						textAlign = TextAlign.Center
					)
				}
			}
		}
	}
}

@Composable
fun PopOutlinedCard(
	modifier: Modifier = Modifier,
	@StringRes text: Int,
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
				text = stringResource(id = text),
			)
		}
	}
}

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
fun InputNumberPreview() {
	AquariumInformationTheme {
		InputNumberField(
			placeholder = R.string.field_label_cel,
			label = R.string.button_label_cel,
			value = "1",
			onValueChange = { },
			color = MaterialTheme.colorScheme.primary
		)
	}
}

@Preview(showBackground = true)
@Composable
fun InputNumberPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		InputNumberField(
			placeholder = R.string.field_label_cel,
			label = R.string.button_label_cel,
			value = "1",
			onValueChange = { },
			color = MaterialTheme.colorScheme.primary
		)
	}
}

@Preview(showBackground = true)
@Composable
fun RadioButtonCardPreview() {
	AquariumInformationTheme {
		RadioButtonCard(
			contentColor = MaterialTheme.colorScheme.primary,
			content = {
				RadioButtonComp(
					text = R.string.text_celsius,
					onClick = { },
					selected = 1,
					selectedColor = MaterialTheme.colorScheme.primary,
					unselectedColor = MaterialTheme.colorScheme.onPrimary,
				)
				RadioButtonComp(
					text = R.string.text_fah,
					onClick = { },
					selected = 1,
					selectedColor = MaterialTheme.colorScheme.primary,
					unselectedColor = MaterialTheme.colorScheme.onPrimary,
				)
			}
		)
	}
}

@Preview(showBackground = true)
@Composable
fun PRadioButtonPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		RadioButtonCard(
			contentColor = MaterialTheme.colorScheme.primary,
			content = {
				RadioButtonComp(
					text = R.string.text_celsius,
					onClick = { },
					selected = 1,
					selectedColor = MaterialTheme.colorScheme.primary,
					unselectedColor = MaterialTheme.colorScheme.onPrimary,
				)
				RadioButtonComp(
					text = R.string.text_fah,
					onClick = { },
					selected = 1,
					selectedColor = MaterialTheme.colorScheme.primary,
					unselectedColor = MaterialTheme.colorScheme.onPrimary,
				)
			}
		)
	}
}

@Preview(showBackground = true)
@Composable
fun PopOutlinedCardPreview() {
	AquariumInformationTheme {
		PopOutlinedCard(
			text = R.string.tap_below_to_navigate
		)
	}
}

@Preview(showBackground = true)
@Composable
fun PopOutlinedCardPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		PopOutlinedCard(
			text = R.string.tap_below_to_navigate
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
				icon = R.drawable.ic_conversion,
				text = R.string.converters,
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
				icon = R.drawable.ic_conversion,
				text = R.string.converters,
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
				icon = R.drawable.baseline_new_releases_24,
				headerText = R.string.text_welcome_compatibility_title,
				bodyText = R.string.text_welcome_compatibility_2
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
				icon = R.drawable.baseline_new_releases_24,
				headerText = R.string.text_welcome_compatibility_title,
				bodyText = R.string.text_welcome_compatibility_2
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
				text = R.string.app_name,
				icon = R.drawable.baseline_info_24
			) {
				SingleWideCard {
					BodyTextCard(text = R.string.text_welcome)
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
				text = R.string.app_name,
				icon = R.drawable.baseline_info_24
			) {
				SingleWideCard {
					BodyTextCard(text = R.string.text_welcome)
				}
			}
		}
	}
}