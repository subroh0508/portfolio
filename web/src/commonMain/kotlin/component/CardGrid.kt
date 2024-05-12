package component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import component.work.Work
import org.jetbrains.compose.resources.DrawableResource

private const val MaxGridCount = 2

@Composable
internal fun CardGrid(
    minWidth: Dp,
    works: List<Work>,
    content: @Composable (Work) -> Unit,
) = BoxWithConstraints {
    val chunkedSize = (((maxWidth / (minWidth + 8.dp)).toInt()))
        .takeIf { it <= MaxGridCount } ?: MaxGridCount
    val chunkedWorks = works.toList().chunked(chunkedSize)

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        (0..<chunkedSize).forEach { i ->
            Column(
                modifier = Modifier.weight(1F),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                chunkedWorks.forEach work@ { row ->
                    content(row.getOrNull(i) ?: return@work)
                }
            }
        }
    }
}
