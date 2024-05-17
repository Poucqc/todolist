package com.teamsparta.todolist.domain.comment.service

import com.teamsparta.todolist.domain.comment.dto.AddCommentRequest
import com.teamsparta.todolist.domain.comment.dto.CommentResponse
import com.teamsparta.todolist.domain.comment.dto.DeleteCommentRequest
import com.teamsparta.todolist.domain.comment.dto.UpdateCommentRequest

interface CommentService {

    fun addComment(todoId: Long, request: AddCommentRequest): CommentResponse

    fun updateComment(todoId: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse

    fun deleteComment(todoId: Long, commentId: Long, request: DeleteCommentRequest)
}