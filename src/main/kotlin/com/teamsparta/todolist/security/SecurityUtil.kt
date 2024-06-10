package com.teamsparta.todolist.security

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails

object SecurityUtil {

    fun getCurrentUsername(): String {
        val principal =  SecurityContextHolder.getContext().authentication.principal as UserPrincipal
        return principal.getUsername()
    }
}