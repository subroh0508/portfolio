import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import components.AppScaffold
import config.*
import page.Biography

@Composable
fun PortfolioApp(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
) {
    val config = rememberAppConfigState(useDarkTheme)

    CompositionLocalProvider(
        LocalAppConfigState provides config,
    ) {
        MaterialTheme(config.theme.schema) {
            AppScaffold {
                Biography()
            }
        }
    }
}
