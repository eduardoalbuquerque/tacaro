package br.com.app.tacaro

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TacaroApiApplication


fun main(args: Array<String>) {
	runApplication<TacaroApiApplication>(*args)
}
