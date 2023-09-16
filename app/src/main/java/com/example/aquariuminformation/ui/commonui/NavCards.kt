package com.example.aquariuminformation.ui.commonui

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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.aquariuminformation.R
import com.example.aquariuminformation.ui.theme.AquariumInformationTheme
import com.example.aquariuminformation.ui.theme.Shapes

@Composable
fun NavButton(
	modifier: Modifier = Modifier,
	shape: Shape = Shapes.large,
	containerColor: Color = MaterialTheme.colorScheme.background,
	contentColor: Color = MaterialTheme.colorScheme.onBackground,
	title: String,
	icon: Painter,
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
				text = title
			)
			Icon(
				painter = icon,
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
	title: String,
	icon: Painter,
	onClick: () -> Unit
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
		Row(
			modifier = Modifier
				.padding(dimensionResource(id = R.dimen.padding_small))
				.height(dimensionResource(id = R.dimen.button_height_medium)),
			verticalAlignment = Alignment.CenterVertically
		) {
			Icon(
				modifier = Modifier
					.padding(end = dimensionResource(id = R.dimen.padding_small)),
				painter = icon,
				contentDescription = null
			)
			Text(
				text = title
			)
		}
	}
}

@Composable
fun NavButtonRow(
	modifier: Modifier = Modifier,
	title1: String,
	icon1: Painter,
	title2: String,
	icon2: Painter,
	containerColor: Color = MaterialTheme.colorScheme.background,
	contentColor: Color = MaterialTheme.colorScheme.onBackground,
	onClick1: () -> Unit,
	onClick2: () -> Unit
){
	Row(
		modifier = modifier
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
				title = stringResource(id = R.string.converters),
				icon = painterResource(id = R.drawable.baseline_home_24),
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
				title = stringResource(R.string.converters),
				icon = painterResource(id = R.drawable.baseline_home_24),
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
				title1 = stringResource(id = R.string.converters),
				icon1 = painterResource(id = R.drawable.baseline_home_24),
				title2 = stringResource(R.string.calculators),
				icon2 = painterResource(id = R.drawable.baseline_email_24),
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
				title1 = stringResource(id = R.string.converters),
				icon1 = painterResource(id = R.drawable.baseline_email_24),
				title2 = stringResource(R.string.calculators),
				icon2 = painterResource(id = R.drawable.baseline_home_24),
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
				title = stringResource(R.string.converters),
				icon = painterResource(id = R.drawable.baseline_email_24),
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
				title = stringResource(R.string.converters),
				icon = painterResource(id = R.drawable.baseline_email_24),
				onClick = {}
			)
		}
	}
}