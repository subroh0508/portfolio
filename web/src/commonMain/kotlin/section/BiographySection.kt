package section

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import portfolio.web.generated.resources.Res
import portfolio.web.generated.resources.biography

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun BiographySection() = Text(
    stringResource(Res.string.biography),
    style = MaterialTheme.typography.bodyMedium,
)
