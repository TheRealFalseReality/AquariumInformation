package cca.capitalcityaquatics.aquariuminfo.ui.commonComposables

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cca.capitalcityaquatics.aquariuminfo.R

@Composable
fun DataOutputLines4(
	inputValue: String,
	@StringRes label: Int,
	onValueChange: (String) -> Unit,
	@StringRes equalsText: Int,
	@StringRes inputText: Int,
	@StringRes outputTextA: Int,
	valueA: Double,
	@StringRes outputTextB: Int,
	valueB: Double
) {
	Column(
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		EditNumberFieldSingle(
			label = label,
			value = inputValue,
			onValueChange = onValueChange
		)
		Text(
			text = (stringResource(id = inputText, inputValue)),
			modifier = Modifier
				.align(Alignment.CenterHorizontally),
			fontSize = 20.sp,
			fontWeight = FontWeight.Bold,
		)
		Spacer(
			modifier = Modifier
				.height(16.dp)
		)
		ContentBorder {
			Text(
				text = stringResource(id = equalsText),
				modifier = Modifier
					.align(Alignment.CenterHorizontally),
			)
			Spacer(
				modifier = Modifier
					.height(16.dp)
			)
			Text(
				text = stringResource(id = outputTextA, valueA),
				modifier = Modifier
					.align(Alignment.CenterHorizontally),
				fontSize = 20.sp,
				fontWeight = FontWeight.Bold,
			)
			Spacer(
				modifier = Modifier
					.height(16.dp)
			)
			Text(
				text = stringResource(id = outputTextB, valueB),
				modifier = Modifier
					.align(Alignment.CenterHorizontally),
				fontSize = 18.sp,
			)
		}
		Spacer(modifier = Modifier.height(8.dp))
	}
}

@Composable
fun DataOutputLines3Inputs2(
	value1: String,
	@StringRes label1: Int,
	onValueChange1: (String) -> Unit,
	value2: String,
	@StringRes label2: Int,
	onValueChange2: (String) -> Unit,
	@StringRes inputText: Int,
	@StringRes equalsText: Int,
	@StringRes outputTextA: Int,
	valueA: Double,
) {
	Column(
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		EditNumberField2Vert(
			label1 = label1,
			label2 = label2,
			value1 = value1,
			value2 = value2,
			onValueChange1 = onValueChange1,
			onValueChange2 = onValueChange2
		)
		Text(
			text = (stringResource(id = inputText, value1, value2)),
			modifier = Modifier
				.align(Alignment.CenterHorizontally),
			fontSize = 20.sp,
			fontWeight = FontWeight.Bold,
		)
		Spacer(
			modifier = Modifier
				.height(16.dp)
		)
		ContentBorder {
			Text(
				text = stringResource(id = equalsText),
				modifier = Modifier
					.align(Alignment.CenterHorizontally),
			)
			Spacer(
				modifier = Modifier
					.height(16.dp)
			)
			Text(
				text = stringResource(id = outputTextA, valueA),
				modifier = Modifier
					.align(Alignment.CenterHorizontally),
				fontSize = 20.sp,
				fontWeight = FontWeight.Bold,
			)
		}
		Spacer(modifier = Modifier.height(8.dp))
	}
}

@Composable
fun DataOutputSalinity(
	inputValue: String,
	@StringRes label: Int,
	onValueChange: (String) -> Unit,
	salinity: Double,
	density: Double
) {
	Column(
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		EditNumberFieldSingle(
			label = label,
			value = inputValue,
			onValueChange = onValueChange
		)
		Text(
			text = (stringResource(id = R.string.text_amount_ppt, inputValue)),
			modifier = Modifier
				.align(Alignment.CenterHorizontally),
			fontSize = 20.sp,
			fontWeight = FontWeight.Bold,
		)
		Spacer(modifier = Modifier.height(8.dp))
		ContentBorder {
			Text(
				text = stringResource(id = R.string.text_equiv),
				modifier = Modifier
					.align(Alignment.CenterHorizontally),
			)
			Spacer(modifier = Modifier.height(8.dp))
			Text(
				text = stringResource(id = R.string.text_amount_sg, salinity),
				modifier = Modifier
					.align(Alignment.CenterHorizontally),
				fontSize = 20.sp,
				fontWeight = FontWeight.Bold,
			)
			Spacer(modifier = Modifier.height(8.dp))
			Text(
				text = stringResource(R.string.text_density),
				modifier = Modifier
					.align(Alignment.CenterHorizontally),
				fontSize = 15.sp,
			)
			Text(
				text = stringResource(id = R.string.text_amount_density, density),
				modifier = Modifier
					.align(Alignment.CenterHorizontally),
				fontSize = 18.sp,
			)
		}
		Spacer(modifier = Modifier.height(8.dp))
	}
}