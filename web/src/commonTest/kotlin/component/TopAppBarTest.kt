package component

import PortfolioTag
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.*
import config.AppConfigState
import config.ColorTheme
import config.Lang
import config.LocalAppConfigState
import kotlin.test.Test
import kotlin.test.assertEquals

private const val TITLE = "Title"

@OptIn(ExperimentalTestApi::class)
class TopAppBarTest {
    @Test
    fun shouldChangeAppConfig() = runComposeUiTest {
        val appConfigState = AppConfigState(
            theme = ColorTheme.Light,
            lang = Lang.JA,
        )

        setContent {
            CompositionLocalProvider(
                LocalAppConfigState provides  appConfigState,
            ) {
                TopAppBar(title = {
                    Text(
                        TITLE,
                        modifier = Modifier.testTag(PortfolioTag.TOP_APP_BAR_TITLE),
                    )
                })
            }
        }

        onNodeWithTag(PortfolioTag.TOP_APP_BAR_TITLE)
            .assertTextEquals(TITLE)

        onNodeWithTag(PortfolioTag.TOP_APP_BAR_COLOR_THEME_BUTTON)
            .performClick()

        assertEquals(appConfigState.theme, ColorTheme.Dark)

        onNodeWithTag(PortfolioTag.TOP_APP_BAR_COLOR_THEME_BUTTON)
            .performClick()

        assertEquals(appConfigState.theme, ColorTheme.Light)
    }
}
