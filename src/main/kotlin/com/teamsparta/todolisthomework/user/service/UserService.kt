package com.teamsparta.todolisthomework.user.service

import com.teamsparta.todolisthomework.user.dto.UserCreateRequest
import com.teamsparta.todolisthomework.user.dto.UserResponse
import com.teamsparta.todolisthomework.user.dto.UserUpdateRequest

interface UserService {
    fun createUser(userCreateRequest: UserCreateRequest): UserResponse
    // fun getUser(id: Long): UserResponse
    fun getUser(name: String): UserResponse
    fun updateUser(id: Long, userUpdateRequest: UserUpdateRequest): UserResponse
    fun deleteUser(id: Long)
    fun getAllUsers(): List<UserResponse>
}
