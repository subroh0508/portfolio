package section

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.stringResource
import portfolio.web.generated.resources.Res
import portfolio.web.generated.resources.icon
import portfolio.web.generated.resources.id
import portfolio.web.generated.resources.name

@Composable
internal fun HandleNameSection() = Column (
    modifier = Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally,
) {
    Image(
        imageResource(Res.drawable.icon),
        "Icon",
        modifier = Modifier.size(96.dp)
            .clip(CircleShape),
    )

    Spacer(Modifier.size(16.dp))

    Text(
        stringResource(Res.string.name),
        style = MaterialTheme.typography.headlineLarge,
    )

    Text(
        stringResource(Res.string.id),
        color = MaterialTheme.colorScheme.outline,
        style = MaterialTheme.typography.titleMedium,
    )

    Spacer(Modifier.size(24.dp))
}
