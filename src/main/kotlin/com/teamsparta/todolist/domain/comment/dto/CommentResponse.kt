package com.teamsparta.todolist.domain.comment.dto

data class CommentResponse(
    val id : Long,
    val author: String,
    val comment: String
)
