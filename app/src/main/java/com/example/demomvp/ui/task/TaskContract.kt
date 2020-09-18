package com.example.demomvp.ui.task

import com.example.demomvp.data.model.Task
import com.example.demomvp.ui.base.BasePresenter
import com.example.demomvp.ui.base.BaseView

interface TaskContract {

    interface View : BaseView {
        val presenter: Presenter?
        fun showTasks(tasks: List<Task>)
    }

    interface Presenter : BasePresenter {
        val view: View
        fun addTask(task: Task)
    }
}
