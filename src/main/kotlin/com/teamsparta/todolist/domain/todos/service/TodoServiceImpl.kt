package com.teamsparta.todolist.domain.todos.service

import com.teamsparta.todolist.domain.todos.dto.CreateTodoRequest
import com.teamsparta.todolist.domain.todos.dto.TodoResponse
import com.teamsparta.todolist.domain.todos.dto.UpdateTodoRequest
import org.springframework.stereotype.Service


@Service
class TodoServiceImpl: TodoService {
    override fun getAllTodos(): List<TodoResponse> {
        // TODO : 모든 TODO 를 가져와서 작성일 기준 내림차순으로 정렬 후 반환
        TODO("Not yet implemented")
    }

    override fun getTodoById(todoId: Long): TodoResponse {
        // TODO : id 에 해당하는 todo 를 반환
        // TODO : 해당하는 id 없을경우 throw TodoNotFoundException
        TODO("Not yet implemented")
    }

    override fun createTodo(request: CreateTodoRequest): TodoResponse {
        // TODO : todo 생성 후 반환
        TODO("Not yet implemented")
    }

    override fun updateTodo(todoId: Long, request: UpdateTodoRequest): TodoResponse {
        // TODO : id 에 해당하는 todo 를 수정 후 반환
        // TODO : 해당하는 id 없을경우 throw TodoNotFoundException
        TODO("Not yet implemented")
    }

    override fun deleteTodo(todoId: Long) {
        // TODO : id 에 해당하는 todo 삭제
        // TODO : 해당하는 id 없을경우 throw TodoNotFoundException
        TODO("Not yet implemented")
    }
}