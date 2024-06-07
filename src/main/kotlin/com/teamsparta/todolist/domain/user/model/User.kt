package com.teamsparta.todolist.domain.user.model

import com.teamsparta.todolist.domain.comment.model.Comment
import com.teamsparta.todolist.domain.todos.model.Todos
import com.teamsparta.todolist.domain.user.dto.UserOperationRequest
import com.teamsparta.todolist.domain.user.dto.UserResponse
import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails


@Entity
@Table(name = "users")
class User(

    @Column(name = "user_name", nullable = false)
    var username: String,

    @Column(name = "password", nullable = false)
    var password: String,

    @OneToMany(mappedBy = "user", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, orphanRemoval = true)
    val todos: MutableList<Todos>? = mutableListOf(),

    @OneToMany(mappedBy = "user", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY, orphanRemoval = true)
    val comments: MutableList<Comment>? = mutableListOf(),

    var role : UserRole
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}

fun User.toResponse(): UserResponse {
    return UserResponse(
        username = username,
        role = role
    )
}

