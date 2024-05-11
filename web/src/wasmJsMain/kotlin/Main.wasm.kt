import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow(
        "Portfolio",
        canvasElementId = "PortfolioCanvas",
    ) {
        PortfolioApp()
    }
}
