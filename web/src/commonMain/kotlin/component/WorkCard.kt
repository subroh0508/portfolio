package component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Tag
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import component.work.Link
import component.work.Time
import component.work.Work
import component.work.WorkType
import kotlinx.browser.window
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.stringResource

internal val WorkCardMinWidth = 240.dp

private val WorkCardThumbnailHeight = 240.dp

@Composable
internal fun WorkCard(
    work: Work,
    modifier: Modifier = Modifier,
) = ElevatedCard(modifier) {
    WorkCardThumbnail(
        work.thumbnail,
        work.type,
    )

    Column(
        modifier = Modifier.padding(16.dp),
    ) {
        WorkHeadline(
            work.headline,
            work.time,
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = stringResource(work.description),
            style = MaterialTheme.typography.bodyLarge,
        )

        Spacer(Modifier.height(16.dp))

        LinkButtons(
            work.links,
            modifier = Modifier.align(Alignment.End),
        )
    }
}

@Composable
private fun WorkCardThumbnail(
    thumbnail: DrawableResource,
    type: WorkType,
) = Box(
    modifier = Modifier.fillMaxWidth()
        .height(WorkCardThumbnailHeight),
) {
    Image(
        imageResource(thumbnail),
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )

    NoRippleAssistChip(
        onClick = { },
        colors = AssistChipDefaults.assistChipColors(
            containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.8F),
        ),
        border = null,
        leadingIcon = { Icon(Icons.Default.Tag, contentDescription = null) },
        label = { Text(stringResource(type.label)) },
        modifier = Modifier.align(Alignment.BottomEnd)
            .offset(x = (-8).dp, y = (-4).dp),
    )
}

@Composable
private fun WorkHeadline(
    headline: StringResource,
    time: Time,
) = Column {
    Text(
        text = stringResource(headline),
        style = MaterialTheme.typography.titleLarge,
    )

    Spacer(Modifier.height(4.dp))

    Text(
        text = time.toString(),
        color = MaterialTheme.colorScheme.outline,
        style = MaterialTheme.typography.bodyMedium,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LinkButtons(
    links: List<Link>,
    modifier: Modifier = Modifier,
) = Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.spacedBy(8.dp),
) {
    links.forEach { link ->
        TooltipBox(
            positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
            state = rememberTooltipState(),
            tooltip = { PlainTooltip { Text(stringResource(link.label)) } },
        ) {
            FilledTonalIconButton(
                onClick = { window.open(link.href, "_blank") },
                modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
            ) {
                Icon(
                    imageVector = link.icon,
                    contentDescription = null,
                )
            }
        }
    }
}
