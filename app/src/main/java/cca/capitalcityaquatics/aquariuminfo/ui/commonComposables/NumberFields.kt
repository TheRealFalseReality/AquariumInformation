package cca.capitalcityaquatics.aquariuminfo.ui.commonComposables

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
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

@Composable
fun EditNumberFieldSingle (
    modifier: Modifier = Modifier,
    @StringRes label: Int,
    value: String,
    onValueChange: (String) -> Unit,
){
    val focusManager = LocalFocusManager.current

    TextField(
        label = {
            Text(stringResource(id = label),
                color = Color.DarkGray
            ) },
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
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
            backgroundColor = colorResource(id = R.color.blue_lt_2),
            textColor = Color.Black
        ),
    )
}

@Composable
fun EditNumberField2Vert (
    modifier: Modifier = Modifier,
    @StringRes label1: Int,
    @StringRes label2: Int,
    value1: String,
    value2: String,
    onValueChange1: (String) -> Unit,
    onValueChange2: (String) -> Unit,
){
    val focusManager = LocalFocusManager.current

    Column {
        TextField(
            label = {
                Text(stringResource(id = label1),
                    color = Color.DarkGray
                ) },
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = value1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            onValueChange = onValueChange1,
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Next) }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = colorResource(id = R.color.blue_lt_2),
                textColor = Color.Black
            ),
        )
        TextField(
            label = {
                Text(stringResource(id = label2),
                    color = Color.DarkGray
                ) },
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = value2,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            onValueChange = onValueChange2,
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = colorResource(id = R.color.blue_lt_2),
                textColor = Color.Black
            ),
        )
    }
}

@Composable
fun EditNumberField3Hor (
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
){
    val focusManager = LocalFocusManager.current

    Row {
        TextField(
            label = {
                Text(stringResource(id = label1),
                    color = Color.DarkGray
                ) },
            modifier = modifier
                .padding(bottom = 16.dp)
                .weight(1f),
            value = value1,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            onValueChange = onValueChange1,
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Next) }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = colorResource(id = R.color.blue_lt_2),
                textColor = Color.Black
            )
        )
        TextField(
            label = {
                Text(stringResource(id = label2),
                    color = Color.DarkGray
                ) },
            modifier = modifier
                .padding(start = 2.dp, end = 2.dp, bottom = 16.dp)
                .weight(1f),
            value = value2,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            onValueChange = onValueChange2,
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Next) }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = colorResource(id = R.color.blue_lt_2),
                textColor = Color.Black
            )
        )
        TextField(
            label = {
                Text(stringResource(id = label3),
                    color = Color.DarkGray
                ) },
            modifier = modifier
                .padding(bottom = 16.dp)
                .weight(1f),
            value = value3,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            onValueChange = onValueChange3,
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = colorResource(id = R.color.blue_lt_2),
                textColor = Color.Black
            )
        )
    }
}

@Composable
fun EditNumberField2Hor (
    modifier: Modifier = Modifier,
    @StringRes label1: Int,
    @StringRes label2: Int,
    value1: String,
    value2: String,
    onValueChange1: (String) -> Unit,
    onValueChange2: (String) -> Unit,
){
    val focusManager = LocalFocusManager.current

    Row {
        TextField(
            label = {
                Text(stringResource(id = label1),
                    color = Color.DarkGray
                ) },
            modifier = modifier
                .padding(bottom = 16.dp)
                .weight(1f),
            value = value1,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            onValueChange = onValueChange1,
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Next) }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = colorResource(id = R.color.blue_lt_2),
                textColor = Color.Black
            )
        )
        TextField(
            label = {
                Text(stringResource(id = label2),
                    color = Color.DarkGray
                ) },
            modifier = modifier
                .padding(start = 2.dp, end = 2.dp, bottom = 16.dp)
                .weight(1f),
            value = value2,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            onValueChange = onValueChange2,
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = colorResource(id = R.color.blue_lt_2),
                textColor = Color.Black
            )
        )
    }
}

@Composable
fun EditNumberFieldQuad (
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
){
    val focusManager = LocalFocusManager.current

    Row {
        TextField(
            label = {
                Text(stringResource(id = label1),
                    color = Color.DarkGray
                ) },
            modifier = modifier
                .padding(bottom = 16.dp)
                .weight(1f),
            value = value1,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            onValueChange = onValueChange1,
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Next) }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = colorResource(id = R.color.blue_lt_2),
                textColor = Color.Black
            )
        )
        TextField(
            label = {
                Text(stringResource(id = label2),
                    color = Color.DarkGray
                ) },
            modifier = modifier
                .padding(start = 2.dp, end = 2.dp, bottom = 16.dp)
                .weight(1f),
            value = value2,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            onValueChange = onValueChange2,
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Next) }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = colorResource(id = R.color.blue_lt_2),
                textColor = Color.Black
            )
        )
    }
    Row {
        TextField(
            label = {
                Text(stringResource(id = label3),
                    color = Color.DarkGray
                ) },
            modifier = modifier
                .padding(bottom = 16.dp)
                .weight(1f),
            value = value3,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            onValueChange = onValueChange3,
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Next) }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = colorResource(id = R.color.blue_lt_2),
                textColor = Color.Black
            )
        )
        TextField(
            label = {
                Text(stringResource(id = label4),
                    color = Color.DarkGray
                ) },
            modifier = modifier
                .padding(start = 2.dp, end = 2.dp, bottom = 16.dp)
                .weight(1f),
            value = value4,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            onValueChange = onValueChange4,
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = colorResource(id = R.color.blue_lt_2),
                textColor = Color.Black
            )
        )
    }
}