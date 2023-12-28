package com.teamsparta.todolisthomework.taskcard.service

import com.teamsparta.todolisthomework.taskcard.dto.TaskCardDto

interface TaskCardService {
    fun createTaskCard(taskCardDto: TaskCardDto): TaskCardDto
    fun getTaskCard(id: Long): TaskCardDto
    fun getAllTaskCards(): List<TaskCardDto>
    fun updateTaskCard(id: Long, taskCardDto: TaskCardDto): TaskCardDto
    fun deleteTaskCard(id: Long)
}
