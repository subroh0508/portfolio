package config

import androidx.compose.runtime.*

data class AppConfig(
    val theme: ColorTheme = ColorTheme.YuikaLight,
    val lang: Lang = Lang.JA,
)

class AppConfigState private constructor(
    state: MutableState<AppConfig>,
) : MutableState<AppConfig> by state {
    constructor(
        theme: ColorTheme = ColorTheme.YuikaLight,
        lang: Lang = Lang.JA,
    ) : this(mutableStateOf(AppConfig(theme, lang)))

    var theme: ColorTheme
        get() = value.theme
        set(value) {
            this.value = this.value.copy(theme = value)
        }

    var lang: Lang
        get() = value.lang
        set(value) {
            this.value = this.value.copy(lang = value)
        }
}

@Composable
fun rememberAppConfigState(
    useDarkTheme: Boolean,
) = remember(useDarkTheme) {
    AppConfigState(
        theme = if (useDarkTheme) ColorTheme.YuikaDark else ColorTheme.YuikaLight,
        lang = Lang.JA,
    )
}

val LocalAppConfigState = compositionLocalOf { AppConfigState() }
