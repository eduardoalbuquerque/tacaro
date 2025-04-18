package br.com.app.tacaro.infrastructure.database.postgre.entity

import jakarta.persistence.*

@Entity
@Table(name = "marca")
data class MarcaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marca_id")
    val marcaId: Long? = 0L,
    @Column(name = "marca_nome", nullable = false, length = 100)
    val marcaNome: String,
    @Column(name = "observacao", columnDefinition = "TEXT")
    val observacao: String?,
)
