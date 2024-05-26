package config

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.luminance

enum class ColorTheme(val schema: ColorScheme) {
    Light(theme.Light),
    Dark(theme.Dark),
}

@Suppress("MagicNumber")
@Composable
fun ColorScheme.isLight() = this.background.luminance() > 0.5F
