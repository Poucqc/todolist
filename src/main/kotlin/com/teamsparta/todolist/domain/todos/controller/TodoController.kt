package com.teamsparta.todolist.domain.todos.controller

import com.teamsparta.todolist.domain.todos.dto.CreateTodoRequest
import com.teamsparta.todolist.domain.todos.dto.TodoResponse
import com.teamsparta.todolist.domain.todos.dto.TodoWithCommentResponse
import com.teamsparta.todolist.domain.todos.dto.UpdateTodoRequest
import com.teamsparta.todolist.domain.todos.model.OrderType
import com.teamsparta.todolist.domain.todos.service.TodoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/todos")
@RestController
class TodoController(
    private val todoService: TodoService
) {

    @GetMapping()
    fun getAllTodosDesc(
        @RequestParam order: OrderType
    ) : ResponseEntity<List<TodoResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.getAllTodosSorted(order))
    }

    @GetMapping("/{todoId}")
    fun getTodoById(
        @PathVariable todoId: Long
    ) : ResponseEntity<TodoWithCommentResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.getTodoById(todoId))
    }

    @PostMapping()
    fun createTodo(
        @RequestBody createTodoRequest: CreateTodoRequest
    ) : ResponseEntity<TodoResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(todoService.createTodo(createTodoRequest))
    }

    @PutMapping("/{todoId}")
    fun updateTodo(
        @PathVariable todoId: Long,
        @RequestBody updateTodoRequest: UpdateTodoRequest
    ) : ResponseEntity<TodoResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.updateTodo(todoId, updateTodoRequest))
    }

    @DeleteMapping("/{todoId}")
    fun deleteTodo(
        @PathVariable todoId: Long
    ) : ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }

    @PatchMapping("/{todoId}/toggle")
    fun markTodoAsDone(
        @PathVariable todoId: Long
    ) : ResponseEntity<TodoResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.markTodoAsDone(todoId))
    }

    @GetMapping("/{done}")
    fun getTodosByStatusAsDone(
        @PathVariable done: Boolean
    ) : ResponseEntity<List<TodoResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.getTodosByStatusAsDone(done))
    }
}