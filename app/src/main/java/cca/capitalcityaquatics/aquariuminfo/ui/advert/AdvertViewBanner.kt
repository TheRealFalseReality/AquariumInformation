package cca.capitalcityaquatics.aquariuminfo.ui.advert

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import cca.capitalcityaquatics.aquariuminfo.AquariumApp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AppTheme
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBannerAd(
	modifier: Modifier = Modifier,
) {
	val deviceCurrentWidth = LocalConfiguration.current.screenWidthDp
	val isInEditMode = LocalInspectionMode.current

	Column {
		if (isInEditMode) {
			Text(
				modifier = modifier
					.fillMaxWidth()
					.background(Color.Red)
					.padding(horizontal = 2.dp, vertical = 6.dp),
				textAlign = TextAlign.Center,
				color = Color.White,
				text = "Advert Here",
			)
		} else {
			Card(
				colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onBackground),
				shape = Shapes.None
			) {
				AndroidView(
					modifier = modifier.fillMaxWidth(),
					factory = { context ->
						AdView(context).apply {
							AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(
								context,
								deviceCurrentWidth
							)
							adUnitId = context.getString(R.string.id_ad_banner)
							loadAd(AdRequest.Builder().build())
						}
					}
				)
			}
		}
	}
}

@Composable
fun InnerBannerAd(
	modifier: Modifier = Modifier,
) {
	val isInEditMode = LocalInspectionMode.current
	Column {
		if (isInEditMode) {
			Text(
				modifier = modifier
					.fillMaxWidth()
					.background(Color.Red)
					.padding(horizontal = 2.dp, vertical = 6.dp),
				textAlign = TextAlign.Center,
				color = Color.White,
				text = "Advert Here",
			)
		} else {
			AndroidView(
				modifier = modifier.fillMaxWidth(),
				factory = { context ->
					AdView(context).apply {
						setAdSize(AdSize.LARGE_BANNER)
						adUnitId = context.getString(R.string.id_ad_banner_inner)
						loadAd(AdRequest.Builder().build())
					}
				}
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
	AppTheme {
		AquariumApp()
	}
}