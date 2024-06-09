package com.teamsparta.todolist.domain.comment.controller

import com.teamsparta.todolist.domain.comment.dto.*
import com.teamsparta.todolist.domain.comment.repository.CommentRepository
import com.teamsparta.todolist.domain.comment.service.CommentService
import com.teamsparta.todolist.security.SecurityUtil
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RequestMapping("/todos/{todoId}")
@RestController
class CommentController(
    private val commentService: CommentService,
    commentRepository: CommentRepository
) {

    private final val commentRepository: CommentRepository = TODO("initialize me")

    @PostMapping()
    fun addComment(
        @PathVariable("todoId") todoId: Long,
        @RequestBody addCommentRequest: CommentRequest
    ) : ResponseEntity<CommentResponse> {
        val username = SecurityUtil.getCurrentUsername()
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(commentService.addComment(todoId, addCommentRequest, username))
    }


    @PutMapping("/update/{commentId}")
    fun updateComment(
        @PathVariable("todoId") todoId: Long,
        @PathVariable("commentId") commentId: Long,
        @RequestBody updateCommentRequest: CommentRequest
    ) : ResponseEntity<CommentResponse> {
        val username = SecurityUtil.getCurrentUsername()
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(commentService.updateComment(todoId, commentId, updateCommentRequest, username))
    }


    @DeleteMapping("/delete/{commentId}")
    fun deleteComment(
        @PathVariable("todoId") todoId: Long,
        @PathVariable("commentId") commentId: Long,
    ) : ResponseEntity<Unit> {
        val username = SecurityUtil.getCurrentUsername()
        commentService.deleteComment(todoId, commentId, username)
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }

}