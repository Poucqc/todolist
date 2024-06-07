package com.teamsparta.todolist.domain.comment.service

import com.teamsparta.todolist.domain.comment.dto.*
import com.teamsparta.todolist.domain.comment.model.Comment
import com.teamsparta.todolist.domain.comment.model.toCommentResponse
import com.teamsparta.todolist.domain.comment.repository.CommentRepository
import com.teamsparta.todolist.domain.exception.ModelNotFoundException
import com.teamsparta.todolist.domain.exception.NoPermissionException
import com.teamsparta.todolist.domain.exception.PasswordNotMatchedException
import com.teamsparta.todolist.domain.todos.model.Todos
import com.teamsparta.todolist.domain.todos.repository.TodoRepository
import com.teamsparta.todolist.domain.user.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentServiceImpl(
    private val todoRepository: TodoRepository,
    private val commentRepository: CommentRepository,
    private val userRepository: UserRepository,

    ) : CommentService {

    @Transactional
    override fun addComment(todoId: Long, request: AddCommentRequest): CommentResponse {
        val todo = validateTodoAccess(todoId)
        return commentRepository.save(
            Comment(
                author = request.author,
                password = request.password,
                commentText = request.commentText,
                todos = todo,
                user = null
            )
        ).toCommentResponse()
    }

    @Transactional
    override fun addUserComment(todoId: Long, request: UserCommentRequest): CommentResponse {
        val todo = validateTodoAccess(todoId)
        val currentUser =
            SecurityContextHolder.getContext().authentication.principal as? org.springframework.security.core.userdetails.User
                ?: throw NoPermissionException("this")
        val author = currentUser.username
        val user = currentUser.let { userRepository.findByUsername(it.username) }
        return commentRepository.save(
            Comment(
                author = user!!.username,
                password = user.password,
                commentText = request.commentText,
                todos = todo,
                user = user
            )
        ).toCommentResponse()
    }


    @Transactional
    override fun updateComment(todoId: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse {
        val comment = validateCommentAccess(todoId, commentId, request.password)
        comment.commentText = request.commentText
        return commentRepository.save(comment).toCommentResponse()
    }

    @Transactional
    override fun updateUserComment(todoId: Long, commentId: Long, request: UserCommentRequest): CommentResponse {
        var todo = validateTodoAccess(todoId)
        val currentUser =
            SecurityContextHolder.getContext().authentication.principal as? org.springframework.security.core.userdetails.User
                ?: throw NoPermissionException("this")
        val author = currentUser.username
        val user = currentUser.let { userRepository.findByUsername(it.username) }
        val comment = validateCommentAccess(todoId, commentId, user!!.password)
        comment.commentText = request.commentText

        return commentRepository.save(comment).toCommentResponse()
    }

    @Transactional
    override fun deleteComment(todoId: Long, commentId: Long, request: DeleteCommentRequest) {
        val comment = validateCommentAccess(todoId, commentId, request.password)
        commentRepository.delete(comment)
    }

    @Transactional
    override fun deleteUserComment(todoId: Long, commentId: Long) {
        validateTodoAccess(todoId)
        val currentUser =
            SecurityContextHolder.getContext().authentication.principal as? org.springframework.security.core.userdetails.User
                ?: throw NoPermissionException("this")
        val user = currentUser.let { userRepository.findByUsername(it.username) }
        val comment = validateCommentAccess(todoId, commentId, user!!.password)
        commentRepository.delete(comment)
    }

    private fun validateCommentAccess(todoId: Long, commentId: Long, password: String): Comment {
        validateTodoAccess(todoId)
        val comment = commentRepository.findByIdOrNull(commentId) ?: throw ModelNotFoundException("comment", commentId)
        if ((comment.password != password)) {
            throw PasswordNotMatchedException(commentId)
        }
        return comment
    }

    private fun validateTodoAccess(todoId: Long): Todos {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("todo", todoId)
        return todo
    }

}