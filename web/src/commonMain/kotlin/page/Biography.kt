package page

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import components.AsyncImage

@Composable
fun Biography() {
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
        ) {
            AsyncImage(
                "icon.webp",
                "Subroh Nishikori's Icon",
                modifier = Modifier.size(96.dp)
                    .clip(CircleShape),
            )

            Spacer(Modifier.size(16.dp))

            Text(
                "Subroh Nishikori",
                style = MaterialTheme.typography.headlineMedium,
            )
        }
    }
}
