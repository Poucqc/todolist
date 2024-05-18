package com.teamsparta.todolist.domain.exception

data class PasswordNotMatchedException(
    val id : Long?
) : RuntimeException("password not matched for id : $id")