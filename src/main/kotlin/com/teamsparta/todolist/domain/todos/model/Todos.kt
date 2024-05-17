package com.teamsparta.todolist.domain.todos.model

import com.teamsparta.todolist.domain.comment.dto.CommentResponse
import com.teamsparta.todolist.domain.comment.model.Comment
import com.teamsparta.todolist.domain.todos.dto.TodoResponse
import com.teamsparta.todolist.domain.todos.dto.TodoWithCommentResponse
import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table(name = "todos")
class Todos(

    @Column(name = "author", nullable = false)
    var author: String,

    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "content")
    var content: String? = null,

    @Column(name = "createdAt", nullable = false)
    var createdAt: LocalDateTime,

    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.EAGER, orphanRemoval = true)
    var comments: MutableList<Comment> = mutableListOf()
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}

fun Todos.toResponse(): TodoResponse {
    return TodoResponse(
        id = id!!,
        title = title,
        author = author,
        content = content,
        createdAt = createdAt
    )
}

fun Todos.toResponseWithComments(comments: List<Comment>?): TodoWithCommentResponse {
    return TodoWithCommentResponse(
        id = id!!,
        title = title,
        author = author,
        content = content,
        createdAt = createdAt,
        comments = comments?.map{ CommentResponse(it.author, it.comment) }
    )
}

