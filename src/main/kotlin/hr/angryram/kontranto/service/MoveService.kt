package hr.angryram.kontranto.service

import hr.angryram.kontranto.models.MoveResponse

interface MoveService {
    fun getMove(GameId:String,Color:String,OpponentColor:String,ntp:String,ncp:String):MoveResponse
}