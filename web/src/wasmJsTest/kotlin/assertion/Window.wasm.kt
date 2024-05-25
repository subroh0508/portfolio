package assertion

import kotlinx.browser.window
import kotlin.test.assertEquals

private external object State : JsAny {
    val href: String
}

actual fun assertsEqualsHref(href: String) = assertEquals(
    (window.history.state?.unsafeCast<State>())?.href,
    href,
)
