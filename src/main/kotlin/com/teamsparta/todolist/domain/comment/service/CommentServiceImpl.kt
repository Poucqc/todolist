package com.teamsparta.todolist.domain.comment.service

import com.teamsparta.todolist.domain.comment.controller.CommentController
import com.teamsparta.todolist.domain.comment.dto.AddCommentRequest
import com.teamsparta.todolist.domain.comment.dto.CommentResponse
import com.teamsparta.todolist.domain.comment.dto.DeleteCommentRequest
import com.teamsparta.todolist.domain.comment.dto.UpdateCommentRequest
import com.teamsparta.todolist.domain.comment.model.Comment
import com.teamsparta.todolist.domain.comment.model.toCommentResponse
import com.teamsparta.todolist.domain.comment.repository.CommentRepository
import com.teamsparta.todolist.domain.common.ValidationFormLength
import com.teamsparta.todolist.domain.exception.ModelNotFoundException
import com.teamsparta.todolist.domain.exception.PasswordNotMatchedException
import com.teamsparta.todolist.domain.todos.repository.TodoRepository

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentServiceImpl(
    private val todoRepository: TodoRepository,
    private val commentRepository: CommentRepository,

) : CommentService {

    @Transactional
    override fun addComment(todoId: Long, request: AddCommentRequest): CommentResponse {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("todo", todoId)
        ValidationFormLength.validateFormLength(request.commentText.length, 50, "comment", "commentText")
        return commentRepository.save(
            Comment(
                author = request.author,
                password = request.password,
                commentText = request.commentText,
                todo = todo
            )
        ).toCommentResponse()
    }

    @Transactional
    override fun updateComment(todoId: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse {
        val comment = validateCommentAccess(todoId, commentId, request.password)
        ValidationFormLength.validateFormLength(request.commentText.length, 50, "comment", "commentText")
        comment.commentText = request.commentText
        return commentRepository.save(comment).toCommentResponse()
    }

    @Transactional
    override fun deleteComment(todoId: Long, commentId: Long, request: DeleteCommentRequest) {
        val comment = validateCommentAccess(todoId, commentId, request.password)
        commentRepository.delete(comment)
    }

    private fun validateCommentAccess(todoId: Long, commentId: Long, password: String): Comment {
        todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("todo", todoId)
        val comment = commentRepository.findByIdOrNull(commentId) ?: throw ModelNotFoundException("comment", commentId)
        if ((comment.password != password)) {
            throw PasswordNotMatchedException(commentId)
        }
        return comment
    }
}