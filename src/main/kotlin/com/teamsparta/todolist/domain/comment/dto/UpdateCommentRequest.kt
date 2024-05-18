package com.teamsparta.todolist.domain.comment.dto

data class UpdateCommentRequest (
    val password: String,
    val commentText: String
)