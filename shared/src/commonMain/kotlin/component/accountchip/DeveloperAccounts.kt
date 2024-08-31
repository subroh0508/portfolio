package component.accountchip

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import portfolio.shared.generated.resources.*
import portfolio.shared.generated.resources.Res
import portfolio.shared.generated.resources.github
import portfolio.shared.generated.resources.href_github
import portfolio.shared.generated.resources.lapras

@Suppress("MagicNumber")
@Composable
internal fun GitHub() = AccountLink(
    icon = {
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
