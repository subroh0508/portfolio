package component.accountchip

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.painterResource
import portfolio.web.generated.resources.*
import portfolio.web.generated.resources.Res
import portfolio.web.generated.resources.github
import portfolio.web.generated.resources.href_github
import portfolio.web.generated.resources.lapras

@Composable
internal fun GitHub() = AccountLink(
    painterResource(Res.drawable.github),
    Res.string.github,
    Res.string.href_github,
    lightColor = Color(0xFF24292F),
    darkColor = Color.White,
)

@Composable
internal fun Lapras() = AccountLink(
    imageResource(Res.drawable.lapras),
    Res.string.lapras,
    Res.string.href_lapras,
)
