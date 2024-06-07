package com.teamsparta.todolist.domain.exception

data class NoPermissionException(
    val model : String
) : RuntimeException("You do not have permission for model: $model")
