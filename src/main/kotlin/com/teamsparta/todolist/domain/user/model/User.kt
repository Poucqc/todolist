package com.teamsparta.todolist.domain.user.model

import com.sun.tools.javac.comp.Todo
import com.teamsparta.todolist.domain.todos.model.Todos
import jakarta.persistence.*


@Entity
@Table(name = "users")
class User(

    @Column(name = "name")
    val name : String,

    @OneToMany(mappedBy = "user_id", fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    var todos : MutableList<Todos> = mutableListOf()
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null
}