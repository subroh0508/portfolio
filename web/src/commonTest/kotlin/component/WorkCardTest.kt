package component

import PortfolioTag
import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Movie
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.test.*
import assertion.assertsEqualsHref
import component.work.Noctiluca
import component.work.Time
import mock.mockWindowOpen
import org.jetbrains.compose.resources.imageResource
import portfolio.web.generated.resources.Res
import portfolio.web.generated.resources.kotlinfest2022
import kotlin.test.Test
import kotlin.test.assertEquals

private const val WORK_HEADLINE = "Headline"
private const val WORK_DESCRIPTION = "Description"
private const val WORK_TYPE = "Conference"
private const val WORK_LINK_LABEL_SLIDE = "SpeakerDeck"
private const val WORK_LINK_HREF_SLIDE = "https://speakerdeck.com"
private const val WORK_LINK_CONTENT_DESCRIPTION_SLIDE = "Slide"
private const val WORK_LINK_LABEL_MOVIE = "YouTube"
private const val WORK_LINK_HREF_MOVIE = "https://youtu.be"
private const val WORK_LINK_CONTENT_DESCRIPTION_MOVIE = "Movie"

private val time = Time.Event(2022)

private data class Link(
    val href: String,
    val label: String,
    val icon: ImageVector,
    val contentDescription: String,
)

private val links = listOf(
    Link(
        WORK_LINK_HREF_SLIDE,
        WORK_LINK_LABEL_SLIDE,
        Icons.Default.Description,
        WORK_LINK_CONTENT_DESCRIPTION_SLIDE,
    ),
    Link(
        WORK_LINK_HREF_MOVIE,
        WORK_LINK_LABEL_MOVIE,
        Icons.Default.Movie,
        WORK_LINK_CONTENT_DESCRIPTION_MOVIE,
    ),
)

@OptIn(ExperimentalTestApi::class)
class WorkCardTest {
    @Test
    fun Time_shouldSerialize() {
        listOf(
            Time.UntilNow(2022) to "2022 - Present",
            Time.Range(2022, 2023) to "2022 - 2023",
            Time.Event(2022) to "2022",
        ).forEach { (time, expected) ->
            assertEquals(time.toString(), expected)
        }
    }

    @Test
    fun shouldDisplay() = runComposeUiTest {
        mockWindowOpen()

        setContent {
            WorkCard(
                WORK_HEADLINE,
                WORK_DESCRIPTION,
                WORK_TYPE,
                time,
                linkButtons = {
                    links.forEach { (href, label, icon, contentDescription) ->
                        LinkButton(
                            href,
                            label,
                            icon,
                            contentDescription,
                        )
                    }
                },
                thumbnail = {
                    Image(
                        imageResource(Res.drawable.kotlinfest2022),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                },
            )
        }

        onNodeWithTag(PortfolioTag.WORK_CARD_TAG)
            .assertTextEquals(WORK_TYPE)

        onNodeWithTag(PortfolioTag.WORK_CARD_HEADLINE)
            .assertTextEquals(WORK_HEADLINE)

        onNodeWithTag(PortfolioTag.WORK_CARD_DESCRIPTION)
            .assertTextEquals(WORK_DESCRIPTION)

        onNodeWithTag(PortfolioTag.WORK_CARD_TIME)
            .assertTextEquals(time.toString())

        links.forEach { (href, _, _, contentDescription) ->
            onNodeWithContentDescription(contentDescription)
                .assertIsDisplayed()
                .performClick()

            assertsEqualsHref(href)
        }
    }
}
