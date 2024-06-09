package com.teamsparta.todolist.domain.user.service

import com.teamsparta.todolist.domain.user.dto.LoginRequest
import com.teamsparta.todolist.domain.user.dto.LoginResponse
import com.teamsparta.todolist.domain.user.dto.RegisterRequest
import com.teamsparta.todolist.domain.user.dto.UserResponse


interface UserService {

    fun registerUser(request: RegisterRequest) : UserResponse

    fun login(request: LoginRequest) : LoginResponse

    fun updateProfile(request: LoginRequest) : UserResponse

    fun resignUser(request: LoginRequest)

}