package com.teamsparta.todolist.security.jwt

import com.teamsparta.todolist.security.UserPrincipal
import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.web.authentication.WebAuthenticationDetails
import java.io.Serializable

class JwtAuthenticationToken(
    private val principal: UserPrincipal,
    details: WebAuthenticationDetails
) : AbstractAuthenticationToken(principal.authorities), Serializable {

    init {
        super.setDetails(details)
        super.setAuthenticated(true)
    }

    override fun getCredentials() = null

    override fun getPrincipal() = principal

    override fun isAuthenticated() = true
}