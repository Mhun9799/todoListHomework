package com.teamsparta.todolisthomework.comment.dto

data class CommentCreateRequest(
    var authorName: String,
    var password: String,
    var content: String,
    var taskCardId: Long,
)
