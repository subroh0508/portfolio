package component.accountchip

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import config.isLight
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.painterResource
import portfolio.web.generated.resources.*
import portfolio.web.generated.resources.Res
import portfolio.web.generated.resources.wantedly_dark

@Composable
internal fun Wantedly() = AccountLink(
    if (MaterialTheme.colorScheme.isLight()) {
        painterResource(Res.drawable.wantedly_light)
    } else {
        painterResource(Res.drawable.wantedly_dark)
    },
    Res.string.wantedly,
    Res.string.href_wantedly,
)

@Composable
internal fun Youtrust() = AccountLink(
    imageResource(Res.drawable.youtrust),
    Res.string.youtrust,
    Res.string.href_youtrust,
)
