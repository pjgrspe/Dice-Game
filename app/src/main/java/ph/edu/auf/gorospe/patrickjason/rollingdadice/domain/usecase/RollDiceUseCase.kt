package ph.edu.auf.gorospe.patrickjason.rollingdadice.domain.usecase

import ph.edu.auf.gorospe.patrickjason.rollingdadice.data.respository.DiceRepositoryImpl

class RollDiceUseCase(private val diceRepository: DiceRepositoryImpl) {
    fun rollDiceSet(): List<Int> {
        return diceRepository.rollDiceSet()
    }

    fun checkResults(diceResults: List<Int>): String {
        return diceRepository.checkResults(diceResults)
    }
}