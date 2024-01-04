package com.teamsparta.todolisthomework.taskcard.service

import com.teamsparta.todolisthomework.taskcard.dto.TaskCardCreateRequest
import com.teamsparta.todolisthomework.taskcard.dto.TaskCardResponse
import com.teamsparta.todolisthomework.taskcard.dto.TaskCardUpdateRequest

interface TaskCardService {
    fun createTaskCard(taskCardCreateRequest: TaskCardCreateRequest): TaskCardResponse
    fun getTaskCard(id: Long): TaskCardResponse
    fun getAllTaskCards(): List<TaskCardResponse>
    fun updateTaskCard(id: Long, taskCardUpdateRequest: TaskCardUpdateRequest): TaskCardResponse
    fun deleteTaskCard(id: Long)
    fun completeTaskCard(id: Long): TaskCardResponse
}

