package component.accountchip

import PortfolioTag
import androidx.compose.ui.test.*
import assertion.assertsEqualsHref
import mock.mockWindowOpen
import org.jetbrains.compose.resources.*
import portfolio.web.generated.resources.Res
import portfolio.web.generated.resources.lapras
import kotlin.test.Test

private const val SITE_NAME = "Site Name"
private const val URL = "https://example.com"

@OptIn(ExperimentalTestApi::class)
class AccountLinkTest {
    @Test
    fun shouldOpenWindowIfClick() = runComposeUiTest {
        mockWindowOpen()

        setContent {
            AccountLink(
                icon = { ServiceIcon(imageResource(Res.drawable.lapras)) },
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
