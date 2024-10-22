// File: `app/src/main/java/ph/edu/auf/gorospe/patrickjason/rollingdadice/presentation/components/TextPlaceholder.kt`
package ph.edu.auf.gorospe.patrickjason.rollingdadice.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun TextPlaceholder(text: String) {
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.White, fontWeight = FontWeight.ExtraBold)) {
                append(text)
            }
        },
        fontSize = 24.sp,
        modifier = Modifier
    )
}