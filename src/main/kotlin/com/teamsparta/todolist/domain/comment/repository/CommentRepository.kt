package com.teamsparta.todolist.domain.comment.repository

import com.teamsparta.todolist.domain.comment.model.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository: JpaRepository<Comment, Long> {

    @Query("select c from Comment c join fetch c.todos t where t.id = :todoId")
    fun findCommentByTodoId(todoId: Long): List<Comment>
}