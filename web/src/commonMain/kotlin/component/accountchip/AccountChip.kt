package component.accountchip

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import config.isLight
import utils.openWindow

private val IconSize = 18.dp

@Composable
internal fun AccountLink(
    icon: @Composable () -> Unit,
    label: String,
    href: String,
) = FilterChip(
    true,
    onClick = { openWindow(href) },
    leadingIcon = { icon() },
    label = {
        Text(
            label,
            style = MaterialTheme.typography.bodyMedium,
        )
    },
    modifier = Modifier.pointerHoverIcon(PointerIcon.Hand)
        .testTag(PortfolioTag.ACCOUNT_LINK),
)

@Composable
internal fun ServiceIcon(
    bitmap: ImageBitmap,
) = Image(
    bitmap,
    "Service Icon",
    modifier = Modifier.size(IconSize),
)

@Composable
internal fun ServiceIcon(
    painter: Painter,
    lightColor: Color? = null,
    darkColor: Color? = null,
) = Image(
    painter,
    "Service Icon",
    modifier = Modifier.size(IconSize),
    colorFilter = tintColor(lightColor, darkColor),
)

@Composable
private fun tintColor(
    lightColor: Color? = null,
    darkColor: Color? = null,
): ColorFilter? {
    lightColor ?: return null
    darkColor ?: return null

    return ColorFilter.tint(
        if (MaterialTheme.colorScheme.isLight()) lightColor else darkColor,
    )
}
