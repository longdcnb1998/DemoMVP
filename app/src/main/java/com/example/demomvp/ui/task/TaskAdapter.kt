package com.example.demomvp.ui.task

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demomvp.R
import com.example.demomvp.data.model.Task

class TaskAdapter(private val context: Context) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    private var mListTask: ArrayList<Task> = ArrayList()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mTvTitle: TextView = itemView.findViewById(R.id.title)
        var mTvDes: TextView = itemView.findViewById(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_task, parent, false))
    }

    override fun getItemCount(): Int {
        return mListTask.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val viewHolder: ViewHolder = holder
        mListTask[position].let {
            val task = mListTask[position]
            viewHolder.mTvTitle.text = task.mTitle
            viewHolder.mTvDes.text = task.mDescription
        }
    }

    fun updateData(tasks: List<Task>) {
        mListTask = tasks as ArrayList<Task>
        notifyDataSetChanged()
    }
}
