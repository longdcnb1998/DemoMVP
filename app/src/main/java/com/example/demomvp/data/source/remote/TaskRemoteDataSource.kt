package com.example.demomvp.data.source.remote

import com.example.demomvp.data.model.Task
import com.example.demomvp.data.source.DataAccessCallBack
import com.example.demomvp.data.source.TaskDataSource
import com.example.demomvp.data.source.dao.TaskDAO

class TaskRemoteDataSource private constructor(taskDao: TaskDAO) : TaskDataSource.Remote {
    override fun loadTask(task: Task, callBack: DataAccessCallBack<Boolean>) {}

    companion object {
        private var INSTANCE: TaskRemoteDataSource? = null
        fun getInstance(taskDao: TaskDAO): TaskRemoteDataSource =
            INSTANCE ?: TaskRemoteDataSource(taskDao).also { INSTANCE = it }
    }
}
