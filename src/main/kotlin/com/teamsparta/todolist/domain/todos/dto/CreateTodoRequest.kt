package com.teamsparta.todolist.domain.todos.dto

data class CreateTodoRequest (
    val title: String,
    val content: String?
)