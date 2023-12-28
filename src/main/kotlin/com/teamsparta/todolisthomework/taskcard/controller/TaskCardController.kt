package com.teamsparta.todolisthomework.taskcard.controller

import com.teamsparta.todolisthomework.taskcard.dto.TaskCardDto
import com.teamsparta.todolisthomework.taskcard.service.TaskCardService
import io.swagger.v3.oas.annotations.parameters.RequestBody
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/task-cards")
class TaskCardController(private val taskCardService: TaskCardService) {

    @PostMapping
    fun createTaskCard(@RequestBody taskCardDto: TaskCardDto): ResponseEntity<TaskCardDto> {
        val createdTaskCardDto = taskCardService.createTaskCard(taskCardDto)
        return ResponseEntity(createdTaskCardDto, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getTaskCard(@PathVariable id: Long): ResponseEntity<TaskCardDto> {
        val taskCardDto = taskCardService.getTaskCard(id)
        return ResponseEntity(taskCardDto, HttpStatus.OK)
    }

    @GetMapping
    fun getAllTaskCards(): ResponseEntity<List<TaskCardDto>> {
        val taskCards = taskCardService.getAllTaskCards()
        return ResponseEntity(taskCards, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updateTaskCard(@PathVariable id: Long, @RequestBody taskCardDto: TaskCardDto): ResponseEntity<TaskCardDto> {
        val updatedTaskCardDto = taskCardService.updateTaskCard(id, taskCardDto)
        return ResponseEntity(updatedTaskCardDto, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteTaskCard(@PathVariable id: Long): ResponseEntity<Void> {
        taskCardService.deleteTaskCard(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}