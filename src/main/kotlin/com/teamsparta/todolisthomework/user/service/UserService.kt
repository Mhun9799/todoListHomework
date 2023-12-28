package com.teamsparta.todolisthomework.user.service

import com.teamsparta.todolisthomework.user.dto.UserDto

interface UserService {
    fun createUser(userDto: UserDto): UserDto
    fun getUser(id: Long): UserDto
    fun updateUser(id: Long, userDto: UserDto): UserDto
    fun deleteUser(id: Long)
}