package hr.angryram.kontranto.entities

import javax.persistence.*

@Entity
@Table(name="games")
class GameEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var gameid: Int? = null

    var game: String? = null

    var whitePlayerId: String? = null

    var blackPlayerId: String? = null

    var whiteScore: String? = null

    var blackScore: String? = null

    var board: String? = null

    var gameState : String? = null


}