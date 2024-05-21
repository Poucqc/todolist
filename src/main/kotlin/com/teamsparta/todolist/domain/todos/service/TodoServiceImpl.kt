package com.teamsparta.todolist.domain.todos.service

import com.teamsparta.todolist.domain.comment.repository.CommentRepository
import com.teamsparta.todolist.domain.exception.ModelNotFoundException
import com.teamsparta.todolist.domain.todos.dto.CreateTodoRequest
import com.teamsparta.todolist.domain.todos.dto.TodoResponse
import com.teamsparta.todolist.domain.todos.dto.TodoWithCommentResponse
import com.teamsparta.todolist.domain.todos.dto.UpdateTodoRequest
import com.teamsparta.todolist.domain.todos.model.Todos
import com.teamsparta.todolist.domain.todos.model.toResponse
import com.teamsparta.todolist.domain.todos.model.toResponseWithComments
import com.teamsparta.todolist.domain.todos.repository.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime


@Service
class TodoServiceImpl(
    private val todoRepository: TodoRepository,
    private val commentRepository: CommentRepository
) : TodoService {

    override fun getAllTodosDesc(): List<TodoResponse> {
        return todoRepository.findAllTodosByOrderByCreatedAtDesc().map { it.toResponse() }
    }

    override fun getAllTodosAsc(): List<TodoResponse> {
        return todoRepository.findAllTodosByOrderByCreatedAtAsc().map { it.toResponse() }
    }

    override fun getTodoById(todoId: Long): TodoWithCommentResponse {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("todo", todoId)
        val comments = commentRepository.findCommentByTodoId(todoId)
        return todo.toResponseWithComments(comments)
    }

    @Transactional
    override fun createTodo(request: CreateTodoRequest): TodoResponse {
        return todoRepository.save(
            Todos(
                author = request.author,
                title = request.title,
                content = request.content,
                createdAt = LocalDateTime.now(),
                isDone = false
            )
        ).toResponse()
    }

    @Transactional
    override fun updateTodo(todoId: Long, request: UpdateTodoRequest): TodoResponse {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("todo", todoId)
        val (title, content) = request
        todo.title = title
        todo.content = content

        return todoRepository.save(todo).toResponse()
    }

    @Transactional
    override fun deleteTodo(todoId: Long) {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("todo", todoId)
        todoRepository.delete(todo)
    }

    @Transactional
    override fun markTodoAsDone(todoId: Long): TodoResponse {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("todo", todoId)
        todo.isDone = true
        return todoRepository.save(todo).toResponse()
    }

    override fun getTodosByStatusAsDone(isDone: Boolean): List<TodoResponse>? {
        return todoRepository.findAllByDoneOrderByCreatedAtDesc(isDone).map { it.toResponse() }
    }

}
