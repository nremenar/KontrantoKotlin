package hr.angryram.kontranto.entities

import lombok.Getter
import lombok.Setter
import java.time.DateTimeException
import java.util.*
import javax.persistence.*

class MoveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private val id:Int? = null

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private val game:String? = null

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

}