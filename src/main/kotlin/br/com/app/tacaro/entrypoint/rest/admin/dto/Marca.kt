package br.com.app.tacaro.entrypoint.rest.admin.dto

data class Marca(
    val marcaId: Long? = 0L,
    val marcaNome: String,
    val observacao: String?,
)
