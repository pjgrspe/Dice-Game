// File: app/src/main/java/ph/edu/auf/gorospe/patrickjason/rollingdadice/presentation/components/RandomizerButton.kt
package ph.edu.auf.gorospe.patrickjason.rollingdadice.presentation.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SimpleButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors()
    ) {
        Text(text = "Click Me")
    }
}