package config

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.luminance

enum class ColorTheme(val schema: ColorScheme) {
    AndroidLight(theme.scheme.AndroidLight),
    AndroidDark(theme.scheme.AndroidDark),

    HarukiLight(theme.scheme.HarukiLight),
    HarukiDark(theme.scheme.HarukiDark),

    KanadeLight(theme.scheme.KanadeLight),
    KanadeDark(theme.scheme.KanadeDark),

    KanonLight(theme.scheme.KanonLight),
    KanonDark(theme.scheme.KanonDark),

    KotlinLight(theme.scheme.KotlinLight),
    KotlinDark(theme.scheme.KotlinDark),

    MadokaLight(theme.scheme.MadokaLight),
    MadokaDark(theme.scheme.MadokaDark),

    MizukiLight(theme.scheme.MizukiLight),
    MizukiDark(theme.scheme.MizukiDark),

    RailsLight(theme.scheme.RailsLight),
    RailsDark(theme.scheme.RailsDark),

    ReactLight(theme.scheme.ReactLight),
    ReactDark(theme.scheme.ReactDark),

    SayakaLight(theme.scheme.SayakaLight),
    SayakaDark(theme.scheme.SayakaDark),

    TemariLight(theme.scheme.TemariLight),
    TemariDark(theme.scheme.TemariDark),

    YouLight(theme.scheme.YouLight),
    YouDark(theme.scheme.YouDark),

    YuLight(theme.scheme.YuLight),
    YuDark(theme.scheme.YuDark),

    YuikaLight(theme.scheme.YuikaLight),
    YuikaDark(theme.scheme.YuikaDark),
}

val AndroidThemes = ColorTheme.AndroidLight to ColorTheme.AndroidDark
val HarukiThemes = ColorTheme.HarukiLight to ColorTheme.HarukiDark
val KanadeThemes = ColorTheme.KanadeLight to ColorTheme.KanadeDark
val KanonThemes = ColorTheme.KanonLight to ColorTheme.KanonDark
val KotlinThemes = ColorTheme.KotlinLight to ColorTheme.KotlinDark
val MadokaThemes = ColorTheme.MadokaLight to ColorTheme.MadokaDark
val MizukiThemes = ColorTheme.MizukiLight to ColorTheme.MizukiDark
val RailsThemes = ColorTheme.RailsLight to ColorTheme.RailsDark
val ReactThemes = ColorTheme.ReactLight to ColorTheme.ReactDark
val SayakaThemes = ColorTheme.SayakaLight to ColorTheme.SayakaDark
val TemariThemes = ColorTheme.TemariLight to ColorTheme.TemariDark
val YouThemes = ColorTheme.YouLight to ColorTheme.YouDark
val YuThemes = ColorTheme.YuLight to ColorTheme.YuDark
val YuikaThemes = ColorTheme.YuikaLight to ColorTheme.YuikaDark

@Suppress("MagicNumber")
@Composable
fun ColorScheme.isLight() = this.background.luminance() > 0.5F
