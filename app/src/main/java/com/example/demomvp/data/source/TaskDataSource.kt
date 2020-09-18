package com.example.demomvp.data.source

import com.example.demomvp.data.model.Task

interface TaskDataSource {

    interface Local {
        fun addTask(task: Task, callBack: DataAccessCallBack<Boolean>)
        fun updateTask(task: Task, callBack: DataAccessCallBack<Boolean>)
        fun getTasks(callBack: DataAccessCallBack<List<Task>>)
        fun deleteTask(task: Task, callBack: DataAccessCallBack<Boolean>)
    }

    interface Remote {
        fun loadTask(task: Task, callBack: DataAccessCallBack<Boolean>)
    }
}
