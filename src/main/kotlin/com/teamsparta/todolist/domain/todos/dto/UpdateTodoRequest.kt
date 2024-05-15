package com.teamsparta.todolist.domain.todos.dto

data class UpdateTodoRequest(
    val title : String,
    val content : String?
)
