import component.ContentTab
import kotlinx.browser.window

internal fun buildContentPath(): ContentTab {
    val path = window.location.pathname.removePrefix("/")
    return ContentTab.entries.find { it.path == path } ?: ContentTab.Biography
}
