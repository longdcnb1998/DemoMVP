package com.example.demomvp.data.source.local

import android.os.AsyncTask
import com.example.demomvp.data.source.DataAccessCallBack

class LocalLoadedAsyncTask<P, T>(
    private val mCallback: DataAccessCallBack<T>,
    private val handle: (P) -> T?
) : AsyncTask<P, Void, T?>() {

    private var exception: Exception? = null

    override fun doInBackground(vararg params: P): T? = try {
        handle(params.first()) ?: throw Exception()
    } catch (e: Exception) {
        exception = e
        null
    }

    override fun onPostExecute(result: T?) {
        super.onPostExecute(result)
        result?.let(mCallback::onLoadDataSuccess) ?: mCallback::onLoadDataFailed
    }

    object EmptyInput
}
