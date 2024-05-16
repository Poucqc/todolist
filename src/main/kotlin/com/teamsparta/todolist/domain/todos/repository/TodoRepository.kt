package com.teamsparta.todolist.domain.todos.repository

import com.teamsparta.todolist.domain.todos.model.Todos
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TodoRepository: JpaRepository<Todos, Long> {

    @Query("select t from Todos t order by t.createdAt desc")
    fun findAllTodos(): List<Todos>
}