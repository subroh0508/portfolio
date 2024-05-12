package component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.TabRow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import config.MinWidth
import org.jetbrains.compose.resources.StringResource
import portfolio.web.generated.resources.*

internal enum class ContentTab(
    val label: StringResource,
    val icon: ImageVector,
) {
    Biography(Res.string.tab_biography, Icons.Default.Person),
    MyFavorites(Res.string.tab_my_favourites, Icons.Default.Favorite),
    Works(Res.string.tab_works, Icons.Default.EmojiEvents),
}

@Composable
internal fun TabLayout(
    current: ContentTab,
    tabs: @Composable (MutableState<ContentTab>) -> Unit,
    content: @Composable (ContentTab) -> Unit,
) {
    val currentTab = remember { mutableStateOf(current) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TabRow(
            selectedTabIndex = currentTab.value.ordinal,
            tabs = { tabs(currentTab) },
            modifier = Modifier.width(MinWidth),
        )

        content(currentTab.value)
    }
}
