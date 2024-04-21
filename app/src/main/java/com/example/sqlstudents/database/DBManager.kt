package com.example.sqlstudents.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.sqlstudents.Student

class DBManager (context: Context){
    val helper = DBHelper(context)
    var db : SQLiteDatabase? = null

    fun openDB(){
        db = helper.writableDatabase
    }
    fun insertDB(title: String, content: String){

        val values = ContentValues().apply {
            put(DBClass.NAME_TITLE, title)
            put(DBClass.NAME_CONTENT, content)
        }
        db?.insert(DBClass.TABLE_NAME, null, values)
    }
    fun readDB(): ArrayList<Student> {
        val dataList = ArrayList<Student>()
        val cursor = db?.query(
                DBClass.TABLE_NAME,
                arrayOf(DBClass.NAME_TITLE, DBClass.NAME_CONTENT),
                null,
                null,
                null,
                null,
                null
        )
        with(cursor){
            while (this?.moveToNext()!!){
                val dataText = cursor?.getString(
                        cursor.getColumnIndex(DBClass.NAME_TITLE))
                val dataContent = cursor?.getString(
                    cursor.getColumnIndex(DBClass.NAME_CONTENT)
                )
                dataList.add(Student(dataText.toString(), dataContent.toString()))
            }
        }
        cursor?.close()
        return dataList
    }
    fun closeDB(){
        helper.close()
    }
    fun deleteDB(){
        helper.onUpgrade(db, 0, 0)
    }
}