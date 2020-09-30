package com.example.demomvp.data.source

import com.example.demomvp.data.model.Task

class TaskRepository private constructor(
    private val local: TaskDataSource.Local,
    private val remote: TaskDataSource.Remote
) : TaskDataSource.Local, TaskDataSource.Remote {

    override fun addTask(task: Task, callBack: DataAccessCallBack<Boolean>) {
        local.addTask(task, callBack)
    }

    override fun updateTask(task: Task, callBack: DataAccessCallBack<Boolean>) {
        local.updateTask(task, callBack)
    }

    override fun getTasks(callBack: DataAccessCallBack<List<Task>>) {
        local.getTasks(callBack)
    }

    override fun deleteTask(task: Task, callBack: DataAccessCallBack<Boolean>) {
        local.deleteTask(task, callBack)
    }

    override fun loadTask(task: Task, callBack: DataAccessCallBack<Boolean>) {}

    companion object {
        private var INSTANCE: TaskRepository? = null
        fun getInstances(
            local: TaskDataSource.Local,
            remote: TaskDataSource.Remote
        ): TaskRepository = INSTANCE ?: TaskRepository(local, remote).also { INSTANCE = it }
    }
}
