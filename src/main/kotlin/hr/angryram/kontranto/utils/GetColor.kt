package hr.angryram.kontranto.utils

class GetColor {

    fun generateColor(color:String) : String{
        return when (color) {
            "" -> return arrayOf("white","black").random()
            "white" -> "black"
            else -> "black"
        }

    }
}