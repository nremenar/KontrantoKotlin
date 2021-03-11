package hr.angryram.kontranto.controller

import org.dom4j.rule.Mode
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class RulesController {

    @GetMapping(value= arrayOf("/rules","/rules/"))
    fun getRules(model : Model) : String{
        return "rules";
    }
}