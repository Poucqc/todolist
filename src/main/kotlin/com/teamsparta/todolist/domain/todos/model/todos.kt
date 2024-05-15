package com.teamsparta.todolist.domain.todos.model

import jakarta.persistence.*


@Entity
@Table(name = "todos")
class todos(

    @Column(name = "authorId", nullable = false)
    var authorId: Long,

    @Column(name = "author", nullable = false)
    var author: String,

    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "content")
    var content: String? = null,

    @Column(name = "createdAt", nullable = false)
    var createdAt: String

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}