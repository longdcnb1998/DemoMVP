package com.example.demomvp.data.source

interface DataAccessCallBack<T> {
    fun onLoadDataSuccess(data: T)
    fun onLoadDataFailed(exception: Exception)
}
