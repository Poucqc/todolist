package com.teamsparta.todolist.domain.comment.dto

data class AddCommentRequest(
    val author: String,
    val password: String,
    val commentText: String
)
