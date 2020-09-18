package com.example.demomvp

import com.example.demomvp.R
import com.example.demomvp.ui.base.BaseActivity
import com.example.demomvp.ui.task.TaskFragment

class MainActivity : BaseActivity() {
    override val layoutResource: Int
        get() = R.layout.activity_main

    override fun initData() {}

    override fun initView() {
        openFragment(R.id.fragment_container, TaskFragment.newInstance(), false)
    }

}
