package component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import kotlinx.browser.window
import org.jetbrains.compose.resources.stringResource
import portfolio.web.generated.resources.*


@Composable
internal fun ColumnScope.Footer() = Footer(
    modifier = Modifier.align(Alignment.CenterHorizontally),
)

private const val RepositoryHref = "https://github.com/subroh0508/portfolio"

@Composable
private fun Footer(
    modifier: Modifier = Modifier,
) = Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = modifier.padding(top = 48.dp, bottom = 16.dp),
) {
    Text(
        stringResource(Res.string.last_modified, "2024-05-13T04:04:00+0900"),
        color = MaterialTheme.colorScheme.outline,
        style = MaterialTheme.typography.bodyMedium,
    )

    Text(
        stringResource(Res.string.sourcecode),
        color = MaterialTheme.colorScheme.outline,
        style = MaterialTheme.typography.bodyMedium,
        textDecoration = TextDecoration.Underline,
        modifier = Modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null,
            onClick = { window.open(RepositoryHref, "_blank") },
        ).pointerHoverIcon(PointerIcon.Hand),
    )
}
