package com.example.demomvp.data.source.dao

import android.annotation.SuppressLint
import android.content.Context
import com.example.demomvp.data.model.Task
import com.example.demomvp.data.source.local.AppDatabase

class TaskDaoImpl private constructor(private val database: AppDatabase) : TaskDAO {


    override fun addTask(task: Task): Boolean =
        database.writableDatabase.insert(Task.TABLE_NAME, null, task.getContentValues()) > 0

    override fun updateTask(task: Task): Boolean =
        database.writableDatabase.update(
            Task.TABLE_NAME,
            task.getContentValues(),
            Task.ID,
            null
        ) > 0

    override fun deleteTask(task: Task): Boolean =
        database.writableDatabase.delete(Task.TABLE_NAME, Task.ID, null) > 0

    @SuppressLint("Recycle")
    override fun getTask(): List<Task> {
        val cursor =
            database.readableDatabase.query(Task.TABLE_NAME, null, null, null, null, null, null)

        return mutableListOf<Task>().apply {
            if (cursor.moveToFirst()) {
                do {
                    add(Task(cursor))
                } while (cursor.moveToNext())
            }
            cursor.close()
        }
    }

    companion object {
        private var INSTANCE : TaskDaoImpl? = null

        fun getInstance(database: AppDatabase) =
            INSTANCE ?: TaskDaoImpl(database = database).also { INSTANCE = it }
    }
}
