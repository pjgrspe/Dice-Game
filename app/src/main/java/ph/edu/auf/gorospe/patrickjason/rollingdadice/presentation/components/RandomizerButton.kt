// File: app/src/main/java/ph/edu/auf/gorospe/patrickjason/rollingdadice/presentation/components/RandomizerButton.kt
package ph.edu.auf.gorospe.patrickjason.rollingdadice.presentation.components

import android.widget.Toast
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import ph.edu.auf.gorospe.patrickjason.rollingdadice.presentation.viewmodel.DiceViewModel

@Composable
fun RandomizerButton(viewModel: DiceViewModel, modifier: Modifier = Modifier) {
    var results by remember { mutableStateOf(listOf<Int>()) }
    var resultCheck by remember { mutableStateOf("") }
    val context = LocalContext.current

    Button(
        onClick = {
            viewModel.rollDiceSet()
            results = viewModel.diceResults
            resultCheck = viewModel.resultsCheck
            Toast.makeText(context, "Results: ${results.joinToString(", ")}\nCheck: $resultCheck", Toast.LENGTH_LONG).show()

        },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors()
    ) {
        Text(text = "Click Me")
    }
}