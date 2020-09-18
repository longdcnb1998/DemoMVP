package com.example.demomvp.data.source.local

import com.example.demomvp.data.model.Task
import com.example.demomvp.data.source.DataAccessCallBack
import com.example.demomvp.data.source.TaskDataSource
import com.example.demomvp.data.source.dao.TaskDAO

class TaskLocalDataSource private constructor(private val taskDAO: TaskDAO) : TaskDataSource.Local {
    override fun addTask(task: Task, callBack: DataAccessCallBack<Boolean>) {
        LocalLoadedAsyncTask<Task, Boolean>(callBack) {
            taskDAO.addTask(task)
        }.execute(task)
    }

    override fun updateTask(task: Task, callBack: DataAccessCallBack<Boolean>) {
        LocalLoadedAsyncTask<Task, Boolean>(callBack) {
            taskDAO.updateTask(task)
        }.execute(task)
    }

    override fun getTasks(callBack: DataAccessCallBack<List<Task>>) {
        LocalLoadedAsyncTask<LocalLoadedAsyncTask.EmptyInput, List<Task>>(callBack) {
            taskDAO.getTask()
        }.execute(LocalLoadedAsyncTask.EmptyInput)
    }

    override fun deleteTask(task: Task, callBack: DataAccessCallBack<Boolean>) {
        LocalLoadedAsyncTask<Task, Boolean>(callBack) {
            taskDAO.deleteTask(task)
        }.execute(task)
    }

    companion object {
        private var INSTANCE: TaskLocalDataSource? = null
        fun getInstance(taskDao: TaskDAO): TaskLocalDataSource =
            INSTANCE ?: TaskLocalDataSource(taskDao).also { INSTANCE = it }
    }
}
