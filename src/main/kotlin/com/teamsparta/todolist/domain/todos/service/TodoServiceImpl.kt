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
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime


@Service
class TodoServiceImpl(
    private val todoRepository: TodoRepository,
    private val commentRepository: CommentRepository
) : TodoService {

    override fun getAllTodosSorted(author: String?, done: Boolean?, pageable: Pageable): Page<TodoResponse> {
        val pageRequest = PageRequest.of(pageable.pageNumber, pageable.pageSize, pageable.sort)
        return if (author != null && done != null) {
            todoRepository.findByAuthorAndDone(author, done, pageRequest).map { it.toResponse() }
        } else if (author != null) {
            todoRepository.findByAuthor(author, pageRequest).map { it.toResponse() }
        } else if (done != null) {
            todoRepository.findByDone(done, pageRequest).map { it.toResponse() }
        } else {
            todoRepository.findAll(pageRequest).map { it.toResponse() }
        }
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
                done = false,
                user = null
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
        todo.done = true
        return todoRepository.save(todo).toResponse()
    }

}