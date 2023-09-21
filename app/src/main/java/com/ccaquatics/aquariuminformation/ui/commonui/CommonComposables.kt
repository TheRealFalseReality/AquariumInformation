package com.ccaquatics.aquariuminformation.ui.commonui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ccaquatics.aquariuminformation.R
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme
import com.ccaquatics.aquariuminformation.ui.theme.Shapes

@Composable
fun TitleTextIcon(
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
					.size(dimensionResource(id = R.dimen.icon_size_small))
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
		AppDivider(color = color)
	}
}

@Composable
fun TitleWideContent(
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
			TitleTextIcon(
				text = text,
				icon = icon,
				color = color
			)
		}
		Column(
			modifier = Modifier
				.fillMaxWidth(),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			SmallSpacer()
			content()
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
					.padding(dimensionResource(id = R.dimen.padding_medium))
					.fillMaxWidth(),
				horizontalAlignment = Alignment.CenterHorizontally,
			) {
				content()
			}
		}
	}
}

@Composable
fun UnitButtonCard(
	modifier: Modifier = Modifier,
	content: @Composable RowScope.() -> Unit,
	containerColor: Color = MaterialTheme.colorScheme.background,
	contentColor: Color,
	shape: Shape = Shapes.large

) {
	Column(modifier = modifier) {
		ElevatedCard(
			elevation = CardDefaults.cardElevation(8.dp),
			colors = CardDefaults.cardColors(
				containerColor = containerColor,
				contentColor = contentColor
			),
			shape = shape
		) {
			Column(
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.padding_small))
					.fillMaxWidth(fraction = 0.6f),
			) {
				HeaderText(
					text = R.string.select_input_units,
					color = contentColor
				)
				Row(
					modifier = Modifier
						.fillMaxWidth(),
					horizontalArrangement = Arrangement.Center,
					verticalAlignment = Alignment.Top
				) {
					content()
				}
			}
		}
	}
}

@Composable
fun TextCard(
	modifier: Modifier = Modifier,
	@StringRes text: Int,
	containerColor: Color = MaterialTheme.colorScheme.background,
	contentColor: Color,
	shape: Shape = Shapes.large
) {
	Column(modifier = modifier) {
		ElevatedCard(
			elevation = CardDefaults.cardElevation(8.dp),
			colors = CardDefaults.cardColors(
				containerColor = containerColor,
				contentColor = contentColor
			),
			shape = shape
		) {
			Column(
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.padding_medium))
					.fillMaxWidth(fraction = 0.6f),
			) {
				Row(
					modifier = Modifier
						.fillMaxWidth(),
					horizontalArrangement = Arrangement.Center,
					verticalAlignment = Alignment.CenterVertically
				) {
					HeaderText(
						modifier = Modifier
							.padding(
								top = dimensionResource(id = R.dimen.padding_medium),
								bottom = dimensionResource(id = R.dimen.padding_medium)
							),
						text = text,
						color = contentColor,
					)
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
		RadioText(
			text = text,
			modifier = Modifier
				.clickable(
					onClick = onClick
				),
			textAlign = TextAlign.Center
		)
	}
}

@Composable
fun FormulaString(
	@StringRes text: Int,
	color: Color,
) {
	TitleWideContent(
		text = R.string.formula,
		icon = R.drawable.baseline_functions_24,
		color = color,
	) {
		SingleWideCard(
		) {
			BodyText(
				text = text
			)
		}
	}
}

@Composable
fun FormulaStringContent(
	color: Color,
	content: @Composable () -> Unit
) {
	Column {
		TitleWideContent(
			text = R.string.formula,
			icon = R.drawable.baseline_functions_24,
			color = color,
		) {
			SingleWideCard {
				content()
			}
		}
	}
}

@Composable
fun PopOutCard(
	modifier: Modifier = Modifier,
	@DrawableRes icon: Int,
	@StringRes title: Int,
	@StringRes body: Int,
	backgroundCardColor: Color = MaterialTheme.colorScheme.tertiary,
	contentColor: Color = MaterialTheme.colorScheme.onTertiary
) {
	Column(modifier = modifier) {
		SingleWideCard(
			backgroundCardColor = backgroundCardColor,
			contentColor = contentColor
		) {
			Row(
				verticalAlignment = Alignment.CenterVertically,
			) {
				Icon(
					modifier = Modifier
						.size(dimensionResource(id = R.dimen.icon_size_medium))
						.weight(1f),
					painter = painterResource(id = icon),
					contentDescription = null,
					tint = contentColor
				)
				Column(
					modifier = Modifier
						.weight(10f),
					horizontalAlignment = Alignment.CenterHorizontally
				) {
					HeaderText(
						text = title,
						color = contentColor
					)
					BodyText(
						text = body,
						style = MaterialTheme.typography.bodyMedium,
						textAlign = TextAlign.Center,
						color = contentColor
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
	shape: Shape = Shapes.large
) {
	Column(
		modifier = modifier,
	) {
		OutlinedCard(
			colors = CardDefaults.cardColors(
				containerColor = containerColor,
				contentColor = contentColor,
			),
			border = BorderStroke(width = 4.dp, color = contentColor),
			shape = shape
		) {
			BodyText(
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.padding_large)),
				text = text,
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

@Composable
fun SwitchThemeToggle(
	modifier: Modifier = Modifier,
) {
	Column(modifier = modifier) {
		Text(
			text = "Theme Switch",
			style = MaterialTheme.typography.headlineLarge,
			textAlign = TextAlign.Center,
		)
		Switch(
			checked = isSystemInDarkTheme(),
			onCheckedChange = { /* TODO */
			}
		)
	}
}

@Preview(showBackground = true)
@Composable
fun SwitchThemePreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		SwitchThemeToggle()
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
		UnitButtonCard(
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
fun RadioButtonPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		UnitButtonCard(
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
fun TitleTextIconPreview() {
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			TitleTextIcon(
				icon = R.drawable.ic_conversion,
				text = R.string.converters,
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun TitleTextIconPreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		) {
			TitleTextIcon(
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
				title = R.string.text_welcome_compatibility_title,
				body = R.string.text_welcome_compatibility_2
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
				title = R.string.text_welcome_compatibility_title,
				body = R.string.text_welcome_compatibility_2
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
			TitleWideContent(
				text = R.string.app_name,
				icon = R.drawable.baseline_info_24
			) {
				SingleWideCard {
					BodyText(text = R.string.text_welcome)
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
			TitleWideContent(
				text = R.string.app_name,
				icon = R.drawable.baseline_info_24
			) {
				SingleWideCard {
					BodyText(text = R.string.text_welcome)
				}
			}
		}
	}
}