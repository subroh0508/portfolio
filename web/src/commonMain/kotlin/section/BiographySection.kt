package section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import portfolio.web.generated.resources.Res
import portfolio.web.generated.resources.biography

@Composable
internal fun BiographySection() = Column(
    modifier = Modifier.padding(32.dp),
) {
    Text(
        stringResource(Res.string.biography),
        style = MaterialTheme.typography.bodyLarge,
    )
}
