package section

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import component.accountchip.*
import component.accountchip.Bluesky
import component.accountchip.Facebook
import component.accountchip.GitHub
import component.accountchip.Lapras
import component.accountchip.X
import config.MediumWidth
import config.MinWidth
import config.SmallWidth

@Composable
internal fun AccountsSection() = Column(
    modifier = Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally,
) {
    ResponsiveRow(
        { X() },
        { Bluesky() },
        { Facebook() },
    )

    ResponsiveRow(
        { GitHub() },
        { Lapras() },
        { Wantedly() },
        { Youtrust() },
    )

    Spacer(Modifier.size(24.dp))
}

@Composable
private fun ResponsiveRow(
    vararg chip: @Composable RowScope.() -> Unit,
) = ResponsiveRow(chip.toList())

@Composable
private fun ResponsiveRow(
    chip: List<@Composable RowScope.() -> Unit>,
) = BoxWithConstraints {
    val chunkedSize = when {
        maxWidth < MinWidth -> 1
        maxWidth in MinWidth..<SmallWidth -> 2
        (maxWidth in SmallWidth..<MediumWidth) && chip.size == 4 -> 2
        maxWidth in SmallWidth..<MediumWidth -> 3
        else -> chip.size
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        chip.chunked(chunkedSize).forEach { row ->
            ChipRow { row.forEach { it() } }
        }
    }
}

@Composable
private fun ChipRow(
    content: @Composable RowScope.() -> Unit,
) = Row(
    modifier = Modifier.padding(horizontal = 16.dp),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
) { content() }
