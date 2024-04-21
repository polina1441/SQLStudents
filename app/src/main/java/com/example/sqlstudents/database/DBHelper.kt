package com.example.sqlstudents.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper (context: Context) : SQLiteOpenHelper (context,
        DBClass.DB_NAME, null, DBClass.DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DBClass.CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL(DBClass.DELETE_TABLE)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

}
