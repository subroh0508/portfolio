package component

import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.*
import org.jetbrains.compose.resources.stringResource
import kotlin.test.Test
import kotlin.test.assertEquals

private const val CONTENT_TAG = "content"

@OptIn(ExperimentalTestApi::class)
class TabLayoutTest {
    @Test
    fun shouldChangeContentTab() = runComposeUiTest {
        val tabState = mutableStateOf(ContentTab.Biography)

        setContent {
            TabLayout(
                ContentTab.Biography,
                tabState = tabState,
                tabs = { currentTab ->
                    ContentTab.entries.forEach { tab ->
                        Tab(
                            currentTab.value == tab,
                            text = { Text(stringResource(tab.label)) },
                            icon = { Icon(tab.icon, contentDescription = null) },
                            onClick = { currentTab.handleTabChange(tab) },
                            modifier = Modifier.pointerHoverIcon(PointerIcon.Hand)
                                .testTag(tab.name),
                        )
                    }
                },
            ) {
                Text(
                    it.name,
                    modifier = Modifier.testTag(CONTENT_TAG),
                )
            }
        }

        assertContentTab(tabState, ContentTab.MyFavorites)
        assertContentTab(tabState, ContentTab.Works)
        assertContentTab(tabState, ContentTab.Biography)
    }

    private fun ComposeUiTest.assertContentTab(
        tabState: MutableState<ContentTab>,
        tab: ContentTab,
    ) {
        onNodeWithTag(tab.name)
            .performClick()

        assertEquals(tab, tabState.value)

        onNodeWithTag(CONTENT_TAG)
            .assertTextEquals(tab.name)
    }
}
