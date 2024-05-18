package com.teamsparta.todolist.domain.comment.model

import com.teamsparta.todolist.domain.comment.dto.CommentResponse
import com.teamsparta.todolist.domain.todos.model.Todos
import jakarta.persistence.*

@Entity
@Table(name = "comment")
class Comment(

    @Column(name = "author", nullable = false)
    val author: String,

    @Column(name = "password", nullable = false)
    val password: String,

    @Column(name = "comment", nullable = false)
    var commentText : String,

    @ManyToOne(cascade = [(CascadeType.MERGE)], fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id", nullable = false)
    var todo: Todos
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}

fun Comment.toCommentResponse() : CommentResponse {
    return CommentResponse(
        author = author,
        commentText = commentText
    )
}