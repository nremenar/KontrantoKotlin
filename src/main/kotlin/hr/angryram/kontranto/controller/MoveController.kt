package hr.angryram.kontranto.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MoveController {

    @GetMapping(value= arrayOf("/move","/move/"))
    fun move () : String{
        return "move";
    }
}