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
    @Getter
    @Setter
    private val gameid: Int? = null

    @Getter
    @Setter
    private val game: String? = null

    @Getter
    @Setter
    private val whitePlayerId: String? = null

    @Getter
    @Setter
    private val blackPlayerId: String? = null

    @Getter
    @Setter
    private val whiteScore: String? = null

    @Getter
    @Setter
    private val blackScore: String? = null

    @Getter
    @Setter
    private val board: String? = null

    @Getter
    @Setter
    private val gameState : String? = null

}