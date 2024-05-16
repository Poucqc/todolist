package com.teamsparta.todolist.domain.todos.service

import com.teamsparta.todolist.domain.exception.TodoNotFoundException
import com.teamsparta.todolist.domain.todos.dto.CreateTodoRequest
import com.teamsparta.todolist.domain.todos.dto.TodoResponse
import com.teamsparta.todolist.domain.todos.dto.UpdateTodoRequest
import com.teamsparta.todolist.domain.todos.model.Todos
import com.teamsparta.todolist.domain.todos.model.toResponse
import com.teamsparta.todolist.domain.todos.repository.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime


@Service
class TodoServiceImpl(
    private val todoRepository: TodoRepository
) : TodoService {

    override fun getAllTodos(): List<TodoResponse> {
        return todoRepository.findAllTodos().map{it.toResponse()}
    }

    override fun getTodoById(todoId: Long): TodoResponse {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw TodoNotFoundException("todo", todoId)
        return todo.toResponse()
    }

    @Transactional
    override fun createTodo(request: CreateTodoRequest): TodoResponse {
        return todoRepository.save(
            Todos(
                author = request.author,
                title = request.title,
                content = request.content,
                createdAt = LocalDateTime.now()
            )
        ).toResponse()
    }

    @Transactional
    override fun updateTodo(todoId: Long, request: UpdateTodoRequest): TodoResponse {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw TodoNotFoundException("todo", todoId)
        val (title, content) = request
        todo.title = todo.title
        todo.content = content

        return todoRepository.save(todo).toResponse()
    }

    @Transactional
    override fun deleteTodo(todoId: Long) {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw TodoNotFoundException("todo", todoId)
        todoRepository.delete(todo)
    }
}