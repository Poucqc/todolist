package com.teamsparta.todolist.domain.user.controller

import com.teamsparta.todolist.domain.user.dto.LoginRequest
import com.teamsparta.todolist.domain.user.dto.LoginResponse
import com.teamsparta.todolist.domain.user.dto.RegisterRequest
import com.teamsparta.todolist.domain.user.dto.UserResponse
import com.teamsparta.todolist.domain.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RequestMapping("/user")
@RestController
class UserController(
    private val userService: UserService
) {

    @PostMapping("/login")
    fun login(
        @RequestBody request: LoginRequest,
    ) : ResponseEntity<LoginResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(userService.login(request))
    }

    @PostMapping("/register")
    fun register(
        @RequestBody request: RegisterRequest,
    ) : ResponseEntity<UserResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(userService.registerUser(request))
    }




    @PatchMapping("/update/{user-id}")
    fun resetPassword(
        @RequestBody request: LoginRequest,
        @PathVariable("user-id") id: Long
    ) : ResponseEntity<UserResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(userService.updateProfile(request))
    }

    @DeleteMapping("/{user-id}")
    fun resignUser(
        @PathVariable("user-id") userId: Long,
        @RequestBody request: LoginRequest
    ) : ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }

}