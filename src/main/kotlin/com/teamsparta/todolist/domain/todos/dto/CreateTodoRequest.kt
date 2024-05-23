package com.teamsparta.todolist.domain.todos.dto

import jakarta.validation.constraints.Size
import org.springframework.validation.annotation.Validated
import java.time.LocalDateTime

data class CreateTodoRequest (
    val author: String,
    @field:Size(min = 1, max = 200, message = "title must be between 1 and 200 characters long")
    val title: String,
    @field:Size(min = 1, max = 1000, message = "content must be between 1 and 1000 characters")
    val content: String,
    val createdAt: LocalDateTime,
    val done: Boolean = false
)