import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import org.jetbrains.skiko.wasm.onWasmReady

fun main() {
    onWasmReady {
        Window("Portfolio") {
            var isClicked by remember { mutableStateOf(false) }

            Button(
                onClick = { isClicked = !isClicked },
            ) {
                Text("Hello, World! / ${if (isClicked) "clicked" else "not clicked"}")
            }
        }
    }
}
