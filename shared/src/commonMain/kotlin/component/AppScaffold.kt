package component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import config.MaxWidth
import config.MinWidth

@Composable
internal fun AppScaffold(
    header: @Composable (Dp) -> Unit = {},
    content: LazyListScope.() -> Unit,
) = Surface(Modifier.fillMaxSize()) {
    BoxWithConstraints {
        val width = when {
            MinWidth <= maxWidth && maxWidth < MaxWidth -> maxWidth
            maxWidth < MinWidth -> MinWidth
            else -> MaxWidth
        }

        LazyColumnScaffold(
            width,
            header = header,
            content = content,
        )
    }
}

@Composable
private fun LazyColumnScaffold(
    width: Dp,
    state: LazyListState = rememberLazyListState(),
    header: @Composable (Dp) -> Unit = {},
    content: LazyListScope.() -> Unit,
) = Scaffold(
    topBar = {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopCenter,
        ) { header(width) }
    },
    modifier = Modifier.fillMaxSize(),
) { paddingValues ->
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter,
    ) {
        LazyColumn(
            state = state,
            modifier = Modifier.fillMaxHeight()
                .width(width)
                .padding(paddingValues),
            content = content,
        )
    }
}
