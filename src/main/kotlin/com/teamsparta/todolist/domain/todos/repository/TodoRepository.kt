package com.teamsparta.todolist.domain.todos.repository

import com.teamsparta.todolist.domain.todos.model.Todos
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TodoRepository: JpaRepository<Todos, Long> {

    fun findByAuthorAndDone(author: String,done: Boolean, pageable: Pageable): Page<Todos>

    fun findByAuthor(author: String, pageable: Pageable): Page<Todos>

    fun findByDone(done: Boolean, pageable: Pageable): Page<Todos>

    fun findAllByDone(done: Boolean, pageable: Pageable): Page<Todos>

    fun findTodosByAuthor(author: String, pageable: Pageable): Page<Todos>

}