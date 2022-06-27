package cca.capitalcityaquatics.aquariuminfo.appscreens

import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cca.capitalcityaquatics.aquariuminfo.R
import cca.capitalcityaquatics.aquariuminfo.common.*
import cca.capitalcityaquatics.aquariuminfo.ui.theme.AquariumInfoTheme
import java.io.InputStream

@Composable
fun HomeScreen (
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(start = 24.dp, end = 24.dp, top = 24.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Card(
            backgroundColor = MaterialTheme.colors.primary,
            modifier = Modifier
                .padding(bottom = 86.dp)
                .fillMaxHeight()
                .fillMaxWidth()
                .border(
                    BorderStroke(2.dp, MaterialTheme.colors.primaryVariant),
                    shape = RoundedCornerShape(4.dp)
                )
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .padding(14.dp)
            ) {
                GeneralComposeHeader(textHeader =R.string.text_title_welcome )

                Spacer(modifier = Modifier.height(36.dp))

                GeneralComposeBody(
                    textBody = R.string.text_body_welcome, textAlign = TextAlign.Center)

                Spacer(modifier = Modifier.height(26.dp))
                
                ChangelogCardContent()

                Spacer(modifier = Modifier.height(26.dp))

                Column(
                    modifier = Modifier
                        .padding(6.dp)
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .border(
                            BorderStroke(2.dp, MaterialTheme.colors.primaryVariant),
                            shape = RoundedCornerShape(4.dp)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    GeneralComposeFooter(
                        textFooter = R.string.text_footer_welcome,
                        textAlign = TextAlign.Center,
                        style = TextStyle(textDecoration = TextDecoration.None),
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}

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
                Text(
                    text = stringResource(id =R.string.text_title_changelog),
                    style = MaterialTheme.typography.body2.copy(
                        fontWeight = FontWeight.ExtraBold),
                )
                Spacer(modifier = Modifier.height(10.dp))
                if (expanded){

                    GeneralComposeBody2(
                        textBody = R.string.text_subtitle_changelog,
                        modifier = Modifier
                            .align(Alignment.Start)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    GeneralComposeBody2(
                        textBody = R.string.text_unreleased,
                        modifier = Modifier
                            .align(Alignment.Start)
                    )

                    GeneralComposeBody2(
                        textBody = R.string.text_unreleased_body,
                        modifier = Modifier
                            .align(Alignment.Start)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    GeneralComposeHeader2(
                        textHeader = R.string.text_version_7,
                        modifier = Modifier
                            .align(Alignment.Start)
                    )

                    GeneralComposeBody2(
                        textBody = R.string.text_added,
                        modifier = Modifier
                            .align(Alignment.Start)
                    )

                    GeneralComposeBody2(
                        textBody = R.string.text_added_body_7,
                        modifier = Modifier
                            .align(Alignment.Start)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    GeneralComposeBody2(
                        textBody = R.string.text_fixed,
                        modifier = Modifier
                            .align(Alignment.Start)
                    )

                    GeneralComposeBody2(
                        textBody = R.string.text_fixed_body_7,
                        modifier = Modifier
                            .align(Alignment.Start)
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
fun HomePreview() {
    AquariumInfoTheme {
        HomeScreen()
    }
}