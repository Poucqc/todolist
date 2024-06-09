package com.teamsparta.todolist.domain.comment.service

import com.teamsparta.todolist.domain.comment.dto.CommentRequest
import com.teamsparta.todolist.domain.comment.dto.CommentResponse
import com.teamsparta.todolist.domain.comment.model.Comment
import com.teamsparta.todolist.domain.comment.model.toCommentResponse
import com.teamsparta.todolist.domain.comment.repository.CommentRepository
import com.teamsparta.todolist.domain.exception.InvalidCredentialException
import com.teamsparta.todolist.domain.exception.ModelNotFoundException
import com.teamsparta.todolist.domain.todos.model.Todos
import com.teamsparta.todolist.domain.todos.repository.TodoRepository
import com.teamsparta.todolist.domain.user.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentServiceImpl(
    private val todoRepository: TodoRepository,
    private val commentRepository: CommentRepository,
    private val userRepository: UserRepository,

    ) : CommentService {

    @Transactional
    override fun addComment(todoId: Long, request: CommentRequest, username : String): CommentResponse {
        val todo = findTodoNullSafe(todoId)
        val user = userRepository.findByUsername(username)
            ?: throw ModelNotFoundException("user", username)
        return commentRepository.save(
            Comment(
                author = username,
                commentText = request.commentText,
                todos = todo,
                user = user
            )
        ).toCommentResponse()
    }


    @Transactional
    override fun updateComment(todoId: Long, commentId: Long, request: CommentRequest, username: String): CommentResponse {
        findTodoNullSafe(todoId)
        val comment = findCommentNullSafe(commentId)
        if (comment.author != username) throw InvalidCredentialException()
        comment.commentText = request.commentText
        return comment.toCommentResponse()
    }


    @Transactional
    override fun deleteComment(todoId: Long, commentId: Long, username: String) {
        findTodoNullSafe(todoId)
        val comment = findCommentNullSafe(commentId)
        if (comment.author != username) throw InvalidCredentialException()
        commentRepository.delete(comment)
        println("삭제되었습니다")
    }



    private fun findTodoNullSafe(todoId: Long): Todos {
        val todo = todoRepository.findByIdOrNull(todoId)
            ?: throw ModelNotFoundException("todo", todoId.toString())
        return todo
    }

    private fun findCommentNullSafe(commentId: Long): Comment {
        val comment = commentRepository.findByIdOrNull(commentId)
            ?: throw ModelNotFoundException("comment", commentId.toString())
        return comment
    }


}