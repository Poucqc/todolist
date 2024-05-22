package com.teamsparta.todolist.domain.comment.repository

import com.teamsparta.todolist.domain.comment.model.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository: JpaRepository<Comment, Long> {

    fun findCommentByTodoId(id: Long): List<Comment>
}