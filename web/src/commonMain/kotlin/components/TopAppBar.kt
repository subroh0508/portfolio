package components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import config.ColorTheme
import config.LocalAppConfigState
import androidx.compose.material3.TopAppBar as M3TopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar() {
    val config = LocalAppConfigState.current

    M3TopAppBar(
        title = { Text("Subroh Nisikori's Portfolio") },
        actions = {
            IconButton(
                onClick = {
                    config.theme = when (config.theme) {
                        ColorTheme.Light -> ColorTheme.Dark
                        ColorTheme.Dark -> ColorTheme.Light
                    }
                },
            ) {
                Icon(
                    when (config.theme) {
                        ColorTheme.Light -> Icons.Default.LightMode
                        ColorTheme.Dark -> Icons.Default.DarkMode
                    },
                    contentDescription = "Change Theme",
                )
            }
        }
    )
}
