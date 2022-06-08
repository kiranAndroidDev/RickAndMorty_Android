package com.example.rickandmorty_android.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Cyan200,
    primaryVariant = Cyan700,
    secondary = Black400
)

private val LightColorPalette = lightColors(
    primary = Cyan500,
    primaryVariant = Cyan700,
    secondary = Black400
)

@Composable
fun RickAndMorty_AndroidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
