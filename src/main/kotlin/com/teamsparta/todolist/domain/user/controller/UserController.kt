package com.teamsparta.todolist.domain.user.controller

import com.teamsparta.todolist.domain.user.dto.LoginResponse
import com.teamsparta.todolist.domain.user.dto.UserOperationRequest
import com.teamsparta.todolist.domain.user.dto.UserResponse
import com.teamsparta.todolist.domain.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/user")
@RestController
class UserController(
    private val userService: UserService
) {

    @PostMapping("/login")
    fun login(
        @RequestBody request: UserOperationRequest,
    ) : ResponseEntity<LoginResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(userService.login(request))
    }

    @PostMapping("/register")
    fun register(
        @RequestBody request: UserOperationRequest,
    ) : ResponseEntity<UserResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(userService.registerUser(request))
    }



    @PatchMapping("/update/{user-id}")
    fun resetPassword(
        @RequestBody request: UserOperationRequest,
        @PathVariable("user-id") id: Long
    ) : ResponseEntity<UserResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(userService.updateProfile(request))
    }

    @DeleteMapping("/{user-id}")
    fun resignUser(
        @PathVariable("user-id") userId: Long,
        @RequestBody request: UserOperationRequest
    ) : ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }

}