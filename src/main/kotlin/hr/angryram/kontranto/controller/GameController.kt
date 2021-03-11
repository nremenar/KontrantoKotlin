package hr.angryram.kontranto.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class GameController {

    @GetMapping(value = arrayOf("/show_board","/show_board/"))
    fun showBoard() :String{
        return "board";
    }
}