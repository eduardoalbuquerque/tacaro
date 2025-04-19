package br.com.app.tacaro.entrypoint.rest.admin.controller

import br.com.app.tacaro.entrypoint.rest.admin.dto.admin.LoginRequest
import br.com.app.tacaro.infrastructure.security.AuthService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authService: AuthService
) {
    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<Any> {
        return try {
            val token = authService.login(request)
            // 4. Retorna o token no corpo da resposta
//            ResponseEntity.ok(mapOf("token" to token))
            ResponseEntity.ok(token)
        } catch (ex: Exception) {
            ex.printStackTrace()
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas ${ex.message}")
        }
    }
}


//fun main() {
//    val senhaDigitada = "123456"
//    val senhaHashBanco = "\$2a\$10\$ghFJGSkUyyX7hkNqMWdumuOfOq2iLfqIFfQIrqcBbJW2UmTJVNsmK"
//
//    val passwordEncoder = BCryptPasswordEncoder()
//    val match = passwordEncoder.matches(senhaDigitada, senhaHashBanco)
//
//    if (match) {
//        println("✅ A senha está correta!")
//    } else {
//        println("❌ A senha NÃO confere!")
//    }
//}
//fun main() {
//    val passwordEncoder = BCryptPasswordEncoder()
//    val rawPassword = "123456"
//    val hashedPassword = "\$2a\$10\$ghFJGSkUyyX7hkNqMWdumuOfOq2iLfqIFfQIrqcBbJW2UmTJVNsmK"
//
//    if (passwordEncoder.matches(rawPassword, hashedPassword)) {
//        println("A senha ${rawPassword} corresponde ao hash.")
//    } else {
//        println("A senha ${rawPassword} NÃO corresponde ao hash.")
//    }
//}
