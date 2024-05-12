package component.icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.stringResource

internal val MyFavouriteImageSize = 64.dp

@Composable
internal fun MyFavourite(
    image: DrawableResource,
    contentDescription: String,
    withCircle: Boolean = true,
) = Image(
    imageResource(image),
    contentDescription,
    modifier =
        if (withCircle) {
            Modifier.size(MyFavouriteImageSize)
                .clip(CircleShape)
        } else {
            Modifier.size(MyFavouriteImageSize)
        },
)
