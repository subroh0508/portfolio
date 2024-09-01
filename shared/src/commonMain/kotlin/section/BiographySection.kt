package section

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import component.AnimatedSection
import component.Footer
import org.jetbrains.compose.resources.stringResource
import portfolio.shared.generated.resources.Res
import portfolio.shared.generated.resources.biography

@Composable
internal fun BiographySection(
    visible: Boolean,
) = AnimatedSection(
    visible,
    modifier = Modifier.fillMaxHeight()
        .padding(32.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
) {
    Text(
        stringResource(Res.string.biography),
        style = MaterialTheme.typography.bodyLarge,
    )

    Spacer(Modifier.weight(1F))

    Footer()
}
