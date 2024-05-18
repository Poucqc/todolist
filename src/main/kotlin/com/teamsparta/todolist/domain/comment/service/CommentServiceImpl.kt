package com.teamsparta.todolist.domain.comment.service

import com.teamsparta.todolist.domain.comment.dto.AddCommentRequest
import com.teamsparta.todolist.domain.comment.dto.CommentResponse
import com.teamsparta.todolist.domain.comment.dto.DeleteCommentRequest
import com.teamsparta.todolist.domain.comment.dto.UpdateCommentRequest
import com.teamsparta.todolist.domain.comment.model.Comment
import com.teamsparta.todolist.domain.comment.model.toCommentResponse
import com.teamsparta.todolist.domain.comment.repository.CommentRepository
import com.teamsparta.todolist.domain.exception.ModelNotFoundException
import com.teamsparta.todolist.domain.exception.PasswordNotMatchedException
import com.teamsparta.todolist.domain.todos.model.Todos
import com.teamsparta.todolist.domain.todos.repository.TodoRepository
import com.teamsparta.todolist.security.PasswordManager
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentServiceImpl(
    private val todoRepository: TodoRepository,
    private val commentRepository: CommentRepository,
    private val passwordManager: PasswordManager
) : CommentService {


    @Transactional
    override fun addComment(todoId: Long, request: AddCommentRequest): CommentResponse {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("todo", todoId)
        return commentRepository.save(
            Comment(
                author = request.author,
                password = request.password,
                commentContent = request.comment,
                todo = todo
            )
        ).toCommentResponse()
    }

    @Transactional
    override fun updateComment(todoId: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse {
        val (todos, comment) = validateCommentAccess(todoId, commentId, request.password)
        val commentContent = request.comment
        return commentRepository.save(comment).toCommentResponse()
    }

    @Transactional
    override fun deleteComment(todoId: Long, commentId: Long, request: DeleteCommentRequest) {
        val (todos, comment) = validateCommentAccess(todoId, commentId, request.password)
        commentRepository.delete(comment)
    }

    private fun validateCommentAccess(todoId: Long, commentId: Long, password: String): Pair<Todos, Comment> {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("todo", todoId)
        val comment = commentRepository.findByIdOrNull(commentId) ?: throw ModelNotFoundException("comment", commentId)
        if (!passwordManager.isPasswordValid(comment.password, password)) {
            throw PasswordNotMatchedException(commentId)
        }
        return Pair(todo, comment)
    }
}