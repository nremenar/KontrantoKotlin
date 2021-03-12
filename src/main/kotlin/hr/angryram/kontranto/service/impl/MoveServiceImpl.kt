package hr.angryram.kontranto.service.impl

import hr.angryram.kontranto.models.MoveResponse
import hr.angryram.kontranto.repository.GameRepository
import hr.angryram.kontranto.repository.MoveRepository
import hr.angryram.kontranto.service.MoveService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MoveServiceImpl : MoveService {

    @Autowired
    var gameRepository: GameRepository? = null

    @Autowired
    var moveRepository: MoveRepository? = null


    override fun getMove(GameId: String, Color: String, OpponentColor: String, ntp: String, ncp: String): MoveResponse {

        val game=gameRepository?.findByGame(GameId)
        val move =moveRepository?.findFirstByGameIsAndOrderByMoveTimestampDesc(GameId)



        return MoveResponse()
    }

}