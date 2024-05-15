package com.teamsparta.todolist.domain.exception

data class TodoNotFoundException(
    val modelName: String,
    val id: Long?
) : RuntimeException("Model $modelName not found given id : $id")
