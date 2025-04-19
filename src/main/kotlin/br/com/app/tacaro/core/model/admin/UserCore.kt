package br.com.app.tacaro.core.model.admin

data class UserCore(
    val id: Long,
    val email: String,
    val password: String,
    val roles: Set<RoleCore> // Representa os papéis no contexto do domínio
)