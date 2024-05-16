package com.teamsparta.todolist.domain.user.model

import com.teamsparta.todolist.domain.todos.model.Todos
import jakarta.persistence.*




class User(

    val name : String,

) {

    var id : Long? = null
}