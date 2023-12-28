package com.teamsparta.todolisthomework.user.dto

import com.teamsparta.todolisthomework.user.model.User

data class UserResponse (
    var id: Long?,
    var name: String,
) {
    companion object {
        fun toResponse(user: User): UserResponse {
            return UserResponse(user.id, user.name)
        }
    }
}
