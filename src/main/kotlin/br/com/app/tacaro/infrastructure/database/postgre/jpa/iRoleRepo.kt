package br.com.app.tacaro.infrastructure.database.postgre.jpa

import br.com.app.tacaro.infrastructure.database.postgre.entity.admin.Role
import org.springframework.data.jpa.repository.JpaRepository

interface iRoleRepo : JpaRepository<Role, Long> {
    fun findByRoleName(roleName: String): Role?
}
