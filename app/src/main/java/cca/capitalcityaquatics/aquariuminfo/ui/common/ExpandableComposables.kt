package cca.capitalcityaquatics.aquariuminfo.ui.common

import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.LoadFile
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.ui.converters.SalScreen
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInfoTheme


@Composable
fun InfoCardContent(
    @StringRes title: Int,
    icon: Painter,
    content: @Composable ColumnScope.() -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        backgroundColor = MaterialTheme.colors.secondary,
        modifier = Modifier
            .padding(vertical = 4.dp),
        contentColor = Color.Black
    ){
        Row (
            modifier = Modifier
                .clickable { expanded = !expanded }
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessLow
                    ),
                )
        ){
            Column (
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 12.dp, bottom = 12.dp, start = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Row {
                    Icon(
                        painter = icon,
                        contentDescription = null,
                        Modifier
                            .height(30.dp)
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = stringResource(id =title),
                        style = MaterialTheme.typography.body2.copy(
                            fontWeight = FontWeight.ExtraBold),
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                if (expanded){
                    content()
                }
            }
            IconButton(
                onClick = { expanded = !expanded },
            ) {
                Icon(
                    painter = if (expanded)
                        painterResource(id = R.drawable.ic_baseline_expand_less_24)
                    else  painterResource(id = R.drawable.ic_baseline_expand_more_24),
                    contentDescription =if (expanded) {
                        stringResource(R.string.text_show_less)
                    } else {
                        stringResource(R.string.text_show_more)
                    },
                )
            }
        }
    }
}

@Composable
fun ChangelogCardContent(
) {
    InfoCardContent(
        icon = painterResource(id = R.drawable.tips_and_updates_48px),
        title = R.string.text_title_changelog
    ) {
        LoadFile(
            file = "Changelog.md",
            textAlign = TextAlign.Start
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SalPreview9() {
    AquariumInfoTheme  {
        SalScreen()
    }
}