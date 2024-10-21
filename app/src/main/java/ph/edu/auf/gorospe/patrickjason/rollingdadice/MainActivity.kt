// File: app/src/main/java/ph/edu/auf/gorospe/patrickjason/rollingdadice/MainActivity.kt
package ph.edu.auf.gorospe.patrickjason.rollingdadice

import android.os.Bundle
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
import ph.edu.auf.gorospe.patrickjason.rollingdadice.data.respository.DiceRepositoryImpl
import ph.edu.auf.gorospe.patrickjason.rollingdadice.domain.usecase.RollDiceUseCase
import ph.edu.auf.gorospe.patrickjason.rollingdadice.presentation.components.SimpleButton
import ph.edu.auf.gorospe.patrickjason.rollingdadice.presentation.viewmodel.DiceViewModel
import ph.edu.auf.gorospe.patrickjason.rollingdadice.ui.theme.RollingDaDiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RollingDaDiceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        val diceRepository = DiceRepositoryImpl()
                        val rollDiceUseCase = RollDiceUseCase(diceRepository)
                        val diceViewModel = DiceViewModel(rollDiceUseCase)
                        SimpleButton(viewModel = diceViewModel)
                    }
                }
            }
        }
    }
}