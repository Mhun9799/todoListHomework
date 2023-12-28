package com.teamsparta.todolisthomework.taskcard.service

import com.teamsparta.todolisthomework.taskcard.dto.TaskCardDto
import com.teamsparta.todolisthomework.taskcard.model.TaskCard
import com.teamsparta.todolisthomework.taskcard.repository.TaskCardRepository
import io.swagger.v3.oas.annotations.parameters.RequestBody
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TaskCardServiceImpl(
    private val taskCardRepository: TaskCardRepository
) : TaskCardService {

    @Transactional
    override fun createTaskCard(@RequestBody taskCardDto: TaskCardDto): TaskCardDto {
        val taskCard = TaskCard(
            title = taskCardDto.title,
            content = taskCardDto.content,
            authorName = taskCardDto.authorName
        )
        val savedTaskCard = taskCardRepository.save(taskCard)
        return TaskCardDto(
            savedTaskCard.id,
            savedTaskCard.title,
            savedTaskCard.content,
            savedTaskCard.creationDate,
            savedTaskCard.authorName
        )
    }

    @Transactional
    override fun getTaskCard(id: Long): TaskCardDto {
        val taskCard = taskCardRepository
            .findById(id)
            .orElseThrow { EntityNotFoundException("TaskCard not found") }
        return TaskCardDto(
            taskCard.id,
            taskCard.title,
            taskCard.content,
            taskCard.creationDate,
            taskCard.authorName
        )
    }

    @Transactional
    override fun getAllTaskCards(): List<TaskCardDto> {
        return taskCardRepository
            .findAllByOrderByCreationDateDesc()
            .map { taskCard: TaskCard ->
                TaskCardDto(
                    taskCard.id,
                    taskCard.title,
                    taskCard.content,
                    taskCard.creationDate,
                    taskCard.authorName
                )
            }
    }


    @Transactional
    override fun updateTaskCard(@RequestBody id: Long, taskCardDto: TaskCardDto): TaskCardDto {
        val taskCard = taskCardRepository.findById(id).orElseThrow { EntityNotFoundException("TaskCard not found") }
        taskCard.title = taskCardDto.title
        taskCard.content = taskCardDto.content
        taskCard.authorName = taskCardDto.authorName
        val updatedTaskCard = taskCardRepository.save(taskCard)
        return TaskCardDto(
            updatedTaskCard.id,
            updatedTaskCard.title,
            updatedTaskCard.content,
            updatedTaskCard.creationDate,
            updatedTaskCard.authorName
        )
    }

    @Transactional
    override fun deleteTaskCard(id: Long) {
        val taskCard = taskCardRepository.findById(id).orElseThrow { EntityNotFoundException("TaskCard not found") }
        taskCardRepository.delete(taskCard)
    }
}