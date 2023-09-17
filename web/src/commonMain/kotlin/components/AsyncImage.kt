package components

import androidx.compose.foundation.Image
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap

@Composable
fun AsyncImage(
    path: String,
    contentDescription: String,
    modifier: Modifier = Modifier,
) {
    var icon by remember { mutableStateOf<ImageBitmap?>(null) }

    LaunchedEffect(path) {
        icon = ImageProvider.getImageBitmap(path)
    }

    icon?.let {
        Image(
            it,
            contentDescription,
            modifier,
        )
    }
}
