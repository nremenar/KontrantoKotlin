package hr.angryram.kontranto.repository

import hr.angryram.kontranto.entities.GameEntity
import org.springframework.data.jpa.repository.JpaRepository

interface GameRepository : JpaRepository<GameEntity, Int?> {

    fun findByGame(game:String) : GameEntity
}