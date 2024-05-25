package component.accountchip

import PortfolioTag
import androidx.compose.runtime.*
import androidx.compose.ui.test.*
import assertion.assertsEqualsHref
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import mock.mockWindowOpen
import org.jetbrains.compose.resources.*
import org.jetbrains.skiko.loadBytesFromPath
import portfolio.web.generated.resources.*
import portfolio.web.generated.resources.Res
import portfolio.web.generated.resources.lapras
import toImageBitmap
import kotlin.test.Test

private const val SITE_NAME = "Site Name"
private const val URL = "https://example.com"

@OptIn(ExperimentalTestApi::class, ExperimentalResourceApi::class)
class AccountLinkTest {
    @Test
    fun shouldOpenWindowIfClick() = runComposeUiTest {
        mockWindowOpen()

        runTest {
            val bitmap = Res.readBytes("test.png").toImageBitmap()

            setContent {
                AccountLink(
                    icon = { ServiceIcon(bitmap) },
                    SITE_NAME,
                    URL,
                )
            }

            onNodeWithTag(PortfolioTag.ACCOUNT_LINK)
                .assertTextEquals(SITE_NAME)
                .performClick()

            assertsEqualsHref(URL)
        }
    }
}
