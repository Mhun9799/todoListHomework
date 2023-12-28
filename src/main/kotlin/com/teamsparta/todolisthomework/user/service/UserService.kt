package com.teamsparta.todolisthomework.user.service

import com.teamsparta.todolisthomework.user.dto.UserRequest
import com.teamsparta.todolisthomework.user.dto.UserResponse

interface UserService {
    fun createUser(userRequest: UserRequest): UserResponse
    fun getUser(id: Long): UserResponse
    fun updateUser(id: Long, userRequest: UserRequest): UserResponse
    fun deleteUser(id: Long)
}