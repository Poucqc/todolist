package com.teamsparta.todolist.domain.exception

data class TypeNotMatchException(
    val modelName : String,
    val requireType : String
) : RuntimeException("Type not match: $modelName must $requireType Type")