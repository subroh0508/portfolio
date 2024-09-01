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
import config.ColorTheme
import config.LocalAppConfigState
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
                onClick = {
                    config.theme = when (config.theme) {
                        ColorTheme.Light -> ColorTheme.Dark
                        ColorTheme.Dark -> ColorTheme.Light
                    }
                },
                modifier = Modifier.pointerHoverIcon(PointerIcon.Hand)
                    .testTag(PortfolioTag.TOP_APP_BAR_COLOR_THEME_BUTTON),
            ) {
                Icon(
                    when (config.theme) {
                        ColorTheme.Light -> Icons.Default.LightMode
                        ColorTheme.Dark -> Icons.Default.DarkMode
                    },
                    contentDescription = "Change Theme",
                )
            }
        },
        modifier = modifier,
    )
}
