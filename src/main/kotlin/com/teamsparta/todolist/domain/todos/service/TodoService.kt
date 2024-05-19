package com.teamsparta.todolist.domain.todos.service

import com.teamsparta.todolist.domain.todos.dto.CreateTodoRequest
import com.teamsparta.todolist.domain.todos.dto.TodoResponse
import com.teamsparta.todolist.domain.todos.dto.TodoWithCommentResponse
import com.teamsparta.todolist.domain.todos.dto.UpdateTodoRequest

interface TodoService {

    fun getAllTodosDesc() : List<TodoResponse>

    fun getAllTodosAsc() : List<TodoResponse>

    fun getTodoById(todoId: Long) : TodoWithCommentResponse

    fun createTodo(request: CreateTodoRequest) : TodoResponse

    fun updateTodo(todoId: Long, request: UpdateTodoRequest) : TodoResponse

    fun deleteTodo(todoId: Long)

    fun markTodoAsDone(todoId: Long) : TodoResponse

    fun getTodosByStatusAsDone(isDone: Boolean) : List<TodoResponse>?

}