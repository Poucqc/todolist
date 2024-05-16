package com.teamsparta.todolist.domain.todos.model

import com.teamsparta.todolist.domain.todos.dto.TodoResponse
import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
@Table(name = "todos")
class Todos(

    @Column(name = "authorId", nullable = false)
    var authorId: Long,

    @Column(name = "author", nullable = false)
    var author: String,

    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "content")
    var content: String? = null,

    @Column(name = "createdAt", nullable = false)
    var createdAt: LocalDateTime
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}

fun Todos.toResponse(): TodoResponse {
    return TodoResponse(
        id = id!!,
        title = title,
        authorId = authorId,
        author = author,
        content = content,
        createdAt = createdAt
    )
}
