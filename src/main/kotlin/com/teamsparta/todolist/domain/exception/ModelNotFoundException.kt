package com.teamsparta.todolist.domain.exception

data class ModelNotFoundException(
    val modelName: String,
    val id: String?
) : RuntimeException("model $modelName not found given id : $id")
