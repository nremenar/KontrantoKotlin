package hr.angryram.kontranto.service.impl

import hr.angryram.kontranto.entities.GameEntity
import hr.angryram.kontranto.models.GameStatusResponse
import hr.angryram.kontranto.repository.GameRepository
import hr.angryram.kontranto.service.GameService
import hr.angryram.kontranto.utils.GetColor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class GameServiceImpl : GameService {

    @Autowired
    var gameRepository: GameRepository? = null

    override fun createNewGame(PlayerId: String): GameEntity {
        val game = GameEntity()

        val color = GetColor().generateColor("")
        game.game = UUID.randomUUID().toString()
        game.gameState="WAITING_FOR_SECOND_PLAYER"
        game.whiteScore="0"
        game.blackScore="0"
        game.board="[\"\",\"\",\"\",\"\"], [\"\",\"\",\"\",\"\"], [\"\",\"\",\"\",\"\"], [\"\",\"\",\"\",\"\"]"
        if(color=="white"){
            game.whitePlayerId =PlayerId}
        else PlayerId.also { game.blackPlayerId = it }
        gameRepository?.save(game)
        return game
    }

    override fun checkJoinGame(GameId:String, PlayerId : String): GameStatusResponse {

        val resp = GameStatusResponse()
        resp.status="Error"
        if(PlayerId == ""){
            resp.message="Player ID is not valid."
            return resp
        }
        if(GameId == ""){
            resp.message="Game id must be entered."
            return resp
        }

        try{
            val game = gameRepository?.findByGame(GameId)!!
            if(game.gameState == "INIT") {resp.message = "Game already started";return resp}
            if(game.whitePlayerId == PlayerId || game.blackPlayerId == PlayerId){resp.message = "You are already joined to the game.";return resp}
        }
        catch(e:Exception){
            resp.message = "Game with this game_id does not exist.";return resp
        }

        resp.message="OK"
        resp.status="OK"
        return resp
    }

    override fun joinGame(GameId: String, PlayerId: String): GameStatusResponse {
        val game = gameRepository?.findByGame(GameId)!!
        var color2 = "white"
        if (game.whitePlayerId == ""){
            game.whitePlayerId = PlayerId
        }
        else{
            game.blackPlayerId = PlayerId
            color2 = "black"
        }
        game.gameState="INIT"
        gameRepository?.save(game)
        val resp = GameStatusResponse()
        resp.status="OK"
        resp.gameId = game.game
        resp.myId = PlayerId
        resp.myColor = color2
        return resp
    }

    override fun gameState(GameId: String, Color: String): GameStatusResponse {
        val game = gameRepository?.findByGame(GameId)!!
        var opponentId = if(Color == "white") game.blackPlayerId else game.whitePlayerId

        val resp = GameStatusResponse()

        resp.status="OK"
        resp.opponentId=opponentId
        resp.whiteScore=game.whiteScore
        resp.blackScore=game.blackScore
        resp.gameState=game.gameState

        return resp
    }
}