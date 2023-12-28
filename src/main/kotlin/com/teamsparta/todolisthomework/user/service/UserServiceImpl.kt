package com.teamsparta.todolisthomework.user.service

import com.teamsparta.todolisthomework.user.dto.UserDto
import com.teamsparta.todolisthomework.user.model.User
import com.teamsparta.todolisthomework.user.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {

    @Transactional
    override fun createUser(userDto: UserDto): UserDto {
        val user = User(name = userDto.name)
        val savedUser = userRepository.save(user)
        return UserDto(savedUser.id, savedUser.name)
    }
    @Transactional
    override fun getUser(id: Long): UserDto {
        val user = userRepository
            .findById(id)
            .orElseThrow { RuntimeException("User not found") }
        return UserDto(user.id, user.name)
    }
    @Transactional
    override fun updateUser(id: Long, userDto: UserDto): UserDto {
        val user = userRepository
            .findById(id)
            .orElseThrow { RuntimeException("User not found") }
        user.name = userDto.name
        val updatedUser = userRepository.save(user)
        return UserDto(updatedUser.id, updatedUser.name)
    }
    @Transactional
    override fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }
}