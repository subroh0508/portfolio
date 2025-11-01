package component

import androidx.compose.runtime.MutableState
import kotlinx.browser.window

internal actual fun MutableState<ContentTab>.handleTabChange(
    next: ContentTab,
) {
    window.history.replaceState(null, "", "/${next.path}")
    value = next
}
