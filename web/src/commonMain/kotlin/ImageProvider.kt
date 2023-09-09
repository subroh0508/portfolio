import androidx.compose.ui.graphics.ImageBitmap
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.resource

object ImageProvider {
    @OptIn(ExperimentalResourceApi::class)
    suspend fun getImageBitmap(filename: String): ImageBitmap = resource(filename).readBytes().toImageBitmap()
}
