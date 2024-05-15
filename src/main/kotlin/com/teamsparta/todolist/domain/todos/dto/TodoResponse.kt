package com.teamsparta.todolist.domain.todos.dto

data class TodoResponse(
    val id: Long,
    val title: String,
    val authorId: Long,
    val author: String,
    val content: String?,
    val createdAt: Long,
)
