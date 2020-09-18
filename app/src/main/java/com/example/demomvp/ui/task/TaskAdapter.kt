package com.example.demomvp.ui.task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demomvp.R
import com.example.demomvp.data.model.Task

class TaskAdapter() : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    private var tasks = mutableListOf<Task>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvTitle: TextView = itemView.findViewById(R.id.title)
        var tvDescription: TextView = itemView.findViewById(R.id.description)

        fun bindData(task: Task) {
            tvTitle.text = task.title
            tvDescription.text = task.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        )
    }

    override fun getItemCount(): Int = tasks.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val viewHolder: ViewHolder = holder
        viewHolder.bindData(tasks[position])
    }

    fun updateData(tasks: List<Task>) {
        this.tasks = tasks as ArrayList<Task>
        notifyDataSetChanged()
    }
}
