import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import component.*
import component.AppScaffold
import component.ContentTab
import component.Footer
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
                footer = { width ->
                    Footer(
                        modifier = Modifier.width(width),
                    )
                },
            ) {
                item { HandleNameSection() }
                item { AccountsSection() }
                item { PortfolioContent() }
            }
        }
    }
}

@Composable
private fun PortfolioContent() = TabLayout(
    ContentTab.Biography,
    tabs = { currentTab ->
        ContentTab.entries.forEach {
            Tab(
                currentTab.value == it,
                text = { Text(stringResource(it.label)) },
                icon = { Icon(it.icon, contentDescription = null) },
                onClick = { currentTab.value = it },
            )
        }
    },
    content = { tab ->
        BiographySection(tab == ContentTab.Biography)
        MyFavoritesSection(tab == ContentTab.MyFavorites)
        WorksSection(tab == ContentTab.Works)
    },
)
