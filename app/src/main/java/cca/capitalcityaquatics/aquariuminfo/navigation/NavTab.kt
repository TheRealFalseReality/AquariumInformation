package cca.capitalcityaquatics.aquariuminfo.navigation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import java.util.*

@Composable
fun NavTab(
    text: String,
    icon: Int,
    selected: Boolean,
    onSelected: () -> Unit,
){
    val colorSelected = MaterialTheme.colors.primaryVariant
    val color = MaterialTheme.colors.onPrimary
    val durationMillis = if (selected) TabFadeInAnimationDuration else TabFadeOutAnimationDuration
    val animSpec = remember {
        tween<Color>(
            durationMillis = durationMillis,
            easing = LinearEasing,
            delayMillis =  TabFadeInAnimationDelay
        )
    }
    val tabTintColor by animateColorAsState(
        targetValue = if (selected) colorSelected else color,
        animationSpec = animSpec
    )
    Row(
        modifier = Modifier
            .padding(16.dp)
            .animateContentSize()
            .height(TabHeight)
            .selectable(
                selected = selected,
                onClick = onSelected,
                role = Role.Tab,
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = rememberRipple(
                    bounded = false,
                    radius = Dp.Unspecified,
                    color = Color.Unspecified
                )
            )
            .clearAndSetSemantics { contentDescription = text }
    ) {

        Icon(painter = painterResource(id = icon), contentDescription = text,  tint = tabTintColor)
        if (selected) {
            Spacer(Modifier.width(12.dp))
            Text(text.uppercase(Locale.getDefault()), color = tabTintColor)
        }
    }
}

@Composable
fun NavBar (
    content: @Composable RowScope.() -> Unit,
    color: Color
){
    Surface(
        Modifier
            .height(TabHeight)
            .fillMaxWidth(),
    ) {
        Row(
            Modifier.selectableGroup(),
        ) {
            BottomNavigation(
                backgroundColor = color,
            ) {
                content()
            }
        }
    }
}

@Composable
fun NavBarCenter (
    content: @Composable RowScope.() -> Unit,
    color: Color
){
    Surface(
        Modifier
            .height(TabHeight)
            .fillMaxWidth(),
        color = color,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                Modifier.selectableGroup(),
            ) {
                content()
            }
        }
    }
}

private val TabHeight = 56.dp
private const val InactiveTabOpacity = 0.60f

private const val TabFadeInAnimationDuration = 150
private const val TabFadeInAnimationDelay = 100
private const val TabFadeOutAnimationDuration = 100