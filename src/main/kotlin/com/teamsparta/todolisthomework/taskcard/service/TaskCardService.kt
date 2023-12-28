package com.teamsparta.todolisthomework.taskcard.service

import com.teamsparta.todolisthomework.taskcard.dto.TaskCardRequest
import com.teamsparta.todolisthomework.taskcard.dto.TaskCardResponse

interface TaskCardService {
    fun createTaskCard(taskCardRequest: TaskCardRequest): TaskCardResponse
    fun getTaskCard(id: Long): TaskCardResponse
    fun getAllTaskCards(): List<TaskCardResponse>
    fun updateTaskCard(id: Long, taskCardRequest: TaskCardRequest): TaskCardResponse
    fun deleteTaskCard(id: Long)
}
