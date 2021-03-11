package hr.angryram.kontranto.entities

import lombok.Data
import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Data
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