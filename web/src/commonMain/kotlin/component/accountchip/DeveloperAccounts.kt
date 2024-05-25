package component.accountchip

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import portfolio.web.generated.resources.*
import portfolio.web.generated.resources.Res
import portfolio.web.generated.resources.github
import portfolio.web.generated.resources.href_github
import portfolio.web.generated.resources.lapras

@Composable
internal fun GitHub() = AccountLink(
    icon =  {
        ServiceIcon(
            painterResource(Res.drawable.github),
            lightColor = Color(0xFF24292F),
            darkColor = Color.White,
        )
    },
    stringResource(Res.string.github),
    stringResource(Res.string.href_github),
)

@Composable
internal fun Lapras() = AccountLink(
    icon = {
        ServiceIcon(
            imageResource(Res.drawable.lapras),
        )
    },
    stringResource(Res.string.lapras),
    stringResource(Res.string.href_lapras),
)
