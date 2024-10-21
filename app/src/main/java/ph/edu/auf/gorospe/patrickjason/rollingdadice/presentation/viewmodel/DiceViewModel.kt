package ph.edu.auf.gorospe.patrickjason.rollingdadice.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ph.edu.auf.gorospe.patrickjason.rollingdadice.domain.usecase.RollDiceUseCase

class DiceViewModel(private val rollDiceUseCase: RollDiceUseCase): ViewModel() {
    var diceResults by mutableStateOf(listOf<Int>())
        private set
    var resultsCheck by mutableStateOf("")

    fun rollDiceSet(){
        viewModelScope.launch {
            diceResults = rollDiceUseCase.rollDiceSet()
            resultsCheck = rollDiceUseCase.checkResults(diceResults)
        }
    }
}