package section

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import component.chip.DeveloperAccounts
import component.chip.RecruitingAccounts
import component.chip.SnsAccounts

@Composable
internal fun AccountsSection() {
    ChipRow { SnsAccounts() }
    ChipRow {
        DeveloperAccounts()
        RecruitingAccounts()
    }
}

@Composable
private fun ChipRow(
    content: @Composable RowScope.() -> Unit,
) = Row(
    modifier = Modifier.padding(horizontal = 16.dp),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
) { content() }
