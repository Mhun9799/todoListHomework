package com.teamsparta.todolisthomework.user.service

import com.teamsparta.todolisthomework.user.dto.UserRequest
import com.teamsparta.todolisthomework.user.dto.UserResponse
import com.teamsparta.todolisthomework.user.model.User
import com.teamsparta.todolisthomework.user.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {

    @Transactional
    override fun createUser(userRequest: UserRequest): UserResponse {
        val user = User(name = userRequest.name)
        val savedUser = userRepository.save(user)
        return UserResponse.toResponse(savedUser)
    }

    @Transactional
    override fun getUser(id: Long): UserResponse {
        val user = userRepository
            .findById(id)
            .orElseThrow { RuntimeException("User not found") }
        return UserResponse.toResponse(user)
    }

    @Transactional
    override fun updateUser(id: Long, userRequest: UserRequest): UserResponse {
        val user = userRepository
            .findById(id)
            .orElseThrow { RuntimeException("User not found") }
        user.name = userRequest.name
        val updatedUser = userRepository.save(user)
        return UserResponse.toResponse(updatedUser)
    }

    @Transactional
    override fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }
}
