package com.teamsparta.todolist.domain.todos.controller

import com.teamsparta.todolist.domain.todos.dto.CreateTodoRequest
import com.teamsparta.todolist.domain.todos.dto.TodoResponse
import com.teamsparta.todolist.domain.todos.dto.TodoWithCommentResponse
import com.teamsparta.todolist.domain.todos.dto.UpdateTodoRequest
import com.teamsparta.todolist.domain.todos.service.TodoService
import com.teamsparta.todolist.security.SecurityUtil
import org.springdoc.core.annotations.ParameterObject
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RequestMapping("/todos")
@RestController
class TodoController(
    private val todoService: TodoService,
) {


    @GetMapping()
    fun getAllTodosDesc(
        @ParameterObject
        @RequestParam(required = false) author: String?,
        @RequestParam(required = false) done: Boolean?,
        @PageableDefault(size = 20, sort = ["createdAt"], direction = Sort.Direction.DESC) pageable: Pageable,
    ): ResponseEntity<Page<TodoResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.getAllTodosSorted(author, done, pageable))
    }

    @GetMapping("/{todoId}")
    fun getTodoById(
        @PathVariable todoId: Long
    ): ResponseEntity<TodoWithCommentResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.getTodoById(todoId))
    }

    @PreAuthorize("hasRole('User')")
    @PostMapping()
    fun createTodo(
        @RequestBody createTodoRequest: CreateTodoRequest
    ): ResponseEntity<TodoResponse> {
        val username = SecurityUtil.getCurrentUsername()
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(todoService.createTodo(createTodoRequest, username))
    }

    @PreAuthorize("hasRole('User')")
    @PutMapping("/{todoId}")
    fun updateTodo(
        @PathVariable todoId: Long,
        @RequestBody updateTodoRequest: UpdateTodoRequest
    ): ResponseEntity<TodoResponse> {
        val username = SecurityUtil.getCurrentUsername()
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.updateTodo(todoId, updateTodoRequest, username))
    }

    @PreAuthorize("hasRole('User')")
    @DeleteMapping("/{todoId}")
    fun deleteTodo(
        @PathVariable todoId: Long
    ): ResponseEntity<Unit> {
        val username = SecurityUtil.getCurrentUsername()
        todoService.deleteTodo(todoId, username)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }

    @PreAuthorize("hasRole('User')")
    @PatchMapping("/{todoId}/toggle")
    fun markTodoAsDone(
        @PathVariable todoId: Long
    ): ResponseEntity<TodoResponse> {
        val username = SecurityUtil.getCurrentUsername()
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(todoService.markTodoAsDone(todoId, username))
    }
}


