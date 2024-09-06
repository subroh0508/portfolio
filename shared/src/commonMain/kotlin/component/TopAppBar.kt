package component

import PortfolioTag
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.testTag
import config.AppConfigState
import config.ColorTheme
import config.LocalAppConfigState
import config.isLight
import org.jetbrains.compose.resources.stringResource
import portfolio.shared.generated.resources.Res
import portfolio.shared.generated.resources.title
import androidx.compose.material3.TopAppBar as M3TopAppBar

@Composable
internal fun TopAppBar(
    modifier: Modifier = Modifier,
) = TopAppBar(
    title = {
        Text(
            stringResource(Res.string.title),
            modifier = Modifier.testTag(PortfolioTag.TOP_APP_BAR_TITLE),
        )
    },
    modifier = modifier,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    val config = LocalAppConfigState.current

    M3TopAppBar(
        title = title,
        actions = {
            IconButton(
                onClick = { config.switchTheme() },
                modifier = Modifier.pointerHoverIcon(PointerIcon.Hand)
                    .testTag(PortfolioTag.TOP_APP_BAR_COLOR_THEME_BUTTON),
            ) {
                Icon(
                    config.themeIcon(),
                    contentDescription = "Change Theme",
                )
            }
        },
        modifier = modifier,
    )
}

@Suppress("CyclomaticComplexMethod")
private fun AppConfigState.switchTheme() {
    theme = when (theme) {
        ColorTheme.AndroidLight -> ColorTheme.AndroidDark
        ColorTheme.AndroidDark -> ColorTheme.AndroidLight
        ColorTheme.HarukiLight -> ColorTheme.HarukiDark
        ColorTheme.HarukiDark -> ColorTheme.HarukiLight
        ColorTheme.KanadeLight -> ColorTheme.KanadeDark
        ColorTheme.KanadeDark -> ColorTheme.KanadeLight
        ColorTheme.KotlinLight -> ColorTheme.KotlinDark
        ColorTheme.KotlinDark -> ColorTheme.KotlinLight
        ColorTheme.MadokaLight -> ColorTheme.MadokaDark
        ColorTheme.MadokaDark -> ColorTheme.MadokaLight
        ColorTheme.MizukiLight -> ColorTheme.MizukiDark
        ColorTheme.MizukiDark -> ColorTheme.MizukiLight
        ColorTheme.RailsLight -> ColorTheme.RailsDark
        ColorTheme.RailsDark -> ColorTheme.RailsLight
        ColorTheme.ReactLight -> ColorTheme.ReactDark
        ColorTheme.ReactDark -> ColorTheme.ReactLight
        ColorTheme.SayakaLight -> ColorTheme.SayakaDark
        ColorTheme.SayakaDark -> ColorTheme.SayakaLight
        ColorTheme.TemariLight -> ColorTheme.TemariDark
        ColorTheme.TemariDark -> ColorTheme.TemariLight
        ColorTheme.YouLight -> ColorTheme.YouDark
        ColorTheme.YouDark -> ColorTheme.YouLight
        ColorTheme.YuLight -> ColorTheme.YuDark
        ColorTheme.YuDark -> ColorTheme.YuLight
        ColorTheme.YuikaLight -> ColorTheme.YuikaDark
        ColorTheme.YuikaDark -> ColorTheme.YuikaLight
    }
}

@Composable
private fun AppConfigState.themeIcon() = if (theme.schema.isLight()) Icons.Default.DarkMode else Icons.Default.LightMode
