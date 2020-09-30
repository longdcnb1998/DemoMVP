package com.example.demomvp.ui.base

interface BaseView {
    fun showLoading()

    fun hideLoading()

    fun toast(obj: Any)
}
