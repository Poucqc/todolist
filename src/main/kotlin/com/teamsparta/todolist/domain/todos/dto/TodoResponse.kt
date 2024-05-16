package com.teamsparta.todolist.domain.todos.dto

import java.time.LocalDateTime

data class TodoResponse(
    val id: Long,
    val title: String,
    val authorId: Long,
    val author: String,
    val content: String?,
    val createdAt: LocalDateTime,
)
