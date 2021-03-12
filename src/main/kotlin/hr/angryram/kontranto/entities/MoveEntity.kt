package hr.angryram.kontranto.entities

import javax.persistence.*

@Entity
@Table(name="moves")
class MoveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var moveid:Int? = null

    var color:String? = null

    var trianglePosition : String? = null

    var circlePosition:String? = null

    var moveTimestamp:String ? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gameid", insertable = false, updatable = false)
    var game:GameEntity? = null

}