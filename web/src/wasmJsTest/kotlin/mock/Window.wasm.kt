package mock

actual fun mockWindowOpen() {
    js("window.open = function(url, target) { window.history.replaceState(null, \"\", url) }")
}
