import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import component.AppScaffold
import config.*
import page.Biography
import section.BiographySection
import section.DescriptionSection
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
            AppScaffold {
                DescriptionSection()
                BiographySection()
            }
        }
    }
}
