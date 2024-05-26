package theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val BodyLargeLineHeight = 24.0.sp
private val BodyLargeSize = 16.sp
private val BodyLargeTracking = 0.5.sp
private val BodyLargeWeight = FontWeight.Normal
private val BodyMediumLineHeight = 20.0.sp
private val BodyMediumSize = 14.sp
private val BodyMediumTracking = 0.2.sp
private val BodyMediumWeight = FontWeight.Normal
private val BodySmallLineHeight = 16.0.sp
private val BodySmallSize = 12.sp
private val BodySmallTracking = 0.4.sp
private val BodySmallWeight = FontWeight.Normal
private val DisplayLargeLineHeight = 64.0.sp
private val DisplayLargeSize = 57.sp
private val DisplayLargeTracking = (-0.2).sp
private val DisplayLargeWeight = FontWeight.Normal
private val DisplayMediumLineHeight = 52.0.sp
private val DisplayMediumSize = 45.sp
private val DisplayMediumTracking = 0.0.sp
private val DisplayMediumWeight = FontWeight.Normal
private val DisplaySmallLineHeight = 44.0.sp
private val DisplaySmallSize = 36.sp
private val DisplaySmallTracking = 0.0.sp
private val DisplaySmallWeight = FontWeight.Normal
private val HeadlineLargeLineHeight = 40.0.sp
private val HeadlineLargeSize = 32.sp
private val HeadlineLargeTracking = 0.0.sp
private val HeadlineLargeWeight = FontWeight.Normal
private val HeadlineMediumLineHeight = 36.0.sp
private val HeadlineMediumSize = 28.sp
private val HeadlineMediumTracking = 0.0.sp
private val HeadlineMediumWeight = FontWeight.Normal
private val HeadlineSmallLineHeight = 32.0.sp
private val HeadlineSmallSize = 24.sp
private val HeadlineSmallTracking = 0.0.sp
private val HeadlineSmallWeight = FontWeight.Normal
private val LabelLargeLineHeight = 20.0.sp
private val LabelLargeSize = 14.sp
private val LabelLargeTracking = 0.1.sp
private val LabelLargeWeight = FontWeight.Medium
private val LabelMediumLineHeight = 16.0.sp
private val LabelMediumSize = 12.sp
private val LabelMediumTracking = 0.5.sp
private val LabelMediumWeight = FontWeight.Medium
private val LabelSmallLineHeight = 16.0.sp
private val LabelSmallSize = 11.sp
private val LabelSmallTracking = 0.5.sp
private val LabelSmallWeight = FontWeight.Medium
private val TitleLargeLineHeight = 28.0.sp
private val TitleLargeSize = 22.sp
private val TitleLargeTracking = 0.0.sp
private val TitleLargeWeight = FontWeight.Normal
private val TitleMediumLineHeight = 24.0.sp
private val TitleMediumSize = 16.sp
private val TitleMediumTracking = 0.2.sp
private val TitleMediumWeight = FontWeight.Medium
private val TitleSmallLineHeight = 20.0.sp
private val TitleSmallSize = 14.sp
private val TitleSmallTracking = 0.1.sp
private val TitleSmallWeight = FontWeight.Medium

@Suppress("LongMethod")
@Composable
fun rememberTypography(): Typography {
    val fontFamily = rememberFontFamily()

    return Typography(
        displayLarge = TextStyle(
            fontFamily = fontFamily,
            fontSize = DisplayLargeSize,
            fontWeight = DisplayLargeWeight,
            lineHeight = DisplayLargeLineHeight,
            letterSpacing = DisplayLargeTracking,
        ),
        displayMedium = TextStyle(
            fontFamily = fontFamily,
            fontSize = DisplayMediumSize,
            fontWeight = DisplayMediumWeight,
            lineHeight = DisplayMediumLineHeight,
            letterSpacing = DisplayMediumTracking,
        ),
        displaySmall = TextStyle(
            fontFamily = fontFamily,
            fontSize = DisplaySmallSize,
            fontWeight = DisplaySmallWeight,
            lineHeight = DisplaySmallLineHeight,
            letterSpacing = DisplaySmallTracking,
        ),
        headlineLarge = TextStyle(
            fontFamily = fontFamily,
            fontSize = HeadlineLargeSize,
            fontWeight = HeadlineLargeWeight,
            lineHeight = HeadlineLargeLineHeight,
            letterSpacing = HeadlineLargeTracking,
        ),
        headlineMedium = TextStyle(
            fontFamily = fontFamily,
            fontSize = HeadlineMediumSize,
            fontWeight = HeadlineMediumWeight,
            lineHeight = HeadlineMediumLineHeight,
            letterSpacing = HeadlineMediumTracking,
        ),
        headlineSmall = TextStyle(
            fontFamily = fontFamily,
            fontSize = HeadlineSmallSize,
            fontWeight = HeadlineSmallWeight,
            lineHeight = HeadlineSmallLineHeight,
            letterSpacing = HeadlineSmallTracking,
        ),
        titleLarge = TextStyle(
            fontFamily = fontFamily,
            fontSize = TitleLargeSize,
            fontWeight = TitleLargeWeight,
            lineHeight = TitleLargeLineHeight,
            letterSpacing = TitleLargeTracking,
        ),
        titleMedium = TextStyle(
            fontFamily = fontFamily,
            fontSize = TitleMediumSize,
            fontWeight = TitleMediumWeight,
            lineHeight = TitleMediumLineHeight,
            letterSpacing = TitleMediumTracking,
        ),
        titleSmall = TextStyle(
            fontFamily = fontFamily,
            fontSize = TitleSmallSize,
            fontWeight = TitleSmallWeight,
            lineHeight = TitleSmallLineHeight,
            letterSpacing = TitleSmallTracking,
        ),
        bodyLarge = TextStyle(
            fontFamily = fontFamily,
            fontSize = BodyLargeSize,
            fontWeight = BodyLargeWeight,
            lineHeight = BodyLargeLineHeight,
            letterSpacing = BodyLargeTracking,
        ),
        bodyMedium = TextStyle(
            fontFamily = fontFamily,
            fontSize = BodyMediumSize,
            fontWeight = BodyMediumWeight,
            lineHeight = BodyMediumLineHeight,
            letterSpacing = BodyMediumTracking,
        ),
        bodySmall = TextStyle(
            fontFamily = fontFamily,
            fontSize = BodySmallSize,
            fontWeight = BodySmallWeight,
            lineHeight = BodySmallLineHeight,
            letterSpacing = BodySmallTracking,
        ),
        labelLarge = TextStyle(
            fontFamily = fontFamily,
            fontSize = LabelLargeSize,
            fontWeight = LabelLargeWeight,
            lineHeight = LabelLargeLineHeight,
            letterSpacing = LabelLargeTracking,
        ),
        labelMedium = TextStyle(
            fontFamily = fontFamily,
            fontSize = LabelMediumSize,
            fontWeight = LabelMediumWeight,
            lineHeight = LabelMediumLineHeight,
            letterSpacing = LabelMediumTracking,
        ),
        labelSmall = TextStyle(
            fontFamily = fontFamily,
            fontSize = LabelSmallSize,
            fontWeight = LabelSmallWeight,
            lineHeight = LabelSmallLineHeight,
            letterSpacing = LabelSmallTracking,
        )
    )
}
