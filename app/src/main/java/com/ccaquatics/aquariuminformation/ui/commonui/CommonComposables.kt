package com.ccaquatics.aquariuminformation.ui.commonui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.ccaquatics.aquariuminformation.BuildConfig
import com.ccaquatics.aquariuminformation.R
import com.ccaquatics.aquariuminformation.data.calculators.alkalinityDataSource
import com.ccaquatics.aquariuminformation.data.calculators.salinityDataSource
import com.ccaquatics.aquariuminformation.data.tankvolumes.calculatorDataSource
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme
import com.ccaquatics.aquariuminformation.ui.theme.Shapes

@Composable
fun FancyIndicator(
	selectedColor: Color,
	modifier: Modifier = Modifier,
	shape: Shape = Shapes.large,
) {
	Box(
		modifier = modifier
			.padding(5.dp)
			.height(3.dp)
			.border(
				BorderStroke(
					50.dp,
					selectedColor
				), shape
			)
	)
}

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

@Composable
fun AppVersion(
) {
	val version = BuildConfig.VERSION_NAME

	Row(
		horizontalArrangement = Arrangement.Center,
	) {
		Text(
			text = stringResource(R.string.app_version)
		)
		Text(
			text = stringResource(id = R.string.text_label_version, version),
		)
	}
}

@Composable
fun SingleWideCard(
	modifier: Modifier = Modifier,
	shape: Shape = Shapes.large,
	containerColor: Color = MaterialTheme.colorScheme.background,
	contentColor: Color = MaterialTheme.colorScheme.onBackground,
	content: @Composable ColumnScope.() -> Unit,
) {
	Column(modifier = modifier) {
		ElevatedCard(
			modifier = Modifier
				.padding(bottom = dimensionResource(id = R.dimen.padding_medium))
				.fillMaxWidth(fraction = 0.9f),
			shape = shape,
			colors = CardDefaults.cardColors(
				containerColor = containerColor,
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
				horizontalAlignment = Alignment.CenterHorizontally,
			) {
				content()
			}
		}
	}
}

@Composable
fun SingleWideCardExpandable(
	modifier: Modifier = Modifier,
	shape: Shape = Shapes.large,
	@StringRes header: Int,
	containerColor: Color = MaterialTheme.colorScheme.background,
	contentColor: Color = MaterialTheme.colorScheme.onBackground,
	content: @Composable ColumnScope.() -> Unit = {},
) {
	var expanded by remember {
		mutableStateOf(false)
	}

	Column(modifier = modifier) {
		ElevatedCard(
			shape = shape,
			colors = CardDefaults.cardColors(
				containerColor = containerColor,
				contentColor = contentColor
			),
		) {
			Row(
				modifier = Modifier
					.fillMaxWidth()
					.animateContentSize(
						animationSpec = spring(
							dampingRatio = Spring.DampingRatioMediumBouncy,
							stiffness = Spring.StiffnessLow
						),
					)
			) {
				Column(
					modifier = Modifier
						.fillMaxWidth()
						.padding(horizontal = dimensionResource(id = R.dimen.padding_small)),
					horizontalAlignment = Alignment.CenterHorizontally
				) {
					Row(
						modifier = Modifier
							.clickable { expanded = !expanded }
							.fillMaxWidth(),
						verticalAlignment = Alignment.CenterVertically,
						horizontalArrangement = Arrangement.SpaceBetween
					) {
						HeaderText(
							text = header,
							color = contentColor
						)
						IconButton(
							onClick = { expanded = !expanded },
						) {
							Icon(
								painter = if (expanded)
									painterResource(id = R.drawable.ic_expand_less)
								else painterResource(id = R.drawable.ic_expand_more),
								contentDescription = if (expanded) {
									stringResource(R.string.text_show_less)
								} else {
									stringResource(R.string.text_show_more)
								},
							)
						}
					}
					if (expanded) {
						Column(modifier = Modifier.selectableGroup()) {
							content()
							SmallSpacer()
						}
					}
				}
			}
		}
	}
}

@Composable
fun UnitButtonCard(
	modifier: Modifier = Modifier,
	header: Int = R.string.select_input_units,
	content: @Composable RowScope.() -> Unit,
	containerColor: Color = MaterialTheme.colorScheme.background,
	contentColor: Color,
	shape: Shape = Shapes.large,
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
					text = header,
					color = contentColor
				)
//				SmallSpacer()
				Row(
					modifier = Modifier
						.selectableGroup()
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
					.padding(dimensionResource(id = R.dimen.padding_small))
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
fun LabelWaterWeight() {
	BodyText(text = calculatorDataSource.labelWaterWeight)
}

@Composable
fun LabelSalinity() {
	BodyText(text = salinityDataSource.labelSalinity)
}

@Composable
fun LabelSpecificGravity() {
	BodyText(text = salinityDataSource.labelSpecificGravity)
}

@Composable
fun LabelConductivity() {
	BodyText(text = salinityDataSource.labelConductivity)
}

//@Composable
//fun RadioButtonComposable(
//	modifier: Modifier = Modifier,
//	@StringRes text: Int,
//	onClick: () -> Unit,
//	selected: Int,
//	selectedColor: Color = MaterialTheme.colorScheme.primary,
//	unselectedColor: Color = MaterialTheme.colorScheme.outline,
//	textColor: Color = MaterialTheme.colorScheme.onBackground,
//) {
//	Column(
//		modifier = modifier,
//		horizontalAlignment = Alignment.CenterHorizontally
//	) {
//		RadioButton(
//			selected = selected == text,
//			onClick = onClick,
//			colors = RadioButtonDefaults.colors(
//				selectedColor = selectedColor,
//				unselectedColor = unselectedColor
//			)
//		)
//		RadioText(
//			text = text,
//			modifier = Modifier
//				.padding(horizontal = dimensionResource(id = R.dimen.padding_verySmall))
//				.clickable(
//					onClick = onClick
//				),
//			textAlign = TextAlign.Center,
//			color = textColor
//		)
//	}
//}

@Composable
fun RadioButtonComposable(
	modifier: Modifier = Modifier,
	@StringRes text: Int,
	onClick: () -> Unit,
	selected: Boolean,
	selectedColor: Color = MaterialTheme.colorScheme.primary,
	unselectedColor: Color = MaterialTheme.colorScheme.outline,
	textColor: Color = MaterialTheme.colorScheme.onBackground,
) {
	Column(
		modifier = modifier,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		RadioButton(
			selected = selected,
			onClick = onClick,
			colors = RadioButtonDefaults.colors(
				selectedColor = selectedColor,
				unselectedColor = unselectedColor
			)
		)
		RadioText(
			text = text,
			modifier = Modifier
				.padding(
					bottom = dimensionResource(id = R.dimen.padding_verySmall),
				)
				.clickable(
					onClick = onClick
				),
			textAlign = TextAlign.Center,
			color = textColor
		)
	}
}

@Composable
fun TankVolumeResults(
	modifier: Modifier = Modifier,
	contentColor: Color,
	calculatedValue1: Double,
	calculatedValue2: Double,
	calculatedValue3: Double,
) {
	Column(
		modifier = modifier,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		CalculatedText(
			text = calculatorDataSource.calculatedTextGallons,
			calculatedValue = calculatedValue1,
			textColor = contentColor,
		)
		CalculatedText(
			text = calculatorDataSource.calculatedTextLiters,
			calculatedValue = calculatedValue2,
			textColor = contentColor,
		)
		VerySmallSpacer()
		LabelWaterWeight()
		CalculatedText(
			text = calculatorDataSource.calculatedTextWaterWeight,
			calculatedValue = calculatedValue3,
			textColor = contentColor,
		)
	}

}

@Composable
fun RadioButtonTwoUnits(
	modifier: Modifier = Modifier,
	onClick1: () -> Unit,
	onClick2: () -> Unit,
	@StringRes label1: Int = calculatorDataSource.radioTextFeet,
	@StringRes label2: Int = calculatorDataSource.radioTextInches,
	selected: Int,
	selectedColor: Color,
	textColor: Color,

	) {
	Row(modifier = modifier) {
		RadioButtonComposable(
			modifier = Modifier
				.weight(1f),
			text = label1,
			onClick = onClick1,
			selected = selected == label1,
			selectedColor = selectedColor,
			textColor =
			if (selected == label1) textColor
			else MaterialTheme.colorScheme.onBackground
		)
		RadioButtonComposable(
			modifier = Modifier
				.weight(1f),
			text = label2,
			onClick = onClick2,
			selected = selected == label2,
			selectedColor = selectedColor,
			textColor =
			if (selected == label2) textColor
			else MaterialTheme.colorScheme.onBackground
		)
	}
}

@Composable
fun RadioButtonThreeUnits(
	modifier: Modifier = Modifier,
	onClick1: () -> Unit,
	onClick2: () -> Unit,
	onClick3: () -> Unit,
	@StringRes label1: Int = alkalinityDataSource.radioTextDkh,
	@StringRes label2: Int = alkalinityDataSource.radioTextPpm,
	@StringRes label3: Int = alkalinityDataSource.radioTextMeq,
	selected: Int,
	selectedColor: Color,
	textColor: Color,

	) {
	Row(modifier = modifier) {
		RadioButtonComposable(
			modifier = Modifier
				.weight(1f),
			text = label1,
			onClick = onClick1,
			selected = selected == label1,
			selectedColor = selectedColor,
			textColor =
			if (selected == label1) textColor
			else MaterialTheme.colorScheme.onBackground
		)
		RadioButtonComposable(
			modifier = Modifier
				.weight(1f),
			text = label2,
			onClick = onClick2,
			selected = selected == label2,
			selectedColor = selectedColor,
			textColor =
			if (selected == label2) textColor
			else MaterialTheme.colorScheme.onBackground
		)
		RadioButtonComposable(
			modifier = Modifier
				.weight(1f),
			text = label3,
			onClick = onClick3,
			selected = selected == label3,
			selectedColor = selectedColor,
			textColor =
			if (selected == label3) textColor
			else MaterialTheme.colorScheme.onBackground
		)
	}
}

//@Composable
//fun RadioButtonSalinityUnits(
//	modifier: Modifier = Modifier,
//	onClick1: () -> Unit,
//	onClick2: () -> Unit,
//	selected: Int,
//	selectedColor: Color,
//	textColor: Color,
//) {
//	Row(modifier = modifier) {
//		RadioButtonComposable(
//			modifier = Modifier.weight(1f),
//			text = salinityDataSource.radioTextPpt,
//			onClick = onClick1,
//			selected = selected == salinityDataSource.radioTextPpt,
//			selectedColor = selectedColor,
//			textColor =
//			if (selected == salinityDataSource.radioTextPpt) textColor
//			else MaterialTheme.colorScheme.onBackground
//		)
//		RadioButtonComposable(
//			modifier = Modifier.weight(1f),
//			text = salinityDataSource.radioTextSg,
//			onClick = onClick2,
//			selected = selected == salinityDataSource.radioTextSg,
//			selectedColor = selectedColor,
//			textColor =
//			if (selected == salinityDataSource.radioTextSg) textColor
//			else MaterialTheme.colorScheme.onBackground
//		)
//	}
//}

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
		SingleWideCard {
			BodyText(
				text = text,
				color = color
			)
		}
	}
}

@Composable
fun FormulaStringContent(
	modifier: Modifier = Modifier,
	color: Color,
	content: @Composable () -> Unit,
	containerColor: Color = MaterialTheme.colorScheme.background
) {
	Column(modifier = modifier) {
		TitleWideContent(
			text = R.string.formula,
			icon = R.drawable.baseline_functions_24,
			color = color,
		) {
			SingleWideCardExpandable(
				modifier = Modifier
					.fillMaxWidth(fraction = 0.8f)
					.padding(vertical = dimensionResource(id = R.dimen.padding_small)),
				header = R.string.tap_to_expand,
				containerColor = containerColor,
				contentColor = color

			) {
				Column(
					horizontalAlignment = Alignment.Start
				) {
					content()
				}
			}
		}
	}
}

@Composable
fun FormulaStringContentExpandable(
	modifier: Modifier = Modifier,
	color: Color,
	content: @Composable () -> Unit,
	containerColor: Color = MaterialTheme.colorScheme.background
) {
	Column(modifier = modifier) {
		TitleWideContent(
			text = R.string.formula,
			icon = R.drawable.baseline_functions_24,
			color = color,
		) {
			SingleWideCardExpandable(
				modifier = Modifier
					.fillMaxWidth(fraction = 0.8f)
					.padding(vertical = dimensionResource(id = R.dimen.padding_small)),
				header = R.string.tap_to_expand,
				containerColor = containerColor,
				contentColor = color

			) {
				Column(
					horizontalAlignment = Alignment.Start
				) {
					content()
				}
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
	backgroundCardColor: Color = MaterialTheme.colorScheme.tertiaryContainer,
	contentColor: Color = MaterialTheme.colorScheme.onTertiaryContainer
) {
	Column(modifier = modifier) {
		SingleWideCard(
			containerColor = backgroundCardColor,
			contentColor = contentColor
		) {
			Row(
				verticalAlignment = Alignment.CenterVertically,
			) {
				Icon(
					modifier = Modifier
						.size(dimensionResource(id = R.dimen.icon_size_small))
						.weight(2f),
					painter = painterResource(id = icon),
					contentDescription = null,
					tint = contentColor
				)
				Column(
					modifier = Modifier
						.weight(11f),
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
				color = contentColor
			)
		}
	}
}

@Composable
fun ThemeSwitch() {
	var isDarkTheme by remember { mutableStateOf(true) }

	AquariumInformationTheme(useDarkTheme = isDarkTheme) {
		Row(
			verticalAlignment = Alignment.CenterVertically,
			modifier = Modifier
				.fillMaxWidth()
				.padding(
					horizontal = 16.dp,
					vertical = 10.dp
				),
			horizontalArrangement = Arrangement.spacedBy(8.dp)
		) {
			Text("☀️")
			Switch(
				checked = isDarkTheme,
				onCheckedChange = {
					isDarkTheme = it
				}
			)
			Text("🌘")
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
fun SingleWideCardExpandablePreviewDark(
) {
	AquariumInformationTheme(useDarkTheme = true) {
		SingleWideCardExpandable(header = calculatorDataSource.labelCylinderType)
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
			focusedColor = MaterialTheme.colorScheme.onPrimaryContainer,
			focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
			unfocusedColor = MaterialTheme.colorScheme.primary,
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
			focusedColor = MaterialTheme.colorScheme.onPrimaryContainer,
			focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
			unfocusedColor = MaterialTheme.colorScheme.primary,
		)
	}
}

//@Preview(showBackground = true)
//@Composable
//fun RadioButtonCardPreview() {
//	AquariumInformationTheme {
//		UnitButtonCard(
//			contentColor = MaterialTheme.colorScheme.primary,
//			content = {
//				RadioButtonComposable(
//					text = R.string.text_celsius,
//					onClick = { },
//					selected = 1,
//					selectedColor = MaterialTheme.colorScheme.primary,
//					unselectedColor = MaterialTheme.colorScheme.onPrimary,
//				)
//				RadioButtonComposable(
//					text = R.string.text_fah,
//					onClick = { },
//					selected = 1,
//					selectedColor = MaterialTheme.colorScheme.primary,
//					unselectedColor = MaterialTheme.colorScheme.onPrimary,
//				)
//			}
//		)
//	}
//}

//@Preview(showBackground = true)
//@Composable
//fun RadioButtonPreviewDark(
//) {
//	AquariumInformationTheme(useDarkTheme = true) {
//		UnitButtonCard(
//			contentColor = MaterialTheme.colorScheme.primary,
//			content = {
//				RadioButtonComposable(
//					text = R.string.text_celsius,
//					onClick = { },
//					selected = 1,
//					selectedColor = MaterialTheme.colorScheme.primary,
//					unselectedColor = MaterialTheme.colorScheme.onPrimary,
//				)
//				RadioButtonComposable(
//					text = R.string.text_fah,
//					onClick = { },
//					selected = 1,
//					selectedColor = MaterialTheme.colorScheme.primary,
//					unselectedColor = MaterialTheme.colorScheme.onPrimary,
//				)
//			}
//		)
//	}
//}

@Preview(showBackground = true)
@Composable
fun AppInfoPreview() {
	AquariumInformationTheme {
		AppVersion()
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