package hr.angryram.kontranto.controller

import hr.angryram.kontranto.models.GameStatusResponse
import hr.angryram.kontranto.service.GameService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class GameController {

    @Autowired
    var gameService: GameService? = null

    @GetMapping(value = ["/show_board", "/show_board/"])
    fun newBoard(model : Model,@RequestParam PlayerId:String) : String{
        model["game"] = gameService?.createNewGame(PlayerId)!!
        return "board";
    }

    @PostMapping(value = ["/show_board", "/show_board/"])
    fun joinBoard(model : Model,@RequestParam PlayerId:String) : String{

        model["game"] = gameService?.createNewGame(PlayerId)!!
        return "board";
    }

    @PostMapping(value=["/joinGame","/joinGame/"])
    fun checkJoinGame(@RequestParam GameId : String, @RequestParam PlayerId:String):ResponseEntity<GameStatusResponse>{
        return ResponseEntity.ok(gameService?.checkJoinGame(GameId,PlayerId)!!)
    }
}