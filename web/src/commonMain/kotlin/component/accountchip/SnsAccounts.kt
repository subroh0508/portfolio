package component.accountchip

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.painterResource
import portfolio.web.generated.resources.*

@Composable
internal fun X() = AccountLink(
    painterResource(Res.drawable.x),
    Res.string.x,
    Res.string.href_x,
    lightColor = Color.Black,
    darkColor = Color.White,
)

@Composable
internal fun Bluesky() = AccountLink(
    painterResource(Res.drawable.bluesky),
    Res.string.bluesky,
    Res.string.href_bluesky,
)

@Composable
internal fun Facebook() = AccountLink(
    imageResource(Res.drawable.facebook),
    Res.string.facebook,
    Res.string.href_facebook,
)
