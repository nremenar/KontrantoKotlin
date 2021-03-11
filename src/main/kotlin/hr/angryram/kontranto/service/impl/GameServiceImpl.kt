package hr.angryram.kontranto.service.impl

import hr.angryram.kontranto.entities.GameEntity
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

    override fun checkForNewGame(): String {
        return "check"
    }

    override fun createNewGame(): GameEntity {
        val game = GameEntity()

        val color = GetColor().generateColor("")

        game?.game = UUID.randomUUID().toString()
        game?.gameState="WAITING_FOR_SECOND_PLAYER"
        game?.whiteScore="0"
        game?.blackScore="0"
        game?.board="[\"\",\"\",\"\",\"\"], [\"\",\"\",\"\",\"\"], [\"\",\"\",\"\",\"\"], [\"\",\"\",\"\",\"\"]"

        if(color=="white"){game?.whitePlayerId="playerId"}
        else game?.blackPlayerId = "playerId"

        gameRepository?.save(game)
        return game
    }
}