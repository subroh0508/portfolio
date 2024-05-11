package theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.FontResource
import portfolio.web.generated.resources.*
import portfolio.web.generated.resources.NotoSansJP_ExtraLight
import portfolio.web.generated.resources.NotoSansJP_Thin
import portfolio.web.generated.resources.Res

private data class FontSet(
    val fileName: String,
    val weight: FontWeight,
    val style: FontStyle,
)

@OptIn(ExperimentalResourceApi::class)
private val fontSets: List<Triple<FontResource, FontWeight, FontStyle>> = listOf(
    Triple(Res.font.NotoSansJP_Thin, FontWeight.Thin, FontStyle.Normal),
    Triple(Res.font.NotoSansJP_ExtraLight, FontWeight.ExtraLight, FontStyle.Normal),
    Triple(Res.font.NotoSansJP_Light, FontWeight.Light, FontStyle.Normal),
    Triple(Res.font.NotoSansJP_Regular, FontWeight.W400, FontStyle.Normal),
    Triple(Res.font.NotoSansJP_Medium, FontWeight.Medium, FontStyle.Normal),
    Triple(Res.font.NotoSansJP_SemiBold, FontWeight.SemiBold, FontStyle.Normal),
    Triple(Res.font.NotoSansJP_Bold, FontWeight.Bold, FontStyle.Normal),
    Triple(Res.font.NotoSansJP_ExtraBold, FontWeight.ExtraBold, FontStyle.Normal),
    Triple(Res.font.NotoSansJP_Black, FontWeight.Black, FontStyle.Normal),
)

@OptIn(ExperimentalResourceApi::class)
@Composable
fun rememberFontFamily() = FontFamily(
    fontSets.map { (res, weight, style) -> Font(res, weight, style) },
)
