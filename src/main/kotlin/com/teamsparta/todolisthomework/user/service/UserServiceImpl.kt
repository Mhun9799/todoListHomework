package com.teamsparta.todolisthomework.user.service

import com.teamsparta.todolisthomework.user.dto.UserCreateRequest
import com.teamsparta.todolisthomework.user.dto.UserResponse
import com.teamsparta.todolisthomework.user.dto.UserUpdateRequest
import com.teamsparta.todolisthomework.user.model.User
import com.teamsparta.todolisthomework.user.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {

    @Transactional
    override fun createUser(userCreateRequest: UserCreateRequest): UserResponse {
        val user = User(name = userCreateRequest.name)
        val savedUser = userRepository.save(user)
        return UserResponse.toResponse(savedUser)
    }

    // @Transactional
    // override fun getUser(id: Long): UserResponse {
    //     val user = userRepository
    //         .findById(id)
    //         .orElseThrow { RuntimeException("User not found") }
    //     return UserResponse.toResponse(user)
    // }

    @Transactional
    override fun getUser(name: String): UserResponse {
        val user = userRepository
            .findByName(name)
            ?: throw RuntimeException("User not found")
        return UserResponse.toResponse(user)
    }

    @Transactional
    override fun updateUser(id: Long, userUpdateRequest: UserUpdateRequest): UserResponse {
        val user = userRepository
            .findById(id)
            .orElseThrow { RuntimeException("User not found") }
        user.name = userUpdateRequest.name
        return UserResponse.toResponse(user)
    }

    @Transactional
    override fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }

    @Transactional
    override fun getAllUsers(): List<UserResponse> {
        val users = userRepository.findAll()
        return users.map { UserResponse.toResponse(it) }
    }
}