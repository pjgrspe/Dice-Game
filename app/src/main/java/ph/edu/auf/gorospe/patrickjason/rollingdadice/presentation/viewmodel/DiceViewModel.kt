import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ph.edu.auf.gorospe.patrickjason.rollingdadice.domain.usecase.RollDiceUseCase
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DiceViewModel(private val rollDiceUseCase: RollDiceUseCase) : ViewModel() {

    // Mutable state to hold the dice results
    var diceResults = mutableStateOf(listOf(1, 1, 1, 1, 1, 1)) // Start with all dice showing "1"
        private set

    var resultText = mutableStateOf("No matches")
        private set

    var isRolling = mutableStateOf(false) // New state for animation
        private set

    init {
        // Roll dice as soon as the ViewModel is initialized
        rollDice()
    }

    // Function to roll the dice and update state
    fun rollDice() {
        isRolling.value = true // Set rolling state to true
        // Launch a coroutine to handle the delay
        viewModelScope.launch {
            // Simulate rolling animation for 1 second
            delay(1000)
            // Now roll the dice and update the results
            val newResults = rollDiceUseCase.rollDiceSet()
            diceResults.value = newResults
            resultText.value = rollDiceUseCase.checkResults(newResults)
            isRolling.value = false // Set rolling state to false after rolling
        }
    }
}


