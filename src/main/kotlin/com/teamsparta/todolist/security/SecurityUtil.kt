package com.teamsparta.todolist.security

import org.springframework.security.core.context.SecurityContextHolder

object SecurityUtil {

    fun getCurrentUsername(): String {
        return SecurityContextHolder.getContext().authentication.name
    }
}