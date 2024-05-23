package com.teamsparta.todolist.domain.user.model

import com.teamsparta.todolist.domain.todos.model.Todos
import com.teamsparta.todolist.domain.user.dto.UserResponse
import jakarta.persistence.*



@Entity
@Table(name = "users")
class User(
    @Column(name = "user_name", nullable = false)
    val name : String,

    @Column(name = "password", nullable = false)
    var password : String,

    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, orphanRemoval = true)
    val todos : MutableList<Todos>? = mutableListOf()
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null
}

fun User.toResponse() : UserResponse {
    return UserResponse(
        id = id!!,
        name = name,
    )
}