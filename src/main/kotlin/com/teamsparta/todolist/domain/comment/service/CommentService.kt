package com.teamsparta.todolist.domain.comment.service

import com.teamsparta.todolist.domain.comment.dto.*

interface CommentService {

    fun addComment(todoId: Long, request: CommentRequest, username : String): CommentResponse

    fun updateComment(todoId: Long, commentId: Long, request: CommentRequest, username: String): CommentResponse

    fun deleteComment(todoId: Long, commentId: Long, username : String)

}