package com.teamsparta.todolist.domain.comment.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/todos/{todoId}")
class CommentController {

    @GetMapping()
    fun addComment() {
        TODO()
    }

    @GetMapping("/{commentId}")
    fun updateComment() {
        TODO()
    }

    @PostMapping("/{commentId}")
    fun deleteComment() {
        TODO()
    }
}