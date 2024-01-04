package com.teamsparta.todolisthomework.taskcard.service

import com.teamsparta.todolisthomework.taskcard.dto.TaskCardCreateRequest
import com.teamsparta.todolisthomework.taskcard.dto.TaskCardResponse
import com.teamsparta.todolisthomework.taskcard.dto.TaskCardUpdateRequest
import com.teamsparta.todolisthomework.taskcard.model.TaskCard
import com.teamsparta.todolisthomework.taskcard.repository.TaskCardRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TaskCardServiceImpl(
    private val taskCardRepository: TaskCardRepository
) : TaskCardService {

    @Transactional
    override fun createTaskCard(taskCardCreateRequest: TaskCardCreateRequest): TaskCardResponse {
        val taskCard = TaskCard(
            title = taskCardCreateRequest.title,
            content = taskCardCreateRequest.content,
            authorName = taskCardCreateRequest.authorName
        )
        val savedTaskCard = taskCardRepository.save(taskCard)
        return TaskCardResponse.toResponse(savedTaskCard)
    }

    @Transactional
    override fun getTaskCard(id: Long): TaskCardResponse {
        val taskCard = taskCardRepository
            .findById(id)
            .orElseThrow { EntityNotFoundException("TaskCard not found") }
        return TaskCardResponse.toResponse(taskCard)
    }

    @Transactional
    override fun getAllTaskCards(): List<TaskCardResponse> {
        return taskCardRepository
            .findAllByOrderByCreationDateDesc()
            .map { taskCard: TaskCard ->
                TaskCardResponse.toResponse(taskCard)
            }
    }

    @Transactional
    override fun updateTaskCard(id: Long, taskCardUpdateRequest: TaskCardUpdateRequest): TaskCardResponse {
        val taskCard = taskCardRepository.findById(id).orElseThrow { EntityNotFoundException("TaskCard not found") }
        taskCard.title = taskCardUpdateRequest.title
        taskCard.content = taskCardUpdateRequest.content
        taskCard.authorName = taskCardUpdateRequest.authorName
        return TaskCardResponse.toResponse(taskCard)
    }

    @Transactional
    override fun deleteTaskCard(id: Long) {
        val taskCard = taskCardRepository
            .findById(id)
            .orElseThrow { EntityNotFoundException("TaskCard not found") }
        taskCardRepository.delete(taskCard)
    }
}
