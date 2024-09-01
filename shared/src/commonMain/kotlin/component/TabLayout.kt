package component

import androidx.compose.foundation.layout.Box
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
import portfolio.shared.generated.resources.*

enum class ContentTab(
    val label: StringResource,
    val icon: ImageVector,
    val path: String,
) {
    Biography(Res.string.tab_biography, Icons.Default.Person, ""),
    MyFavorites(Res.string.tab_my_favourites, Icons.Default.Favorite, "my_fave"),
    Works(Res.string.tab_works, Icons.Default.EmojiEvents, "works"),
}

@Composable
internal fun TabLayout(
    current: ContentTab,
    tabState: MutableState<ContentTab> = remember { mutableStateOf(current) },
    tabs: @Composable (MutableState<ContentTab>) -> Unit,
    content: @Composable (ContentTab) -> Unit,
) = Column(
    modifier = Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally,
) {
    TabRow(
        selectedTabIndex = tabState.value.ordinal,
        tabs = { tabs(tabState) },
        modifier = Modifier.width(MinWidth),
    )

    Box(
        contentAlignment = Alignment.TopCenter,
    ) { content(tabState.value) }
}

internal expect fun MutableState<ContentTab>.handleTabChange(
    next: ContentTab,
)
