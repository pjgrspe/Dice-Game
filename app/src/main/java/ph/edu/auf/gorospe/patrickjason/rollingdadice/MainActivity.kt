// File: app/src/main/java/ph/edu/auf/gorospe/patrickjason/rollingdadice/MainActivity.kt
package ph.edu.auf.gorospe.patrickjason.rollingdadice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ph.edu.auf.gorospe.patrickjason.rollingdadice.presentation.screens.DiceScreen
import ph.edu.auf.gorospe.patrickjason.rollingdadice.ui.theme.RollingDaDiceTheme
import ph.edu.auf.gorospe.patrickjason.rollingdadice.util.resizeBitmap

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RollingDaDiceTheme {
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
                        onButtonClick = { Log.d("MainActivity", "Button clicked") },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}