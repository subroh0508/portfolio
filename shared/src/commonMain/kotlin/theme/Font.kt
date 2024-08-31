package theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.FontResource
import portfolio.shared.generated.resources.*
import portfolio.shared.generated.resources.Res

private val fontSets: List<Triple<FontResource, FontWeight, FontStyle>> = listOf(
    Triple(Res.font.MPLUS1p_Regular, FontWeight.Normal, FontStyle.Normal),
)

@Composable
fun rememberFontFamily() = FontFamily(
    fontSets.map { (res, weight, style) -> Font(res, weight, style) },
)
