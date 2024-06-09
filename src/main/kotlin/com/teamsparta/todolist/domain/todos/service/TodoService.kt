package com.teamsparta.todolist.domain.todos.service

import com.teamsparta.todolist.domain.todos.dto.CreateTodoRequest
import com.teamsparta.todolist.domain.todos.dto.TodoResponse
import com.teamsparta.todolist.domain.todos.dto.TodoWithCommentResponse
import com.teamsparta.todolist.domain.todos.dto.UpdateTodoRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface TodoService {

    fun getAllTodosSorted(author: String?, done: Boolean?, pageable: Pageable): Page<TodoResponse>

    fun getTodoById(todoId: Long): TodoWithCommentResponse

    fun createTodo(request: CreateTodoRequest, username : String): TodoResponse

    fun updateTodo(todoId: Long, request: UpdateTodoRequest, username: String): TodoResponse

    fun deleteTodo(todoId: Long, username: String)

    fun markTodoAsDone(todoId: Long, username: String): TodoResponse


}