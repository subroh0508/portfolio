package component

import PortfolioTag
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource

@Composable
internal fun IconGrid(
    size: Dp,
    vararg resource: Triple<DrawableResource, String, () -> Unit>,
    content: @Composable (DrawableResource, String, () -> Unit) -> Unit,
) = BoxWithConstraints {
    val chunkedSize = (maxWidth / (size + 8.dp)).toInt()

    Column {
        resource.toList().chunked(chunkedSize).forEach { row ->
            Row(
                modifier = Modifier.padding(vertical = 8.dp)
                    .testTag(PortfolioTag.ICON_GRID_ROW),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                row.forEach { (drawable, string, onClick) ->
                    content(drawable, string, onClick)
                }
            }
        }
    }
}
