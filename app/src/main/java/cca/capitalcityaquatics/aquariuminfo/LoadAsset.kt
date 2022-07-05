package cca.capitalcityaquatics.aquariuminfo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import java.io.InputStream

@Composable
fun LoadFile(
    file: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign
) {
    val isInEditMode = LocalInspectionMode.current
    Column {
        if (isInEditMode) {
            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .background(Color.Red)
                    .padding(horizontal = 2.dp, vertical = 6.dp)
                    .height(300.dp),
                textAlign = TextAlign.Center,
                color = Color.White,
                text = "Text File here",
            )
        } else {
            var dataText by remember {
                mutableStateOf("")
            }

            Column {
                Text(
                    dataText,
                    modifier = modifier,
                    textAlign = textAlign
                )
            }

            val context = LocalContext.current
            val error = stringResource(id = R.string.text_error)

            LaunchedEffect(true) {
                kotlin.runCatching {
                    val inputStream: InputStream = context.assets.open(file)
                    val size: Int = inputStream.available()
                    val buffer = ByteArray(size)
                    inputStream.read(buffer)
                    String(buffer)
                }.onSuccess {
                    dataText = it
                }.onFailure {
                    dataText = error
                }
            }
        }
    }
}