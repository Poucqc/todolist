package com.teamsparta.todolist.domain.exception

data class UserNotFoundException(
    val name: String
) : RuntimeException("User not found by $name")
