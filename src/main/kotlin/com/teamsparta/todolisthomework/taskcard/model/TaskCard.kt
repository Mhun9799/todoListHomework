package com.teamsparta.todolisthomework.taskcard.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "task_cards")
data class TaskCard(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var title: String = "",

    @Column(nullable = false)
    var content: String = "",

    @Column(name = "creation_date", nullable = false)
    var creationDate: LocalDateTime = LocalDateTime.now(),

    @Column(name = "author_name", nullable = false)
    var authorName: String = ""
)
