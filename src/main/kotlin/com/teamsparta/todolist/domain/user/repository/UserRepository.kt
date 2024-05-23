package com.teamsparta.todolist.domain.user.repository

import com.teamsparta.todolist.domain.user.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun findByName(name: String): User?
}