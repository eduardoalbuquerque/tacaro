package br.com.app.tacaro.infrastructure.security

import br.com.app.tacaro.infrastructure.database.postgre.jpa.IUserRepo
import org.apache.tomcat.util.net.openssl.ciphers.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val iUserRepo: IUserRepo
): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {

        val user = iUserRepo.findByEmail(username)
            ?: throw UsernameNotFoundException("Usuário nao encontrado!")
        return CustomUserDetails(user)
    }
}