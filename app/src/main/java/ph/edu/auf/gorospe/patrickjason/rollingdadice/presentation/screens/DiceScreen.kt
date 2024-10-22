// File: `app/src/main/java/ph/edu/auf/gorospe/patrickjason/rollingdadice/presentation/screens/DiceScreen.kt`
package ph.edu.auf.gorospe.patrickjason.rollingdadice.presentation.screens

import DiceViewModel
import android.graphics.Bitmap
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ph.edu.auf.gorospe.patrickjason.rollingdadice.data.respository.DiceRepositoryImpl
import ph.edu.auf.gorospe.patrickjason.rollingdadice.domain.usecase.RollDiceUseCase
import ph.edu.auf.gorospe.patrickjason.rollingdadice.presentation.components.RandomizerButton
import ph.edu.auf.gorospe.patrickjason.rollingdadice.presentation.components.TextPlaceholder
import ph.edu.auf.gorospe.patrickjason.rollingdadice.ui.theme.RollingDaDiceTheme
import ph.edu.auf.gorospe.patrickjason.rollingdadice.util.bouncingAnimation
import ph.edu.auf.gorospe.patrickjason.rollingdadice.util.floatingAnimation

@Composable
fun DiceScreen(
    diceImages: List<Bitmap>,
    displayText: String,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    diceViewModel: DiceViewModel
) {
    val diceResults = diceViewModel.diceResults.value // Observe the dice results
    val resultText = diceViewModel.resultText.value   // Observe the result text
    val isRolling = diceViewModel.isRolling.value       // Observe rolling state

    // If rolling, show random dice values; otherwise, show the actual results
    val displayDiceResults = if (isRolling) {
        List(6) { (1..6).random() } // Show random values during rolling
    } else {
        diceResults
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Display result text
        TextPlaceholder(resultText)

        Spacer(modifier = Modifier.height(16.dp))

        // First Row of Dice
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            displayDiceResults.take(3).forEach { diceValue ->
                Image(
                    bitmap = diceImages[diceValue - 1].asImageBitmap(), // Map dice result to image
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .floatingAnimation()
                        .let {
                            if (isRolling) {
                                it
                                    .rotate((360 * (1..5).random()).toFloat()) // Random rotation
                                    .bouncingAnimation()
                            } else {
                                it // No transformation
                            }
                        }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Second Row of Dice
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            displayDiceResults.drop(3).forEach { diceValue ->
                Image(
                    bitmap = diceImages[diceValue - 1].asImageBitmap(), // Map dice result to image
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .floatingAnimation()
                        .let {
                            if (isRolling) {
                                it
                                    .rotate((360 * (1..5).random()).toFloat()) // Random rotation
                                    .bouncingAnimation()
                            } else {
                                it // No transformation
                            }
                        }
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Randomizer button to roll dice
        RandomizerButton(viewModel = diceViewModel)
    }
}


