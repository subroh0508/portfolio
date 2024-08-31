package component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.runComposeUiTest
import androidx.compose.ui.unit.dp
import component.work.Noctiluca
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class CardGridTest {
    @Test
    fun shouldDisplayOneColumn() = runComposeUiTest {
        setContent {
            Box(Modifier.width(320.dp)) {
                WorkGrid()
            }
        }

        onAllNodes(hasTestTag(PortfolioTag.CARD_GRID_COLUMN))
            .assertCountEquals(1)
    }

    @Test
    fun shouldDisplayTwoColumns() = runComposeUiTest {
        setContent {
            Box(Modifier.width((WorkCardMinWidth + 8.dp) * 2)) {
                WorkGrid()
            }
        }

        onAllNodes(hasTestTag(PortfolioTag.CARD_GRID_COLUMN))
            .assertCountEquals(2)
    }

    @Composable
    private fun WorkGrid() = CardGrid(
        WorkCardMinWidth,
        listOf(Noctiluca, Noctiluca),
    ) { work -> WorkCard(work) }
}
