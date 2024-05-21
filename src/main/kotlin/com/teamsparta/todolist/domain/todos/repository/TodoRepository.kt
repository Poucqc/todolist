package com.teamsparta.todolist.domain.todos.repository

import com.teamsparta.todolist.domain.todos.model.Todos
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface TodoRepository: JpaRepository<Todos, Long> {


    fun findAllTodosByOrderByCreatedAtDesc(): List<Todos>

    fun findAllTodosByOrderByCreatedAtAsc(): List<Todos>

    fun findAllByDoneOrderByCreatedAtDesc(done: Boolean): List<Todos>

}