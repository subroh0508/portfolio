package section

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import component.AnimatedSection
import component.CardGrid
import component.WorkCard
import component.WorkCardMinWidth
import component.work.Works

@Composable
internal fun WorksSection(
    visible: Boolean,
    footer: @Composable () -> Unit,
) = AnimatedSection(
    visible,
    modifier = Modifier.padding(32.dp),
) {
    CardGrid(
        WorkCardMinWidth,
        Works,
    ) { work ->
        WorkCard(work)
    }

    Box(
        modifier = Modifier.align(Alignment.CenterHorizontally),
    ) { footer() }
}
