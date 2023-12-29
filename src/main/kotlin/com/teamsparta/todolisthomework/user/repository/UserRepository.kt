package com.teamsparta.todolisthomework.user.repository

import com.teamsparta.todolisthomework.user.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByName(name: String): User?
}