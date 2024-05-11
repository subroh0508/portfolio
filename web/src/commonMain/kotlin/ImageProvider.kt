import org.jetbrains.compose.resources.ExperimentalResourceApi
import portfolio.web.generated.resources.Res

object ImageProvider {
    @OptIn(ExperimentalResourceApi::class)
    suspend fun getImageBitmap(filename: String) = Res.readBytes("drawable/$filename").toImageBitmap()
}
