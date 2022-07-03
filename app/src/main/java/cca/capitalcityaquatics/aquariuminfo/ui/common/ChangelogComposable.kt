package cca.capitalcityaquatics.aquariuminfo.ui.common

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.LoadFile
import cca.capitalcityaquatics.aquariuminfo.R

@Composable
fun ChangelogCardContent(
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        backgroundColor = MaterialTheme.colors.secondary,
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
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
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.tips_and_updates_48px),
                        contentDescription = stringResource(id = R.string.text_title_changelog),
                        modifier = Modifier
                            .height(28.dp)
                            .padding(end = 36.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.text_title_changelog),
                        style = MaterialTheme.typography.body2.copy(
                            fontWeight = FontWeight.ExtraBold),
                    )

                }

                Spacer(modifier = Modifier.height(10.dp))
                if (expanded){

                    LoadFile(
                        file = "Changelog.md",
                        textAlign = TextAlign.Start
                    )

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