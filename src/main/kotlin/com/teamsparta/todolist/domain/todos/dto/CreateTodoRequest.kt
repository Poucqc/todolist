package com.teamsparta.todolist.domain.todos.dto

import java.time.LocalDateTime

data class CreateTodoRequest (
    val author: String,
    val title: String,
    val content: String,
    val createdAt: LocalDateTime,
    val done: Boolean = false
)