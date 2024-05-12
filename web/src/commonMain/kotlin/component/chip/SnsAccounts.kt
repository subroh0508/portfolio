package component.chip

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import component.AccountLink
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.painterResource
import portfolio.web.generated.resources.*

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun SnsAccounts() {
    AccountLink(
        painterResource(Res.drawable.x),
        Res.string.x,
        Res.string.href_x,
        lightColor = Color.Black,
        darkColor = Color.White,
    )

    AccountLink(
        painterResource(Res.drawable.bluesky),
        Res.string.bluesky,
        Res.string.href_bluesky,
    )

    AccountLink(
        imageResource(Res.drawable.facebook),
        Res.string.facebook,
        Res.string.href_facebook,
    )
}
