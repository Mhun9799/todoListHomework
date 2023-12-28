package com.teamsparta.todolisthomework.taskcard.repository

import com.teamsparta.todolisthomework.taskcard.model.TaskCard
import org.springframework.data.jpa.repository.JpaRepository

interface TaskCardRepository : JpaRepository<TaskCard, Long> {
    fun findAllByOrderByCreationDateDesc(): List<TaskCard>
}