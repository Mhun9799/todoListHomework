package com.teamsparta.todolisthomework.taskcard.service

import com.teamsparta.todolisthomework.taskcard.dto.TaskCardRequest
import com.teamsparta.todolisthomework.taskcard.dto.TaskCardResponse
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
    override fun createTaskCard(taskCardRequest: TaskCardRequest): TaskCardResponse {
        val taskCard = TaskCard(
            title = taskCardRequest.title,
            content = taskCardRequest.content,
            authorName = taskCardRequest.authorName
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
    override fun updateTaskCard(id: Long, taskCardRequest: TaskCardRequest): TaskCardResponse {
        val taskCard = taskCardRepository.findById(id).orElseThrow { EntityNotFoundException("TaskCard not found") }
        taskCard.title = taskCardRequest.title
        taskCard.content = taskCardRequest.content
        taskCard.authorName = taskCardRequest.authorName
        val updatedTaskCard = taskCardRepository.save(taskCard)
        return TaskCardResponse.toResponse(updatedTaskCard)
    }

    @Transactional
    override fun deleteTaskCard(id: Long) {
        val taskCard = taskCardRepository
            .findById(id)
            .orElseThrow { EntityNotFoundException("TaskCard not found") }
        taskCardRepository.delete(taskCard)
    }
}
