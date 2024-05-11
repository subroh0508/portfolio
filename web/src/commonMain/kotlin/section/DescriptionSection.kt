package section

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import component.AccountLink
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import portfolio.web.generated.resources.*
import portfolio.web.generated.resources.Res
import portfolio.web.generated.resources.icon
import portfolio.web.generated.resources.id
import portfolio.web.generated.resources.name

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun DescriptionSection() = Column(
    modifier = Modifier.fillMaxWidth()
        .padding(16.dp),
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

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        AccountLink(
            painterResource(Res.drawable.x),
            Res.string.x,
            Res.string.href_x,
            lightColor = Color.Black,
            darkColor = Color.White,
        )

        AccountLink(
            painterResource(Res.drawable.bluesky),
            Res.string.bluesky,
            Res.string.href_bluesky,
        )

        AccountLink(
            imageResource(Res.drawable.facebook),
            Res.string.facebook,
            Res.string.href_facebook,
        )
    }
}
