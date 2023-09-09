@file:Suppress("FunctionName")

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun MainView() {
    var isClicked by remember { mutableStateOf(false) }

    BoxWithConstraints {
        println("Max width: $maxWidth")

        Button(
            onClick = { isClicked = !isClicked },
        ) {
            Text("Hello, World! / ${if (isClicked) "clicked" else "not clicked"}")
        }
    }
}