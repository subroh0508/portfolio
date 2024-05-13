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
import androidx.compose.ui.unit.dp
import config.isLight
import kotlinx.browser.window
import org.jetbrains.compose.resources.*

private val IconSize = 18.dp

@Composable
internal fun AccountLink(
    bitmap: ImageBitmap,
    label: StringResource,
    href: StringResource,
) {
    val hrefRes = stringResource(href)

    FilterChip(
        true,
        onClick = {
            window.open(hrefRes, "_blank")
        },
        leadingIcon = {
            Image(
                bitmap,
                "Service Icon",
                modifier = Modifier.size(IconSize),
            )
        },
        label = {
            Text(
                stringResource(label),
                style = MaterialTheme.typography.bodyMedium,
            )
        },
        modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
    )
}

@Composable
internal fun AccountLink(
    painter: Painter,
    label: StringResource,
    href: StringResource,
    lightColor: Color? = null,
    darkColor: Color? = null,
) {
    val hrefRes = stringResource(href)

    FilterChip(
        true,
        onClick = {
            window.open(hrefRes, "_blank")
        },
        leadingIcon = {
            Image(
                painter,
                "Service Icon",
                modifier = Modifier.size(IconSize),
                colorFilter = tintColor(lightColor, darkColor),
            )
        },
        label = {
            Text(
                stringResource(label),
                style = MaterialTheme.typography.bodyMedium,
            )
        },
        modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
    )
}

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
