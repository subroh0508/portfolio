import component.ContentTab
import kotlinx.browser.window
import kotlin.test.Test
import kotlin.test.assertEquals

class PathTest {
    @Test
    fun testBuildContentPath() {
        listOf(
            "" to ContentTab.Biography,
            "my_fave" to ContentTab.MyFavorites,
            "works" to ContentTab.Works,
            "unknown_path" to ContentTab.Biography,
        ).forEach { (path, tab) ->
            window.history.replaceState(null, "", "/$path")
            assertEquals(tab, buildContentPath())
        }
    }
}
