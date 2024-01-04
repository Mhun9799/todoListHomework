package com.teamsparta.todolisthomework.user.model

import com.teamsparta.todolisthomework.taskcard.model.TaskCard
import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var name: String,

    @OneToMany(mappedBy = "authorName")
    var taskCards: List<TaskCard> = mutableListOf(),

   // @OneToMany(mappedBy = "authorName")
   // var comments: List<Comment> = mutableListOf()
)