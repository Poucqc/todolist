package com.teamsparta.todolist.domain.user.dto

import com.teamsparta.todolist.domain.user.model.UserRole

data class UserOperationRequest (
    val username: String,
    val password: String,
    val role: UserRole
)