package com.teamsparta.todolist.domain.comment.controller

import com.teamsparta.todolist.domain.comment.dto.AddCommentRequest
import com.teamsparta.todolist.domain.comment.dto.CommentResponse
import com.teamsparta.todolist.domain.comment.dto.DeleteCommentRequest
import com.teamsparta.todolist.domain.comment.dto.UpdateCommentRequest
import com.teamsparta.todolist.domain.comment.service.CommentService
import io.swagger.v3.oas.annotations.parameters.RequestBody
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

    @PutMapping("/{commentId}")
    fun updateComment(
        @PathVariable("todoId") todoId: Long,
        @PathVariable("commentId") commentId: Long,
        @RequestBody updateCommentRequest: UpdateCommentRequest
    ) : ResponseEntity<CommentResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(commentService.updateComment(todoId, commentId, updateCommentRequest))
    }

    @DeleteMapping("/{commentId}")
    fun deleteComment(
        @PathVariable("todoId") todoId: Long,
        @PathVariable("commentId") commentId: Long,
        @RequestBody deleteCommentRequest: DeleteCommentRequest
    ) : ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .build()
    }
}