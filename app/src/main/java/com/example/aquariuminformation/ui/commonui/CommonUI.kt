package com.example.aquariuminformation.ui.commonui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.aquariuminformation.R
import com.example.aquariuminformation.ui.theme.AquariumInformationTheme

@ExperimentalMaterial3Api
@Composable
fun AquariumAppBar(
	modifier: Modifier = Modifier,
//	navController: NavHostController,
//	onClick: () -> Unit
) {
	CenterAlignedTopAppBar(
		modifier = modifier,
		title = { 
			Row(
				verticalAlignment = Alignment.CenterVertically
			) {
				Icon(
					painter = painterResource(id = R.drawable.ic_launcher_foreground),
					contentDescription = null,
					modifier = Modifier
						.size(dimensionResource(R.dimen.icon_size)),
					tint = MaterialTheme.colorScheme.onSurfaceVariant
				)
				Text(
					text = stringResource(id = R.string.app_name),
					color = MaterialTheme.colorScheme.onSurfaceVariant,
					style = MaterialTheme.typography.titleLarge
				)
			}
		},
		colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
			containerColor = MaterialTheme.colorScheme.surfaceVariant
		)
	)
}



@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun TopAppBarPreview(){
	AquariumInformationTheme {
		AquariumAppBar()
	}
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun TopAppBarPreviewDark(
){
	AquariumInformationTheme(useDarkTheme = true) {
		AquariumAppBar()
	}
}