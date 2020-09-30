package com.example.demomvp.ui.task

import android.view.View
import com.example.demomvp.R
import com.example.demomvp.data.model.Task
import com.example.demomvp.data.source.TaskRepository
import com.example.demomvp.data.source.dao.TaskDaoImpl
import com.example.demomvp.data.source.local.AppDatabase
import com.example.demomvp.data.source.local.TaskLocalDataSource
import com.example.demomvp.data.source.remote.TaskRemoteDataSource
import com.example.demomvp.showToast
import com.example.demomvp.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_task.*

class TaskFragment : BaseFragment(), TaskContract.View, View.OnClickListener {
    private val taskAdapter by lazy {
        TaskAdapter()
    }
    override val layoutResource: Int
        get() = R.layout.fragment_task

    override var presenter: TaskContract.Presenter? = null

    override fun initView() {
        initRecyclerView()
        imageAdd.setOnClickListener(this)
    }

    private fun initRecyclerView() {
        recyclerTasks.adapter = taskAdapter
    }

    override fun initData() {
        initPresenter()
        presenter?.start()
    }

    private fun initPresenter() {
        val context = context ?: return
        val database = AppDatabase.getInstance(context)
        val localDataSource = TaskLocalDataSource.getInstance(TaskDaoImpl.getInstance(database))
        val remoteDataSource = TaskRemoteDataSource.getInstance(TaskDaoImpl.getInstance(database))
        val repository = TaskRepository.getInstances(localDataSource, remoteDataSource)
        presenter = TaskPresenter(this, repository)
    }


    override fun showTasks(tasks: List<Task>) {
        taskAdapter?.updateData(tasks)
    }

    override fun showLoading() {}

    override fun hideLoading() {}

    override fun toast(obj: Any) {
        context?.showToast(obj)
    }


    override fun onClick(v: View?) {
        if (v?.id == R.id.imageAdd) presenter?.addTask(Task(0, "LongDinh", "Description"))
    }

    companion object {
        fun newInstance() = TaskFragment()
    }
}
