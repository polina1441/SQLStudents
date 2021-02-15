package com.example.sqlstudents.database

import android.provider.BaseColumns
import com.example.sqlstudents.MainActivity
import com.example.sqlstudents.MainActivity.Companion.recording


object DBClass : BaseColumns {
    const val TABLE_NAME = "students"
    const val NAME_TITLE = "title"
    const val NAME_CONTENT = "content"


    const val DB_VERSION = 1
    const val DB_NAME = "StudentsDB.db"

    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
            "${(BaseColumns._ID)} SERIAL PRIMARY KEY," +
            "$NAME_TITLE TEXT," +
            "$NAME_CONTENT TEXT);"

    const val DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    //const val SELECT = "SELECT * FROM $TABLE_NAME WHERE $NAME_TITLE='$recording'"
}
//IF NOT EXISTS