import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import org.jetbrains.skiko.wasm.onWasmReady
import utils.buildContentPath

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    onWasmReady {
        CanvasBasedWindow(
            "Subroh Nishikori's Portfolio",
            canvasElementId = "PortfolioCanvas",
        ) {
            PortfolioApp(
                current = buildContentPath(),
            )
        }
    }
}
