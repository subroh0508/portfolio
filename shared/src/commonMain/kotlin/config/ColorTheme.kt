package config

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.luminance

enum class ColorTheme(val schema: ColorScheme) {
    YuikaLight(theme.scheme.YuikaLight),
    YuikaDark(theme.scheme.YuikaDark),
}

@Suppress("MagicNumber")
@Composable
fun ColorScheme.isLight() = this.background.luminance() > 0.5F
