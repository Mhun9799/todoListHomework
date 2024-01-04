package com.teamsparta.todolisthomework.comment.model

import com.teamsparta.todolisthomework.user.model.User
import jakarta.persistence.*

@Entity
@Table(name = "comments")
data class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var authorName: String,

    @Column(nullable = false)
    var password: String,

    @Column(nullable = false)
    var content: String,

    @ManyToOne
    @JoinColumn(name = "user_name", referencedColumnName = "name")
    var user: User
) {

}