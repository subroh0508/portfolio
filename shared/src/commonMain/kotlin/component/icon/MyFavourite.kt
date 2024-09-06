package component.icon

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.onClick
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp

internal val MyFavouriteImageSize = 64.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun MyFavourite(
    bitmap: ImageBitmap,
    contentDescription: String,
    onClick: () -> Unit = {},
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
        )
        .pointerHoverIcon(PointerIcon.Hand)
        .onClick(onClick = onClick),
)
