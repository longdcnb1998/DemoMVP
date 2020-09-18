package com.example.demomvp.data.source.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.demomvp.data.model.Task

@RequiresApi(Build.VERSION_CODES.P)
class AppDatabase(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(UPDATE_TABLE)
        onCreate(db)
    }

    companion object {
        private const val DATABASE_NAME = "DemoMVP.db"
        private const val DATABASE_VERSION = 1
        private const val CREATE_TABLE = "CREATE TABLE " + Task.TABLE_NAME + "(" +
                Task.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Task.TITLE + " TEXT, " +
                Task.DESCRIPTION + " TEXT)"
        private const val UPDATE_TABLE = "DROP TABLE " + Task.TABLE_NAME + " IF EXISTS"

        private var INSTANCE: AppDatabase? = null
        private val lock = Any()

        fun getInstance(context: Context?): AppDatabase =
            INSTANCE ?: synchronized(lock) {
                INSTANCE ?: AppDatabase(context, DATABASE_NAME, null, DATABASE_VERSION)
            }
    }
}
