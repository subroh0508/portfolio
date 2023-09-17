package theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import org.jetbrains.skiko.loadBytesFromPath

private data class FontSet(
    val fileName: String,
    val weight: FontWeight,
    val style: FontStyle,
)

private val fontSets: List<FontSet> = listOf(
    FontSet("NotoSansJP-Medium.ttf", FontWeight.Medium, FontStyle.Normal),
    FontSet("NotoSansJP-Regular.ttf", FontWeight.W400, FontStyle.Normal),
    FontSet("NotoSansJP-Black.ttf", FontWeight.Black, FontStyle.Normal),
    FontSet("NotoSansJP-Bold.ttf", FontWeight.Bold, FontStyle.Normal),
    FontSet("NotoSansJP-ExtraBold.ttf", FontWeight.ExtraBold, FontStyle.Normal),
    FontSet("NotoSansJP-ExtraLight.ttf", FontWeight.ExtraLight, FontStyle.Normal),
    FontSet("NotoSansJP-Light.ttf", FontWeight.Light, FontStyle.Normal),
    FontSet("NotoSansJP-SemiBold.ttf", FontWeight.SemiBold, FontStyle.Normal),
    FontSet("NotoSansJP-Thin.ttf", FontWeight.Thin, FontStyle.Normal),
)

@Composable
fun rememberFontFamily(): FontFamily {
    val fontFamily = remember { mutableStateOf(listOf<Font>()) }

    LaunchedEffect(Unit) {
        fontFamily.value = fontSets.map {
            val byte = loadBytesFromPath("fonts/${it.fileName}")

            Font(it.fileName, byte, it.weight, it.style)
        }
    }

    return if (fontFamily.value.isEmpty()) FontFamily.Default else FontFamily(fontFamily.value)
}
