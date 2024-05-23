package com.teamsparta.todolist.domain.comment.dto

import jakarta.validation.constraints.Size

data class UpdateCommentRequest (
    val password: String,
    @field:Size(min = 1, max = 50, message = "commentText must be between 1 and 50 characters")
    val commentText: String
)