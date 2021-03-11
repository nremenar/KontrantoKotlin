package hr.angryram.kontranto.entities

import lombok.Data
import lombok.Getter
import lombok.Setter

import javax.persistence.*

@Data
@Entity
@Table(name="moves")
class MoveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private val moveid:Int? = null

    @Getter
    @Setter
    private val color:String? = null

    @Getter
    @Setter
    private val trianglePosition : String? = null

    @Getter
    @Setter
    private val circlePosition:String? = null

    @Getter
    @Setter
    private val moveTimestamp:String ? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gameid", insertable = false, updatable = false)
    @Getter
    @Setter
    private val game:GameEntity? = null

}