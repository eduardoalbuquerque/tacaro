package br.com.app.tacaro.infrastructure.database.postgre.jpa

import br.com.app.tacaro.infrastructure.database.postgre.entity.admin.User
import org.springframework.data.jpa.repository.JpaRepository

interface IUserRepo : JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
}