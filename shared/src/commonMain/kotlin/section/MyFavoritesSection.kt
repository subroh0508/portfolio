package section

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import component.AnimatedSection
import component.Footer
import component.IconGrid
import component.icon.*
import component.icon.MyFavourite
import config.*
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.stringResource
import portfolio.shared.generated.resources.*
import theme.scheme.*

@Composable
internal fun MyFavoritesSection(
    visible: Boolean,
    appConfigState: AppConfigState,
) = AnimatedSection(
    visible,
    modifier = Modifier.fillMaxHeight()
        .padding(32.dp),
) {
    MyDearestGrid(appConfigState)
    Spacer(Modifier.size(24.dp))
    LoveGrid(appConfigState)
    Footer()
}

@Composable
private fun MyDearestGrid(
    appConfigState: AppConfigState,
) {
    val isLight = appConfigState.theme.schema.isLight()

    Text(
        stringResource(Res.string.label_my_dearest),
        style = MaterialTheme.typography.titleLarge,
    )

    IconGrid(
        MyFavouriteImageSize,
        Triple(Res.drawable.kotlin, DescriptionKotlin) { appConfigState.change(isLight, KotlinThemes) },
        Triple(Res.drawable.mitsumine, DescriptionMitsumine) { appConfigState.change(isLight, YuikaThemes) },
        Triple(Res.drawable.higuchi, DescriptionHiguchi) { appConfigState.change(isLight, MadokaThemes) },
        Triple(Res.drawable.haruki, DescriptionHaruki) { appConfigState.change(isLight, HarukiThemes) },
        Triple(Res.drawable.kanade, DescriptionKanade) { appConfigState.change(isLight, KanadeThemes) },
        Triple(Res.drawable.mizuki, DescriptionMizuki) { appConfigState.change(isLight, MizukiThemes) },
        Triple(Res.drawable.temari, DescriptionTemari) { appConfigState.change(isLight, TemariThemes) },
    ) { drawable, string, onClick ->
        MyFavourite(
            imageResource(drawable),
            string,
            onClick = onClick,
            withCircle = drawable != Res.drawable.kotlin,
        )
    }
}

@Composable
private fun LoveGrid(
    appConfigState: AppConfigState,
) {
    val isLight = appConfigState.theme.schema.isLight()

    Text(
        stringResource(Res.string.label_love),
        style = MaterialTheme.typography.titleLarge,
    )

    IconGrid(
        MyFavouriteImageSize,
        Triple(Res.drawable.ruby_on_rails, DescriptionRubyOnRails) { appConfigState.change(isLight, RailsThemes) },
        Triple(Res.drawable.react, DescriptionReact) { appConfigState.change(isLight, ReactThemes) },
        Triple(Res.drawable.android, DescriptionAndroid) { appConfigState.change(isLight, AndroidThemes) },
        Triple(Res.drawable.sayaka, DescriptionSayaka) { appConfigState.change(isLight, SayakaThemes) },
        Triple(Res.drawable.you, DescriptionYou) { appConfigState.change(isLight, YouThemes) },
        Triple(Res.drawable.yu, DescriptionYu) { appConfigState.change(isLight, YuThemes) },
    ) { drawable, string, onClick ->
        MyFavourite(
            imageResource(drawable),
            string,
            onClick = onClick,
            withCircle = drawable != Res.drawable.android,
        )
    }
}



private fun AppConfigState.change(
    isLight: Boolean,
    themes: Pair<ColorTheme, ColorTheme>
) {
    val (light, dark) = themes

    theme = if (isLight) light else dark
}
