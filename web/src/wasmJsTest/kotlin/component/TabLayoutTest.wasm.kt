package component

import androidx.compose.runtime.mutableStateOf
import kotlinx.browser.window
import kotlin.test.Test
import kotlin.test.assertEquals

class TabLayoutTestWasm {
    @Test
    fun HandleTabChange_shouldChangeLocationPathname() {
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
