package com.teamsparta.todolist.domain.exception

data class PasswordNotMatchWhitNameException(
    val name : String
) : RuntimeException("password does not match for name : $name")