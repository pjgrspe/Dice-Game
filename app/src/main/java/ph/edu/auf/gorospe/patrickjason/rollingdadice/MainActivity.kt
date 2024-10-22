// File: `app/src/main/java/ph/edu/auf/gorospe/patrickjason/rollingdadice/MainActivity.kt`
package ph.edu.auf.gorospe.patrickjason.rollingdadice

import DiceViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import ph.edu.auf.gorospe.patrickjason.rollingdadice.data.respository.DiceRepositoryImpl
import ph.edu.auf.gorospe.patrickjason.rollingdadice.domain.usecase.RollDiceUseCase
import ph.edu.auf.gorospe.patrickjason.rollingdadice.presentation.screens.DiceScreen
import ph.edu.auf.gorospe.patrickjason.rollingdadice.ui.theme.RollingDaDiceTheme
import ph.edu.auf.gorospe.patrickjason.rollingdadice.util.resizeBitmap

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val diceRepository = DiceRepositoryImpl()
        val rollDiceUseCase = RollDiceUseCase(diceRepository)
        val diceViewModel = DiceViewModel(rollDiceUseCase)

        setContent {
            RollingDaDiceTheme(darkTheme = true) { // Set darkTheme to true
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val diceImages = listOf(
                        resizeBitmap(this, R.drawable.dice_1, 80, 80),
                        resizeBitmap(this, R.drawable.dice_2, 80, 80),
                        resizeBitmap(this, R.drawable.dice_3, 80, 80),
                        resizeBitmap(this, R.drawable.dice_4, 80, 80),
                        resizeBitmap(this, R.drawable.dice_5, 80, 80),
                        resizeBitmap(this, R.drawable.dice_6, 80, 80)
                    )
                    DiceScreen(
                        diceImages = diceImages,
                        displayText = "Roll the Dice!",
                        onButtonClick = { /* Handle button click */ },
                        modifier = Modifier.padding(innerPadding),
                        diceViewModel = diceViewModel // Pass the view model here
                    )
                }
            }
        }
    }
}
