// File: app/src/main/java/ph/edu/auf/gorospe/patrickjason/rollingdadice/presentation/screens/DiceScreen.kt
package ph.edu.auf.gorospe.patrickjason.rollingdadice.presentation.screens

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
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ph.edu.auf.gorospe.patrickjason.rollingdadice.data.respository.DiceRepositoryImpl
import ph.edu.auf.gorospe.patrickjason.rollingdadice.domain.usecase.RollDiceUseCase
import ph.edu.auf.gorospe.patrickjason.rollingdadice.presentation.components.RandomizerButton
import ph.edu.auf.gorospe.patrickjason.rollingdadice.presentation.components.TextPlaceholder
import ph.edu.auf.gorospe.patrickjason.rollingdadice.presentation.viewmodel.DiceViewModel
import ph.edu.auf.gorospe.patrickjason.rollingdadice.ui.theme.RollingDaDiceTheme
import ph.edu.auf.gorospe.patrickjason.rollingdadice.util.floatingAnimation

@Preview
@Composable
fun DiceScreenPreview() {
    Log.d("DiceScreen", "DiceScreen preview called")
    RollingDaDiceTheme {
        DiceScreen(
            diceImages = listOf(),
            displayText = "Roll the Dice!",
            onButtonClick = { Log.d("DiceScreen", "Button clicked") }
        )
    }
}

@Composable
fun DiceScreen(diceImages: List<Bitmap>, displayText: String, onButtonClick: () -> Unit, modifier: Modifier = Modifier) {
    Log.d("DiceScreen", "DiceScreen composable called")
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Text Placeholder
        TextPlaceholder(displayText)

        Spacer(modifier = Modifier.height(16.dp))

        // First Row of Dice
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            diceImages.take(3).forEach { bitmap ->
                Image(
                    bitmap = bitmap.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .floatingAnimation()
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Second Row of Dice
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            diceImages.drop(3).forEach { bitmap ->
                Image(
                    bitmap = bitmap.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .floatingAnimation()
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))


        val diceRepository = DiceRepositoryImpl()
        val rollDiceUseCase = RollDiceUseCase(diceRepository)
        val diceViewModel = DiceViewModel(rollDiceUseCase)
        RandomizerButton(viewModel = diceViewModel)
    }
}