package component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
internal fun AnimatedSection(
    visible: Boolean,
    modifier: Modifier = Modifier,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    content: @Composable ColumnScope.() -> Unit,
) = FadeAnimatedVisibility(
    visible,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = horizontalAlignment,
        content = content,
    )
}
