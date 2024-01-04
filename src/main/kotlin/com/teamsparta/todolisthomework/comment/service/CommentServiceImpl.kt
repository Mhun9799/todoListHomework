package com.teamsparta.todolisthomework.comment.service

import com.teamsparta.todolisthomework.comment.dto.CommentCreateRequest
import com.teamsparta.todolisthomework.comment.dto.CommentResponse
import com.teamsparta.todolisthomework.comment.dto.CommentUpdateRequest
import com.teamsparta.todolisthomework.comment.model.Comment
import com.teamsparta.todolisthomework.comment.repository.CommentRepository
import com.teamsparta.todolisthomework.taskcard.repository.TaskCardRepository
import com.teamsparta.todolisthomework.user.repository.UserRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentServiceImpl(
    private val commentRepository: CommentRepository,
    private val userRepository: UserRepository,
    private val taskCardRepository: TaskCardRepository
) : CommentService {

    @Transactional
    override fun createComment(commentCreateRequest: CommentCreateRequest): CommentResponse {
        val user = userRepository.findByName(commentCreateRequest.authorName)
            ?: throw EntityNotFoundException("User not found")
        val taskCard = taskCardRepository.findById(commentCreateRequest.taskCardId).orElse(null)
            ?: throw EntityNotFoundException("TaskCard not found")
        val comment = Comment(
            authorName = user.name,
            password = commentCreateRequest.password,
            content = commentCreateRequest.content,
            user = user,
            taskCard = taskCard
        )
        val savedComment = commentRepository.save(comment)
        return CommentResponse.toResponse(savedComment)
    }

    @Transactional
    override fun updateComment(id: Long, commentUpdateRequest: CommentUpdateRequest): CommentResponse {
        val comment = commentRepository.findById(id).orElseThrow { EntityNotFoundException("Comment not found") }
        if (comment.password != commentUpdateRequest.password) {
            throw IllegalArgumentException("Password does not match")
        }
        comment.content = commentUpdateRequest.content
        return CommentResponse.toResponse(comment)
    }

    @Transactional
    override fun deleteComment(id: Long, authorName: String, password: String) {
        val comment = commentRepository.findById(id).orElseThrow { EntityNotFoundException("Comment not found") }
        if (comment.authorName != authorName || comment.password != password) {
            throw IllegalArgumentException("Invalid credentials")
        }
        commentRepository.delete(comment)
    }
}