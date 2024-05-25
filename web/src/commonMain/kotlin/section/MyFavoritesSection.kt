package section

import androidx.compose.foundation.layout.*
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
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.stringResource
import portfolio.web.generated.resources.*

@Composable
internal fun MyFavoritesSection(
    visible: Boolean,
) = AnimatedSection(
    visible,
    modifier = Modifier.fillMaxHeight()
        .padding(32.dp),
) {
    MyDearestGrid()
    Spacer(Modifier.size(24.dp))
    LoveGrid()
    Footer()
}

@Composable
private fun MyDearestGrid() {
    Text(
        stringResource(Res.string.label_my_dearest),
        style = MaterialTheme.typography.titleLarge,
    )

    IconGrid(
        MyFavouriteImageSize,
        Res.drawable.kotlin to DescriptionKotlin,
        Res.drawable.mitsumine to DescriptionMitsumine,
        Res.drawable.higuchi to DescriptionHiguchi,
        Res.drawable.haruki to DescriptionHaruki,
        Res.drawable.kanade to DescriptionKanade,
        Res.drawable.mizuki to DescriptionMizuki,
        Res.drawable.temari to DescriptionTemari,
    ) { drawable, string ->
        MyFavourite(
            imageResource(drawable),
            string,
            withCircle = drawable != Res.drawable.kotlin,
        )
    }
}

@Composable
private fun LoveGrid() {
    Text(
        stringResource(Res.string.label_love),
        style = MaterialTheme.typography.titleLarge,
    )

    IconGrid(
        MyFavouriteImageSize,
        Res.drawable.ruby_on_rails to DescriptionRubyOnRails,
        Res.drawable.react to DescriptionReact,
        Res.drawable.android to DescriptionAndroid,
        Res.drawable.sayaka to DescriptionSayaka,
        Res.drawable.yu to DescriptionYu,
    ) { drawable, string ->
        MyFavourite(
            imageResource(drawable),
            string,
            withCircle = drawable != Res.drawable.android,
        )
    }
}
