package hr.angryram.kontranto.service

import hr.angryram.kontranto.entities.GameEntity

interface GameService {
    fun checkForNewGame () : String

    fun createNewGame():GameEntity
}