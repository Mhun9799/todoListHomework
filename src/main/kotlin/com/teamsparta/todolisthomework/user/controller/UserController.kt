package com.teamsparta.todolisthomework.user.controller

import com.teamsparta.todolisthomework.user.dto.UserDto
import com.teamsparta.todolisthomework.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @PostMapping
    fun createUser(@RequestBody userDto: UserDto): ResponseEntity<UserDto> {
        val creatUserDto = userService.createUser(userDto)
        return ResponseEntity(creatUserDto, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): ResponseEntity<UserDto> {
        val getUserDto = userService.getUser(id)
        return ResponseEntity(getUserDto, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody userDto: UserDto): ResponseEntity<UserDto> {
        val updatedUserDto = userService.updateUser(id, userDto)
        return ResponseEntity(updatedUserDto, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> {
        userService.deleteUser(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}