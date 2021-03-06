package hr.angryram.kontranto.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {

    @GetMapping(value= ["/", ""])
    fun index(model:Model): String{
        return "index"
    }

    @GetMapping(value = ["/startgame","startgame/"])
    fun newOrJoin(model:Model):String
    {
        return "newOrJoin"
    }

}