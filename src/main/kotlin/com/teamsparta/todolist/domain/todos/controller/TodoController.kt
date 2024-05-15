package com.teamsparta.todolist.domain.todos.controller

import com.teamsparta.todolist.domain.todos.dto.CreateTodoRequest
import com.teamsparta.todolist.domain.todos.dto.TodoResponse
import com.teamsparta.todolist.domain.todos.dto.UpdateTodoRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/todos")
@RestController
class TodoController() {

    @GetMapping()
    fun getAllTodos() : ResponseEntity<List<TodoResponse>> {
        TODO("Not yet implemented")
    }

    @GetMapping("/{todoId}")
    fun getTodosById(
        @PathVariable todoId: Long
    ) : ResponseEntity<TodoResponse> {
        TODO("Not yet implemented")
    }

    @PostMapping()
    fun createTodo(
        @RequestBody createTodoRequest: CreateTodoRequest
    ) : ResponseEntity<TodoResponse> {
        TODO("Not yet implemented")
    }

    @PutMapping("/{todoId}")
    fun updateTodo(
        @PathVariable todoId: Long,
        @RequestBody updateTodoRequest: UpdateTodoRequest
    ) : ResponseEntity<TodoResponse> {
        TODO("Not yet implemented")
    }

    @DeleteMapping("/{todoId}")
    fun deleteTodo(
        @PathVariable todoId: Long
    ) : ResponseEntity<Unit> {
        TODO("Not yet implemented")
    }
}