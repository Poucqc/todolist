package com.teamsparta.todolist.domain.todos.repository

import com.teamsparta.todolist.domain.todos.model.OrderType
import com.teamsparta.todolist.domain.todos.model.Todos
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface TodoRepository: JpaRepository<Todos, Long> {


    fun findAllByOrderByCreatedAtDesc(): List<Todos>

    fun findAllByOrderByCreatedAtAsc(): List<Todos>

    fun findAllByDoneOrderByCreatedAtDesc(done: Boolean): List<Todos>

    fun findTodosByAuthor(author: String): List<Todos>

}