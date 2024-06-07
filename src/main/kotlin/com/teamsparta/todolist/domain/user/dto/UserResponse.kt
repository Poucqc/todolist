package com.teamsparta.todolist.domain.user.dto

import com.teamsparta.todolist.domain.user.model.UserRole

data class UserResponse(
    val username : String,
    val role : UserRole
)
