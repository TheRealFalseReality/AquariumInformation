package cca.capitalcityaquatics.aquariuminfo.ui.commonComposables

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.ui.advert.InnerBannerAd

@Composable
fun FormulaStringTemp(
) {
	Spacer(
		modifier = Modifier.height(8.dp)
	)

	InnerBannerAd()

	Spacer(modifier = Modifier.height(8.dp))

	InfoCardContent(
		icon = painterResource(id = R.drawable.tips_and_updates_48px),
		title = R.string.text_formulas
	) {
		GeneralComposeBody(
			text = R.string.text_formula_celsius,
			textAlign = TextAlign.Center
		)
		GeneralComposeBody(
			text = R.string.text_formula_fahrenheit,
			textAlign = TextAlign.Center
		)
		GeneralComposeBody(
			text = R.string.formula_kelvin,
			textAlign = TextAlign.Center
		)
	}
	Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun FormulaString(
	content: @Composable ColumnScope.() -> Unit,
) {
	Spacer(modifier = Modifier.height(8.dp))

	InnerBannerAd()

	Spacer(modifier = Modifier.height(8.dp))

	InfoCardContent(
		icon = painterResource(id = R.drawable.functions_48px),
		title = R.string.text_formula,
		content = content
	)

	Spacer(modifier = Modifier.height(8.dp))
}