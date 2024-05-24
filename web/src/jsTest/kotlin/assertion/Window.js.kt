package assertion

import kotlinx.browser.window
import kotlin.test.assertEquals

actual fun assertsEqualsHref(href: String) = assertEquals(window.location.href, href)
