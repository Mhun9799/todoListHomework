package com.teamsparta.todolisthomework.taskcard.model

import com.teamsparta.todolisthomework.user.model.User
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "task_cards")
data class TaskCard(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "title", nullable = false)
    var title: String = "",

    @Column(name = "content", nullable = false)
    var content: String = "",

    @Column(name = "creation_date", nullable = false)
    var creationDate: LocalDateTime = LocalDateTime.now(),

    @Column(name = "author_name", nullable = false)
    var authorName: String,

    @Column(name = "is_completed", nullable = false)
    var isCompleted: Boolean = false
)
