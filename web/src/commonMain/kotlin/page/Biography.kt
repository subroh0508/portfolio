package page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.stringResource
import portfolio.web.generated.resources.Res
import portfolio.web.generated.resources.icon
import portfolio.web.generated.resources.name

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Biography() {
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
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
                style = MaterialTheme.typography.headlineMedium,
            )
        }
    }
}
