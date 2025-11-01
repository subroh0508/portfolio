package component

import PortfolioTag
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Tag
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import component.work.Time
import component.work.Work
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.stringResource
import utils.openWindow

internal val WorkCardMinWidth = 240.dp

private val WorkCardThumbnailHeight = 240.dp

@Composable
internal fun WorkCard(
    work: Work,
    modifier: Modifier = Modifier,
) = WorkCard(
    stringResource(work.headline),
    stringResource(work.description),
    stringResource(work.type.label),
    work.time,
    linkButtons = {
        work.links.forEach {
            LinkButton(
                it.href,
                stringResource(it.label),
                it.icon,
                it.contentDescription,
            )
        }
    },
    thumbnail = {
        Image(
            imageResource(work.thumbnail),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
        )
    },
    modifier = modifier,
)

@Composable
internal fun WorkCard(
    headline: String,
    description: String,
    type: String,
    time: Time,
    linkButtons: @Composable () -> Unit,
    thumbnail: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) = ElevatedCard(modifier) {
    WorkCardThumbnail(
        type,
        thumbnail,
    )

    Column(
        modifier = Modifier.padding(16.dp),
    ) {
        WorkHeadline(
            headline,
            time,
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = description,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.testTag(PortfolioTag.WORK_CARD_DESCRIPTION),
        )

        Spacer(Modifier.height(16.dp))

        Row(
            modifier = Modifier.align(Alignment.End),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) { linkButtons() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun LinkButton(
    href: String,
    label: String,
    icon: ImageVector,
    contentDescription: String,
) = TooltipBox(
    positionProvider = TooltipDefaults.rememberTooltipPositionProvider(),
    state = rememberTooltipState(),
    tooltip = { PlainTooltip { Text(label) } },
) {
    FilledTonalIconButton(
        onClick = { openWindow(href) },
        modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
        )
    }
}

@Composable
private fun WorkCardThumbnail(
    type: String,
    thumbnail: @Composable () -> Unit,
) = Box(
    modifier = Modifier.fillMaxWidth()
        .height(WorkCardThumbnailHeight),
) {
    thumbnail()

    NoRippleAssistChip(
        onClick = { },
        colors = AssistChipDefaults.assistChipColors(
            containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.8F),
        ),
        border = null,
        leadingIcon = { Icon(Icons.Default.Tag, contentDescription = null) },
        label = { Text(type) },
        modifier = Modifier.align(Alignment.BottomEnd)
            .offset(x = (-8).dp, y = (-4).dp)
            .testTag(PortfolioTag.WORK_CARD_TAG),
    )
}

@Composable
private fun WorkHeadline(
    headline: String,
    time: Time,
) = Column {
    Text(
        text = headline,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier.testTag(PortfolioTag.WORK_CARD_HEADLINE),
    )

    Spacer(Modifier.height(4.dp))

    Text(
        text = time.toString(),
        color = MaterialTheme.colorScheme.outline,
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.testTag(PortfolioTag.WORK_CARD_TIME),
    )
}
