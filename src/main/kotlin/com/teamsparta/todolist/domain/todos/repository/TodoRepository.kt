package com.teamsparta.todolist.domain.todos.repository

import com.teamsparta.todolist.domain.todos.model.Todos
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository: JpaRepository<Todos, Long> {



    fun findAllByDone(done: Boolean, pageable: Pageable): Page<Todos>

    fun findTodosByAuthor(author: String, pageable: Pageable): Page<Todos>

}