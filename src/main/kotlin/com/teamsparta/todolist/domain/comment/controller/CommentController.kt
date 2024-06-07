package com.teamsparta.todolist.domain.comment.controller

import com.teamsparta.todolist.domain.comment.dto.*
import com.teamsparta.todolist.domain.comment.service.CommentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RequestMapping("/todos/{todoId}")
@RestController
class CommentController(
    private val commentService: CommentService
) {

    @PostMapping()
    fun addComment(
        @PathVariable("todoId") todoId: Long,
        @RequestBody addCommentRequest: AddCommentRequest
    ) : ResponseEntity<CommentResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(commentService.addComment(todoId, addCommentRequest))
    }

    @PostMapping("/user")
    fun addUserComment(
        @PathVariable("todoId") todoId: Long,
        @RequestBody userCommentRequest: UserCommentRequest
    ) : ResponseEntity<CommentResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(commentService.addUserComment(todoId, userCommentRequest))
    }

    @PutMapping("/update/{commentId}")
    fun updateComment(
        @PathVariable("todoId") todoId: Long,
        @PathVariable("commentId") commentId: Long,
        @RequestBody updateCommentRequest: UpdateCommentRequest
    ) : ResponseEntity<CommentResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(commentService.updateComment(todoId, commentId, updateCommentRequest))
    }

    @PutMapping("/update/user/{commentId}")
    fun updateUserComment(
        @PathVariable("todoId") todoId: Long,
        @PathVariable("commentId") commentId: Long,
        @RequestBody userCommentRequest: UserCommentRequest
    ) :ResponseEntity<CommentResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(commentService.updateUserComment(todoId, commentId, userCommentRequest))
    }

    @DeleteMapping("/delete/{commentId}")
    fun deleteComment(
        @PathVariable("todoId") todoId: Long,
        @PathVariable("commentId") commentId: Long,
        @RequestBody deleteCommentRequest: DeleteCommentRequest
    ) : ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }

    @DeleteMapping("/delete/user/{commentId}")
    fun deleteUserComment(
        @PathVariable("todoId") todoId: Long,
        @PathVariable("commentId") commentId: Long,
    ) : ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }
}