@file:Suppress("FunctionName")

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.ImageBitmap

@Composable
fun MainView() {
    var isClicked by remember { mutableStateOf(false) }
    var icon by remember { mutableStateOf<ImageBitmap?>(null) }

    LaunchedEffect(Unit) {
        icon = ImageProvider.getImageBitmap("icon.webp")
    }

    BoxWithConstraints {
        println("Max width: $maxWidth")

        Button(
            onClick = { isClicked = !isClicked },
        ) {
            Text("Hello, World! / ${if (isClicked) "clicked" else "not clicked"}")
        }

        icon?.let { Image(it, "icon") }
    }
}
