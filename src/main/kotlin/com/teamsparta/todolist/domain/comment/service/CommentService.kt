package com.teamsparta.todolist.domain.comment.service

import com.teamsparta.todolist.domain.comment.dto.*

interface CommentService {

    fun addComment(todoId: Long, request: AddCommentRequest): CommentResponse

    fun addUserComment(todoId: Long, request: UserCommentRequest): CommentResponse

    fun updateComment(todoId: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse

    fun updateUserComment(todoId: Long, commentId: Long, request: UserCommentRequest): CommentResponse

    fun deleteComment(todoId: Long, commentId: Long, request: DeleteCommentRequest)

    fun deleteUserComment(todoId: Long, commentId: Long)
}