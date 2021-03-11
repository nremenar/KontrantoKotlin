package hr.angryram.kontranto.repository

import hr.angryram.kontranto.entities.MoveEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MoveRepository:JpaRepository<MoveEntity?,Int?> {
}
