package com.teamsparta.todolist.domain.user.service

import com.teamsparta.todolist.domain.exception.PasswordNotMatchWhitNameException
import com.teamsparta.todolist.domain.exception.UserNotFoundException
import com.teamsparta.todolist.domain.user.dto.UserOperationRequest
import com.teamsparta.todolist.domain.user.dto.UserResponse
import com.teamsparta.todolist.domain.user.model.User
import com.teamsparta.todolist.domain.user.model.toResponse
import com.teamsparta.todolist.domain.user.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {
    override fun registerUser(request: UserOperationRequest): UserResponse {
        return userRepository.save(
            User(
                name = request.name,
                password = request.password,
            )
        ).toResponse()
    }

    @Transactional
    override fun login(request: UserOperationRequest): UserResponse {
        if (validatePasswordByName(request)) {
            TODO("login success")
        } else throw PasswordNotMatchWhitNameException(request.name)
    }

    @Transactional
    override fun resetPassword(request: UserOperationRequest): UserResponse {
        val user = userRepository.findByName(request.name) ?: throw UserNotFoundException(request.name)
        if (validatePasswordByName(request)) {
            user.password = request.password
            return userRepository.save(user).toResponse()
        } else throw PasswordNotMatchWhitNameException(request.name)
    }

    @Transactional
    override fun resignUser(request: UserOperationRequest) {
        val user = userRepository.findByName(request.name) ?: throw UserNotFoundException(request.name)
        if (validatePasswordByName(request)) {
            userRepository.delete(user)
            println("resigned user ${user.name}")
        }
    }

    private fun validatePasswordByName(request: UserOperationRequest): Boolean {
        val user = userRepository.findByName(request.name) ?: throw UserNotFoundException(request.name)
        return user.password == request.password
    }


}