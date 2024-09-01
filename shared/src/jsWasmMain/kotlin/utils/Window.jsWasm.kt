package utils

import component.ContentTab
import kotlinx.browser.window

actual fun openWindow(url: String, target: String) { window.open(url, target) }

actual fun buildContentPath(): ContentTab {
    val path = window.location.pathname.removePrefix("/")
    return ContentTab.entries.find { it.path == path } ?: ContentTab.Biography
}
