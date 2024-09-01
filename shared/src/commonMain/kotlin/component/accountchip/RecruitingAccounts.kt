package component.accountchip

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import config.isLight
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import portfolio.shared.generated.resources.*
import portfolio.shared.generated.resources.Res
import portfolio.shared.generated.resources.wantedly_dark

@Composable
internal fun Wantedly() = AccountLink(
    icon = {
        ServiceIcon(
            if (MaterialTheme.colorScheme.isLight()) {
                painterResource(Res.drawable.wantedly_light)
            } else {
                painterResource(Res.drawable.wantedly_dark)
            },
        )
    },
    stringResource(Res.string.wantedly),
    stringResource(Res.string.href_wantedly),
)

@Composable
internal fun Youtrust() = AccountLink(
    icon = {
        ServiceIcon(
            imageResource(Res.drawable.youtrust),
        )
    },
    stringResource(Res.string.youtrust),
    stringResource(Res.string.href_youtrust),
)
