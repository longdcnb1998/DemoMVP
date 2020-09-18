package com.example.demomvp.data.model

import android.content.ContentValues
import android.database.Cursor

data class Task(val mId: Int, val mTitle: String, val mDescription: String) {
    constructor(cursor: Cursor) : this(
        mId = cursor.getInt(cursor.getColumnIndex(ID)),
        mTitle = cursor.getString(cursor.getColumnIndex(TITLE)),
        mDescription = cursor.getString(cursor.getColumnIndex(DESCRIPTION))
    )


    fun getContentValues(): ContentValues? {
        return ContentValues().apply {
            put(TITLE, mTitle)
            put(DESCRIPTION, mDescription)
        }
    }

    companion object {
        const val TABLE_NAME = "table_task"
        const val ID = "ID"
        const val TITLE = "TITLE"
        const val DESCRIPTION = "DESCRIPTION"
    }
}
