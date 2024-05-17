package com.teamsparta.todolist.domain.todos.repository

import com.teamsparta.todolist.domain.todos.model.Todos
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TodoRepository: JpaRepository<Todos, Long> {


    fun findAllTodosByOrderByCreatedAtDesc(): List<Todos>

    // 오름차순 메서드 따로 구현
}