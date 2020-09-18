package com.example.demomvp.data.source.dao

import com.example.demomvp.data.model.Task

interface TaskDAO {
    fun addTask(task: Task): Boolean

    fun updateTask(task: Task): Boolean

    fun deleteTask(task: Task): Boolean

    fun getTask(): List<Task>
}
