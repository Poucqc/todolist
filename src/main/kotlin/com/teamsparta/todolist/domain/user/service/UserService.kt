package com.teamsparta.todolist.domain.user.service

import com.teamsparta.todolist.domain.user.dto.TokenResponse
import com.teamsparta.todolist.domain.user.dto.UserOperationRequest
import com.teamsparta.todolist.domain.user.dto.UserResponse


interface UserService {

    fun registerUser(request: UserOperationRequest) : UserResponse

    fun login(request: UserOperationRequest) : TokenResponse

    fun resetPassword(request: UserOperationRequest) : UserResponse

    fun resignUser(request: UserOperationRequest)

}