package com.teamsparta.todolist.domain.exception

data class ValidationException(
    val modelName: String,
    val fieldName: String
) : RuntimeException("model $modelName 's $fieldName validation failed")
