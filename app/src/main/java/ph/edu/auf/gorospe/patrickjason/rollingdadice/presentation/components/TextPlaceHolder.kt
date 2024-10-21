package ph.edu.auf.gorospe.patrickjason.rollingdadice.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun TextPlaceholder(text: String) {
    Text(
        text = text,
        fontSize = 18.sp
    )
}