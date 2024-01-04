package com.teamsparta.todolisthomework.comment.repository

import com.teamsparta.todolisthomework.comment.model.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long>{

}