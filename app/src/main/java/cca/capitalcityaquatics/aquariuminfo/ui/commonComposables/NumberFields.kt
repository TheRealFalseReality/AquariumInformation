package cca.capitalcityaquatics.aquariuminfo.ui.commonComposables

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.ui.theme.Shapes

@Composable
fun EditNumberFieldSingle(
	modifier: Modifier = Modifier,
	@StringRes label: Int,
	value: String,
	onValueChange: (String) -> Unit,
) {
	val focusManager = LocalFocusManager.current

	Spacer(modifier = Modifier.height(12.dp))

	TextField(
		placeholder = {
			Text(
				stringResource(id = label),
				color = Color.DarkGray
			)
		},
		modifier = modifier
			.widthIn(max = 500.dp)
			.padding(start = 16.dp, end = 16.dp),
		value = value,
		singleLine = true,
		keyboardOptions = KeyboardOptions(
			keyboardType = KeyboardType.Number,
			imeAction = ImeAction.Done
		),
		onValueChange = onValueChange,
		keyboardActions = KeyboardActions(
			onDone = { focusManager.clearFocus() }
		),
		colors = TextFieldDefaults.textFieldColors(
			containerColor = colorResource(id = R.color.blue_lt_2),
			textColor = Color.Black
		),
		shape = Shapes.medium
	)
}

@Composable
fun EditNumberField2Vert(
	modifier: Modifier = Modifier,
	@StringRes label1: Int,
	@StringRes label2: Int,
	value1: String,
	value2: String,
	onValueChange1: (String) -> Unit,
	onValueChange2: (String) -> Unit,
) {
	val focusManager = LocalFocusManager.current

	Column {

		Spacer(modifier = Modifier.height(12.dp))

		TextField(
			placeholder = {
				Text(
					stringResource(id = label1),
					color = Color.DarkGray
				)
			},
			modifier = modifier
				.widthIn(max = 500.dp)
				.padding(start = 16.dp, end = 16.dp),
			value = value1,
			singleLine = true,
			keyboardOptions = KeyboardOptions(
				keyboardType = KeyboardType.Number,
				imeAction = ImeAction.Next
			),
			shape = Shapes.medium,
			onValueChange = onValueChange1,
			keyboardActions = KeyboardActions(
				onNext = { focusManager.moveFocus(FocusDirection.Next) }
			),
			colors = TextFieldDefaults.textFieldColors(
				containerColor = colorResource(id = R.color.blue_lt_2),
				textColor = Color.Black
			),
		)

		Spacer(modifier = Modifier.height(12.dp))

		TextField(
			placeholder = {
				Text(
					stringResource(id = label2),
					color = Color.DarkGray
				)
			},
			modifier = modifier
				.widthIn(max = 500.dp)
				.padding(start = 16.dp, end = 16.dp),
			value = value2,
			singleLine = true,
			keyboardOptions = KeyboardOptions(
				keyboardType = KeyboardType.Number,
				imeAction = ImeAction.Done
			),
			shape = Shapes.medium,
			onValueChange = onValueChange2,
			keyboardActions = KeyboardActions(
				onDone = { focusManager.clearFocus() }
			),
			colors = TextFieldDefaults.textFieldColors(
				containerColor = colorResource(id = R.color.blue_lt_2),
				textColor = Color.Black
			),
		)

		Spacer(modifier = Modifier.height(12.dp))
	}
}

@Composable
fun EditNumberField3Hor(
	modifier: Modifier = Modifier,
	@StringRes label1: Int,
	@StringRes label2: Int,
	@StringRes label3: Int,
	value1: String,
	value2: String,
	value3: String,
	onValueChange1: (String) -> Unit,
	onValueChange2: (String) -> Unit,
	onValueChange3: (String) -> Unit,
) {
	val focusManager = LocalFocusManager.current

	Row(
		modifier = modifier
			.widthIn(max = 500.dp)
	) {

		Spacer(modifier = Modifier.height(12.dp))

		TextField(
			placeholder = {
				Text(
					stringResource(id = label1),
					color = Color.DarkGray
				)
			},
			modifier = modifier
				.padding(bottom = 16.dp)
				.weight(1f),
			value = value1,
			keyboardOptions = KeyboardOptions(
				keyboardType = KeyboardType.Number,
				imeAction = ImeAction.Next
			),
			shape = Shapes.medium,
			onValueChange = onValueChange1,
			keyboardActions = KeyboardActions(
				onNext = { focusManager.moveFocus(FocusDirection.Next) }
			),
			colors = TextFieldDefaults.textFieldColors(
				containerColor = colorResource(id = R.color.blue_lt_2),
				textColor = Color.Black
			)
		)

		Spacer(modifier = Modifier.width(4.dp))

		TextField(
			placeholder = {
				Text(
					stringResource(id = label2),
					color = Color.DarkGray
				)
			},
			modifier = modifier
				.padding(start = 2.dp, end = 2.dp, bottom = 16.dp)
				.weight(1f),
			value = value2,
			keyboardOptions = KeyboardOptions(
				keyboardType = KeyboardType.Number,
				imeAction = ImeAction.Next
			),
			shape = Shapes.medium,
			onValueChange = onValueChange2,
			keyboardActions = KeyboardActions(
				onNext = { focusManager.moveFocus(FocusDirection.Next) }
			),
			colors = TextFieldDefaults.textFieldColors(
				containerColor = colorResource(id = R.color.blue_lt_2),
				textColor = Color.Black
			)
		)

		Spacer(modifier = Modifier.width(4.dp))

		TextField(
			placeholder = {
				Text(
					stringResource(id = label3),
					color = Color.DarkGray
				)
			},
			modifier = modifier
				.padding(bottom = 16.dp)
				.weight(1f),
			value = value3,
			keyboardOptions = KeyboardOptions(
				keyboardType = KeyboardType.Number,
				imeAction = ImeAction.Done
			),
			shape = Shapes.medium,
			onValueChange = onValueChange3,
			keyboardActions = KeyboardActions(
				onDone = { focusManager.clearFocus() }
			),
			colors = TextFieldDefaults.textFieldColors(
				containerColor = colorResource(id = R.color.blue_lt_2),
				textColor = Color.Black
			)
		)
	}
}

@Composable
fun EditNumberField2Hor(
	modifier: Modifier = Modifier,
	@StringRes label1: Int,
	@StringRes label2: Int,
	value1: String,
	value2: String,
	onValueChange1: (String) -> Unit,
	onValueChange2: (String) -> Unit,
) {
	val focusManager = LocalFocusManager.current

	Row(
		modifier = modifier
			.widthIn(max = 500.dp)
	) {

		Spacer(modifier = Modifier.height(12.dp))

		TextField(
			placeholder = {
				Text(
					stringResource(id = label1),
					color = Color.DarkGray
				)
			},
			modifier = modifier
				.padding(bottom = 16.dp)
				.weight(1f),
			value = value1,
			keyboardOptions = KeyboardOptions(
				keyboardType = KeyboardType.Number,
				imeAction = ImeAction.Next
			),
			shape = Shapes.medium,
			onValueChange = onValueChange1,
			keyboardActions = KeyboardActions(
				onNext = { focusManager.moveFocus(FocusDirection.Next) }
			),
			colors = TextFieldDefaults.textFieldColors(
				containerColor = colorResource(id = R.color.blue_lt_2),
				textColor = Color.Black
			)
		)

		Spacer(modifier = Modifier.width(4.dp))

		TextField(
			placeholder = {
				Text(
					stringResource(id = label2),
					color = Color.DarkGray
				)
			},
			modifier = modifier
				.padding(start = 2.dp, end = 2.dp, bottom = 16.dp)
				.weight(1f),
			value = value2,
			keyboardOptions = KeyboardOptions(
				keyboardType = KeyboardType.Number,
				imeAction = ImeAction.Done
			),
			shape = Shapes.medium,
			onValueChange = onValueChange2,
			keyboardActions = KeyboardActions(
				onDone = { focusManager.clearFocus() }
			),
			colors = TextFieldDefaults.textFieldColors(
				containerColor = colorResource(id = R.color.blue_lt_2),
				textColor = Color.Black
			)
		)
	}
}

@Composable
fun EditNumberFieldQuad(
	modifier: Modifier = Modifier,
	@StringRes label1: Int,
	@StringRes label2: Int,
	@StringRes label3: Int,
	@StringRes label4: Int,
	value1: String,
	value2: String,
	value3: String,
	value4: String,
	onValueChange1: (String) -> Unit,
	onValueChange2: (String) -> Unit,
	onValueChange3: (String) -> Unit,
	onValueChange4: (String) -> Unit,
) {
	val focusManager = LocalFocusManager.current

	Row(
		modifier = modifier
			.widthIn(max = 500.dp)
	) {

		Spacer(modifier = Modifier.height(12.dp))

		TextField(
			placeholder = {
				Text(
					stringResource(id = label1),
					color = Color.DarkGray
				)
			},
			modifier = modifier
				.padding(bottom = 16.dp)
				.weight(1f),
			value = value1,
			keyboardOptions = KeyboardOptions(
				keyboardType = KeyboardType.Number,
				imeAction = ImeAction.Next
			),
			shape = Shapes.medium,
			onValueChange = onValueChange1,
			keyboardActions = KeyboardActions(
				onNext = { focusManager.moveFocus(FocusDirection.Next) }
			),
			colors = TextFieldDefaults.textFieldColors(
				containerColor = colorResource(id = R.color.blue_lt_2),
				textColor = Color.Black
			)
		)

		Spacer(modifier = Modifier.width(4.dp))

		TextField(
			placeholder = {
				Text(
					stringResource(id = label2),
					color = Color.DarkGray
				)
			},
			modifier = modifier
				.padding(start = 2.dp, end = 2.dp, bottom = 16.dp)
				.weight(1f),
			value = value2,
			keyboardOptions = KeyboardOptions(
				keyboardType = KeyboardType.Number,
				imeAction = ImeAction.Next
			),
			shape = Shapes.medium,
			onValueChange = onValueChange2,
			keyboardActions = KeyboardActions(
				onNext = { focusManager.moveFocus(FocusDirection.Next) }
			),
			colors = TextFieldDefaults.textFieldColors(
				containerColor = colorResource(id = R.color.blue_lt_2),
				textColor = Color.Black
			)
		)
	}
	Row(
		modifier = modifier
			.widthIn(max = 500.dp)
	) {
		TextField(
			placeholder = {
				Text(
					stringResource(id = label3),
					color = Color.DarkGray
				)
			},
			modifier = modifier
				.padding(bottom = 16.dp)
				.weight(1f),
			value = value3,
			keyboardOptions = KeyboardOptions(
				keyboardType = KeyboardType.Number,
				imeAction = ImeAction.Next
			),
			shape = Shapes.medium,
			onValueChange = onValueChange3,
			keyboardActions = KeyboardActions(
				onNext = { focusManager.moveFocus(FocusDirection.Next) }
			),
			colors = TextFieldDefaults.textFieldColors(
				containerColor = colorResource(id = R.color.blue_lt_2),
				textColor = Color.Black
			)
		)

		Spacer(modifier = Modifier.width(4.dp))

		TextField(
			placeholder = {
				Text(
					stringResource(id = label4),
					color = Color.DarkGray
				)
			},
			modifier = modifier
				.padding(start = 2.dp, end = 2.dp, bottom = 16.dp)
				.weight(1f),
			value = value4,
			keyboardOptions = KeyboardOptions(
				keyboardType = KeyboardType.Number,
				imeAction = ImeAction.Done
			),
			shape = Shapes.medium,
			onValueChange = onValueChange4,
			keyboardActions = KeyboardActions(
				onDone = { focusManager.clearFocus() }
			),
			colors = TextFieldDefaults.textFieldColors(
				containerColor = colorResource(id = R.color.blue_lt_2),
				textColor = Color.Black
			)
		)
	}
}