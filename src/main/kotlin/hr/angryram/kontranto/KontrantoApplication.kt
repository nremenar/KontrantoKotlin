package hr.angryram.kontranto

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KontrantoApplication

fun main(args: Array<String>) {
    runApplication<KontrantoApplication>(*args)
}
