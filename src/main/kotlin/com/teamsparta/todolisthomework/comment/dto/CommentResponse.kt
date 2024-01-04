package com.teamsparta.todolisthomework.comment.dto

import com.teamsparta.todolisthomework.comment.model.Comment


data class CommentResponse(
    var id: Long?,
    var content: String,
    var authorName: String,
) {
    companion object {
        fun toResponse(comment: Comment): CommentResponse {
            return CommentResponse(
                comment.id,
                comment.content,
                comment.authorName,
            )
        }
    }
}