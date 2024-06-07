package com.teamsparta.todolist.security

import com.teamsparta.todolist.domain.user.model.UserRole
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority

data class UserPrincipal(
    val userId : Long,
    val username : String,
    val authorities : Collection<GrantedAuthority>
) {
    constructor(userId: Long, username: String, role: Set<String>)
            : this(userId, username, role.map{ SimpleGrantedAuthority("ROLE_$it") })
}
