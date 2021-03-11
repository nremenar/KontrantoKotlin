package hr.angryram.kontranto.controller

import hr.angryram.kontranto.repository.GameRepository
import hr.angryram.kontranto.service.GameService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class GameController {

    @Autowired
    var gameService: GameService? = null

    @GetMapping(value = ["/show_board", "/show_board/"])
    fun showBoard(model : Model) : String{
        model["game"] = gameService?.createNewGame()!!
        return "board";
    }
}