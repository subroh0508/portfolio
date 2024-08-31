package utils

import component.ContentTab

expect fun openWindow(url: String, target: String = "_blank")

expect fun buildContentPath(): ContentTab
