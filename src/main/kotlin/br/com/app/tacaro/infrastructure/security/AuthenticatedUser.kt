package br.com.app.tacaro.infrastructure.security

data class AuthenticatedUser(
    val id: Long,
    val email: String,
    val roles: List<String>
)
