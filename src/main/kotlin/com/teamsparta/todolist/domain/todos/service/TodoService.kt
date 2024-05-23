package com.teamsparta.todolist.domain.todos.service

import com.teamsparta.todolist.domain.todos.dto.CreateTodoRequest
import com.teamsparta.todolist.domain.todos.dto.TodoResponse
import com.teamsparta.todolist.domain.todos.dto.TodoWithCommentResponse
import com.teamsparta.todolist.domain.todos.dto.UpdateTodoRequest
import com.teamsparta.todolist.domain.todos.model.OrderType
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface TodoService {

    fun getAllTodosSorted(order: OrderType, pageable: Pageable) : Page<TodoResponse>

    fun getTodoById(todoId: Long) : TodoWithCommentResponse

    fun createTodo(request: CreateTodoRequest) : TodoResponse

    fun updateTodo(todoId: Long, request: UpdateTodoRequest) : TodoResponse

    fun deleteTodo(todoId: Long)

    fun markTodoAsDone(todoId: Long) : TodoResponse

    fun getTodosByStatusAsDone(done: Boolean, pageable: Pageable) : Page<TodoResponse>

    fun getTodosByAuthorName(authorName: String, pageable: Pageable): Page<TodoResponse>

}