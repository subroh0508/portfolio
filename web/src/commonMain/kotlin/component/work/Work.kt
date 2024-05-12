package component.work

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Movie
import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import portfolio.web.generated.resources.*
import portfolio.web.generated.resources.Res
import portfolio.web.generated.resources.droidkaigi2019
import portfolio.web.generated.resources.work_droidkaigi_2019_description
import portfolio.web.generated.resources.work_droidkaigi_2019_headline

internal data class Work(
    val headline: StringResource,
    val description: StringResource,
    val links: List<Link>,
    val time: Time,
    val thumbnail: DrawableResource,
)

data class Link(
    val href: String,
    val label: StringResource,
    val icon: ImageVector,
)

internal sealed class Time {
    data class UntilNow(val start: Int) : Time() {
        override fun toString() = "$start - Present"
    }
    data class Range(val start: Int, val end: Int) : Time() {
        override fun toString() = "$start - $end"
    }
    data class Event(val year: Int) : Time() {
        override fun toString() = year.toString()
    }
}

internal val Works = listOf(
    Work(
        Res.string.work_kotlinfest_2022_headline,
        Res.string.work_kotlinfest_2022_description,
        listOf(
            Link(
                "https://speakerdeck.com/subroh0508/hurontoendomojetpack-composedeshu-kitai-compose-for-webhamodanwebapurikesiyonnomeng-wojian-ruka",
                Res.string.slide,
                Icons.Default.Description,
            ),
            Link(
                "https://youtu.be/9KywTQJej1Q",
                Res.string.movie,
                Icons.Default.Movie,
            ),
        ),
        Time.Event(2022),
        Res.drawable.kotlinfest2022,
    ),
    Work(
        Res.string.work_kotlinfest_2019_headline,
        Res.string.work_kotlinfest_2019_description,
        listOf(
            Link(
                "https://speakerdeck.com/subroh0508/jsdezuo-tutagui-ji",
                Res.string.slide,
                Icons.Default.Description,
            ),
            Link(
                "https://youtu.be/-QrMI844kH4",
                Res.string.movie,
                Icons.Default.Movie,
            ),
        ),
        Time.Event(2019),
        Res.drawable.kotlinfest2019,
    ),
    Work(
        Res.string.work_droidkaigi_2019_headline,
        Res.string.work_droidkaigi_2019_description,
        listOf(
            Link(
                "https://speakerdeck.com/subroh0508/spek2-plus-mockk-plus-jacocodeiketeru-unit-testhuan-jing-woshou-niru-rero",
                Res.string.slide,
                Icons.Default.Description,
            ),
            Link(
                "https://youtu.be/MWaDPm0lwms",
                Res.string.movie,
                Icons.Default.Movie,
            ),
        ),
        Time.Event(2019),
        Res.drawable.droidkaigi2019,
    ),
)
