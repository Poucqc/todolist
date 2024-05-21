package com.teamsparta.todolist.domain.todos.dto

data class CreateTodoRequest (
    val author: String,
    val title: String,
    val content: String,
    val isDone: Boolean = false
)