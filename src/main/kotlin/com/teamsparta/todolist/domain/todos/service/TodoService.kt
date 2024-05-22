package com.teamsparta.todolist.domain.todos.service

import com.teamsparta.todolist.domain.todos.dto.CreateTodoRequest
import com.teamsparta.todolist.domain.todos.dto.TodoResponse
import com.teamsparta.todolist.domain.todos.dto.TodoWithCommentResponse
import com.teamsparta.todolist.domain.todos.dto.UpdateTodoRequest
import com.teamsparta.todolist.domain.todos.model.OrderType

interface TodoService {

    fun getAllTodosSorted(orderType: OrderType) : List<TodoResponse>

    fun getTodoById(todoId: Long) : TodoWithCommentResponse

    fun createTodo(request: CreateTodoRequest) : TodoResponse

    fun updateTodo(todoId: Long, request: UpdateTodoRequest) : TodoResponse

    fun deleteTodo(todoId: Long)

    fun markTodoAsDone(todoId: Long) : TodoResponse

    fun getTodosByStatusAsDone(done: Boolean) : List<TodoResponse>

    fun getTodosByAuthorName(authorName: String): List<TodoResponse>

}