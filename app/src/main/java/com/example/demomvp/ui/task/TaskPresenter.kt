package com.example.demomvp.ui.task

import com.example.demomvp.R
import com.example.demomvp.data.model.Task
import com.example.demomvp.data.source.DataAccessCallBack
import com.example.demomvp.data.source.TaskRepository

class TaskPresenter(
    override val view: TaskContract.View,
    private val taskRepository: TaskRepository
) : TaskContract.Presenter {


    override fun addTask(task: Task) {
        taskRepository.addTask(task, object : DataAccessCallBack<Boolean> {
            override fun onLoadDataSuccess(data: Boolean) {
                val msgId = if (data) R.string.msg_success else R.string.msg_error
                view.toast(msgId)
            }

            override fun onLoadDataFailed(exception: Exception) {
                view.toast(exception)
            }
        })
    }

    override fun getTasks() {
        taskRepository.getTasks(object : DataAccessCallBack<List<Task>> {
            override fun onLoadDataSuccess(data: List<Task>) {
                view.showTasks(data)
            }

            override fun onLoadDataFailed(exception: Exception) {
                view.toast(exception)
            }
        })
    }

    override fun start() {
        getTasks()
    }

}
