package br.com.app.tacaro.infrastructure.database.postgre.entity.admin

import jakarta.persistence.*

@Entity
@Table(name = "roles")
data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "role_name", unique = true, nullable = false)
    val roleName: String
)