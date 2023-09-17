package com.ccaquatics.aquariuminformation.ui.commonui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ccaquatics.aquariuminformation.ui.theme.AquariumInformationTheme
import com.ccaquatics.aquariuminformation.ui.theme.Shapes
import com.example.aquariuminformation.R

@Composable
fun NavButton(
	modifier: Modifier = Modifier,
	shape: Shape = Shapes.large,
	containerColor: Color = MaterialTheme.colorScheme.background,
	contentColor: Color = MaterialTheme.colorScheme.onBackground,
	@StringRes title: Int,
	@DrawableRes icon: Int,
	onClick: () -> Unit,
){
	Button(
		modifier = modifier,
		onClick = onClick,
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
				.padding(dimensionResource(id = R.dimen.padding_small))
				.height(dimensionResource(id = R.dimen.button_height_medium)),
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally,
		) {
			Text(
				text = stringResource(id = title),
			)
			Icon(
				painter = painterResource(id = icon),
				contentDescription = null,
				modifier = Modifier
					.padding(top = dimensionResource(id = R.dimen.padding_small)),
			)
		}
	}
}

@Composable
fun NavRowButton(
	modifier: Modifier = Modifier,
	shape: Shape = Shapes.large,
	containerColor: Color = MaterialTheme.colorScheme.background,
	contentColor: Color = MaterialTheme.colorScheme.onBackground,
	@StringRes title: Int,
	@DrawableRes icon: Int,
	onClick: () -> Unit
){
	Row(
		modifier = modifier
	) {
		Button(
			modifier = Modifier
				.fillMaxWidth(fraction = 0.9f)
				.padding(
					top = dimensionResource(id = R.dimen.padding_small),
					bottom = dimensionResource(id = R.dimen.padding_small),
					end = dimensionResource(id = R.dimen.padding_small),
				),
			onClick = onClick,
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
			Row(
				modifier = Modifier
					.padding(dimensionResource(id = R.dimen.padding_small))
					.height(dimensionResource(id = R.dimen.button_height_medium)),
				verticalAlignment = Alignment.CenterVertically
			) {
				Icon(
					modifier = Modifier
						.padding(end = dimensionResource(id = R.dimen.padding_small)),
					painter = painterResource(id = icon),
					contentDescription = null
				)
				Text(
					text = stringResource(id = title)
				)
			}
		}
	}
}

@Composable
fun NavButtonRow(
	modifier: Modifier = Modifier,
	@StringRes title1: Int,
	@DrawableRes icon1: Int,
	@StringRes title2: Int,
	@DrawableRes icon2: Int,
	containerColor: Color = MaterialTheme.colorScheme.background,
	contentColor: Color = MaterialTheme.colorScheme.onBackground,
	onClick1: () -> Unit,
	onClick2: () -> Unit
){
	Row(
		modifier = modifier.fillMaxWidth(fraction = 0.9f)
	) {
		NavButton(
			modifier = Modifier
				.weight(1f)
				.fillMaxWidth(fraction = 0.9f)
				.padding(
					top = dimensionResource(id = R.dimen.padding_small),
					bottom = dimensionResource(id = R.dimen.padding_small),
					end = dimensionResource(id = R.dimen.padding_small),
				),
			title = title1,
			icon = icon1,
			containerColor = containerColor,
			contentColor = contentColor,
			onClick = onClick1
		)
		NavButton(
			modifier = Modifier
				.weight(1f)
				.padding(
					top = dimensionResource(id = R.dimen.padding_small),
					bottom = dimensionResource(id = R.dimen.padding_small),
					start = dimensionResource(id = R.dimen.padding_small),
				),
			title = title2,
			icon = icon2,
			containerColor = containerColor,
			contentColor = contentColor,
			onClick = onClick2
		)
	}
}


@Preview(showBackground = true)
@Composable
fun NavRowButtonPreview(){
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		){
			NavRowButton(
				title = R.string.converters,
				icon = R.drawable.baseline_home_24,
				onClick = {}
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun NavRowButtonPreviewDark(
){
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		){
			NavRowButton(
				title = R.string.converters,
				icon =  R.drawable.baseline_home_24,
				onClick = {}
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun NavButtonRowPreview(){
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		){
			NavButtonRow(
				title1 = R.string.converters,
				icon1 = R.drawable.baseline_home_24,
				title2 = R.string.calculators,
				icon2 = R.drawable.baseline_email_24,
				onClick1 = {},
				onClick2 = {},
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun NavButtonRowPreviewDark(
){
	AquariumInformationTheme(useDarkTheme = true) {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		){
			NavButtonRow(
				title1 = R.string.converters,
				icon1 = R.drawable.baseline_email_24,
				title2 = R.string.calculators,
				icon2 = R.drawable.baseline_home_24,
				onClick1 = {},
				onClick2 = {},
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun NavButtonPreview(){
	AquariumInformationTheme {
		Column(
			modifier = Modifier
				.background(color = MaterialTheme.colorScheme.background)
		){
			NavButton(
				title = R.string.converters,
				icon = R.drawable.baseline_email_24,
				onClick = {}
			)
		}
	}
}

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
				title = R.string.converters,
				icon = R.drawable.baseline_email_24,
				onClick = {}
			)
		}
	}
}