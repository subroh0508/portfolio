package component

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource

@Composable
internal fun IconGrid(
    size: Dp,
    vararg resource: Pair<DrawableResource, String>,
    content: @Composable (DrawableResource, String) -> Unit,
) = BoxWithConstraints {
    val chunkedSize = (maxWidth / (size + 8.dp)).toInt()

    Column {
        resource.toList().chunked(chunkedSize).forEach { row ->
            Row(
                modifier = Modifier.padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) { row.forEach { (drawable, string) -> content(drawable, string) } }
        }
    }
}
