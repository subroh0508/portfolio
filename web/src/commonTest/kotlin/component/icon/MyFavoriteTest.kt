package component.icon

import androidx.compose.ui.test.*
import assertion.assertsEqualsHref
import kotlinx.coroutines.test.runTest
import mock.mockWindowOpen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import portfolio.web.generated.resources.Res
import toImageBitmap
import kotlin.test.Test

private const val CONTENT_DESCRIPTION = "test"

@OptIn(ExperimentalTestApi::class, ExperimentalResourceApi::class)
class MyFavoriteTest {
    @Test
    fun shouldDisplay() = runComposeUiTest {
        runTest {
            val bitmap = Res.readBytes("test.png").toImageBitmap()

            setContent {
                MyFavourite(
                    bitmap,
                    contentDescription = CONTENT_DESCRIPTION,
                )
            }

            onNodeWithContentDescription(CONTENT_DESCRIPTION)
                .assertIsDisplayed()
        }
    }
}
