package com.teamsparta.todolist.domain.comment.service

import com.teamsparta.todolist.domain.comment.dto.AddCommentRequest
import com.teamsparta.todolist.domain.comment.dto.CommentResponse
import com.teamsparta.todolist.domain.comment.dto.DeleteCommentRequest
import com.teamsparta.todolist.domain.comment.dto.UpdateCommentRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentServiceImpl: CommentService {

    @Transactional
    override fun addComment(todoId: Long, request: AddCommentRequest): CommentResponse {
        // TODO : 해당 id Todo 에 comment 를 작성
        // todo : todo 가 존재하지 않으면 exception : todo not found
        TODO("Not yet implemented")
    }

    @Transactional
    override fun updateComment(todoId: Long, commentId: Long, request: UpdateCommentRequest): CommentResponse {
        // todo : 해당 todoId 의 todo 에서 해당하는 commentId 의 comment 를 수정
        // todo : todoId 혹은 commentId 존재하지 않으면 ModelNotFoundException(todo or comment , id)
        TODO("Not yet implemented")
    }

    @Transactional
    override fun deleteComment(todoId: Long, commentId: Long, request: DeleteCommentRequest) {
        // todo : 해당 todoId 의 todo 에서 해당하는 commentId 의 comment 를 삭제
        // todo : todoId 혹은 commentId 존재하지 않으면 ModelNotFoundException(todo or comment , id)
        TODO("Not yet implemented")
    }
}