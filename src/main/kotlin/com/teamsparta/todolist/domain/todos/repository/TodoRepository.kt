package com.teamsparta.todolist.domain.todos.repository

import com.teamsparta.todolist.domain.todos.model.Todos
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TodoRepository: JpaRepository<Todos, Long> {


    fun findAllTodosByOrderByCreatedAtDesc(): List<Todos>

    fun findAllTodosByOrderByCreatedAtAsc(): List<Todos>

    @Query("SELECT t FROM Todos t WHERE t.isDone = :isDone ORDER BY t.createdAt DESC")
    fun findTodosByIsDoneByOrderByCreatedAtDesc(isDone: Boolean): List<Todos>?

}