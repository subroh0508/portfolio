package component.work

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.WebElementView
import kotlinx.browser.document
import org.w3c.dom.HTMLIFrameElement

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun SpeakerDeck(
    link: SpeakerDeckLink,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        WebElementView(
            factory = { iframe(link.src, link.title) },
            modifier = Modifier.fillMaxSize(),
            update = { iframe -> iframe.src = iframe.src },
        )
    }
}

internal data class SpeakerDeckLink(
    val src: String,
    val title: String,
)

private fun iframe(
    src: String,
    title: String,
): HTMLIFrameElement {
    val element = document.createElement(
        "iframe"
    ) as HTMLIFrameElement

    return element.apply {
        this.src = src
        this.title = title
        className = "speakerdeck-iframe"
        allowFullscreen = true
        setAttribute("data-ratio", "1.7777777777777777")
        with (style) {
            border = "0px"
            background = "padding-box padding-box rgba(0, 0, 0, 0.1)"
            margin = "0px"
            padding = "0px"
            borderRadius = "6px"
            boxShadow = "rgba(0, 0, 0, 0.2) 0px 5px 40px"
            width = "100%"
            height = "auto"
            setProperty("aspect-ratio", "560 / 315")
        }
    }
}
