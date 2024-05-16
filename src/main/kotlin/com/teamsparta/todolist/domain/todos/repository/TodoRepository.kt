package com.teamsparta.todolist.domain.todos.repository

import com.sun.tools.javac.comp.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository: JpaRepository<Todo, Long> {
}