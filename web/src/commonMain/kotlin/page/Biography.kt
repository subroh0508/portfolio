package page

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.AsyncImage

@Composable
fun Biography() {
    AsyncImage(
        "icon.webp",
        "Subroh Nishikori's Icon",
        modifier = Modifier.size(48.dp)
    )
}
