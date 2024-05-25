package component.icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp

internal val MyFavouriteImageSize = 64.dp

@Composable
internal fun MyFavourite(
    bitmap: ImageBitmap,
    contentDescription: String,
    withCircle: Boolean = true,
) = Image(
    bitmap,
    contentDescription,
    modifier = Modifier.size(MyFavouriteImageSize)
        .then(
            if (withCircle) {
                Modifier.clip(CircleShape)
            } else {
                Modifier
            }
        ),
)
