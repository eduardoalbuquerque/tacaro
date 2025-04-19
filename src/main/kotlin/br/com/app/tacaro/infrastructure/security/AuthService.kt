package br.com.app.tacaro.infrastructure.security

import br.com.app.tacaro.entrypoint.rest.admin.dto.admin.LoginRequest
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val authenticationManager: AuthenticationManager,
    private val jwtTokenProvider: JwtTokenProvider
) {
    fun login(request: LoginRequest): String {
        // 1. Cria o token de autenticação (Spring)
        val authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(request.email, request.password)
        )

        // 2. Define a autenticação no contexto
        SecurityContextHolder.getContext().authentication = authentication

        // 3. Gera o token JWT com base no usuário autenticado
        val userDetails = authentication.principal as UserDetails
        val roles = userDetails.authorities.map { it.authority } // extrai as roles como String
        return jwtTokenProvider.generateToken(userDetails.username, roles)
    }
}