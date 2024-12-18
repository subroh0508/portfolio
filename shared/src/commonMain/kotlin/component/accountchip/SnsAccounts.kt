package component.accountchip

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import portfolio.shared.generated.resources.*

@Composable
internal fun X() = AccountLink(
    icon = {
        ServiceIcon(
            painterResource(Res.drawable.x),
            lightColor = Color.Black,
            darkColor = Color.White,
        )
    },
    stringResource(Res.string.x),
    stringResource(Res.string.href_x),
)

@Composable
internal fun Mixi2() = AccountLink(
    icon = {
        ServiceIcon(
            painterResource(Res.drawable.mixi2),
        )
    },
    stringResource(Res.string.mixi2),
    stringResource(Res.string.href_mixi2),
)

@Composable
internal fun Facebook() = AccountLink(
    icon = {
        ServiceIcon(
            imageResource(Res.drawable.facebook),
        )
    },
    stringResource(Res.string.facebook),
    stringResource(Res.string.href_facebook),
)
