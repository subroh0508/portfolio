package component.work

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Movie
import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import portfolio.web.generated.resources.*

internal data class Work(
    val headline: StringResource,
    val description: StringResource,
    val type: WorkType,
    val links: List<Link>,
    val time: Time,
    val thumbnail: DrawableResource,
)

internal enum class WorkType(val label: StringResource) {
    Conference(Res.string.conference),
    StudyMeeting(Res.string.study_meeting),
    PersonalProject(Res.string.personal_project),
}

internal data class Link(
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
        Res.string.work_noctiluca_headline,
        Res.string.work_noctiluca_description,
        WorkType.PersonalProject,
        listOf(
            Link(
                "https://github.com/subroh0508/Noctiluca",
                Res.string.repository,
                Icons.Default.Code,
            ),
        ),
        Time.UntilNow(2022),
        Res.drawable.noctiluca,
    ),
    Work(
        Res.string.work_colormaster_headline,
        Res.string.work_colormaster_description,
        WorkType.PersonalProject,
        listOf(
            Link(
                "https://github.com/subroh0508/colormaster",
                Res.string.repository,
                Icons.Default.Code,
            ),
            Link(
                "https://imas-colormaster.web.app/",
                Res.string.try_it_now,
                Icons.AutoMirrored.Filled.OpenInNew,
            ),
        ),
        Time.UntilNow(2020),
        Res.drawable.colormaster,
    ),
    Work(
        Res.string.work_kotlinfest_2022_headline,
        Res.string.work_kotlinfest_2022_description,
        WorkType.Conference,
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
        WorkType.Conference,
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
        WorkType.Conference,
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
    Work(
        Res.string.work_kotlin_material_ui_headline,
        Res.string.work_kotlin_material_ui_description,
        WorkType.PersonalProject,
        listOf(),
        Time.Range(2019, 2022),
        Res.drawable.kotlin_material_ui,
    ),
)
