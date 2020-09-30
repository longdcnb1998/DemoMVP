package com.example.demomvp.data.model

import android.content.ContentValues
import android.database.Cursor

data class Task(val id: Int, val title: String, val description: String) {
    constructor(cursor: Cursor) : this(
        id = cursor.getInt(cursor.getColumnIndex(ID)),
        title = cursor.getString(cursor.getColumnIndex(TITLE)),
        description = cursor.getString(cursor.getColumnIndex(DESCRIPTION))
    )


    fun getContentValues() = ContentValues().apply {
        put(TITLE, title)
        put(DESCRIPTION, description)
    }

    companion object {
        const val TABLE_NAME = "table_task"
        const val ID = "ID"
        const val TITLE = "TITLE"
        const val DESCRIPTION = "DESCRIPTION"
    }
}
