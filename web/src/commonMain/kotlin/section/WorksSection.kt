package section

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import component.*
import component.AnimatedSection
import component.CardGrid
import component.WorkCard
import component.WorkCardMinWidth
import component.work.Works

@Composable
internal fun WorksSection(
    visible: Boolean,
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

    Footer()
}
