package hr.angryram.kontranto.service

import hr.angryram.kontranto.entities.GameEntity
import hr.angryram.kontranto.models.GameStatusResponse

interface GameService {
    fun createNewGame(PlayerId:String):GameEntity
    fun checkJoinGame(GameId:String, PlayerId : String): GameStatusResponse
    fun joinGame(GameId: String, PlayerId: String) : GameStatusResponse
    fun gameState(GameId: String, Color:String) : GameStatusResponse
}