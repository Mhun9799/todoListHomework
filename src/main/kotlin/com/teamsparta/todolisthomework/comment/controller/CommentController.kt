package com.teamsparta.todolisthomework.comment.controller

import com.teamsparta.todolisthomework.comment.dto.CommentCreateRequest
import com.teamsparta.todolisthomework.comment.dto.CommentResponse
import com.teamsparta.todolisthomework.comment.dto.CommentUpdateRequest
import com.teamsparta.todolisthomework.comment.service.CommentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/comments")
class CommentController(private val commentService: CommentService) {

    @PostMapping
    fun createComment(@RequestBody commentCreateRequest: CommentCreateRequest): ResponseEntity<CommentResponse> {
        val commentResponse = commentService.createComment(commentCreateRequest)
        return ResponseEntity(commentResponse, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updateComment(@PathVariable id: Long, @RequestBody commentUpdateRequest: CommentUpdateRequest): ResponseEntity<CommentResponse> {
        val commentResponse = commentService.updateComment(id, commentUpdateRequest)
        return ResponseEntity(commentResponse, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteComment(@PathVariable id: Long, @RequestParam authorName: String, @RequestParam password: String): ResponseEntity<Void> {
        commentService.deleteComment(id, authorName, password)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

}
