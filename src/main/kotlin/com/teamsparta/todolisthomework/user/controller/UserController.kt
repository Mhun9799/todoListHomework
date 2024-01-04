package com.teamsparta.todolisthomework.user.controller

import com.teamsparta.todolisthomework.user.dto.UserCreateRequest
import com.teamsparta.todolisthomework.user.dto.UserResponse
import com.teamsparta.todolisthomework.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @PostMapping
    fun createUser(@RequestBody userRequest: UserCreateRequest): ResponseEntity<UserResponse> {
        val createdUserResponse = userService.createUser(userRequest)
        return ResponseEntity(createdUserResponse, HttpStatus.CREATED)
    }

    // @GetMapping("/{id}")
    // fun getUser(@PathVariable id: Long): ResponseEntity<UserResponse> {
    //     val userResponse = userService.getUser(id)
    //     return ResponseEntity(userResponse, HttpStatus.OK)
    // }

    @GetMapping("/{name}")
    fun getUser(@PathVariable name: String): ResponseEntity<UserResponse> {
        val userResponse = userService.getUser(name)
        return ResponseEntity(userResponse, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody userRequest: UserCreateRequest): ResponseEntity<UserResponse> {
        val updatedUserResponse = userService.updateUser(id, userRequest)
        return ResponseEntity(updatedUserResponse, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> {
        userService.deleteUser(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<UserResponse>> {
        val userResponses = userService.getAllUsers()
        return ResponseEntity(userResponses, HttpStatus.OK)
    }
}
