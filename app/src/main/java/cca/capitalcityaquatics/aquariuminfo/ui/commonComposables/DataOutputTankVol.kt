package cca.capitalcityaquatics.aquariuminfo.ui.commonComposables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.ui.tankVolume.TankVolBFScreen
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AppTheme

@Composable
fun DataOutputTankVol(
	valueA: String,
	valueB: String,
	valueC: String,
) {
	Column {
		Text(
			text = stringResource(R.string.text_equal_to),
			modifier = Modifier
				.align(Alignment.CenterHorizontally),
			style = MaterialTheme.typography.bodySmall
		)
		Spacer(
			modifier = Modifier
				.height(10.dp)
		)
	}

	ContentBorder {

		Text(
			text = (stringResource(id = R.string.text_amount_gallon, valueA)),
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
			text = stringResource(id = R.string.text_amount_liters, valueB),
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
			text = stringResource(R.string.text_water_weight),
			modifier = Modifier
				.align(Alignment.CenterHorizontally),
			fontSize = 15.sp,
		)
		Text(
			text = stringResource(id = R.string.text_amount_water_weight_lbs, valueC),
			modifier = Modifier
				.align(Alignment.CenterHorizontally),
			fontSize = 18.sp,
		)
	}
	Spacer(modifier = Modifier.height(16.dp))
}

@Preview(showBackground = true)
@Composable
fun BFPreview3() {
	AppTheme {
		TankVolBFScreen()
	}
}