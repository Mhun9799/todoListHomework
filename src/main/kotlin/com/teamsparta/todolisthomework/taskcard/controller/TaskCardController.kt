package com.teamsparta.todolisthomework.taskcard.controller

import com.teamsparta.todolisthomework.taskcard.dto.TaskCardRequest
import com.teamsparta.todolisthomework.taskcard.dto.TaskCardResponse
import com.teamsparta.todolisthomework.taskcard.service.TaskCardService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/task-cards")
class TaskCardController(private val taskCardService: TaskCardService) {

    @PostMapping
    fun createTaskCard(@RequestBody taskCardRequest: TaskCardRequest): ResponseEntity<TaskCardResponse> {
        val createdTaskCardResponse = taskCardService.createTaskCard(taskCardRequest)
        return ResponseEntity(createdTaskCardResponse, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getTaskCard(@PathVariable id: Long): ResponseEntity<TaskCardResponse> {
        val taskCardResponse = taskCardService.getTaskCard(id)
        return ResponseEntity(taskCardResponse, HttpStatus.OK)
    }

    @GetMapping
    fun getAllTaskCards(): ResponseEntity<List<TaskCardResponse>> {
        val taskCards = taskCardService.getAllTaskCards()
        return ResponseEntity(taskCards, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updateTaskCard(@PathVariable id: Long, @RequestBody taskCardRequest: TaskCardRequest): ResponseEntity<TaskCardResponse> {
        val updatedTaskCardResponse = taskCardService.updateTaskCard(id, taskCardRequest)
        return ResponseEntity(updatedTaskCardResponse, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteTaskCard(@PathVariable id: Long): ResponseEntity<Void> {
        taskCardService.deleteTaskCard(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}
