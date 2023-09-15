package com.example.aquariuminformation.ui.commonui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import com.example.aquariuminformation.R
import com.example.aquariuminformation.ui.theme.Shapes

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