package cca.capitalcityaquatics.aquariuminfo.common

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.converters.SalScreen
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInfoTheme

@Composable
fun InfoCardContentSubTitle(
    @StringRes title: Int,
    @StringRes subTitle: Int,
    @StringRes textBody: Int,
) {
    var expanded by remember { mutableStateOf(false) }

    Row (
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
            ){
        Column (
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
                ){
            Text(
                text = stringResource(id = title)
            )
            Text(
                text = stringResource(id =subTitle),
                style = MaterialTheme.typography.body2.copy(
                    fontWeight = FontWeight.ExtraBold)
                )
            if (expanded){
                Text(
                    text = stringResource(id = textBody)
                )
            }
        }
        IconButton(
            onClick = { expanded = !expanded }
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

@Composable
fun InfoCardContent(
    @StringRes title: Int,
    @StringRes textBody: Int,
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
                        dampingRatio = Spring.DampingRatioMediumBouncy,
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
                Text(
                    text = stringResource(id =title),
                    style = MaterialTheme.typography.body2.copy(
                        fontWeight = FontWeight.ExtraBold),
                )
                Spacer(modifier = Modifier.height(10.dp))
                if (expanded){
                    Text(
                        text = stringResource(id = textBody)
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

@Composable
fun InfoCardContent3(
    @StringRes title: Int,
    @StringRes textBody1: Int,
    @StringRes textBody2: Int,
    @StringRes textBody3: Int,
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
                        dampingRatio = Spring.DampingRatioMediumBouncy,
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
                Text(
                    text = stringResource(id =title),
                    style = MaterialTheme.typography.body2.copy(
                        fontWeight = FontWeight.ExtraBold),
                    modifier = Modifier
                        .clickable { expanded = !expanded }
                )
                if (expanded){
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = stringResource(id = textBody1)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = stringResource(id = textBody2)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = stringResource(id = textBody3)
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

@Preview(showBackground = true)
@Composable
fun SalPreview9() {
    AquariumInfoTheme  {
        SalScreen()
    }
}