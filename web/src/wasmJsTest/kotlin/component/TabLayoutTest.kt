package component

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import kotlinx.browser.window
import kotlin.test.Test
import kotlin.test.assertEquals

class TabLayoutTest {
    @Test
    fun testHandleTabChangeExtension() {
        listOf(
            ContentTab.Biography to "",
            ContentTab.MyFavorites to "my_fave",
            ContentTab.Works to "works",
        ).forEach { (tab, path) ->
            val state = mutableStateOf(ContentTab.Biography)
            state.handleTabChange(tab)

            assertEquals(tab, state.value)
            assertEquals("/$path", window.location.pathname)
        }
    }
}
