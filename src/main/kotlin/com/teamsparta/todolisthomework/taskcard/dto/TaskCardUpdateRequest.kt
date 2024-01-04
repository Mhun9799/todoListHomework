package com.teamsparta.todolisthomework.taskcard.dto

data class TaskCardUpdateRequest(
    var title: String,
    var content: String,
    var authorName: String
)