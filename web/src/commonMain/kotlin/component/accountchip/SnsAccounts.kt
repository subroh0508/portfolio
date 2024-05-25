package component.accountchip

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import portfolio.web.generated.resources.*

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
internal fun Bluesky() = AccountLink(
    icon = {
        ServiceIcon(
            painterResource(Res.drawable.bluesky),
        )
    },
    stringResource(Res.string.bluesky),
    stringResource(Res.string.href_bluesky),
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
