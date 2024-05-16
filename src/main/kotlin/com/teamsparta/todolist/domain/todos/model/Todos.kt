package com.teamsparta.todolist.domain.todos.model

import com.teamsparta.todolist.domain.user.model.User
import jakarta.persistence.*


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
    var createdAt: String,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id")
    var user: User
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}