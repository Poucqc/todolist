package com.teamsparta.todolist.domain.user.service

import com.teamsparta.todolist.domain.user.dto.LoginResponse
import com.teamsparta.todolist.domain.user.dto.UserOperationRequest
import com.teamsparta.todolist.domain.user.dto.UserResponse
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService


interface UserService {

    fun registerUser(request: UserOperationRequest) : UserResponse

    fun login(request: UserOperationRequest) : LoginResponse

    fun updateProfile(request: UserOperationRequest) : UserResponse

    fun resignUser(request: UserOperationRequest)

}