package com.teamsparta.todolisthomework.taskcard.service

import com.teamsparta.todolisthomework.taskcard.dto.TaskCardCreateRequest
import com.teamsparta.todolisthomework.taskcard.dto.TaskCardResponse
import com.teamsparta.todolisthomework.taskcard.dto.TaskCardUpdateRequest
import com.teamsparta.todolisthomework.taskcard.model.TaskCard
import com.teamsparta.todolisthomework.taskcard.repository.TaskCardRepository
import com.teamsparta.todolisthomework.user.repository.UserRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TaskCardServiceImpl(
    private val taskCardRepository: TaskCardRepository,
    private val userRepository: UserRepository
) : TaskCardService {

    @Transactional
    override fun createTaskCard(taskCardCreateRequest: TaskCardCreateRequest): TaskCardResponse {
        val user = userRepository.findByName(taskCardCreateRequest.authorName)
            ?: throw EntityNotFoundException("User not found")
        val taskCard = TaskCard(
            title = taskCardCreateRequest.title,
            content = taskCardCreateRequest.content,
            authorName = user.name
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
        val user = userRepository.findByName(taskCardUpdateRequest.authorName)
            ?: throw EntityNotFoundException("User not found")
        val taskCard = taskCardRepository.findById(id).orElseThrow { EntityNotFoundException("TaskCard not found") }
        taskCard.title = taskCardUpdateRequest.title
        taskCard.content = taskCardUpdateRequest.content
        taskCard.authorName = user.name
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
