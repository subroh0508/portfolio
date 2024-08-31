package component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.runComposeUiTest
import androidx.compose.ui.unit.dp
import component.icon.DescriptionKotlin
import component.icon.MyFavourite
import component.icon.MyFavouriteImageSize
import org.jetbrains.compose.resources.imageResource
import portfolio.web.generated.resources.Res
import portfolio.web.generated.resources.kotlin
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class IconGridTest {
    @Test
    fun shouldDisplayOneRow() = runComposeUiTest {
        setContent {
            Box(Modifier.size(250.dp)) {
                IconGrid()
            }
        }

        onAllNodes(hasTestTag(PortfolioTag.ICON_GRID_ROW))
            .assertCountEquals(1)
    }

    @Test
    fun shouldDisplayTwoRows() = runComposeUiTest {
        setContent {
            Box(Modifier.size(150.dp)) {
                IconGrid()
            }
        }

        onAllNodes(hasTestTag(PortfolioTag.ICON_GRID_ROW))
            .assertCountEquals(2)
    }

    @Test
    fun shouldDisplayThreeRows() = runComposeUiTest {
        setContent {
            Box(Modifier.size(100.dp)) {
                IconGrid()
            }
        }

        onAllNodes(hasTestTag(PortfolioTag.ICON_GRID_ROW))
            .assertCountEquals(3)
    }

    @Composable
    private fun IconGrid() = IconGrid(
        MyFavouriteImageSize,
        Res.drawable.kotlin to DescriptionKotlin,
        Res.drawable.kotlin to DescriptionKotlin,
        Res.drawable.kotlin to DescriptionKotlin,
    ) { drawable, string ->
        MyFavourite(
            imageResource(drawable),
            string,
            withCircle = false,
        )
    }
}
