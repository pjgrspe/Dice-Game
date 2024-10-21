package ph.edu.auf.gorospe.patrickjason.rollingdadice.data.respository

class DiceRepositoryImpl {
    fun rollDice(): Int {
        return (1..6).random()
    }

    fun rollDiceSet(): List<Int>{
        return List(6) { rollDice() }
    }

    fun checkResults(diceResults: List<Int>): String {
        val counts = diceResults.groupingBy { it }.eachCount()

        return when {
            counts.size == 6 && counts.values.all { it == 1 } -> "Straight"
            counts.containsValue(6) -> "Six of a Kind"
            counts.containsValue(5) -> "Five of a Kind"
            counts.containsValue(4) -> "Four of a Kind"
            counts.containsValue(3) && counts.containsValue(2) -> "Full House"
            counts.containsValue(3) -> "Three of a Kind"
            counts.filterValues { it == 2 }.size == 2 -> "Two pairs"
            counts.containsValue(2) -> "One pair"
            else -> "No matches"
        }
    }

}