package com.teamsparta.todolisthomework.taskcard.dto

import java.time.LocalDateTime

data class TaskCardDto(
    var id: Long? = null,
    var title: String = "",
    var content: String = "",
    var createDate: LocalDateTime = LocalDateTime.now(),
    val authorName: String = ""
)


