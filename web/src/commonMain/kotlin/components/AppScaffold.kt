package components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    content: @Composable () -> Unit,
) = Scaffold(
    topBar = { TopAppBar() },
) { paddingValues ->
    BoxWithConstraints {
        val width = when {
            maxWidth < 640.dp -> maxWidth
            else -> 640.dp
        }

        Box(
            modifier = Modifier.fillMaxSize()
                .padding(paddingValues),
        ) {
            Column(
                modifier = Modifier.width(width)
                    .fillMaxHeight()
                    .align(Alignment.Center),
            ) { content() }
        }
    }
}
