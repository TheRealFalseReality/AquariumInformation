package cca.capitalcityaquatics.aquariuminfo.ui.commonComposables

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cca.capitalcityaquatics.aquariuminfo.ui.tankVolume.TankVolBFScreen
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AppTheme

@Composable
fun InputUnitsDisplay4(
	@StringRes textA: Int,
	@StringRes textB: Int,
	@StringRes textC: Int,
	@StringRes textD: Int,
	valueA: Double,
	valueB: Double,
	valueC: Double,
	valueD: Double,
) {
	Column {
		Row(
			modifier = Modifier
				.widthIn(max = 500.dp),
		) {
			Text(
				text = (stringResource(textA, valueA)),
				modifier = Modifier
					.padding(start = 2.dp, top = 4.dp)
					.weight(1f),
				fontSize = 20.sp,
				textAlign = TextAlign.Center,
				fontWeight = FontWeight.Bold,
			)
			Text(
				text = (stringResource(textB, valueB)),
				modifier = Modifier
					.padding(end = 2.dp, top = 4.dp)
					.weight(1f),
				textAlign = TextAlign.Center,
				fontSize = 20.sp,
				fontWeight = FontWeight.Bold,
			)
		}

		Row(
			modifier = Modifier
				.widthIn(max = 500.dp),
		) {
			Text(
				text = (stringResource(textC, valueC)),
				modifier = Modifier
					.padding(start = 2.dp, top = 4.dp)
					.weight(1f),
				fontSize = 20.sp,
				textAlign = TextAlign.Center,
				fontWeight = FontWeight.Bold,
			)
			Text(
				text = (stringResource(textD, valueD)),
				modifier = Modifier
					.padding(end = 2.dp, top = 4.dp)
					.weight(1f),
				textAlign = TextAlign.Center,
				fontSize = 20.sp,
				fontWeight = FontWeight.Bold,
			)
		}
		Spacer(modifier = Modifier.height(16.dp))
	}
}

@Composable
fun InputUnitsDisplay3(
	@StringRes textA: Int,
	@StringRes textB: Int,
	@StringRes textC: Int,
	valueA: Double,
	valueB: Double,
	valueC: Double,
) {
	Column {
		Row(
			modifier = Modifier
				.widthIn(max = 550.dp),
		) {
			Text(
				text = (stringResource(textA, valueA)),
				modifier = Modifier
					.padding(start = 2.dp, top = 4.dp)
					.weight(1f),
				fontSize = 20.sp,
				textAlign = TextAlign.Center,
				fontWeight = FontWeight.Bold,
			)
			Text(
				text = (stringResource(textB, valueB)),
				modifier = Modifier
					.padding(end = 2.dp, top = 4.dp)
					.weight(1f),
				textAlign = TextAlign.Center,
				fontSize = 20.sp,
				fontWeight = FontWeight.Bold,
			)
			Text(
				text = (stringResource(textC, valueC)),
				modifier = Modifier
					.padding(start = 2.dp, top = 4.dp)
					.weight(1f),
				fontSize = 20.sp,
				textAlign = TextAlign.Center,
				fontWeight = FontWeight.Bold,
			)
		}
		Spacer(modifier = Modifier.height(16.dp))
	}
}

@Composable
fun InputUnitsDisplay1(
	@StringRes textA: Int,
	valueA: Double,
) {
	Column {
		Row(
			modifier = Modifier
				.widthIn(max = 500.dp),
		) {
			Text(
				text = (stringResource(textA, valueA)),
				modifier = Modifier
					.padding(start = 2.dp, top = 4.dp)
					.weight(1f),
				fontSize = 20.sp,
				textAlign = TextAlign.Center,
				fontWeight = FontWeight.Bold,
			)
		}
		Spacer(modifier = Modifier.height(16.dp))
	}
}

@Composable
fun InputUnitsDisplay2(
	@StringRes textA: Int,
	@StringRes textB: Int,
	valueA: Double,
	valueB: Double,
) {
	Column {
		Row(
			modifier = Modifier
				.widthIn(max = 500.dp),
		) {
			Text(
				text = (stringResource(textA, valueA)),
				modifier = Modifier
					.padding(start = 2.dp, top = 4.dp)
					.weight(1f),
				fontSize = 20.sp,
				textAlign = TextAlign.Center,
				fontWeight = FontWeight.Bold,
			)
			Text(
				text = (stringResource(textB, valueB)),
				modifier = Modifier
					.padding(end = 2.dp, top = 4.dp)
					.weight(1f),
				textAlign = TextAlign.Center,
				fontSize = 20.sp,
				fontWeight = FontWeight.Bold,
			)
		}
		Spacer(modifier = Modifier.height(16.dp))
	}
}

@Preview(showBackground = true)
@Composable
fun BFPreview4() {
	AppTheme {
		TankVolBFScreen()
	}
}

