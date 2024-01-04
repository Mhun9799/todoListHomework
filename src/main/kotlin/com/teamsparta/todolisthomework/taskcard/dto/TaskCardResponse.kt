package com.teamsparta.todolisthomework.taskcard.dto

import com.teamsparta.todolisthomework.taskcard.model.TaskCard
import java.time.LocalDateTime

data class TaskCardResponse(
    var id: Long?,
    var title: String,
    var content: String,
    var authorName: String,
    var isCompleted: Boolean
) {
    companion object {
        fun toResponse(taskCard: TaskCard): TaskCardResponse {
            return TaskCardResponse(
                taskCard.id,
                taskCard.title,
                taskCard.content,
                taskCard.authorName,
                taskCard.isCompleted
            )
        }
    }
}


