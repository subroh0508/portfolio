import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import org.jetbrains.skiko.wasm.onWasmReady
import utils.buildContentPath

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    onWasmReady {
        ComposeViewport("PortfolioCanvas") {
            PortfolioApp(
                current = buildContentPath(),
            )
        }
    }
}
