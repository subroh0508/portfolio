package component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Today
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import component.work.Link
import component.work.Time
import component.work.Work
import kotlinx.browser.window
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.stringResource

internal val WorkCardMinWidth = 240.dp

private val WorkCardThumbnailHeight = 240.dp

@Composable
internal fun WorkCard(
    work: Work,
    modifier: Modifier = Modifier,
) = ElevatedCard(modifier) {
    WorkCardThumbnail(work.thumbnail)

    Column(
        modifier = Modifier.padding(16.dp),
    ) {
        Text(
            text = stringResource(work.headline),
            style = MaterialTheme.typography.titleLarge,
        )

        Spacer(Modifier.height(4.dp))

        Text(
            text = work.time.toString(),
            color = MaterialTheme.colorScheme.outline,
            style = MaterialTheme.typography.bodyMedium,
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
) = Box(
    modifier = Modifier.fillMaxWidth()
        .height(WorkCardThumbnailHeight),
) {
    Image(
        imageResource(thumbnail),
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )
}

@Composable
private fun LinkButtons(
    links: List<Link>,
    modifier: Modifier = Modifier,
) = Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.spacedBy(8.dp),
) {
    links.forEach { link ->
        FilledTonalButton(
            onClick = { window.open(link.href, "_blank") },
            contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
        ) {
            Icon(
                imageVector = link.icon,
                contentDescription = null,
            )
            Spacer(Modifier.width(8.dp))
            Text(stringResource(link.label))
        }
    }
}
