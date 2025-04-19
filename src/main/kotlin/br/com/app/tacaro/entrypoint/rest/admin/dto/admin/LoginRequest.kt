package br.com.app.tacaro.entrypoint.rest.admin.dto.admin

data class LoginRequest(
    val email: String,
    val password: String
)
