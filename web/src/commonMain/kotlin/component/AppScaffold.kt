package component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import config.MaxWidth
import config.MinWidth

@Composable
internal fun AppScaffold(
    header: @Composable (Dp) -> Unit = {},
    footer: @Composable (Dp) -> Unit = {},
    content: LazyListScope.() -> Unit,
) = Surface(Modifier.fillMaxSize()) {
    BoxWithConstraints {
        val width = when {
            MinWidth <= maxWidth && maxWidth < MaxWidth -> maxWidth
            maxWidth < MinWidth -> MinWidth
            else -> MaxWidth
        }

        Scaffold(
            topBar = { MainFrame { header(width) } },
            modifier = Modifier.fillMaxSize(),
        ) { paddingValues ->
            MainFrame {
                LazyColumn(
                    modifier = Modifier.fillMaxHeight()
                        .width(width)
                        .padding(paddingValues),
                    content = content,
                )

                Box(
                    modifier = Modifier.align(Alignment.BottomCenter),
                ) { footer(width) }
            }
        }
    }
}

@Composable
private fun MainFrame(
    content: @Composable BoxScope.() -> Unit,
) = Box(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.TopCenter,
    content = content,
)
