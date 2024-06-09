package com.teamsparta.todolist.domain.user.service

import com.teamsparta.todolist.domain.exception.InvalidCredentialException
import com.teamsparta.todolist.domain.user.dto.LoginRequest
import com.teamsparta.todolist.domain.user.dto.LoginResponse
import com.teamsparta.todolist.domain.user.dto.RegisterRequest
import com.teamsparta.todolist.domain.user.dto.UserResponse
import com.teamsparta.todolist.domain.user.model.User
import com.teamsparta.todolist.domain.user.model.toResponse
import com.teamsparta.todolist.domain.user.repository.UserRepository
import com.teamsparta.todolist.security.jwt.JwtPlugin
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtPlugin: JwtPlugin
) : UserService {

    override fun registerUser(request: RegisterRequest): UserResponse {
        if (userRepository.existsByUsername(request.username)) {
            throw IllegalArgumentException("Username ${request.username} already registered")
        }
        return userRepository.save(
            User(
                username = request.username,
                password = passwordEncoder.encode(request.password),
                role = request.role
            )
        ).toResponse()
    }

    override fun login(request: LoginRequest): LoginResponse {
        val user = userRepository.findByUsername(request.username)
            ?: throw UsernameNotFoundException("Username ${request.username} not found")
        if (!passwordEncoder.matches(request.password, user.password)) {
            throw InvalidCredentialException()
        }
        return LoginResponse(
            accessToken = jwtPlugin.generateAccessToken(
                subject = user.id.toString(),
                username = user.username,
                role = user.role
            )
        )
    }

    @Transactional
    override fun updateProfile(request: LoginRequest): UserResponse {
        val user = userRepository.findByUsername(request.username)
            ?: throw UsernameNotFoundException("Username ${request.username} not found")
        return userRepository.save(
            User(
                username = request.username,
                password = passwordEncoder.encode(request.password),
                role = user.role
            )
        ).toResponse()
    }

    override fun resignUser(request: LoginRequest) {
        val user = userRepository.findByUsername(request.username)
            ?:throw UsernameNotFoundException("Username ${request.username} not found")
        if(!passwordEncoder.matches(request.password, user.password)) {
            throw InvalidCredentialException()
        }
        userRepository.delete(user)
        println("Your Account has been successfully resigned")
    }
}