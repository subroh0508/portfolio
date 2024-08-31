import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import component.*
import component.AppScaffold
import component.ContentTab
import component.TabLayout
import component.TopAppBar
import config.*
import org.jetbrains.compose.resources.stringResource
import section.AccountsSection
import section.BiographySection
import section.HandleNameSection
import section.MyFavoritesSection
import section.WorksSection
import theme.rememberTypography

@Composable
fun PortfolioApp(
    current: ContentTab,
    useDarkTheme: Boolean = isSystemInDarkTheme(),
) {
    val config = rememberAppConfigState(useDarkTheme)
    val typography = rememberTypography()

    CompositionLocalProvider(
        LocalAppConfigState provides config,
    ) {
        MaterialTheme(
            colorScheme = config.theme.schema,
            typography = typography,
        ) {
            AppScaffold(
                header = { width ->
                    TopAppBar(
                        modifier = Modifier.width(width),
                    )
                },
            ) {
                item { HandleNameSection() }
                item { AccountsSection() }
                item { PortfolioContent(current) }
            }
        }
    }
}

@Composable
private fun PortfolioContent(
    current: ContentTab,
) = TabLayout(
    current,
    tabs = { currentTab ->
        ContentTab.entries.forEach {
            Tab(
                currentTab.value == it,
                text = { Text(stringResource(it.label)) },
                icon = { Icon(it.icon, contentDescription = null) },
                onClick = { currentTab.handleTabChange(it) },
                modifier = Modifier.pointerHoverIcon(PointerIcon.Hand),
            )
        }
    },
    content = { tab ->
        BiographySection(tab == ContentTab.Biography)
        MyFavoritesSection(tab == ContentTab.MyFavorites)
        WorksSection(tab == ContentTab.Works)
    },
)
