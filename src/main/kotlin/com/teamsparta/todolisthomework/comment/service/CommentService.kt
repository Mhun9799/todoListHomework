package com.teamsparta.todolisthomework.comment.service

import com.teamsparta.todolisthomework.comment.dto.CommentCreateRequest
import com.teamsparta.todolisthomework.comment.dto.CommentResponse
import com.teamsparta.todolisthomework.comment.dto.CommentUpdateRequest
import org.springframework.http.ResponseEntity

interface CommentService {
    fun createComment(commentCreateRequest: CommentCreateRequest): CommentResponse
    fun updateComment(id: Long, commentUpdateRequest: CommentUpdateRequest): CommentResponse
    fun deleteComment(id: Long, authorName: String, password: String)
}