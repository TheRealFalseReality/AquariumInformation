package cca.capitalcityaquatics.aquariuminfo.ui.commonComposables

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.ui.converters.AlkalinityScreen
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AppTheme

@Composable
fun ImageGeneral(
	modifier: Modifier = Modifier,
	@DrawableRes image: Int,
	@StringRes contDesc: Int,
) {
	Image(
		painter = painterResource(id = image),
		contentDescription = stringResource(id = contDesc),
		modifier = modifier
			.fillMaxWidth()
	)
	Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun ZoomImage(
//	modifier: Modifier = Modifier,
//	@DrawableRes image: Int,
//	@StringRes contDesc: Int,
) {
	Button(onClick = { /*TODO*/ }) {

	}
	Image(
		painter = painterResource(id = R.drawable.screenshot_20220618_122436),
		contentDescription = null
	)
}

@Preview(showBackground = true)
@Composable
fun Alk3Preview() {
	AppTheme {
		AlkalinityScreen()
	}
}

@Preview(showBackground = true)
@Composable
fun ZoomPreview() {
	AppTheme {
		ZoomImage()
	}
}